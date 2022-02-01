package com.tencent.mobileqq.utils;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;

class QQCustomDialogWtihEmoticonInput$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQCustomDialogWtihEmoticonInput$5(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.mRootScrollView != null) {
      this.this$0.mRootScrollView.fullScroll(130);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.5
 * JD-Core Version:    0.7.0.1
 */