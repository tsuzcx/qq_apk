package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class BridgeModule$3
  implements INetInfoHandler
{
  BridgeModule$3(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=");
      localStringBuilder.append(paramString);
      QLog.i("BridgeModule", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetNone2Wifi():NET_XG,ssid=");
      localStringBuilder.append(paramString);
      QLog.i("BridgeModule", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetNone2Wifi():NET_WIFI,ssid=");
      localStringBuilder.append(paramString);
      QLog.i("BridgeModule", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INetInfoHandler onNetNone2Wifi():NET_XG,ssid=");
      localStringBuilder.append(paramString);
      QLog.i("BridgeModule", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgeModule", 2, "INetInfoHandler onNetNone2Wifi():NET_NONE");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getNetType(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.3
 * JD-Core Version:    0.7.0.1
 */