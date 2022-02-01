package com.tencent.mobileqq.forward;

import android.widget.EditText;
import android.widget.PopupWindow.OnDismissListener;

class ForwardFileOption$10
  implements PopupWindow.OnDismissListener
{
  ForwardFileOption$10(ForwardFileOption paramForwardFileOption) {}
  
  public void onDismiss()
  {
    if (!this.a.am) {
      ForwardFileOption.a(this.a, -8);
    }
    if (ForwardFileOption.d(this.a) != null)
    {
      ForwardFileOption.d(this.a).setFocusable(true);
      ForwardFileOption.d(this.a).setFocusableInTouchMode(true);
      ForwardFileOption.d(this.a).requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.10
 * JD-Core Version:    0.7.0.1
 */