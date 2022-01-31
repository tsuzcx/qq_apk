package com.tencent.mobileqq.vas;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class VasExtensionManager
  implements INetInfoHandler, Manager
{
  public QQAppInterface a;
  public VasFaceManager a;
  public EmoticonFromGroupManager a;
  public VasEmojiManager a;
  public ColorScreenManager a;
  public ProfileCardManager a;
  public FlashCarGameManager a;
  
  public VasExtensionManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager = new VasEmojiManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager = new ColorScreenManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager = new FlashCarGameManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager = new EmoticonFromGroupManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager = new ProfileCardManager(paramQQAppInterface);
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this);
  }
  
  public static boolean a()
  {
    if (TMSManager.a())
    {
      if (NetworkUtil.b(BaseApplicationImpl.getApplication()) == 0)
      {
        TMSManager.a(null, false);
        return true;
      }
      QLog.d("TMSManager", 1, "can only query in mobile connection");
      return true;
    }
    QLog.d("TMSManager", 1, "so not ready");
    return false;
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager.onDestroy();
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    a();
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    a();
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionManager
 * JD-Core Version:    0.7.0.1
 */