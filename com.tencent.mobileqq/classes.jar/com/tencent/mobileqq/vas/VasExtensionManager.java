package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import mqq.manager.Manager;

public class VasExtensionManager
  implements Manager
{
  public QQAppInterface a;
  public VasFaceManager a;
  public EmoticonFromGroupManager a;
  public VasEmojiManager a;
  public ColorScreenManager a;
  public FlashCarGameManager a;
  
  public VasExtensionManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager = new VasEmojiManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager = new ColorScreenManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager = new FlashCarGameManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager = new EmoticonFromGroupManager(paramQQAppInterface);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasFlashCarGameManager.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionManager
 * JD-Core Version:    0.7.0.1
 */