package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.CheckBox;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzonePatchApi;
import com.tencent.qzonehub.api.IQzonePluginProxyActivityProxy;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QzonePluginProxyActivityProxyImpl
  implements IQzonePluginProxyActivityProxy
{
  private static final String[] PICTURE_VIEWER_ACTIVITY_LIST = { "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QZonePanoramaActivity", "com.qzone.preview.QzonePictureSelectViewer" };
  public static final String QZONE_EXTRA_KEY_PLUGIN_ISLOADING = "QZoneExtra.Plugin.isloading";
  static final String QZONE_PLGUIN_APK = "qzone_plugin.apk";
  public static final String QZONE_PLUGIN_ACTIVITY_NAME = "qzone_plugin_activity_name";
  static final String QZONE_PLUGIN_NAME = "QZone";
  private static final String TAG = "QzonePluginProxyActivityProxyImpl";
  private static final String[] TRANSLUCENT_NOTITLE_ACTIVITY_LIST = { "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity", "com.qzone.common.activities.QzoneAdaptVideoActivity", "com.qzone.log.CrashNotificationActivity", "com.qzone.common.activities.NotificationActivity", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity", "com.qzone.misc.web.QZoneTranslucentActivity", "com.qzone.misc.web.QZoneTranslucentActivity2", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.album.business.dlna.activity.DLNAActivity", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.common.activities.base.QzoneGiftPanelActivity", "com.qzone.common.activities.QzoneDualWarmActivity" };
  
  private void checkStartupSuceess()
  {
    boolean bool2 = isQzoneExist();
    boolean bool1 = false;
    if (!bool2)
    {
      long l2 = 0L;
      long l1 = l2;
      if (BaseApplicationImpl.sApplication != null)
      {
        l1 = l2;
        if (BaseApplicationImpl.sApplication.getRuntime() != null) {
          l1 = BaseApplicationImpl.sApplication.getRuntime().getLongAccountUin();
        }
      }
      int i = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, l1);
      if (i == 8)
      {
        localObject1 = LocalMultiProcConfig.getString4Uin("creditmessage", "", l1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("空间被封，creditLevel:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",msg:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.w("QzonePluginProxyActivityProxyImpl", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      QLog.w("QzonePluginProxyActivityProxyImpl", 1, "qzone进程可能启动失败");
      i = LocalMultiProcConfig.getInt("qzone_app_start_fail_count", 0) + 1;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_startup_failed_toast_show_limit", 1) < i)
      {
        localObject1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_startup_fail_msg", HardCodeUtil.a(2131909757));
        QQToast.makeText(BaseApplicationImpl.sApplication, 4, (CharSequence)localObject1, 1).show();
        LocalMultiProcConfig.putInt("qzone_app_start_fail_count", 0);
        QLog.w("QzonePluginProxyActivityProxyImpl", 1, "qzone进程可能启动失败弹出toast提示用户卸载重新安装");
        bool1 = true;
      }
      else
      {
        LocalMultiProcConfig.putInt("qzone_app_start_fail_count", i);
      }
      Object localObject1 = (IQzoneExceptionReport)QRoute.api(IQzoneExceptionReport.class);
      Object localObject2 = new QZoneStartupFailException("qzone进程启动失败");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qzone进程启动失败,failCount:");
      localStringBuilder.append(i);
      localStringBuilder.append(",showToast:");
      localStringBuilder.append(bool1);
      ((IQzoneExceptionReport)localObject1).doReport((Throwable)localObject2, localStringBuilder.toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("qzone进程启动失败,failCount:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",showToast:");
      ((StringBuilder)localObject1).append(bool1);
      QLog.w("QzonePluginProxyActivityProxyImpl", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzonePluginProxyActivityProxyImpl", 1, "qzone进程启动成功");
    }
    LocalMultiProcConfig.putInt("qzone_app_start_fail_count", 0);
  }
  
  static String getActivityNameToIntent(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_plugin_activity_name");
  }
  
  public static boolean isQzoneExist()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if ("com.tencent.mobileqq:qzone".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QzonePluginProxyActivityProxyImpl", 2, "QzoneProcess is exist");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean isStringInArray(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static void openActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    openActivityForResult(paramActivity, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean, paramPreloadProcHitPluginSession, false);
  }
  
  private static void openActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean2)
  {
    if ((QZoneHelper.comboqzProtectEnable) && ((paramContext instanceof SplashActivity)))
    {
      paramInt = LocalMultiProcConfig.getInt("qzapp_vercode", 84);
      if (!LocalMultiProcConfig.getBool("qz_safe_mode_no_tip", false))
      {
        paramContext = DialogUtil.a(paramContext, 230, 2080636952, HardCodeUtil.a(2131909746), "空间出问题了，启用空间保护模式点\"确定\"；点击\"取消\"，保护模式不会生效。", HardCodeUtil.a(2131898212), HardCodeUtil.a(2131899883), new QzonePluginProxyActivityProxyImpl.1(paramContext, paramInt, paramString, paramIntent), new QzonePluginProxyActivityProxyImpl.2());
        ((CheckBox)paramContext.findViewById(2080571438)).setOnCheckedChangeListener(new QzonePluginProxyActivityProxyImpl.3());
        paramContext.show();
        return;
      }
      if (!QZoneHelper.forwardQZoneApp(paramContext, paramInt, Long.valueOf(paramString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
        QZoneHelper.forwardH5QZone(paramIntent.getStringExtra("sid"), paramContext);
      }
      return;
    }
    if (((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isProfileCardActivity(paramContext)) {
      StatisticHitRateCollector.a().c(paramString);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchPluingActivityForResult.isPluginInstalled start， showProgressDialog：");
      localStringBuilder.append(paramBoolean1);
      QLog.d("PluginDebug", 2, localStringBuilder.toString());
    }
    QZoneHelper.openActivityAsync(paramBoolean1, new QzonePluginProxyActivityProxyImpl.4(paramIntent, paramString, paramPreloadProcHitPluginSession, paramInt, paramBoolean2, paramContext, paramOnDismissListener));
  }
  
  public ClassLoader getPhotoPlusClassLoader(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "Photoplus.apk");
  }
  
  public String getPluginID()
  {
    return "qzone_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return QzonePluginProxyActivityProxyImpl.PluginProxyActivityClassFactory.a(paramString);
  }
  
  public ClassLoader getQzoneLiveClassLoader(Context paramContext)
  {
    Object localObject = ((IQzonePatchApi)QRoute.api(IQzonePatchApi.class)).getLoadQZoneLivePluginId();
    if (((String)localObject).equals("qzone_live_video_plugin_hack.apk")) {
      paramContext = PluginStatic.getOrCreateClassLoader(paramContext, (String)localObject);
    } else if (((String)localObject).equals("qzone_live_video_plugin.apk")) {
      paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_live_video_plugin.apk");
    } else {
      paramContext = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getQzoneLiveClassLoader classsloader: ");
      ((StringBuilder)localObject).append(paramContext);
      QLog.i("patch", 2, ((StringBuilder)localObject).toString());
    }
    return paramContext;
  }
  
  public ClassLoader getQzoneVerticalVideoClassLoader(Context paramContext)
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_vertical_video_plugin.apk");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQzoneVerticalVideoClassLoader classsloader: ");
      localStringBuilder.append(paramContext);
      QLog.i("patch", 2, localStringBuilder.toString());
    }
    return paramContext;
  }
  
  public ClassLoader getQzoneWeishiFeedsClassLoader(Context paramContext)
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_weishi_feeds_plugin.apk");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQzoneWeishiFeedsClassLoader classsloader: ");
      localStringBuilder.append(paramContext);
      QLog.i("patch", 2, localStringBuilder.toString());
    }
    return paramContext;
  }
  
  public void launchPluingActivityForResult(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, boolean paramBoolean2)
  {
    openActivityForResult(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean1, paramPreloadProcHitPluginSession, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl
 * JD-Core Version:    0.7.0.1
 */