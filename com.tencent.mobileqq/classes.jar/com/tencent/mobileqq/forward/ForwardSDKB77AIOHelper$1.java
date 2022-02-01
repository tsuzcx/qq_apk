package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class ForwardSDKB77AIOHelper$1
  implements DialogInterface.OnClickListener
{
  ForwardSDKB77AIOHelper$1(ForwardSDKB77AIOHelper paramForwardSDKB77AIOHelper, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardShareByServerHelper.a(ForwardSDKB77AIOHelper.a(this.c), "shareToQQ", ForwardSDKB77AIOHelper.b(this.c), this.a, this.b);
      Util.a(ForwardSDKB77AIOHelper.a(this.c), 0, "", "");
      if (ForwardSDKB77AIOHelper.c(this.c) != null) {
        ForwardSDKB77AIOHelper.c(this.c).f(1);
      }
      ForwardSDKB77AIOHelper.a(this.c).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.1
 * JD-Core Version:    0.7.0.1
 */