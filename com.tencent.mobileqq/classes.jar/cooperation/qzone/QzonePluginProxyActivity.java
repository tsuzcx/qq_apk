package cooperation.qzone;

import alud;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.CheckBox;
import asta;
import azrq;
import bdgm;
import bdjz;
import bdoo;
import bjdt;
import bjfz;
import bjga;
import bjgb;
import bjgc;
import bjge;
import bjhg;
import bjpz;
import bjuz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.exception.QZoneStartupFailException;
import java.util.Iterator;
import java.util.List;

public class QzonePluginProxyActivity
  extends PluginProxyFragmentActivity
  implements QzoneJumpQBrowserInterface
{
  public static volatile ClassLoader a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QZonePanoramaActivity", "com.qzone.preview.QzonePictureSelectViewer" };
  private static final String[] b = { "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity", "com.qzone.common.activities.QzoneAdaptVideoActivity", "com.qzone.log.CrashNotificationActivity", "com.qzone.common.activities.NotificationActivity", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity", "com.qzone.misc.web.QZoneTranslucentActivity", "com.qzone.misc.web.QZoneTranslucentActivity2", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.album.business.dlna.activity.DLNAActivity", "com.qzone.bulletscreen.BulletScreenActivity", "com.qzone.common.activities.base.QzoneGiftPanelActivity", "com.qzone.common.activities.QzoneDualWarmActivity" };
  private bjhg jdField_a_of_type_Bjhg = new bjhg();
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  
  public static ClassLoader a()
  {
    return jdField_a_of_type_JavaLangClassLoader;
  }
  
  public static ClassLoader a(Context paramContext)
  {
    jdField_a_of_type_JavaLangClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
    return jdField_a_of_type_JavaLangClassLoader;
  }
  
  public static String a()
  {
    return "qzone_plugin.apk";
  }
  
  public static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_plugin_activity_name");
  }
  
  private void a()
  {
    Intent localIntent = new Intent("action_launch_completed");
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "FriendFeed", "好友动态");
    localIntent.putExtra("plugin_apk", this.mPluginID);
    localIntent.putExtra("plugin_name", str);
    sendBroadcast(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null, true, null, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramContext, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    a(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean, null, false);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, asta paramasta, boolean paramBoolean2)
  {
    b(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean1, paramasta, paramBoolean2);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, asta paramasta)
  {
    a(paramContext, paramString, paramIntent, paramInt, null, true, paramasta, false);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qzone_plugin_activity_name", paramString);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putBoolean("cleartop", true);
    paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
    paramBundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
    paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
  }
  
  public static boolean a()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:qzone".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzonePluginProxyActivity", 2, "QzoneProcess is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  public static ClassLoader b(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "Photoplus.apk");
  }
  
  private static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, asta paramasta, boolean paramBoolean2)
  {
    if ((bjdt.a) && ((paramContext instanceof SplashActivity)))
    {
      paramInt = LocalMultiProcConfig.getInt("qzapp_vercode", 84);
      if (!LocalMultiProcConfig.getBool("qz_safe_mode_no_tip", false))
      {
        paramContext = bdgm.a(paramContext, 230, 2131562338, alud.a(2131712571), "空间出问题了，启用空间保护模式点\"确定\"；点击\"取消\"，保护模式不会生效。", alud.a(2131712583), alud.a(2131712567), new bjfz(paramContext, paramInt, paramString, paramIntent), new bjga());
        ((CheckBox)paramContext.findViewById(2131365269)).setOnCheckedChangeListener(new bjgb());
        paramContext.show();
      }
      while (bjdt.a(paramContext, paramInt, Long.valueOf(paramString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
        return;
      }
      bjdt.a(paramIntent.getStringExtra("sid"), paramContext);
      return;
    }
    if ((paramContext instanceof FriendProfileCardActivity)) {
      azrq.a().c(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "launchPluingActivityForResult.isPluginInstalled start， showProgressDialog：" + paramBoolean1);
    }
    bjdt.a(paramBoolean1, new bjgc(paramIntent, paramString, paramasta, paramInt, paramBoolean2, paramContext, paramOnDismissListener));
  }
  
  private static boolean b(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
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
  }
  
  public static ClassLoader c(Context paramContext)
  {
    ClassLoader localClassLoader = null;
    String str = bjpz.a();
    if (str.equals("qzone_live_video_plugin_hack.apk")) {
      localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "getQzoneLiveClassLoader classsloader: " + localClassLoader);
      }
      return localClassLoader;
      if (str.equals("qzone_live_video_plugin.apk")) {
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_live_video_plugin.apk");
      }
    }
  }
  
  public static ClassLoader d(Context paramContext)
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_vertical_video_plugin.apk");
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "getQzoneVerticalVideoClassLoader classsloader: " + paramContext);
    }
    return paramContext;
  }
  
  public static ClassLoader e(Context paramContext)
  {
    paramContext = PluginStatic.getOrCreateClassLoader(paramContext, "qzone_weishi_feeds_plugin.apk");
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "getQzoneWeishiFeedsClassLoader classsloader: " + paramContext);
    }
    return paramContext;
  }
  
  public bjhg a()
  {
    return this.jdField_a_of_type_Bjhg;
  }
  
  public IPluginActivity a()
  {
    return this.mPluginActivity;
  }
  
  public String getPluginID()
  {
    return "qzone_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return 1;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return bjge.a(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    bdoo.a();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new QZoneTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    }
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success")))
    {
      if (paramBundle != null) {}
      for (;;)
      {
        paramBundle = paramBundle.getString("pluginsdk_launchActivity");
        localObject = new StringBuffer(alud.a(2131712585));
        ((StringBuffer)localObject).append(paramBundle).append(" ").append(this.mCreateErrorInfo);
        QLog.e("QZLog", 1, ((StringBuffer)localObject).toString());
        bjuz.a(new QZoneStartupFailException(this.mCreateErrorInfo), alud.a(2131712572) + getPluginActivity());
        a();
        return;
        paramBundle = getIntent().getExtras();
      }
    }
    Object localObject = getIntent().getExtras();
    if (localObject != null)
    {
      paramBundle = ((Bundle)localObject).getString("from_plugin");
      localObject = ((Bundle)localObject).getString("uin");
      getIntent().putExtra("from_plugin", "");
      if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("QZoneVideoPlugin"))) {
        a(this, (String)localObject, getIntent(), 1000);
      }
    }
    this.jdField_a_of_type_Bjhg.a(this);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bjhg.c();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    this.jdField_a_of_type_Bjhg.a(paramInt, paramKeyEvent);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bjhg.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Bjhg.b();
  }
  
  public boolean shouldHandleStartPluginFailed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    label60:
    do
    {
      do
      {
        return false;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginPermissionErrorHandle", 1) != 0) {}
        int j;
        for (i = 1;; i = 0)
        {
          j = QzoneConfig.getInstance().getConfig("QZoneSetting", "PluginErrorHandleCount", -1);
          if (j != 0) {
            break label60;
          }
          if (i == 0) {
            break;
          }
          return super.shouldHandleStartPluginFailed(paramString);
        }
        paramString = paramString.toLowerCase();
        if (!paramString.contains("classnotfoundexception")) {
          break;
        }
        SharedPreferences localSharedPreferences = getSharedPreferences("Qz_setting", 0);
        int k = localSharedPreferences.getInt("Crash_Count_In_CNFException", 0);
        localSharedPreferences.edit().putInt("Crash_Count_In_CNFException", k + 1).commit();
        if (k == 0)
        {
          QLog.e("Plugin", 1, "kill process with first Exception:" + paramString);
          finish();
          Process.killProcess(Process.myPid());
        }
        for (;;)
        {
          return true;
          if ((j >= 0) && (k >= j)) {
            break;
          }
          QLog.e("Plugin", 1, "show dialog with non-first Exception:" + paramString);
          showNeedUninstanllAndInstallDialog();
        }
      } while (i == 0);
      return super.shouldHandleStartPluginFailed(paramString);
    } while (i == 0);
    return super.shouldHandleStartPluginFailed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */