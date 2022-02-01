package com.tencent.mobileqq.qqexpand.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

final class ExtendFriendSendMsgHelper$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.getAppRuntime() instanceof QQAppInterface))
    {
      String str = ExtendFriendSendMsgHelper.a((QQAppInterface)this.a.getAppRuntime());
      if (this.b) {
        CampusHelper.a(this.a, this.c.a, this.c.d, this.c.c);
      } else {
        CampusHelper.a(this.a, str);
      }
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.5
 * JD-Core Version:    0.7.0.1
 */