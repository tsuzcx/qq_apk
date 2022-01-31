package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import aqln;
import aqlq;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(aqlq paramaqlq, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!aqln.a(this.jdField_a_of_type_Aqlq.a))
    {
      localContext = aqln.a(this.jdField_a_of_type_Aqlq.a);
      str2 = aqlq.a(this.jdField_a_of_type_Aqlq);
      localIVPluginInfo = aqlq.a(this.jdField_a_of_type_Aqlq);
      localInstalledPlugin = aqlq.a(this.jdField_a_of_type_Aqlq);
      str3 = aqln.d(this.jdField_a_of_type_Aqlq.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = aqln.e(this.jdField_a_of_type_Aqlq.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, aqln.c(this.jdField_a_of_type_Aqlq.a), aqlq.a(this.jdField_a_of_type_Aqlq));
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