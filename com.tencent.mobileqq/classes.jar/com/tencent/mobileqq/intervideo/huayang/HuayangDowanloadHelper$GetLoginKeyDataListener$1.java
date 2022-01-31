package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import arfs;
import arfv;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(arfv paramarfv, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!arfs.a(this.jdField_a_of_type_Arfv.a))
    {
      localContext = arfs.a(this.jdField_a_of_type_Arfv.a);
      str2 = arfv.a(this.jdField_a_of_type_Arfv);
      localIVPluginInfo = arfv.a(this.jdField_a_of_type_Arfv);
      localInstalledPlugin = arfv.a(this.jdField_a_of_type_Arfv);
      str3 = arfs.d(this.jdField_a_of_type_Arfv.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = arfs.e(this.jdField_a_of_type_Arfv.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, arfs.c(this.jdField_a_of_type_Arfv.a), arfv.a(this.jdField_a_of_type_Arfv));
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