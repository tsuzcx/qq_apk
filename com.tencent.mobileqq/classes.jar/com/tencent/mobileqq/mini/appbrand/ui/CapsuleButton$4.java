package com.tencent.mobileqq.mini.appbrand.ui;

import android.widget.TextView;
import bkjh;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class CapsuleButton$4
  implements Runnable
{
  CapsuleButton$4(CapsuleButton paramCapsuleButton) {}
  
  public void run()
  {
    if ((CapsuleButton.access$400() > 0) && (CapsuleButton.access$500(this.this$0) != null) && (!CapsuleButton.access$500(this.this$0).isAnimating()))
    {
      CapsuleButton.access$600(this.this$0).setVisibility(0);
      bkjh.a(CapsuleButton.access$600(this.this$0), 7, CapsuleButton.access$400(), 0);
      return;
    }
    CapsuleButton.access$600(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.4
 * JD-Core Version:    0.7.0.1
 */