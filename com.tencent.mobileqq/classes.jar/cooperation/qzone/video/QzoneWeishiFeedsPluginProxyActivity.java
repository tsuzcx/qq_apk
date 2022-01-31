package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import biqn;
import biqw;
import bjoa;
import bjog;
import bjpz;
import bjwj;
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
    Class localClass = bjwj.a("com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_weishi_feeds_plugin.apk"))
    {
      localObject = new biqw(0);
      ((biqw)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((biqw)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
      ((biqw)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((biqw)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((biqw)localObject).jdField_b_of_type_Int = paramInt;
      ((biqw)localObject).c = 15000;
      ((biqw)localObject).f = null;
      ((biqw)localObject).jdField_b_of_type_Boolean = false;
      ((biqw)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
      ((biqw)localObject).d = "QZoneWeishiFeedsVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      biqn.a(paramActivity, (biqw)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneWeishiFeedsPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bjpz.a(paramActivity), "qzone_weishi_feeds_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_weishi_feeds_plugin.apk");
        }
        localObject = new bjog(0);
        ((bjog)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bjog)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
        ((bjog)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bjog)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bjog)localObject).jdField_b_of_type_Int = paramInt;
        ((bjog)localObject).c = 15000;
        ((bjog)localObject).f = null;
        ((bjog)localObject).jdField_a_of_type_Boolean = false;
        ((bjog)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
        ((bjog)localObject).d = "QZoneWeishiFeedsVideo";
        bjoa.a(paramActivity, (bjog)localObject);
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
    return bjwj.a(paramString);
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