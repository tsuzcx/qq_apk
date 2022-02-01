package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import aqvd;
import aqvf;
import bcrg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ConfessManager$4
  implements Runnable
{
  public ConfessManager$4(aqvd paramaqvd, String paramString, aqvf paramaqvf) {}
  
  public void run()
  {
    aqvf localaqvf = this.this$0.jdField_a_of_type_Aqvf;
    if ((localaqvf == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localaqvf.c)) {
        localaqvf.c = ContactUtils.getTroopMemberName(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqvf.d);
      }
      if (localaqvf.jdField_e_of_type_Int == 0) {
        localaqvf.jdField_e_of_type_Int = this.this$0.a(this.jdField_a_of_type_JavaLangString, localaqvf.d, localaqvf.b, localaqvf.jdField_e_of_type_JavaLangString, localaqvf.jdField_a_of_type_Int);
      }
    } while (localaqvf.jdField_e_of_type_Int != 1);
    long l2 = bcrg.a();
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(this.jdField_a_of_type_JavaLangString, 1);
    long l1;
    if ((localList != null) && (!localList.isEmpty())) {
      l1 = ((ChatMessage)localList.get(localList.size() - 1)).shmsgseq + 1L;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(localaqvf.jdField_a_of_type_Boolean) }));
      }
      this.this$0.a(this.jdField_a_of_type_JavaLangString, localaqvf, l2, l2, l1);
      return;
      l1 = Math.abs(new Random().nextInt());
      localaqvf.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.4
 * JD-Core Version:    0.7.0.1
 */