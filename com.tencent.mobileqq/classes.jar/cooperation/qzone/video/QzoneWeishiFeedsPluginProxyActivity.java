package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bfcz;
import bfdi;
import bfzg;
import bfzm;
import bgbf;
import bghg;
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
    Class localClass = bghg.a("com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_weishi_feeds_plugin.apk"))
    {
      localObject = new bfdi(0);
      ((bfdi)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bfdi)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
      ((bfdi)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bfdi)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bfdi)localObject).jdField_b_of_type_Int = paramInt;
      ((bfdi)localObject).c = 15000;
      ((bfdi)localObject).f = null;
      ((bfdi)localObject).jdField_b_of_type_Boolean = false;
      ((bfdi)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
      ((bfdi)localObject).d = "QZoneWeishiFeedsVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bfcz.a(paramActivity, (bfdi)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneWeishiFeedsPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bgbf.a(paramActivity), "qzone_weishi_feeds_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_weishi_feeds_plugin.apk");
        }
        localObject = new bfzm(0);
        ((bfzm)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bfzm)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
        ((bfzm)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bfzm)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bfzm)localObject).jdField_b_of_type_Int = paramInt;
        ((bfzm)localObject).c = 15000;
        ((bfzm)localObject).f = null;
        ((bfzm)localObject).jdField_a_of_type_Boolean = false;
        ((bfzm)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
        ((bfzm)localObject).d = "QZoneWeishiFeedsVideo";
        bfzg.a(paramActivity, (bfzm)localObject);
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
    return bghg.a(paramString);
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