package com.tencent.mobileqq.dating.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewDebug.ExportedProperty;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class DatingCommentTextView
  extends TextView
{
  private int a = -1;
  private int b = -1;
  private ClickableSpan c;
  
  public DatingCommentTextView(Context paramContext)
  {
    super(paramContext);
    setFocusable(false);
  }
  
  public DatingCommentTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(false);
  }
  
  @ViewDebug.ExportedProperty(category="focus")
  public boolean hasFocus()
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i;
    do
    {
      try
      {
        i = paramMotionEvent.getActionMasked();
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = getTotalPaddingLeft();
        int n = getTotalPaddingTop();
        int i1 = getScrollX();
        int i2 = getScrollY();
        paramMotionEvent = getLayout();
        j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
        paramMotionEvent = getText();
        if (!TextUtils.isEmpty(paramMotionEvent))
        {
          if (!(paramMotionEvent instanceof Spannable)) {
            return bool;
          }
          paramMotionEvent = (Spannable)getText();
          ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
          if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length != 0))
          {
            if (i == 0)
            {
              this.c = arrayOfClickableSpan[0];
              this.a = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
              this.b = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
              if ((this.a < 0) || (this.b < this.a)) {
                break;
              }
              if ((arrayOfClickableSpan[0] instanceof DatingCommentTextView.TouchableSpan))
              {
                ((DatingCommentTextView.TouchableSpan)arrayOfClickableSpan[0]).a(true);
                return true;
              }
              paramMotionEvent.setSpan(new BackgroundColorSpan(Color.parseColor("#d5d5d5")), this.a, this.b, 33);
              return true;
              this.c = null;
              if ((this.a < 0) || (this.b < this.a)) {
                break;
              }
              if ((arrayOfClickableSpan[0] instanceof DatingCommentTextView.TouchableSpan)) {
                ((DatingCommentTextView.TouchableSpan)arrayOfClickableSpan[0]).a(false);
              } else {
                paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.a, this.b, 33);
              }
              Selection.removeSelection(paramMotionEvent);
              this.a = -1;
              this.b = -1;
              return true;
            }
          }
          else
          {
            if ((this.a >= 0) && (this.b >= this.a))
            {
              if ((this.c != null) && ((this.c instanceof DatingCommentTextView.TouchableSpan)))
              {
                ((DatingCommentTextView.TouchableSpan)this.c).a(false);
                this.c = null;
              }
              else
              {
                paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.a, this.b, 33);
              }
              Selection.removeSelection(paramMotionEvent);
              this.a = -1;
              this.b = -1;
            }
            return false;
          }
        }
        else
        {
          return bool;
        }
      }
      catch (Exception paramMotionEvent)
      {
        if (QLog.isDevelopLevel()) {
          paramMotionEvent.printStackTrace();
        }
        return bool;
      }
    } while ((i == 1) || (i == 3));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingCommentTextView
 * JD-Core Version:    0.7.0.1
 */