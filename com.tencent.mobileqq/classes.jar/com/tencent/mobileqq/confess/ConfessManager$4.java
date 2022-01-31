package com.tencent.mobileqq.confess;

import amno;
import amnq;
import android.text.TextUtils;
import awzw;
import bbcl;
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
  public ConfessManager$4(amno paramamno, String paramString, amnq paramamnq) {}
  
  public void run()
  {
    amnq localamnq = this.this$0.jdField_a_of_type_Amnq;
    if ((localamnq == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localamnq.c)) {
        localamnq.c = bbcl.h(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Amnq.d);
      }
      if (localamnq.jdField_e_of_type_Int == 0) {
        localamnq.jdField_e_of_type_Int = this.this$0.a(this.jdField_a_of_type_JavaLangString, localamnq.d, localamnq.b, localamnq.jdField_e_of_type_JavaLangString, localamnq.jdField_a_of_type_Int);
      }
    } while (localamnq.jdField_e_of_type_Int != 1);
    long l2 = awzw.a();
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1);
    long l1;
    if ((localList != null) && (!localList.isEmpty())) {
      l1 = ((ChatMessage)localList.get(localList.size() - 1)).shmsgseq + 1L;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(localamnq.jdField_a_of_type_Boolean) }));
      }
      this.this$0.a(this.jdField_a_of_type_JavaLangString, localamnq, l2, l2, l1);
      return;
      l1 = Math.abs(new Random().nextInt());
      localamnq.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.4
 * JD-Core Version:    0.7.0.1
 */