package com.tencent.mobileqq.mini.appbrand.ui;

import alof;
import android.app.Activity;
import bebh;
import bkax;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.QLog;

class CapsuleButton$9
  implements Runnable
{
  CapsuleButton$9(CapsuleButton paramCapsuleButton, Activity paramActivity) {}
  
  public void run()
  {
    if (!CapsuleButton.access$900(this.this$0))
    {
      bkax.a().a(this.val$activity, CapsuleButton.access$500(this.this$0), CapsuleButton.access$1000(this.this$0), 1, 14.0F, 5.0D, 10.0D, 3000L, -16578534, false, true, 0, null, 0);
      CapsuleButton.access$1100(this.this$0);
    }
    for (;;)
    {
      CapsuleButton.access$500(this.this$0).addAnimatorListener(new CapsuleButton.9.1(this));
      if ((CapsuleButton.access$1200(this.this$0) != -1) && (!CapsuleButton.access$1300(this.this$0))) {
        break;
      }
      CapsuleButton.access$1400(this.this$0).a(CapsuleButton.access$500(this.this$0), MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE, alof.ci + MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE.hashCode() + ".zip", true);
      return;
      QLog.i("CapsuleButton", 1, "showKingCardTips, guide had been showed, not show this time");
    }
    CapsuleButton.access$1400(this.this$0).a(CapsuleButton.access$500(this.this$0), MiniAppGlobal.KINGCARD_GUIDE_LOTTIE, alof.ci + MiniAppGlobal.KINGCARD_GUIDE_LOTTIE.hashCode() + ".zip", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.9
 * JD-Core Version:    0.7.0.1
 */