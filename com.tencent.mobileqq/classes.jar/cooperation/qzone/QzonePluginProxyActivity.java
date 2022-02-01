package cooperation.qzone;

import Override;
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
import android.view.MotionEvent;
import android.widget.CheckBox;
import anzj;
import avsk;
import bdml;
import bhlq;
import bhpc;
import bhtq;
import bmtd;
import bmvi;
import bmvj;
import bmvk;
import bmvl;
import bmvn;
import bmwo;
import bmww;
import bnfk;
import bnkm;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  private bmwo jdField_a_of_type_Bmwo = new bmwo();
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  
  public static ClassLoader a()
  {
    return jdField_a_of_type_JavaLangClassLoader;
  }
  
  public static ClassLoader a(Context paramContext)
  {
    if (jdField_a_of_type_JavaLangClassLoader == null) {
      QLog.e("QzonePluginProxyActivity", 1, new Exception("getQZonePluginClassLoader"), new Object[] { BaseApplicationImpl.processName + " isQzonePluginInstalledAndVersionRight " + bmww.a + " " + bmww.b });
    }
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
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, avsk paramavsk, boolean paramBoolean2)
  {
    b(paramContext, paramString, paramIntent, paramInt, paramOnDismissListener, paramBoolean1, paramavsk, paramBoolean2);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt, avsk paramavsk)
  {
    a(paramContext, paramString, paramIntent, paramInt, null, true, paramavsk, false);
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
  
  private static void b(Context paramContext, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean1, avsk paramavsk, boolean paramBoolean2)
  {
    if ((bmtd.a) && ((paramContext instanceof SplashActivity)))
    {
      paramInt = LocalMultiProcConfig.getInt("qzapp_vercode", 84);
      if (!LocalMultiProcConfig.getBool("qz_safe_mode_no_tip", false))
      {
        paramContext = bhlq.a(paramContext, 230, 2131562614, anzj.a(2131711059), "空间出问题了，启用空间保护模式点\"确定\"；点击\"取消\"，保护模式不会生效。", anzj.a(2131711071), anzj.a(2131711055), new bmvi(paramContext, paramInt, paramString, paramIntent), new bmvj());
        ((CheckBox)paramContext.findViewById(2131365554)).setOnCheckedChangeListener(new bmvk());
        paramContext.show();
      }
      while (bmtd.a(paramContext, paramInt, Long.valueOf(paramString).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
        return;
      }
      bmtd.a(paramIntent.getStringExtra("sid"), paramContext);
      return;
    }
    if ((paramContext instanceof FriendProfileCardActivity)) {
      bdml.a().c(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "launchPluingActivityForResult.isPluginInstalled start， showProgressDialog：" + paramBoolean1);
    }
    bmtd.a(paramBoolean1, new bmvl(paramIntent, paramString, paramavsk, paramInt, paramBoolean2, paramContext, paramOnDismissListener));
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
    String str = bnfk.a();
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
  
  public bmwo a()
  {
    return this.jdField_a_of_type_Bmwo;
  }
  
  public IPluginActivity a()
  {
    return this.mPluginActivity;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
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
    return bmvn.a(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    bhtq.a();
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
        localObject = new StringBuffer(anzj.a(2131711073));
        ((StringBuffer)localObject).append(paramBundle).append(" ").append(this.mCreateErrorInfo);
        QLog.e("QZLog", 1, ((StringBuffer)localObject).toString());
        bnkm.a(new QZoneStartupFailException(this.mCreateErrorInfo), anzj.a(2131711060) + getPluginActivity());
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
    this.jdField_a_of_type_Bmwo.a(this);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bmwo.c();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    this.jdField_a_of_type_Bmwo.a(paramInt, paramKeyEvent);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bmwo.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Bmwo.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */