package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import java.util.Random;

class ConfessManager$4
  implements Runnable
{
  ConfessManager$4(ConfessManager paramConfessManager, String paramString, ConfessManager.GroupChatExtra paramGroupChatExtra) {}
  
  public void run()
  {
    ConfessManager.GroupChatExtra localGroupChatExtra = this.this$0.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra;
    if (localGroupChatExtra != null)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      if (TextUtils.isEmpty(localGroupChatExtra.c)) {
        localGroupChatExtra.c = ContactUtils.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra.d);
      }
      if (localGroupChatExtra.jdField_e_of_type_Int == 0) {
        localGroupChatExtra.jdField_e_of_type_Int = this.this$0.a(this.jdField_a_of_type_JavaLangString, localGroupChatExtra.d, localGroupChatExtra.b, localGroupChatExtra.jdField_e_of_type_JavaLangString, localGroupChatExtra.jdField_a_of_type_Int);
      }
      if (localGroupChatExtra.jdField_e_of_type_Int == 1)
      {
        long l2 = MessageCache.a();
        List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, 1);
        long l1;
        if ((localList != null) && (!localList.isEmpty()))
        {
          l1 = ((ChatMessage)localList.get(localList.size() - 1)).shmsgseq + 1L;
        }
        else
        {
          l1 = Math.abs(new Random().nextInt());
          localGroupChatExtra.jdField_a_of_type_Boolean = true;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(localGroupChatExtra.jdField_a_of_type_Boolean) }));
        }
        this.this$0.a(this.jdField_a_of_type_JavaLangString, localGroupChatExtra, l2, l2, l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.4
 * JD-Core Version:    0.7.0.1
 */