package cooperation.ilive.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;
import cooperation.ilive.IliveLaunchFragment;
import cooperation.ilive.config.IliveConfigBean;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class IlivePreloadHelper
{
  public static boolean a = false;
  public static boolean b = false;
  private static boolean c = true;
  private static WeakReference<IlivePreloadHelper.PreloadEnd> d;
  
  public static void a()
  {
    Object localObject = d;
    if (localObject == null) {
      return;
    }
    localObject = (IlivePreloadHelper.PreloadEnd)((WeakReference)localObject).get();
    if (localObject != null) {
      ((IlivePreloadHelper.PreloadEnd)localObject).onPreloadEnd();
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new IlivePreloadHelper.1(paramInt, paramContext));
  }
  
  public static void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IlivePreloadHelper", 2, "preload LiveShopping");
    }
    if ((c) && (!b))
    {
      c = false;
      a = true;
      QLog.i("IlivePreloadHelper", 1, "preload start");
      IliveLaunchFragment localIliveLaunchFragment = new IliveLaunchFragment();
      if (paramIntent != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("source", paramIntent.getIntExtra("source", 0));
        localIliveLaunchFragment.setArguments(localBundle);
      }
      localIliveLaunchFragment.doLoading(true, BaseApplicationImpl.getApplication());
      return;
    }
    c = false;
    QLog.e("IlivePreloadHelper", 1, "ilive has preload");
  }
  
  public static void a(IlivePreloadHelper.PreloadEnd paramPreloadEnd)
  {
    if (paramPreloadEnd == null) {
      d = null;
    }
    d = new WeakReference(paramPreloadEnd);
  }
  
  public static void b()
  {
    QLog.i("LiteMonitorTag", 1, "preloadLiteServiceConfig ");
    ThreadCenter.postLogicTask(new IlivePreloadHelper.2());
  }
  
  private static boolean e()
  {
    int i = QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadModelLevel", 21);
    if (Build.VERSION.SDK_INT < i) {
      return false;
    }
    if (!DeviceInfoUtils.isHighPerfDevice()) {
      return false;
    }
    if (f())
    {
      QLog.e("IlivePreloadHelper", 1, "checkDrawerSwitchEnable preload limit");
      return false;
    }
    if (!IliveConfigBean.e()) {
      return false;
    }
    return QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadSwitch", 1) == 1;
  }
  
  private static boolean f()
  {
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("qq_ilive", 4).getLong("last_preload_time", 0L);
    return System.currentTimeMillis() - l < 7200000L;
  }
  
  private static void g()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_ilive", 4).edit();
    localEditor.putLong("last_preload_time", System.currentTimeMillis());
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.util.IlivePreloadHelper
 * JD-Core Version:    0.7.0.1
 */