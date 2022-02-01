package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

@TargetApi(16)
class ContextMenuTextView$DissmissListener
  implements BubblePopupWindow.OnDismissListener
{
  ContextMenuTextView$DissmissListener(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onDismiss()
  {
    if (Build.VERSION.SDK_INT < 16) {
      ContextMenuTextView.a(this.a, null);
    } else {
      ContextMenuTextView.b(this.a, null);
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContextMenuTextView.DissmissListener
 * JD-Core Version:    0.7.0.1
 */