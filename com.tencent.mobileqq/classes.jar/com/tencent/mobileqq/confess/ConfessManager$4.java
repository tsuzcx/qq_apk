package com.tencent.mobileqq.confess;

import alxy;
import alya;
import android.text.TextUtils;
import awao;
import babh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ConfessManager$4
  implements Runnable
{
  public ConfessManager$4(alxy paramalxy, String paramString, alya paramalya) {}
  
  public void run()
  {
    alya localalya = this.this$0.jdField_a_of_type_Alya;
    if ((localalya == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localalya.c)) {
        localalya.c = babh.h(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alya.d);
      }
      if (localalya.jdField_e_of_type_Int == 0) {
        localalya.jdField_e_of_type_Int = this.this$0.a(this.jdField_a_of_type_JavaLangString, localalya.d, localalya.b, localalya.jdField_e_of_type_JavaLangString, localalya.jdField_a_of_type_Int);
      }
    } while (localalya.jdField_e_of_type_Int != 1);
    long l2 = awao.a();
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1);
    long l1;
    if ((localList != null) && (!localList.isEmpty())) {
      l1 = ((ChatMessage)localList.get(localList.size() - 1)).shmsgseq + 1L;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(localalya.jdField_a_of_type_Boolean) }));
      }
      this.this$0.a(this.jdField_a_of_type_JavaLangString, localalya, l2, l2, l1);
      return;
      l1 = Math.abs(new Random().nextInt());
      localalya.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.4
 * JD-Core Version:    0.7.0.1
 */