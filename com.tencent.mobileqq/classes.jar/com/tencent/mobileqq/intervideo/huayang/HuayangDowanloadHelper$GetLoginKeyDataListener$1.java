package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import awat;
import awaw;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(awaw paramawaw, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!awat.a(this.jdField_a_of_type_Awaw.a))
    {
      localContext = awat.a(this.jdField_a_of_type_Awaw.a);
      str2 = awaw.a(this.jdField_a_of_type_Awaw);
      localIVPluginInfo = awaw.a(this.jdField_a_of_type_Awaw);
      localInstalledPlugin = awaw.a(this.jdField_a_of_type_Awaw);
      str3 = awat.d(this.jdField_a_of_type_Awaw.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = awat.e(this.jdField_a_of_type_Awaw.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, awat.c(this.jdField_a_of_type_Awaw.a), awaw.a(this.jdField_a_of_type_Awaw));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        Context localContext;
        String str2;
        IVPluginInfo localIVPluginInfo;
        InstalledPlugin localInstalledPlugin;
        String str3;
        return;
        String str1 = null;
      }
    }
    QLog.d("HuayangPluginNewDownloader", 2, "isNeedStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper.GetLoginKeyDataListener.1
 * JD-Core Version:    0.7.0.1
 */