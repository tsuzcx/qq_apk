package com.tencent.qqperf.monitor.memory;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.memory.leakdetect.LeakInspector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.config.APMModuleConfig;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.monitor.base.IAPMModuleLeak;
import com.tencent.qqperf.monitor.base.IDumpMemoryCallback;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONException;

public class QAPMLeakWrapper
  extends AbstractMagnifierItem
  implements Application.ActivityLifecycleCallbacks, IAPMModuleLeak
{
  static boolean jdField_a_of_type_Boolean = false;
  static boolean b = false;
  IInspectorListener jdField_a_of_type_ComTencentQapmsdkBaseListenerIInspectorListener = new QAPMLeakListener();
  
  public QAPMLeakWrapper()
  {
    MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(this);
  }
  
  public static void c()
  {
    if ((new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_02")).exists()) || (new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists())) {}
    for (jdField_a_of_type_Boolean = false; new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/AutoTestFlag_03")).exists(); jdField_a_of_type_Boolean = true)
    {
      b = false;
      return;
    }
    b = true;
  }
  
  public DumpResult a(String paramString, IDumpMemoryCallback paramIDumpMemoryCallback)
  {
    try
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "dumpMemory " + paramString);
      paramString = LeakInspector.dumpMemory(paramString, true, new QAPMLeakWrapper.1(this, paramIDumpMemoryCallback));
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "", paramString);
    }
    return new DumpResult();
  }
  
  public String a()
  {
    return "leak";
  }
  
  public void a(long paramLong, String paramString)
  {
    try
    {
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "dumpMemory " + paramString);
      LeakInspector.report("" + paramLong, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(APMModuleConfig paramAPMModuleConfig) {}
  
  public void a(Object paramObject, String paramString)
  {
    if (n_())
    {
      LeakInspector.startInspect(paramObject, paramString);
      return;
    }
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "startInspect failedNoStart");
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    ((IPerfApi)QRoute.api(IPerfApi.class)).startDumpingMemory(paramString1, paramString2, paramLong);
  }
  
  public void b()
  {
    c();
    LeakInspector.setKeepUuidWhenLeak(true);
    com.tencent.qapmsdk.memory.MemoryLeakMonitor.enableFragmentInspect = false;
    QAPM.setProperty(110, this.jdField_a_of_type_ComTencentQapmsdkBaseListenerIInspectorListener);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    try
    {
      ((IPerfApi)QRoute.api(IPerfApi.class)).onActivityDestroyed(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onActivityDestroyed ", paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMLeakWrapper
 * JD-Core Version:    0.7.0.1
 */