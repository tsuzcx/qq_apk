package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.qphone.base.util.QLog;

class HuayangDowanloadHelperImpl$GetLoginKeyDataListener$1
  implements Runnable
{
  HuayangDowanloadHelperImpl$GetLoginKeyDataListener$1(HuayangDowanloadHelperImpl.GetLoginKeyDataListener paramGetLoginKeyDataListener, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startLoadingActivity：");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("IHuayangPluginNewDownloader", 2, ((StringBuilder)localObject).toString());
    }
    if (!HuayangDowanloadHelperImpl.access$1100(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener.a))
    {
      Context localContext = HuayangDowanloadHelperImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener.a);
      String str1 = HuayangDowanloadHelperImpl.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener);
      IVPluginInfo localIVPluginInfo = HuayangDowanloadHelperImpl.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener);
      InstalledPlugin localInstalledPlugin = HuayangDowanloadHelperImpl.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener);
      String str2 = HuayangDowanloadHelperImpl.access$1500(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener.a);
      if (this.jdField_a_of_type_Boolean) {
        localObject = HuayangDowanloadHelperImpl.access$1600(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener.a);
      } else {
        localObject = null;
      }
      HuayangLoadbackgroudActivity.a(localContext, str1, localIVPluginInfo, localInstalledPlugin, str2, (String)localObject, this.b, this.jdField_a_of_type_Boolean, HuayangDowanloadHelperImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener.a), HuayangDowanloadHelperImpl.GetLoginKeyDataListener.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl$GetLoginKeyDataListener));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IHuayangPluginNewDownloader", 2, "isNeedStop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangDowanloadHelperImpl.GetLoginKeyDataListener.1
 * JD-Core Version:    0.7.0.1
 */