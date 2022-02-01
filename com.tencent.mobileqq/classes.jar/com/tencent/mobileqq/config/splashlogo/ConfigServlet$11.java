package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.app.DynamicSplashManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class ConfigServlet$11
  implements Runnable
{
  ConfigServlet$11(ConfigServlet paramConfigServlet, ConfigurationService.Config paramConfig, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version != null))
    {
      str = (String)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.get(0);
      i = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get();
      j = SharedPreUtils.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 63,content: " + str + ",version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
      }
      if (i > j) {
        DynamicSplashManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, i);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 63,content_list is empty ,version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.11
 * JD-Core Version:    0.7.0.1
 */