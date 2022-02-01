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
    int[] arrayOfInt;
    int j;
    int k;
    if (((this.this$0.getContext() instanceof Activity)) && (!((Activity)this.this$0.getContext()).isFinishing()))
    {
      arrayOfInt = new int[2];
      this.val$view.getLocationInWindow(arrayOfInt);
      j = QQEmoticonPanelLinearLayoutHelper.access$400(this.this$0, this.val$view);
      k = this.val$view.getMeasuredWidth();
      i = 0;
      if (j >= 0) {
        if (j > 1) {
          break label125;
        }
      }
    }
    label125:
    for (int i = -(int)((1 - j) * k + k / 2.0F + ViewUtils.a(3.0F));; i = (int)((j - 2) * k + k / 2.0F - ViewUtils.a(1.0F)))
    {
      QQEmoticonPanelLinearLayoutHelper.access$500(this.this$0).showAtLocation(this.val$view, 48, i, arrayOfInt[1] - this.val$linearLayout.getMeasuredHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.3
 * JD-Core Version:    0.7.0.1
 */