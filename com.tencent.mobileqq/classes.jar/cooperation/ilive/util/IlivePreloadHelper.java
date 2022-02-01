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
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;
import cooperation.ilive.IliveLaunchFragment;
import cooperation.ilive.config.IliveConfigBean;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.IliveLiteHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class IlivePreloadHelper
{
  private static WeakReference<IlivePreloadHelper.PreloadEnd> a;
  public static boolean a = false;
  public static boolean b = false;
  private static boolean c = true;
  
  private static BusinessConfig a()
  {
    Object localObject2 = LiteLiveSDKFactory.a().a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = BusinessManager.a.a();
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new BusinessConfig();
      ((BusinessConfig)localObject2).jdField_a_of_type_JavaLangString = "1037";
    }
    return localObject2;
  }
  
  public static void a()
  {
    Object localObject = jdField_a_of_type_JavaLangRefWeakReference;
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
      jdField_a_of_type_Boolean = true;
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
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPreloadEnd);
  }
  
  private static boolean a(BusinessConfig paramBusinessConfig)
  {
    if (paramBusinessConfig == null) {
      return false;
    }
    return "1".equals(paramBusinessConfig.jdField_a_of_type_JavaUtilHashMap.get("has_preload"));
  }
  
  public static void b()
  {
    QLog.i("LiteMonitorTag", 1, "preloadLiteServiceConfig ");
    ThreadCenter.postLogicTask(new IlivePreloadHelper.2());
  }
  
  private static void b(IliveManagerCfgBean paramIliveManagerCfgBean)
  {
    if ((paramIliveManagerCfgBean != null) && (paramIliveManagerCfgBean.b()))
    {
      paramIliveManagerCfgBean = a();
      if ((LiteLiveSDKFactory.a().a()) && (a(paramIliveManagerCfgBean)))
      {
        QLog.e("IlivePreloadHelper", 1, "has preload");
        return;
      }
      QLog.e("IlivePreloadHelper", 1, "onEnterPreload start");
      paramIliveManagerCfgBean = new IliveJumpParams(BaseApplicationImpl.getContext(), "preload", "1", 0);
      IliveLiteHelper.a().a(paramIliveManagerCfgBean);
      return;
    }
    QLog.e("IlivePreloadHelper", 1, "onEnterPreload disable");
  }
  
  private static boolean b()
  {
    int i = QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadModelLevel", 21);
    if (Build.VERSION.SDK_INT < i) {
      return false;
    }
    if (!DeviceInfoUtils.a()) {
      return false;
    }
    if (c())
    {
      QLog.e("IlivePreloadHelper", 1, "checkDrawerSwitchEnable preload limit");
      return false;
    }
    if (!IliveConfigBean.a()) {
      return false;
    }
    return QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadSwitch", 1) == 1;
  }
  
  private static boolean c()
  {
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("qq_ilive", 4).getLong("last_preload_time", 0L);
    return System.currentTimeMillis() - l < 7200000L;
  }
  
  private static void d()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_ilive", 4).edit();
    localEditor.putLong("last_preload_time", System.currentTimeMillis());
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.util.IlivePreloadHelper
 * JD-Core Version:    0.7.0.1
 */