package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;

class HuayangDowanloadHelper$GetLoginKeyDataListener$1
  implements Runnable
{
  HuayangDowanloadHelper$GetLoginKeyDataListener$1(HuayangDowanloadHelper.GetLoginKeyDataListener paramGetLoginKeyDataListener, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "startLoadingActivity：" + System.currentTimeMillis());
    }
    if (!HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener.a))
    {
      localContext = HuayangDowanloadHelper.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener.a);
      str2 = HuayangDowanloadHelper.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener);
      localIVPluginInfo = HuayangDowanloadHelper.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener);
      localInstalledPlugin = HuayangDowanloadHelper.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener);
      str3 = HuayangDowanloadHelper.d(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener.a);
      if (this.jdField_a_of_type_Boolean)
      {
        str1 = HuayangDowanloadHelper.e(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener.a);
        HuayangLoadbackgroudActivity.a(localContext, str2, localIVPluginInfo, localInstalledPlugin, str3, str1, this.b, this.jdField_a_of_type_Boolean, HuayangDowanloadHelper.c(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener.a), HuayangDowanloadHelper.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangDowanloadHelper$GetLoginKeyDataListener));
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