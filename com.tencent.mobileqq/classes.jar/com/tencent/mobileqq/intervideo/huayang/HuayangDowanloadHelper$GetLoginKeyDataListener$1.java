package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import aunt;
import aunw;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

public class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  public HuayangDowanloadHelper$GetLoginKeyDataListener$1(aunw paramaunw, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!aunt.a(this.jdField_a_of_type_Aunw.a))
    {
      localContext = aunt.a(this.jdField_a_of_type_Aunw.a);
      str2 = aunw.a(this.jdField_a_of_type_Aunw);
      localIVPluginInfo = aunw.a(this.jdField_a_of_type_Aunw);
      localInstalledPlugin = aunw.a(this.jdField_a_of_type_Aunw);
      str3 = aunt.d(this.jdField_a_of_type_Aunw.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = aunt.e(this.jdField_a_of_type_Aunw.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, aunt.c(this.jdField_a_of_type_Aunw.a), aunw.a(this.jdField_a_of_type_Aunw));
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