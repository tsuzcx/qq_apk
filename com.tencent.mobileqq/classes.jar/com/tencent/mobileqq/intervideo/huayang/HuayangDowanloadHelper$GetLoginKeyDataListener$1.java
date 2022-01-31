package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import aswi;
import aswl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(aswl paramaswl, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!aswi.a(this.jdField_a_of_type_Aswl.a))
    {
      localContext = aswi.a(this.jdField_a_of_type_Aswl.a);
      str2 = aswl.a(this.jdField_a_of_type_Aswl);
      localIVPluginInfo = aswl.a(this.jdField_a_of_type_Aswl);
      localInstalledPlugin = aswl.a(this.jdField_a_of_type_Aswl);
      str3 = aswi.d(this.jdField_a_of_type_Aswl.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = aswi.e(this.jdField_a_of_type_Aswl.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, aswi.c(this.jdField_a_of_type_Aswl.a), aswl.a(this.jdField_a_of_type_Aswl));
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