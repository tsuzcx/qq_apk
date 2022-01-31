package cooperation.qzone.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aobd;
import betl;
import bimg;
import bimp;
import bjjt;
import bjjz;
import bjls;
import bjry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import java.io.File;

public class QzoneVerticalVideoPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String jdField_a_of_type_JavaLangString = QzoneVerticalVideoPluginProxyActivity.class.getSimpleName();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = bjry.a("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_vertical_video_plugin.apk"))
    {
      localObject = new bimp(0);
      ((bimp)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bimp)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
      ((bimp)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bimp)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bimp)localObject).jdField_b_of_type_Int = paramInt;
      ((bimp)localObject).c = 15000;
      ((bimp)localObject).f = null;
      ((bimp)localObject).jdField_b_of_type_Boolean = false;
      ((bimp)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
      ((bimp)localObject).d = "QZoneVerticalVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bimg.a(paramActivity, (bimp)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bjls.a(paramActivity), "qzone_vertical_video_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_vertical_video_plugin.apk");
        }
        localObject = new bjjz(0);
        ((bjjz)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bjjz)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
        ((bjjz)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bjjz)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bjjz)localObject).jdField_b_of_type_Int = paramInt;
        ((bjjz)localObject).c = 15000;
        ((bjjz)localObject).f = null;
        ((bjjz)localObject).jdField_a_of_type_Boolean = false;
        ((bjjz)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
        ((bjjz)localObject).d = "QZoneVerticalVideo";
        bjjt.a(paramActivity, (bjjz)localObject);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("PluginDebug", 2, "launchPluginActivityForResult 加载动态包不存在");
      }
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
    return bjry.a(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public void handleCrash(Bundle paramBundle, Throwable paramThrowable)
  {
    super.handleCrash(paramBundle, paramThrowable);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    betl.a(BaseApplicationImpl.getContext(), false, 5);
    aobd.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */