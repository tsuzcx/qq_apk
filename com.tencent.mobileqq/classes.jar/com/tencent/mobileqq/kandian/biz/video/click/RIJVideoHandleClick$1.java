package com.tencent.mobileqq.kandian.biz.video.click;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RIJVideoHandleClick$1
  implements DialogInterface.OnClickListener
{
  @TargetApi(11)
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)RIJVideoHandleClick.a(this.b).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("article", this.a));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.1
 * JD-Core Version:    0.7.0.1
 */