package com.tencent.mobileqq.doutu;

import alto;
import apjx;
import apjy;
import apkg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$4
  implements Runnable
{
  public DoutuManager$4(apjy paramapjy, apjx paramapjx, long paramLong, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetRecommendPicList item:" + this.jdField_a_of_type_Apjx.toString() + ", timeKey:" + this.jdField_a_of_type_Long + ", sessionType:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", friendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    NewIntent localNewIntent = new NewIntent(apjy.a(this.this$0).getApp(), apkg.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(apjy.a(this.this$0).getCurrentAccountUin()).longValue());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label351;
      }
    }
    for (;;)
    {
      localNewIntent.putExtra("KEY_SESSION_TYPE", i);
      localNewIntent.putExtra("KEY_TO_UIN", Long.valueOf(this.jdField_a_of_type_Apjx.d));
      localNewIntent.putExtra("KEY_MD5", this.jdField_a_of_type_Apjx.b);
      localNewIntent.putExtra("key_url", this.jdField_a_of_type_Apjx.c);
      localNewIntent.putExtra("KEY_CMD", 6);
      localNewIntent.putExtra("key_sequence", this.jdField_a_of_type_Long);
      if (apjy.a(this.this$0) == null)
      {
        Object localObject = (alto)apjy.a(this.this$0).getManager(51);
        if (localObject != null)
        {
          localObject = ((alto)localObject).b(apjy.a(this.this$0).getCurrentAccountUin());
          if (localObject != null) {
            apjy.a(this.this$0, (Card)localObject);
          }
        }
      }
      if (apjy.a(this.this$0) != null)
      {
        localNewIntent.putExtra("key_gender", apjy.a(this.this$0).shGender);
        localNewIntent.putExtra("KEY_AGE", apjy.a(this.this$0).age);
      }
      apjy.a(this.this$0).startServlet(localNewIntent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.4
 * JD-Core Version:    0.7.0.1
 */