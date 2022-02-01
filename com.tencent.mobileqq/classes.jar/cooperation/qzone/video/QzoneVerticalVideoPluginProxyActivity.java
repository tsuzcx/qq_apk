package cooperation.qzone.video;

import Override;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import aquy;
import bjfr;
import bmgk;
import bmgt;
import bnls;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QzoneVerticalVideoPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String jdField_a_of_type_JavaLangString = QzoneVerticalVideoPluginProxyActivity.class.getSimpleName();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = bnls.a("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    bmgt localbmgt = new bmgt(0);
    localbmgt.jdField_a_of_type_JavaLangString = paramString;
    localbmgt.e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
    localbmgt.jdField_a_of_type_JavaLangClass = localClass;
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbmgt.jdField_b_of_type_Int = paramInt;
    localbmgt.c = 15000;
    localbmgt.f = null;
    localbmgt.jdField_b_of_type_Boolean = false;
    localbmgt.jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
    localbmgt.d = "QZoneVerticalVideo";
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "加载原始插件");
    }
    bmgk.a(paramActivity, localbmgt);
    if (QLog.isColorLevel()) {
      QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
    }
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
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
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
    return "qzone_vertical_video_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return 2;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return bnls.a(paramString);
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
    bjfr.a(BaseApplicationImpl.getContext(), false, 5);
    aquy.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    aquy.a(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */