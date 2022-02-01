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
  static boolean b = false;
  static boolean c = false;
  IInspectorListener d = new QAPMLeakListener();
  
  public QAPMLeakWrapper()
  {
    MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(this);
  }
  
  public static void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/AutoTestFlag_02");
    if (!new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString())).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/AutoTestFlag_03");
      if (!new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString())).exists())
      {
        b = true;
        break label106;
      }
    }
    b = false;
    label106:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/AutoTestFlag_03");
    if (new File(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString())).exists())
    {
      c = false;
      return;
    }
    c = true;
  }
  
  public DumpResult a(String paramString, IDumpMemoryCallback paramIDumpMemoryCallback)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpMemory ");
      localStringBuilder.append(paramString);
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dumpMemory ");
      localStringBuilder.append(paramString);
      QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramLong);
      LeakInspector.report(localStringBuilder.toString(), paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  public void a(Object paramObject, String paramString)
  {
    if (dH_())
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
  
  public void j()
  {
    k();
    LeakInspector.setKeepUuidWhenLeak(true);
    com.tencent.qapmsdk.memory.MemoryLeakMonitor.enableFragmentInspect = false;
    QAPM.setProperty(110, this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMLeakWrapper
 * JD-Core Version:    0.7.0.1
 */