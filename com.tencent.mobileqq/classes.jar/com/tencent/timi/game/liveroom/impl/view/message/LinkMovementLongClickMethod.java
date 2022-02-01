package com.tencent.timi.game.liveroom.impl.view.message;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class LinkMovementLongClickMethod
  extends LinkMovementMethod
{
  private static LinkMovementLongClickMethod a;
  private long b;
  @Nullable
  private MsgLongClickableSpan c;
  private final Runnable d = new LinkMovementLongClickMethod.1(this);
  
  public static LinkMovementLongClickMethod a()
  {
    if (a == null) {
      a = new LinkMovementLongClickMethod();
    }
    return a;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 0))
    {
      if (i == 3)
      {
        paramTextView.removeCallbacks(this.d);
        this.c = null;
      }
    }
    else
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
        paramMotionEvent = localObject[0];
        if (i == 1)
        {
          if (System.currentTimeMillis() - this.b < 300L)
          {
            localObject[0].onClick(paramTextView);
          }
          else
          {
            paramSpannable = this.c;
            if ((paramSpannable != null) && (paramSpannable == paramMotionEvent)) {
              paramSpannable.b();
            }
          }
          paramTextView.removeCallbacks(this.d);
          this.c = null;
          return true;
        }
        this.c = null;
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
        this.b = System.currentTimeMillis();
        if ((paramMotionEvent instanceof MsgLongClickableSpan))
        {
          this.c = ((MsgLongClickableSpan)paramMotionEvent);
          paramTextView.postDelayed(this.d, 300L);
        }
        return true;
      }
      Selection.removeSelection(paramSpannable);
      this.c = null;
    }
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.LinkMovementLongClickMethod
 * JD-Core Version:    0.7.0.1
 */