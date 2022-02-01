package com.tencent.mobileqq.qcall;

import acnh;
import awyz;
import bapk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    label143:
    label160:
    for (;;)
    {
      return;
      if (QCallDetailActivity.a(this.this$0, QCallDetailActivity.a(this.this$0)))
      {
        Object localObject = acnh.q;
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
          localObject = (awyz)this.this$0.app.getManager(QQManagerFactory.CONTACT_MANAGER);
          if (localObject != null) {
            break label143;
          }
        }
        for (localObject = null;; localObject = ((awyz)localObject).c(QCallDetailActivity.a(this.this$0)))
        {
          if (localObject == null) {
            break label160;
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