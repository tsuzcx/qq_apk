package com.tencent.mobileqq.doutu;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class DoutuManager$3
  implements Runnable
{
  DoutuManager$3(DoutuManager paramDoutuManager, SessionInfo paramSessionInfo, DoutuItem paramDoutuItem) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetDoutuList : run begin .");
    }
    DoutuManager.a(this.this$0, 1);
    NewIntent localNewIntent = new NewIntent(DoutuManager.a(this.this$0).getApp(), DoutuServlet.class);
    localNewIntent.putExtra("KEY_CMD", 1);
    DoutuManager.a(this.this$0, localNewIntent, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem);
    Object localObject = (FriendsManager)DoutuManager.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i;
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).a(DoutuManager.a(this.this$0).getCurrentAccountUin());
      if (localObject != null)
      {
        i = ((Card)localObject).age;
        localNewIntent.putExtra("KEY_AGE", ((Card)localObject).age);
        localNewIntent.putExtra("key_gender", ((Card)localObject).shGender);
        DoutuManager.a(this.this$0, (Card)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "postGetDoutuList age = " + i);
      }
      DoutuManager.a(this.this$0).startServlet(localNewIntent);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.3
 * JD-Core Version:    0.7.0.1
 */