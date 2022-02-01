package com.tencent.mobileqq.doutu;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class DoutuManager$4
  implements Runnable
{
  DoutuManager$4(DoutuManager paramDoutuManager, DoutuItem paramDoutuItem, long paramLong, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetRecommendPicList item:" + this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.toString() + ", timeKey:" + this.jdField_a_of_type_Long + ", sessionType:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", friendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    NewIntent localNewIntent = new NewIntent(DoutuManager.a(this.this$0).getApp(), DoutuServlet.class);
    DoutuManager.a(this.this$0, localNewIntent, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem);
    localNewIntent.putExtra("KEY_MD5", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.b);
    localNewIntent.putExtra("key_url", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.c);
    localNewIntent.putExtra("KEY_CMD", 6);
    localNewIntent.putExtra("key_sequence", this.jdField_a_of_type_Long);
    if (DoutuManager.a(this.this$0) == null)
    {
      Object localObject = (FriendsManager)DoutuManager.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).a(DoutuManager.a(this.this$0).getCurrentAccountUin());
        if (localObject != null) {
          DoutuManager.a(this.this$0, (Card)localObject);
        }
      }
    }
    if (DoutuManager.a(this.this$0) != null)
    {
      localNewIntent.putExtra("key_gender", DoutuManager.a(this.this$0).shGender);
      localNewIntent.putExtra("KEY_AGE", DoutuManager.a(this.this$0).age);
    }
    DoutuManager.a(this.this$0).startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.4
 * JD-Core Version:    0.7.0.1
 */