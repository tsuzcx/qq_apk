package com.tencent.mobileqq.kandian.biz.comment;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadInJoyLinkMovementMethod
  extends LinkMovementMethod
{
  private static ReadInJoyLinkMovementMethod b;
  private BackgroundColorSpan a;
  
  public static ReadInJoyLinkMovementMethod a()
  {
    if (b == null) {
      b = new ReadInJoyLinkMovementMethod();
    }
    return b;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0) || (i == 2) || (i == 3))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (localObject.length != 0)
      {
        if (i == 1)
        {
          paramSpannable.removeSpan(this.a);
          paramSpannable.setSpan(new BackgroundColorSpan(0), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
          Selection.removeSelection(paramSpannable);
          localObject[0].onClick(paramTextView);
          return true;
        }
        if (i == 0)
        {
          this.a = new BackgroundColorSpan(Color.parseColor("#DBE5EF"));
          paramSpannable.setSpan(this.a, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
          return true;
        }
        if ((i == 3) || (i == 2))
        {
          paramSpannable.removeSpan(this.a);
          paramSpannable.setSpan(new BackgroundColorSpan(0), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
        }
        return true;
      }
      if ((paramTextView.getTag(2131444320) != null) && ((paramTextView.getTag(2131444320) instanceof Boolean)) && (((Boolean)paramTextView.getTag(2131444320)).booleanValue()))
      {
        i = paramMotionEvent.getAction();
        if (i != 0)
        {
          if ((i != 1) && (i != 3)) {
            return true;
          }
          ((LinearLayout)paramTextView.getParent()).setBackgroundDrawable(paramTextView.getResources().getDrawable(2130851362));
          return true;
        }
        ((LinearLayout)paramTextView.getParent()).setBackgroundDrawable(paramTextView.getResources().getDrawable(2130851358));
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyLinkMovementMethod
 * JD-Core Version:    0.7.0.1
 */