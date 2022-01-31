package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import atar;
import atau;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(atau paramatau, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!atar.a(this.jdField_a_of_type_Atau.a))
    {
      localContext = atar.a(this.jdField_a_of_type_Atau.a);
      str2 = atau.a(this.jdField_a_of_type_Atau);
      localIVPluginInfo = atau.a(this.jdField_a_of_type_Atau);
      localInstalledPlugin = atau.a(this.jdField_a_of_type_Atau);
      str3 = atar.d(this.jdField_a_of_type_Atau.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = atar.e(this.jdField_a_of_type_Atau.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, atar.c(this.jdField_a_of_type_Atau.a), atau.a(this.jdField_a_of_type_Atau));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper.GetLoginKeyDataListener.1
 * JD-Core Version:    0.7.0.1
 */