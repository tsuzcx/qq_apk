package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePluginVersion
  extends Step
{
  public static final String[] a = { "expand.apk", "qwallet_plugin.apk", "qqdataline.apk", "qlink_plugin.apk", "qqsmartdevice.apk", "qqreaderplugin.apk", "readinjoy_plugin.apk", "comic_plugin.apk", "QQWifiPlugin.apk", "group_video_plugin.apk", "qqpim_plugin.apk", "qqindividuality_plugin.apk", "LiveRoomPlugin.apk", "qzone_live_video_plugin.apk", "qzone_vertical_video_plugin.apk" };
  
  protected boolean doStep()
  {
    Object localObject2 = BaseApplicationImpl.sApplication.getApplicationContext();
    SharedPreferences localSharedPreferences = ((Context)localObject2).getSharedPreferences("update_plugin_version", 0);
    Object localObject1 = localSharedPreferences.getString("cur_version", "");
    String str1 = AppSetting.g();
    QLog.d("UpdatePluginVersion", 1, (String)localObject1 + ", " + str1);
    if (!str1.equals(localObject1))
    {
      localObject1 = PluginUtils.getPluginInstallDir((Context)localObject2);
      localObject2 = ((Context)localObject2).getDir("plugin_info", 0);
      int i = 0;
      while (i < a.length)
      {
        String str2 = a[i];
        File localFile = new File((File)localObject1, str2 + ".cfg");
        QLog.d("UpdatePluginVersion", 1, "clear start " + str2);
        boolean bool;
        if (localFile.exists())
        {
          bool = localFile.delete();
          QLog.d("UpdatePluginVersion", 1, "clear cfg" + str2 + bool);
        }
        localFile = new File((File)localObject1, str2);
        int j = 0;
        while ((localFile.exists()) && (j < 3))
        {
          bool = localFile.delete();
          QLog.d("UpdatePluginVersion", 1, "clear plugin" + str2 + bool);
          j += 1;
        }
        localFile = new File((File)localObject2, str2 + ".cfg");
        if (localFile.exists())
        {
          bool = localFile.delete();
          QLog.d("UpdatePluginVersion", 1, "clear update cfg" + str2 + bool);
        }
        i += 1;
      }
      localSharedPreferences.edit().putString("cur_version", str1).commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePluginVersion
 * JD-Core Version:    0.7.0.1
 */