package com.tencent.mobileqq.together;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class TogetherWatchingDelegate$2
  implements DialogInterface.OnClickListener
{
  TogetherWatchingDelegate$2(TogetherWatchingDelegate paramTogetherWatchingDelegate, String paramString, int paramInt1, Bundle paramBundle, int paramInt2, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TogetherWatchingDelegate localTogetherWatchingDelegate = this.f;
    String str2 = this.a;
    String str1;
    if (this.b == 8) {
      str1 = "clk_openframe_open";
    } else {
      str1 = "clk_joinbar_open";
    }
    TogetherWatchingDelegate.a(localTogetherWatchingDelegate, str2, str1);
    paramDialogInterface.dismiss();
    paramInt = this.b;
    if (paramInt == 8)
    {
      TogetherWatchingDelegate.a(this.f, this.c, this.a, this.d, paramInt);
      return;
    }
    TogetherWatchingDelegate.a(this.f, this.e, this.d, this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate.2
 * JD-Core Version:    0.7.0.1
 */