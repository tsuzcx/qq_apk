package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class ForwardShareByServerHelper$7
  implements DialogInterface.OnClickListener
{
  ForwardShareByServerHelper$7(ForwardShareByServerHelper paramForwardShareByServerHelper, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ForwardShareByServerHelper.a(ForwardShareByServerHelper.d(this.c), "shareToQQ", ForwardShareByServerHelper.g(this.c), this.a, this.b);
      Util.a(ForwardShareByServerHelper.d(this.c), 0, "", "");
      if (ForwardShareByServerHelper.h(this.c) != null) {
        ForwardShareByServerHelper.h(this.c).f(1);
      }
      ForwardShareByServerHelper.d(this.c).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.7
 * JD-Core Version:    0.7.0.1
 */