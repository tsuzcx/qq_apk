package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import avto;
import avtr;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(avtr paramavtr, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!avto.a(this.jdField_a_of_type_Avtr.a))
    {
      localContext = avto.a(this.jdField_a_of_type_Avtr.a);
      str2 = avtr.a(this.jdField_a_of_type_Avtr);
      localIVPluginInfo = avtr.a(this.jdField_a_of_type_Avtr);
      localInstalledPlugin = avtr.a(this.jdField_a_of_type_Avtr);
      str3 = avto.d(this.jdField_a_of_type_Avtr.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = avto.e(this.jdField_a_of_type_Avtr.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, avto.c(this.jdField_a_of_type_Avtr.a), avtr.a(this.jdField_a_of_type_Avtr));
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