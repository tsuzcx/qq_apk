package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.widget.PopupWindow;
import android.widget.TextView;

class AIOEmotionFragment$4
  implements Runnable
{
  AIOEmotionFragment$4(AIOEmotionFragment paramAIOEmotionFragment, PopupWindow paramPopupWindow, TextView paramTextView) {}
  
  public void run()
  {
    if (((this.this$0.b instanceof Activity)) && (!((Activity)this.this$0.b).isFinishing())) {
      this.a.showAsDropDown(this.this$0.i, this.this$0.i.getMeasuredWidth() - this.b.getMeasuredWidth() / 2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.4
 * JD-Core Version:    0.7.0.1
 */