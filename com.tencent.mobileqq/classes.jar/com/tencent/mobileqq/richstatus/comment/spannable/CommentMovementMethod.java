package com.tencent.mobileqq.richstatus.comment.spannable;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class CommentMovementMethod
  extends BaseMovementMethod
{
  public final String a = "CommentMovementMethod";
  private int b;
  private int c;
  private BackgroundColorSpan d;
  private ClickableSpan[] e;
  private boolean f = true;
  
  public CommentMovementMethod(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  private void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    Object localObject;
    if (i == 0)
    {
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      localObject = paramTextView.getLayout();
      i = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(j - m + i1), i - k + n);
      this.e = ((ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class));
      if (this.e.length > 0)
      {
        a(false);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.e[0]), paramSpannable.getSpanEnd(this.e[0]));
        this.d = new BackgroundColorSpan(this.c);
        paramSpannable.setSpan(this.d, paramSpannable.getSpanStart(this.e[0]), paramSpannable.getSpanEnd(this.e[0]), 33);
      }
      else
      {
        a(true);
        paramTextView.setBackgroundColor(this.b);
      }
    }
    else if (i == 1)
    {
      localObject = this.e;
      if (localObject.length > 0)
      {
        localObject[0].onClick(paramTextView);
        localObject = this.d;
        if (localObject != null) {
          paramSpannable.removeSpan(localObject);
        }
      }
      Selection.removeSelection(paramSpannable);
      paramTextView.setBackgroundResource(2131168376);
    }
    else if (i != 2)
    {
      localObject = this.d;
      if (localObject != null) {
        paramSpannable.removeSpan(localObject);
      }
      paramTextView.setBackgroundResource(2131168376);
    }
    return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.spannable.CommentMovementMethod
 * JD-Core Version:    0.7.0.1
 */