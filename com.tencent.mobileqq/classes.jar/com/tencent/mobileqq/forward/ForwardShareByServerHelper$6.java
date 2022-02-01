package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class ForwardShareByServerHelper$6
  implements DialogInterface.OnClickListener
{
  ForwardShareByServerHelper$6(ForwardShareByServerHelper paramForwardShareByServerHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardSdkBaseOption.a(ForwardShareByServerHelper.a(this.a), false, "shareToQQ", ForwardShareByServerHelper.a(this.a));
      Util.a(ForwardShareByServerHelper.a(this.a), 0, "", "");
      if (ForwardShareByServerHelper.a(this.a) != null) {
        ForwardShareByServerHelper.a(this.a).b(1);
      }
      ForwardShareByServerHelper.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.6
 * JD-Core Version:    0.7.0.1
 */