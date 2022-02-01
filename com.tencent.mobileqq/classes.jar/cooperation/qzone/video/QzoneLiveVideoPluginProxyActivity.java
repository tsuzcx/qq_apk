package cooperation.qzone.video;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import apoh;
import bhlx;
import bkkq;
import bkkz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QzoneLiveVideoPluginProxyActivity
  extends PluginProxyActivity
{
  public static final String EC_LAUNCH_NAME = "com.qzone.adapter.livevideo.ECLiveVideoActivity";
  public static final String QZONE_LAUNCH_NAME = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
  private static final String[] TRANSLUCENT_NOTITLE_ACTIVITY_LIST = { "com.qzone.adapter.livevideo.RewardGiftActivity", "com.qzonex.module.global.FeedActionPanelActivity", "com.qzone.adapter.livevideo.LiveCommonActivity" };
  Object mPermissionCaller = null;
  
  private static boolean isStringInArray(String[] paramArrayOfString, String paramString)
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
  
  public static void launchPluginActivityForResult(Activity paramActivity, String paramString1, Intent paramIntent, int paramInt, String paramString2)
  {
    Class localClass = QzoneLiveVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass(paramString2);
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject = QZonePluginUtils.getLoadQZoneLivePluginId();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
    }
    for (;;)
    {
      return;
      if (((String)localObject).equals("qzone_live_video_plugin_hack.apk")) {
        if (new File(QZonePluginUtils.getPluginInstallDir(paramActivity), (String)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:" + (String)localObject);
          }
          localObject = new IQZonePluginManager.PluginParams(0);
          ((IQZonePluginManager.PluginParams)localObject).mUin = paramString1;
          ((IQZonePluginManager.PluginParams)localObject).mConponentName = paramString2;
          ((IQZonePluginManager.PluginParams)localObject).mProxyActivityClass = localClass;
          ((IQZonePluginManager.PluginParams)localObject).mIntent = paramIntent;
          ((IQZonePluginManager.PluginParams)localObject).mRequestCode = paramInt;
          ((IQZonePluginManager.PluginParams)localObject).mTimeOut = 15000;
          ((IQZonePluginManager.PluginParams)localObject).mProgressTips = null;
          ((IQZonePluginManager.PluginParams)localObject).mDialogDismissBySDK = false;
          ((IQZonePluginManager.PluginParams)localObject).mPluginID = "qzone_live_video_plugin_hack.apk";
          ((IQZonePluginManager.PluginParams)localObject).mPluginName = "QZoneLiveVideo";
          IQZonePluginManager.openActivityForResult(paramActivity, (IQZonePluginManager.PluginParams)localObject);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("PluginDebug", 2, "QzoneLiveVideoPluginProxyActivity.launchPluingActivityForResult");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("PluginDebug", 2, "launchPluginActivityForResult 加载动态包不存在");
          continue;
          if (!"qzone_live_video_plugin.apk".equals(localObject)) {
            break label355;
          }
          localObject = new bkkz(0);
          ((bkkz)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((bkkz)localObject).e = paramString2;
          ((bkkz)localObject).jdField_a_of_type_JavaLangClass = localClass;
          ((bkkz)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
          ((bkkz)localObject).jdField_b_of_type_Int = paramInt;
          ((bkkz)localObject).c = 15000;
          ((bkkz)localObject).f = null;
          ((bkkz)localObject).jdField_b_of_type_Boolean = false;
          ((bkkz)localObject).jdField_b_of_type_JavaLangString = "qzone_live_video_plugin.apk";
          ((bkkz)localObject).d = "QZoneLiveVideo";
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "加载原始插件");
          }
          bkkq.a(paramActivity, (bkkz)localObject);
        }
      }
    }
    label355:
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return QzoneLiveVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass(paramString);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bhlx.a(BaseApplicationImpl.getContext(), false, 5);
    apoh.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    super.requestPermissions(paramObject, paramInt, paramVarArgs);
    this.mPermissionCaller = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */