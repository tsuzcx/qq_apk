package com.tencent.mobileqq.data;

import alzf;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class MessageForQQWalletTips$1$1
  implements Runnable
{
  MessageForQQWalletTips$1$1(MessageForQQWalletTips.1 param1, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips$1.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    ((alzf)localQQAppInterface.a(20)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips$1.jdField_a_of_type_JavaLangString), Long.parseLong(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.1.1
 * JD-Core Version:    0.7.0.1
 */