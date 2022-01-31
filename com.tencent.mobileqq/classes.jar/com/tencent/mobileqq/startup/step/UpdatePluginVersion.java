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
  public static final String[] a = { "qwallet_plugin.apk", "qqdataline.apk", "qlink_plugin.apk", "qqsmartdevice.apk", "qqreaderplugin.apk", "readinjoy_plugin.apk", "comic_plugin.apk", "QQWifiPlugin.apk", "group_video_plugin.apk", "qqpim_plugin.apk", "qqindividuality_plugin.apk", "LiveRoomPlugin.apk", "qzone_live_video_plugin.apk" };
  
  protected boolean doStep()
  {
    Context localContext = BaseApplicationImpl.sApplication.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("update_plugin_version", 0);
    Object localObject = localSharedPreferences.getString("cur_version", "");
    String str1 = AppSetting.f();
    QLog.d("UpdatePluginVersion", 1, (String)localObject + ", " + str1);
    if (!str1.equals(localObject))
    {
      localObject = PluginUtils.getPluginInstallDir(localContext);
      File localFile1 = localContext.getDir("plugin_info", 0);
      int i = 0;
      while (i < a.length)
      {
        String str2 = a[i];
        File localFile2 = new File((File)localObject, str2 + ".cfg");
        boolean bool;
        if (localFile2.exists())
        {
          bool = localFile2.delete();
          QLog.d("UpdatePluginVersion", 1, "clear cfg" + str2 + bool);
        }
        localFile2 = new File((File)localObject, str2);
        int j = 0;
        while ((localFile2.exists()) && (j < 3))
        {
          bool = localFile2.delete();
          QLog.d("UpdatePluginVersion", 1, "clear plugin" + str2 + bool);
          j += 1;
        }
        localFile2 = new File(localFile1, str2 + ".cfg");
        if (localFile2.exists())
        {
          bool = localFile2.delete();
          QLog.d("UpdatePluginVersion", 1, "clear update cfg" + str2 + bool);
        }
        i += 1;
      }
      localSharedPreferences.edit().putString("cur_version", str1).commit();
      localContext.getSharedPreferences("proc_reporter", 0).edit().clear().commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePluginVersion
 * JD-Core Version:    0.7.0.1
 */