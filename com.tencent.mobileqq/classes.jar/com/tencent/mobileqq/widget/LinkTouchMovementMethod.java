package com.tencent.mobileqq.widget;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.text.ClickableImageSpan;

public class LinkTouchMovementMethod
  extends LinkMovementMethod
{
  private ClickableImageSpan a;
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if ((j == 1) || (j == 0) || (j == 3) || (j == 2))
    {
      float f1 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      f1 = Math.max(0.0F, f1 - paramTextView.getTotalPaddingLeft());
      f1 = Math.min(paramTextView.getWidth() - paramTextView.getTotalPaddingLeft() - 1, f1);
      float f2 = paramTextView.getScrollX();
      f3 = Math.max(0.0F, f3 - paramTextView.getTotalPaddingTop());
      f3 = Math.min(paramTextView.getHeight() - paramTextView.getTotalPaddingBottom() - 1, f3);
      float f4 = paramTextView.getScrollY();
      int i = -1;
      Layout localLayout = paramTextView.getLayout();
      if (localLayout != null) {
        i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical((int)(f3 + f4)), f1 + f2);
      }
      paramSpannable = (ClickableImageSpan[])paramSpannable.getSpans(i, i, ClickableImageSpan.class);
      if ((j == 0) && (paramSpannable != null) && (paramSpannable.length != 0)) {
        this.a = paramSpannable[0];
      } else if (((j == 1) || (j == 2)) && (paramSpannable != null) && (paramSpannable.length == 0)) {
        paramMotionEvent.setAction(3);
      }
      paramSpannable = this.a;
      if (paramSpannable != null)
      {
        boolean bool = paramSpannable.onTouch(paramTextView, paramMotionEvent);
        if ((j == 1) || (j == 3)) {
          this.a = null;
        }
        return bool;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LinkTouchMovementMethod
 * JD-Core Version:    0.7.0.1
 */