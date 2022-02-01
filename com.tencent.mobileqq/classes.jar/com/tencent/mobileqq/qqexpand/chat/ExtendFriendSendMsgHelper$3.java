package com.tencent.mobileqq.qqexpand.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

final class ExtendFriendSendMsgHelper$3
  implements DialogInterface.OnClickListener
{
  ExtendFriendSendMsgHelper$3(boolean paramBoolean, QBaseActivity paramQBaseActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a) {
      CampusHelper.a(this.b, this.c, this.d, this.e);
    } else {
      CampusHelper.a(this.b, this.d);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.3
 * JD-Core Version:    0.7.0.1
 */