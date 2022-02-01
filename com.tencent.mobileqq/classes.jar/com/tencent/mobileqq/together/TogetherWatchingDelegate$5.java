package com.tencent.mobileqq.together;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class TogetherWatchingDelegate$5
  implements DialogInterface.OnClickListener
{
  TogetherWatchingDelegate$5(TogetherWatchingDelegate paramTogetherWatchingDelegate, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TogetherWatchingDelegate.a(this.e, this.a, "clk_unableframe_open");
    paramDialogInterface.dismiss();
    TogetherWatchingDelegate.a(this.e, this.b, this.c, this.a, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate.5
 * JD-Core Version:    0.7.0.1
 */