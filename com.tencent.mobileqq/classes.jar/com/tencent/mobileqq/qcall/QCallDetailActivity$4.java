package com.tencent.mobileqq.qcall;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class QCallDetailActivity$4
  implements Runnable
{
  QCallDetailActivity$4(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    Object localObject = this.this$0;
    if (QCallDetailActivity.a((QCallDetailActivity)localObject, QCallDetailActivity.a((QCallDetailActivity)localObject)))
    {
      localObject = UinTypeUtil.c;
      int m = localObject.length;
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        j = localObject[i];
        if (QCallDetailActivity.a(this.this$0) == j)
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0)
      {
        localObject = (IPhoneContactService)this.this$0.app.getRuntimeService(IPhoneContactService.class, "");
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((IPhoneContactService)localObject).queryContactByCodeNumber(QCallDetailActivity.a(this.this$0));
        }
        if (localObject != null) {
          QCallDetailActivity.a(this.this$0).a(((PhoneContact)localObject).mobileCode, 1006, QCallDetailActivity.a(this.this$0), QCallDetailActivity.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.4
 * JD-Core Version:    0.7.0.1
 */