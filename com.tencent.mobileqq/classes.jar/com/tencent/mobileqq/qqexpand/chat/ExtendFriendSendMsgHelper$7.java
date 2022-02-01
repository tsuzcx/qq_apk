package com.tencent.mobileqq.qqexpand.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

final class ExtendFriendSendMsgHelper$7
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = ExtendFriendSendMsgHelper.a(this.a.app);
    CampusHelper.a(this.a, str);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.7
 * JD-Core Version:    0.7.0.1
 */