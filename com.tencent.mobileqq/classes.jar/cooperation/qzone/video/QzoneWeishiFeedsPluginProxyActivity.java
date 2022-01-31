package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bgkq;
import bgkz;
import bhhr;
import bhhx;
import bhjq;
import bhqa;
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
    Class localClass = bhqa.a("com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_weishi_feeds_plugin.apk"))
    {
      localObject = new bgkz(0);
      ((bgkz)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bgkz)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
      ((bgkz)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bgkz)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bgkz)localObject).jdField_b_of_type_Int = paramInt;
      ((bgkz)localObject).c = 15000;
      ((bgkz)localObject).f = null;
      ((bgkz)localObject).jdField_b_of_type_Boolean = false;
      ((bgkz)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
      ((bgkz)localObject).d = "QZoneWeishiFeedsVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bgkq.a(paramActivity, (bgkz)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneWeishiFeedsPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bhjq.a(paramActivity), "qzone_weishi_feeds_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_weishi_feeds_plugin.apk");
        }
        localObject = new bhhx(0);
        ((bhhx)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bhhx)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
        ((bhhx)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bhhx)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bhhx)localObject).jdField_b_of_type_Int = paramInt;
        ((bhhx)localObject).c = 15000;
        ((bhhx)localObject).f = null;
        ((bhhx)localObject).jdField_a_of_type_Boolean = false;
        ((bhhx)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
        ((bhhx)localObject).d = "QZoneWeishiFeedsVideo";
        bhhr.a(paramActivity, (bhhx)localObject);
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
    return bhqa.a(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneWeishiFeedsPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */