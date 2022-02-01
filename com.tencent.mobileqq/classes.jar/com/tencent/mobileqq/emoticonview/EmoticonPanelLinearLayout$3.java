package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.mobileqq.utils.ViewUtils;

class EmoticonPanelLinearLayout$3
  implements Runnable
{
  EmoticonPanelLinearLayout$3(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, View paramView, LinearLayout paramLinearLayout) {}
  
  public void run()
  {
    int[] arrayOfInt;
    int j;
    int k;
    if (((this.this$0.getContext() instanceof Activity)) && (!((Activity)this.this$0.getContext()).isFinishing()))
    {
      arrayOfInt = new int[2];
      this.val$view.getLocationInWindow(arrayOfInt);
      j = EmoticonPanelLinearLayout.access$700(this.this$0, this.val$view);
      k = this.val$view.getMeasuredWidth();
      i = 0;
      if (j >= 0) {
        if (j > 1) {
          break label125;
        }
      }
    }
    label125:
    for (int i = -(int)((1 - j) * k + k / 2.0F + ViewUtils.dip2px(3.0F));; i = (int)((j - 2) * k + k / 2.0F - ViewUtils.dip2px(1.0F)))
    {
      EmoticonPanelLinearLayout.access$800(this.this$0).showAtLocation(this.val$view, 48, i, arrayOfInt[1] - this.val$linearLayout.getMeasuredHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.3
 * JD-Core Version:    0.7.0.1
 */