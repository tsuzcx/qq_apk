package com.tencent.mobileqq.forward;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ForwardFileOption$11
  implements TextView.OnEditorActionListener
{
  ForwardFileOption$11(ForwardFileOption paramForwardFileOption) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) || (paramInt == 6) || ((paramKeyEvent != null) && (66 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileOption.11
 * JD-Core Version:    0.7.0.1
 */