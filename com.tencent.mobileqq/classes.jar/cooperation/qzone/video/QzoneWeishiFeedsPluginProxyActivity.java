package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bglh;
import bglq;
import bhii;
import bhio;
import bhkh;
import bhqr;
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
    Class localClass = bhqr.a("com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_weishi_feeds_plugin.apk"))
    {
      localObject = new bglq(0);
      ((bglq)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bglq)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
      ((bglq)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bglq)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bglq)localObject).jdField_b_of_type_Int = paramInt;
      ((bglq)localObject).c = 15000;
      ((bglq)localObject).f = null;
      ((bglq)localObject).jdField_b_of_type_Boolean = false;
      ((bglq)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
      ((bglq)localObject).d = "QZoneWeishiFeedsVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bglh.a(paramActivity, (bglq)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneWeishiFeedsPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bhkh.a(paramActivity), "qzone_weishi_feeds_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_weishi_feeds_plugin.apk");
        }
        localObject = new bhio(0);
        ((bhio)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bhio)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
        ((bhio)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bhio)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bhio)localObject).jdField_b_of_type_Int = paramInt;
        ((bhio)localObject).c = 15000;
        ((bhio)localObject).f = null;
        ((bhio)localObject).jdField_a_of_type_Boolean = false;
        ((bhio)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
        ((bhio)localObject).d = "QZoneWeishiFeedsVideo";
        bhii.a(paramActivity, (bhio)localObject);
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
    return bhqr.a(paramString);
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