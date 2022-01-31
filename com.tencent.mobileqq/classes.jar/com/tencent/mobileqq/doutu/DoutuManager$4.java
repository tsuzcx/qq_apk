package com.tencent.mobileqq.doutu;

import ajxl;
import anoh;
import anoi;
import anoq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$4
  implements Runnable
{
  public DoutuManager$4(anoi paramanoi, anoh paramanoh, long paramLong, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetRecommendPicList item:" + this.jdField_a_of_type_Anoh.toString() + ", timeKey:" + this.jdField_a_of_type_Long + ", sessionType:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", friendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    NewIntent localNewIntent = new NewIntent(anoi.a(this.this$0).getApp(), anoq.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(anoi.a(this.this$0).getCurrentAccountUin()).longValue());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label351;
      }
    }
    for (;;)
    {
      localNewIntent.putExtra("KEY_SESSION_TYPE", i);
      localNewIntent.putExtra("KEY_TO_UIN", Long.valueOf(this.jdField_a_of_type_Anoh.d));
      localNewIntent.putExtra("KEY_MD5", this.jdField_a_of_type_Anoh.b);
      localNewIntent.putExtra("key_url", this.jdField_a_of_type_Anoh.c);
      localNewIntent.putExtra("KEY_CMD", 6);
      localNewIntent.putExtra("key_sequence", this.jdField_a_of_type_Long);
      if (anoi.a(this.this$0) == null)
      {
        Object localObject = (ajxl)anoi.a(this.this$0).getManager(51);
        if (localObject != null)
        {
          localObject = ((ajxl)localObject).b(anoi.a(this.this$0).getCurrentAccountUin());
          if (localObject != null) {
            anoi.a(this.this$0, (Card)localObject);
          }
        }
      }
      if (anoi.a(this.this$0) != null)
      {
        localNewIntent.putExtra("key_gender", anoi.a(this.this$0).shGender);
        localNewIntent.putExtra("KEY_AGE", anoi.a(this.this$0).age);
      }
      anoi.a(this.this$0).startServlet(localNewIntent);
      return;
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      break;
      label351:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
        i = 2;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.4
 * JD-Core Version:    0.7.0.1
 */