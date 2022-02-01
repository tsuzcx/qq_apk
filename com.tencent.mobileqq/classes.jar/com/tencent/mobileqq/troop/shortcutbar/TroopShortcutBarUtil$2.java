package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public final class TroopShortcutBarUtil$2
  implements Runnable
{
  public TroopShortcutBarUtil$2(QQAppInterface paramQQAppInterface, String paramString, long paramLong) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil.2
 * JD-Core Version:    0.7.0.1
 */