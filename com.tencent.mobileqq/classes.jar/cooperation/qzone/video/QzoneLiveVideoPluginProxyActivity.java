package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anjg;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;
import cooperation.qzone.plugin.QZonePluginUtils;
import java.io.File;

public class QzoneLiveVideoPluginProxyActivity
  extends PluginProxyActivity
{
  private static final String[] a = { "com.qzone.adapter.livevideo.RewardGiftActivity", "com.qzonex.module.global.FeedActionPanelActivity" };
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = anjg.a("com.qzone.adapter.livevideo.QZoneLiveVideoActivity");
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject = QZonePluginUtils.a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
    }
    for (;;)
    {
      return;
      if (((String)localObject).equals("qzone_live_video_plugin_hack.apk")) {
        if (new File(QZonePluginUtils.a(paramActivity), (String)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:" + (String)localObject);
          }
          localObject = new IQZonePluginManager.PluginParams(0);
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
          ((IQZonePluginManager.PluginParams)localObject).e = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = localClass;
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
          ((IQZonePluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
          ((IQZonePluginManager.PluginParams)localObject).c = 15000;
          ((IQZonePluginManager.PluginParams)localObject).f = null;
          ((IQZonePluginManager.PluginParams)localObject).jdField_a_of_type_Boolean = false;
          ((IQZonePluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
          ((IQZonePluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
          IQZonePluginManager.a(paramActivity, (IQZonePluginManager.PluginParams)localObject);
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
          localObject = new IPluginManager.PluginParams(0);
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
          ((IPluginManager.PluginParams)localObject).e = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = localClass;
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
          ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
          ((IPluginManager.PluginParams)localObject).c = 15000;
          ((IPluginManager.PluginParams)localObject).f = null;
          ((IPluginManager.PluginParams)localObject).jdField_a_of_type_Boolean = false;
          ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qzone_live_video_plugin.apk";
          ((IPluginManager.PluginParams)localObject).d = "QZoneLiveVideo";
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "加载原始插件");
          }
          IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
        }
      }
    }
    label355:
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
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
  
  protected Class getProxyActivity(String paramString)
  {
    return anjg.a(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */