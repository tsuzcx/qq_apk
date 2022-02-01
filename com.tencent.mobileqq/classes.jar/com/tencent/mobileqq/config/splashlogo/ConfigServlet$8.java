package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.hotchat.api.IHotChatSCMng;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;

class ConfigServlet$8
  implements Runnable
{
  ConfigServlet$8(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    boolean bool = ((IHotChatSCMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOTCHAT_SCENE_CONFIG_MANAGER)).updateHotChatSceneConfig(this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config);
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get(), bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.8
 * JD-Core Version:    0.7.0.1
 */