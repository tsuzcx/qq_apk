package com.tencent.mobileqq.doutu;

import ajxn;
import anod;
import anol;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$3
  implements Runnable
{
  public DoutuManager$3(anod paramanod) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetDoutuList : run begin .");
    }
    anod.a(this.this$0, 1);
    NewIntent localNewIntent = new NewIntent(anod.a(this.this$0).getApp(), anol.class);
    long l = Long.valueOf(anod.a(this.this$0).getCurrentAccountUin()).longValue();
    localNewIntent.putExtra("KEY_SRC_UIN", l);
    localNewIntent.putExtra("KEY_CMD", 1);
    Object localObject = (ajxn)anod.a(this.this$0).getManager(51);
    int i;
    if (localObject != null)
    {
      localObject = ((ajxn)localObject).b(anod.a(this.this$0).getCurrentAccountUin());
      if (localObject != null)
      {
        i = ((Card)localObject).age;
        localNewIntent.putExtra("KEY_AGE", ((Card)localObject).age);
        localNewIntent.putExtra("key_gender", ((Card)localObject).shGender);
        anod.a(this.this$0, (Card)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "postGetDoutuList : curUin = " + l + ", age = " + i);
      }
      anod.a(this.this$0).startServlet(localNewIntent);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.3
 * JD-Core Version:    0.7.0.1
 */