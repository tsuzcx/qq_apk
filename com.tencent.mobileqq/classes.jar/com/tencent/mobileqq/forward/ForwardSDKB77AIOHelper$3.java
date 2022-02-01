package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class ForwardSDKB77AIOHelper$3
  implements DialogInterface.OnClickListener
{
  ForwardSDKB77AIOHelper$3(ForwardSDKB77AIOHelper paramForwardSDKB77AIOHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(ForwardSDKB77AIOHelper.a(this.a), false, "shareToQQ", ForwardSDKB77AIOHelper.b(this.a));
      Util.a(ForwardSDKB77AIOHelper.a(this.a), 0, "", "");
      if (ForwardSDKB77AIOHelper.c(this.a) != null) {
        ForwardSDKB77AIOHelper.c(this.a).f(1);
      }
      ForwardSDKB77AIOHelper.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.3
 * JD-Core Version:    0.7.0.1
 */