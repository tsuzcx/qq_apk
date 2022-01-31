package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bimg;
import bimp;
import bjjt;
import bjjz;
import bjls;
import bjsc;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import java.io.File;

public class QzoneWeishiFeedsPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String[] a = new String[0];
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = bjsc.a("com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_weishi_feeds_plugin.apk"))
    {
      localObject = new bimp(0);
      ((bimp)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bimp)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
      ((bimp)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bimp)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bimp)localObject).jdField_b_of_type_Int = paramInt;
      ((bimp)localObject).c = 15000;
      ((bimp)localObject).f = null;
      ((bimp)localObject).jdField_b_of_type_Boolean = false;
      ((bimp)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
      ((bimp)localObject).d = "QZoneWeishiFeedsVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bimg.a(paramActivity, (bimp)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneWeishiFeedsPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bjls.a(paramActivity), "qzone_weishi_feeds_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_weishi_feeds_plugin.apk");
        }
        localObject = new bjjz(0);
        ((bjjz)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bjjz)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
        ((bjjz)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bjjz)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bjjz)localObject).jdField_b_of_type_Int = paramInt;
        ((bjjz)localObject).c = 15000;
        ((bjjz)localObject).f = null;
        ((bjjz)localObject).jdField_a_of_type_Boolean = false;
        ((bjjz)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
        ((bjjz)localObject).d = "QZoneWeishiFeedsVideo";
        bjjt.a(paramActivity, (bjjz)localObject);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("PluginDebug", 2, "launchPluginActivityForResult 加载动态包不存在");
      }
    }
  }
  
  public String getPluginID()
  {
    return "qzone_weishi_feeds_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return -1;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return bjsc.a(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.video.QzoneWeishiFeedsPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */