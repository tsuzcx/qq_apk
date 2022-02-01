package com.tencent.mobileqq.doutu;

import anvk;
import arzz;
import asaa;
import asai;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$4
  implements Runnable
{
  public DoutuManager$4(asaa paramasaa, arzz paramarzz, long paramLong, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetRecommendPicList item:" + this.jdField_a_of_type_Arzz.toString() + ", timeKey:" + this.jdField_a_of_type_Long + ", sessionType:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType + ", friendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    }
    NewIntent localNewIntent = new NewIntent(asaa.a(this.this$0).getApp(), asai.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0)
    {
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(asaa.a(this.this$0).getCurrentAccountUin()).longValue());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) {
        break label352;
      }
    }
    for (;;)
    {
      localNewIntent.putExtra("KEY_SESSION_TYPE", i);
      localNewIntent.putExtra("KEY_TO_UIN", Long.valueOf(this.jdField_a_of_type_Arzz.d));
      localNewIntent.putExtra("KEY_MD5", this.jdField_a_of_type_Arzz.b);
      localNewIntent.putExtra("key_url", this.jdField_a_of_type_Arzz.c);
      localNewIntent.putExtra("KEY_CMD", 6);
      localNewIntent.putExtra("key_sequence", this.jdField_a_of_type_Long);
      if (asaa.a(this.this$0) == null)
      {
        Object localObject = (anvk)asaa.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject != null)
        {
          localObject = ((anvk)localObject).b(asaa.a(this.this$0).getCurrentAccountUin());
          if (localObject != null) {
            asaa.a(this.this$0, (Card)localObject);
          }
        }
      }
      if (asaa.a(this.this$0) != null)
      {
        localNewIntent.putExtra("key_gender", asaa.a(this.this$0).shGender);
        localNewIntent.putExtra("KEY_AGE", asaa.a(this.this$0).age);
      }
      asaa.a(this.this$0).startServlet(localNewIntent);
      return;
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin));
      break;
      label352:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)) {
        i = 2;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.4
 * JD-Core Version:    0.7.0.1
 */