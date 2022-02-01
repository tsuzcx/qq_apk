package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ForwardSendHongBaoOption$4
  implements DialogInterface.OnClickListener
{
  ForwardSendHongBaoOption$4(ForwardSendHongBaoOption paramForwardSendHongBaoOption, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.dismiss();
    this.b.s.setResult(-1);
    this.b.s.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSendHongBaoOption.4
 * JD-Core Version:    0.7.0.1
 */