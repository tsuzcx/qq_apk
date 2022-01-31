package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import anji;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QzoneWeishiFeedsPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String[] a = new String[0];
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = anji.a("com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.a("qzone_weishi_feeds_plugin.apk"))
    {
      localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((IPluginManager.PluginParams)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
      ((IPluginManager.PluginParams)localObject).c = 15000;
      ((IPluginManager.PluginParams)localObject).f = null;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_Boolean = false;
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
      ((IPluginManager.PluginParams)localObject).d = "QZoneWeishiFeedsVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneWeishiFeedsPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(QZonePluginUtils.a(paramActivity), "qzone_weishi_feeds_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_weishi_feeds_plugin.apk");
        }
        localObject = new IQZonePluginManager.PluginParams(0);
        ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((IQZonePluginManager.PluginParams)localObject).e = "com.qzone.commoncode.module.verticalvideo.WeishiFeedsLayerActivity";
        ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((IQZonePluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
        ((IQZonePluginManager.PluginParams)localObject).c = 15000;
        ((IQZonePluginManager.PluginParams)localObject).f = null;
        ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_Boolean = false;
        ((IQZonePluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qzone_weishi_feeds_plugin.apk";
        ((IQZonePluginManager.PluginParams)localObject).d = "QZoneWeishiFeedsVideo";
        IQZonePluginManager.a(paramActivity, (IQZonePluginManager.PluginParams)localObject);
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
  
  protected int getPluginResType()
  {
    return -1;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return anji.a(paramString);
  }
  
  protected int getThemeResId()
  {
    return 0;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneWeishiFeedsPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */