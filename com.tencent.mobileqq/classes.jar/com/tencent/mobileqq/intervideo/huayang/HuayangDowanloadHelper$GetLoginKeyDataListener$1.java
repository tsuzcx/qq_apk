package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import arfu;
import arfx;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(arfx paramarfx, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!arfu.a(this.jdField_a_of_type_Arfx.a))
    {
      localContext = arfu.a(this.jdField_a_of_type_Arfx.a);
      str2 = arfx.a(this.jdField_a_of_type_Arfx);
      localIVPluginInfo = arfx.a(this.jdField_a_of_type_Arfx);
      localInstalledPlugin = arfx.a(this.jdField_a_of_type_Arfx);
      str3 = arfu.d(this.jdField_a_of_type_Arfx.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = arfu.e(this.jdField_a_of_type_Arfx.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, arfu.c(this.jdField_a_of_type_Arfx.a), arfx.a(this.jdField_a_of_type_Arfx));
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