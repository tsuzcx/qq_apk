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
    String str = AppSetting.g();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", ");
    ((StringBuilder)localObject3).append(str);
    QLog.d("UpdatePluginVersion", 1, ((StringBuilder)localObject3).toString());
    if (!str.equals(localObject1))
    {
      localObject1 = PluginUtils.getPluginInstallDir((Context)localObject2);
      localObject2 = ((Context)localObject2).getDir("plugin_info", 0);
      int i = 0;
      for (;;)
      {
        localObject3 = a;
        if (i >= localObject3.length) {
          break;
        }
        localObject3 = localObject3[i];
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(".cfg");
        localObject4 = new File((File)localObject1, ((StringBuilder)localObject4).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clear start ");
        localStringBuilder.append((String)localObject3);
        QLog.d("UpdatePluginVersion", 1, localStringBuilder.toString());
        boolean bool;
        if (((File)localObject4).exists())
        {
          bool = ((File)localObject4).delete();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("clear cfg");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(bool);
          QLog.d("UpdatePluginVersion", 1, ((StringBuilder)localObject4).toString());
        }
        localObject4 = new File((File)localObject1, (String)localObject3);
        int j = 0;
        while ((((File)localObject4).exists()) && (j < 3))
        {
          bool = ((File)localObject4).delete();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("clear plugin");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(bool);
          QLog.d("UpdatePluginVersion", 1, localStringBuilder.toString());
          j += 1;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(".cfg");
        localObject4 = new File((File)localObject2, ((StringBuilder)localObject4).toString());
        if (((File)localObject4).exists())
        {
          bool = ((File)localObject4).delete();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("clear update cfg");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(bool);
          QLog.d("UpdatePluginVersion", 1, ((StringBuilder)localObject4).toString());
        }
        i += 1;
      }
      localSharedPreferences.edit().putString("cur_version", str).commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePluginVersion
 * JD-Core Version:    0.7.0.1
 */