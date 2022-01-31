package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePluginVersion
  extends Step
{
  public static final String[] a = { "qwallet_plugin.apk", "qqdataline.apk", "qlink_plugin.apk", "qqsmartdevice.apk", "qqreaderplugin.apk", "readinjoy_plugin.apk", "comic_plugin.apk", "QQWifiPlugin.apk", "group_video_plugin.apk", "qqpim_plugin.apk", "qqindividuality_plugin.apk" };
  
  protected boolean a()
  {
    Context localContext = BaseApplicationImpl.sApplication.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("update_plugin_version", 0);
    Object localObject = localSharedPreferences.getString("cur_version", "");
    QLog.d("UpdatePluginVersion", 1, (String)localObject + ", " + "355371");
    if (!"355371".equals(localObject))
    {
      localObject = PluginUtils.getPluginInstallDir(localContext);
      File localFile1 = localContext.getDir("plugin_info", 0);
      int i = 0;
      while (i < a.length)
      {
        String str = a[i];
        File localFile2 = new File((File)localObject, str + ".cfg");
        boolean bool;
        if (localFile2.exists())
        {
          bool = localFile2.delete();
          QLog.d("UpdatePluginVersion", 1, "clear cfg" + str + bool);
        }
        localFile2 = new File((File)localObject, str);
        int j = 0;
        while ((localFile2.exists()) && (j < 3))
        {
          bool = localFile2.delete();
          QLog.d("UpdatePluginVersion", 1, "clear plugin" + str + bool);
          j += 1;
        }
        localFile2 = new File(localFile1, str + ".cfg");
        if (localFile2.exists())
        {
          bool = localFile2.delete();
          QLog.d("UpdatePluginVersion", 1, "clear update cfg" + str + bool);
        }
        i += 1;
      }
      localSharedPreferences.edit().putString("cur_version", "355371").commit();
      localContext.getSharedPreferences("proc_reporter", 0).edit().clear().commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePluginVersion
 * JD-Core Version:    0.7.0.1
 */