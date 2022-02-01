package com.tencent.mobileqq.qcall;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;

class QCallDetailActivity$4
  implements Runnable
{
  QCallDetailActivity$4(QCallDetailActivity paramQCallDetailActivity) {}
  
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
        Object localObject = UinTypeUtil.c;
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
          localObject = (PhoneContactManager)this.this$0.app.getManager(QQManagerFactory.CONTACT_MANAGER);
          if (localObject != null) {
            break label143;
          }
        }
        for (localObject = null;; localObject = ((PhoneContactManager)localObject).c(QCallDetailActivity.a(this.this$0)))
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
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.4
 * JD-Core Version:    0.7.0.1
 */