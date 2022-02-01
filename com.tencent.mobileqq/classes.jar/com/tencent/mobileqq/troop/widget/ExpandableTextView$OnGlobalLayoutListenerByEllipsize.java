package com.tencent.mobileqq.troop.widget;

import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

public class ExpandableTextView$OnGlobalLayoutListenerByEllipsize
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private TextView a;
  private int b;
  
  public ExpandableTextView$OnGlobalLayoutListenerByEllipsize(TextView paramTextView, int paramInt)
  {
    this.a = paramTextView;
    this.b = paramInt;
    this.a.setMaxLines(this.b + 1);
    this.a.setSingleLine(false);
  }
  
  public void onGlobalLayout()
  {
    int i;
    if (this.a.getLineCount() > this.b)
    {
      i = this.a.getLayout().getLineEnd(this.b - 1);
      localCharSequence = this.a.getText();
    }
    try
    {
      localCharSequence = localCharSequence.subSequence(0, i - 3);
      str = "...";
    }
    catch (Exception localException)
    {
      String str;
      label56:
      break label56;
    }
    CharSequence localCharSequence = this.a.getText();
    str = "";
    this.a.setText(localCharSequence);
    this.a.append(str);
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExpandableTextView.OnGlobalLayoutListenerByEllipsize
 * JD-Core Version:    0.7.0.1
 */