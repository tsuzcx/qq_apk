package com.tencent.mobileqq.qcall;

import abwz;
import avsy;
import azjc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;

class QCallDetailActivity$3
  implements Runnable
{
  QCallDetailActivity$3(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    int k = 0;
    if (this.this$0.app == null) {
      break label12;
    }
    label12:
    label142:
    label159:
    for (;;)
    {
      return;
      if (QCallDetailActivity.a(this.this$0, QCallDetailActivity.a(this.this$0)))
      {
        Object localObject = abwz.q;
        int m = localObject.length;
        int i = 0;
        int j = k;
        if (i < m)
        {
          j = localObject[i];
          if (QCallDetailActivity.a(this.this$0) == j) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break;
          }
          localObject = (avsy)this.this$0.app.getManager(11);
          if (localObject != null) {
            break label142;
          }
        }
        for (localObject = null;; localObject = ((avsy)localObject).c(QCallDetailActivity.a(this.this$0)))
        {
          if (localObject == null) {
            break label159;
          }
          QCallDetailActivity.a(this.this$0).a(((PhoneContact)localObject).mobileCode, 1006, QCallDetailActivity.a(this.this$0), QCallDetailActivity.a(this.this$0));
          return;
          i += 1;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */