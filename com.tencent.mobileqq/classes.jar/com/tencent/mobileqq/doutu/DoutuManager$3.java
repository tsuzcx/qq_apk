package com.tencent.mobileqq.doutu;

import anvk;
import asaa;
import asai;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$3
  implements Runnable
{
  public DoutuManager$3(asaa paramasaa) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetDoutuList : run begin .");
    }
    asaa.a(this.this$0, 1);
    NewIntent localNewIntent = new NewIntent(asaa.a(this.this$0).getApp(), asai.class);
    long l = Long.valueOf(asaa.a(this.this$0).getCurrentAccountUin()).longValue();
    localNewIntent.putExtra("KEY_SRC_UIN", l);
    localNewIntent.putExtra("KEY_CMD", 1);
    Object localObject = (anvk)asaa.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i;
    if (localObject != null)
    {
      localObject = ((anvk)localObject).b(asaa.a(this.this$0).getCurrentAccountUin());
      if (localObject != null)
      {
        i = ((Card)localObject).age;
        localNewIntent.putExtra("KEY_AGE", ((Card)localObject).age);
        localNewIntent.putExtra("key_gender", ((Card)localObject).shGender);
        asaa.a(this.this$0, (Card)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "postGetDoutuList : curUin = " + l + ", age = " + i);
      }
      asaa.a(this.this$0).startServlet(localNewIntent);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.3
 * JD-Core Version:    0.7.0.1
 */