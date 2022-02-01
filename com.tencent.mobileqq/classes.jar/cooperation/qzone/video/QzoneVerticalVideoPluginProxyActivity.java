package cooperation.qzone.video;

import Override;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import apoh;
import bhlx;
import bkkq;
import bkkz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QzoneVerticalVideoPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String LAUNCH_NAME = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
  private static final String TAG = QzoneVerticalVideoPluginProxyActivity.class.getSimpleName();
  private static final String[] TRANSLUCENT_NOTITLE_ACTIVITY_LIST = new String[0];
  
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
  
  public static void launchPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = QzoneVerticalVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    bkkz localbkkz = new bkkz(0);
    localbkkz.jdField_a_of_type_JavaLangString = paramString;
    localbkkz.e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
    localbkkz.jdField_a_of_type_JavaLangClass = localClass;
    localbkkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbkkz.jdField_b_of_type_Int = paramInt;
    localbkkz.c = 15000;
    localbkkz.f = null;
    localbkkz.jdField_b_of_type_Boolean = false;
    localbkkz.jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
    localbkkz.d = "QZoneVerticalVideo";
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "加载原始插件");
    }
    bkkq.a(paramActivity, localbkkz);
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
    }
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "qzone_vertical_video_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return 2;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return QzoneVerticalVideoPluginProxyActivity.PluginProxyFactory.getPluginProxyActivityClass(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public void handleCrash(Bundle paramBundle, Throwable paramThrowable)
  {
    super.handleCrash(paramBundle, paramThrowable);
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
    apoh.a(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */