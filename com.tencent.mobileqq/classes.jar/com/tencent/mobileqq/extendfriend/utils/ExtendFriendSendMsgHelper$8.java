package com.tencent.mobileqq.extendfriend.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

final class ExtendFriendSendMsgHelper$8
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = ExtendFriendSendMsgHelper.a(this.a.app);
    CampusHelper.a(this.a, str);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.8
 * JD-Core Version:    0.7.0.1
 */