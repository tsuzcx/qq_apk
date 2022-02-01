package com.tencent.mobileqq.doutu;

import amsw;
import aqwf;
import aqwg;
import aqwo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$4
  implements Runnable
{
  public DoutuManager$4(aqwg paramaqwg, aqwf paramaqwf, long paramLong, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetRecommendPicList item:" + this.jdField_a_of_type_Aqwf.toString() + ", timeKey:" + this.jdField_a_of_type_Long + ", sessionType:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType + ", friendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    }
    NewIntent localNewIntent = new NewIntent(aqwg.a(this.this$0).getApp(), aqwo.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0)
    {
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(aqwg.a(this.this$0).getCurrentAccountUin()).longValue());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) {
        break label351;
      }
    }
    for (;;)
    {
      localNewIntent.putExtra("KEY_SESSION_TYPE", i);
      localNewIntent.putExtra("KEY_TO_UIN", Long.valueOf(this.jdField_a_of_type_Aqwf.d));
      localNewIntent.putExtra("KEY_MD5", this.jdField_a_of_type_Aqwf.b);
      localNewIntent.putExtra("key_url", this.jdField_a_of_type_Aqwf.c);
      localNewIntent.putExtra("KEY_CMD", 6);
      localNewIntent.putExtra("key_sequence", this.jdField_a_of_type_Long);
      if (aqwg.a(this.this$0) == null)
      {
        Object localObject = (amsw)aqwg.a(this.this$0).getManager(51);
        if (localObject != null)
        {
          localObject = ((amsw)localObject).b(aqwg.a(this.this$0).getCurrentAccountUin());
          if (localObject != null) {
            aqwg.a(this.this$0, (Card)localObject);
          }
        }
      }
      if (aqwg.a(this.this$0) != null)
      {
        localNewIntent.putExtra("key_gender", aqwg.a(this.this$0).shGender);
        localNewIntent.putExtra("KEY_AGE", aqwg.a(this.this$0).age);
      }
      aqwg.a(this.this$0).startServlet(localNewIntent);
      return;
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin));
      break;
      label351:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)) {
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