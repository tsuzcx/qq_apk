package com.tencent.mobileqq.structmsg.view;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class StructMsgItemLayoutPromotion$1
  implements Runnable
{
  StructMsgItemLayoutPromotion$1(StructMsgItemLayoutPromotion paramStructMsgItemLayoutPromotion, LinearLayout paramLinearLayout, TextView paramTextView1, float paramFloat, int paramInt, TextView paramTextView2, LinearLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    if (this.a.getWidth() - this.b.getWidth() > this.c + this.d)
    {
      this.a.addView(this.e, this.f);
      StructMsgItemLayoutPromotion.a(this.this$0, 1);
      return;
    }
    StructMsgItemLayoutPromotion.a(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion.1
 * JD-Core Version:    0.7.0.1
 */