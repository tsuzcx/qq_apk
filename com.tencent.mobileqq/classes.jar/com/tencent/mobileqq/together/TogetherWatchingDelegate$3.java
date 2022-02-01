package com.tencent.mobileqq.together;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class TogetherWatchingDelegate$3
  implements DialogInterface.OnClickListener
{
  TogetherWatchingDelegate$3(TogetherWatchingDelegate paramTogetherWatchingDelegate, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TogetherWatchingDelegate localTogetherWatchingDelegate = this.c;
    String str2 = this.a;
    String str1;
    if (this.b == 8) {
      str1 = "clk_openframe_cancel";
    } else {
      str1 = "clk_joinbar_cancel";
    }
    TogetherWatchingDelegate.a(localTogetherWatchingDelegate, str2, str1);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate.3
 * JD-Core Version:    0.7.0.1
 */