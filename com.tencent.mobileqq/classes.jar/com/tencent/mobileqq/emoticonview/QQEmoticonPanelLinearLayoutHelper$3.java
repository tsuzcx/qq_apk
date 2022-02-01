package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.mobileqq.utils.ViewUtils;

class QQEmoticonPanelLinearLayoutHelper$3
  implements Runnable
{
  QQEmoticonPanelLinearLayoutHelper$3(QQEmoticonPanelLinearLayoutHelper paramQQEmoticonPanelLinearLayoutHelper, View paramView, LinearLayout paramLinearLayout) {}
  
  public void run()
  {
    if (((this.this$0.getContext() instanceof Activity)) && (!((Activity)this.this$0.getContext()).isFinishing()))
    {
      int[] arrayOfInt = new int[2];
      this.val$view.getLocationInWindow(arrayOfInt);
      int j = QQEmoticonPanelLinearLayoutHelper.access$300(this.this$0, this.val$view);
      int k = this.val$view.getMeasuredWidth();
      int i = 0;
      if (j >= 0) {
        if (j <= 1) {
          i = -(int)((1 - j) * k + k / 2.0F + ViewUtils.dip2px(3.0F));
        } else {
          i = (int)((j - 2) * k + k / 2.0F - ViewUtils.dip2px(1.0F));
        }
      }
      QQEmoticonPanelLinearLayoutHelper.access$400(this.this$0).showAtLocation(this.val$view, 48, i, arrayOfInt[1] - this.val$linearLayout.getMeasuredHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.3
 * JD-Core Version:    0.7.0.1
 */