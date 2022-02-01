package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.text.ClickableImageSpan;
import com.tencent.mobileqq.text.ITopic;
import java.util.ArrayList;

public class StatableSpanTextView
  extends TextView
{
  ITopic a;
  boolean b;
  private ImageSpan[] c;
  private StatableSpanTextView.StatableForegroundColorSpan[] d;
  
  public StatableSpanTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatableSpanTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StatableSpanTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject1 = this.c;
    int j = 0;
    Object localObject2;
    int k;
    int i;
    if (localObject1 != null)
    {
      localObject1 = getDrawableState();
      localObject2 = this.c;
      k = localObject2.length;
      i = 0;
      while (i < k)
      {
        Drawable localDrawable = localObject2[i].getDrawable();
        if (localDrawable.isStateful()) {
          localDrawable.setState((int[])localObject1);
        }
        i += 1;
      }
    }
    if (this.d != null)
    {
      localObject1 = getDrawableState();
      localObject2 = this.d;
      k = localObject2.length;
      i = j;
      while (i < k)
      {
        localObject2[i].a((int[])localObject1);
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    MovementMethod localMovementMethod = getMovementMethod();
    if (((localMovementMethod != null) || (onCheckIsTextEditor())) && (isEnabled()) && ((getText() instanceof Spannable)) && (getLayout() != null))
    {
      Object localObject = (Spannable)getText();
      if (localMovementMethod != null)
      {
        int i = paramMotionEvent.getAction();
        if ((i == 1) || (i == 0) || (i == 3))
        {
          int j = (int)paramMotionEvent.getX();
          int k = (int)paramMotionEvent.getY();
          int m = getTotalPaddingLeft();
          int n = getTotalPaddingTop();
          int i1 = getScrollX();
          int i2 = getScrollY();
          paramMotionEvent = getLayout();
          j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
          paramMotionEvent = (ITopic[])((Spannable)localObject).getSpans(j, j, ITopic.class);
          if (paramMotionEvent.length != 0)
          {
            this.b = false;
            paramMotionEvent = paramMotionEvent[0];
            if (i == 0)
            {
              paramMotionEvent.setPressed(this, true);
              this.a = paramMotionEvent;
              return true;
            }
            localObject = this.a;
            if (localObject != null)
            {
              ((ITopic)localObject).setPressed(this, false);
              this.a = null;
            }
            if (i == 1) {
              paramMotionEvent.onClick(this);
            }
            return true;
          }
          if (i == 1)
          {
            if (this.b)
            {
              this.b = false;
              performClick();
            }
          }
          else if (i == 0) {
            this.b = true;
          } else if (i == 3) {
            this.b = false;
          }
          paramMotionEvent = this.a;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(this, false);
            this.a = null;
          }
        }
      }
    }
    return false;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramCharSequence != null) && ((paramCharSequence instanceof Spannable)))
    {
      Spannable localSpannable = (Spannable)paramCharSequence;
      this.c = ((ImageSpan[])localSpannable.getSpans(0, localSpannable.length(), ImageSpan.class));
      if (this.c != null)
      {
        ArrayList localArrayList = new ArrayList();
        ImageSpan[] arrayOfImageSpan = this.c;
        int j = arrayOfImageSpan.length;
        int i = 0;
        while (i < j)
        {
          ImageSpan localImageSpan = arrayOfImageSpan[i];
          if (!(localImageSpan instanceof ClickableImageSpan)) {
            localArrayList.add(localImageSpan);
          }
          i += 1;
        }
        if (localArrayList.size() > 0)
        {
          this.c = new ImageSpan[localArrayList.size()];
          this.c = ((ImageSpan[])localArrayList.toArray(this.c));
        }
        else
        {
          this.c = null;
        }
      }
      this.d = ((StatableSpanTextView.StatableForegroundColorSpan[])localSpannable.getSpans(0, localSpannable.length(), StatableSpanTextView.StatableForegroundColorSpan.class));
    }
    else
    {
      this.c = null;
      this.d = null;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.StatableSpanTextView
 * JD-Core Version:    0.7.0.1
 */