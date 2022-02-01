package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import avil;
import avio;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(avio paramavio, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!avil.a(this.jdField_a_of_type_Avio.a))
    {
      localContext = avil.a(this.jdField_a_of_type_Avio.a);
      str2 = avio.a(this.jdField_a_of_type_Avio);
      localIVPluginInfo = avio.a(this.jdField_a_of_type_Avio);
      localInstalledPlugin = avio.a(this.jdField_a_of_type_Avio);
      str3 = avil.d(this.jdField_a_of_type_Avio.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = avil.e(this.jdField_a_of_type_Avio.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, avil.c(this.jdField_a_of_type_Avio.a), avio.a(this.jdField_a_of_type_Avio));
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