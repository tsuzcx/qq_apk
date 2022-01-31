package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class ClickableColorSpanTextView
  extends TextView
{
  private ClickableColorSpanTextView.SpanClickListener jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$SpanClickListener;
  private StatableSpanTextView.StatableForegroundColorSpan jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
  private StatableSpanTextView.StatableForegroundColorSpan[] jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
  
  public ClickableColorSpanTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClickableColorSpanTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickableColorSpanTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    return Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat) + getScrollX();
  }
  
  private int a(float paramFloat)
  {
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    return getLayout().getLineForVertical((int)(paramFloat + f));
  }
  
  private int a(int paramInt, float paramFloat)
  {
    paramFloat = a(paramFloat);
    return getLayout().getOffsetForHorizontal(paramInt, paramFloat);
  }
  
  public int getOffsetForPosition(float paramFloat1, float paramFloat2)
  {
    if (getLayout() == null) {
      return -1;
    }
    return a(a(paramFloat2), paramFloat1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    StatableSpanTextView.StatableForegroundColorSpan localStatableForegroundColorSpan;
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null) && ((getText() instanceof Spannable)))
    {
      int j = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      StatableSpanTextView.StatableForegroundColorSpan[] arrayOfStatableForegroundColorSpan = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
      int k = arrayOfStatableForegroundColorSpan.length;
      i = 0;
      if (i >= k) {
        break label247;
      }
      localStatableForegroundColorSpan = arrayOfStatableForegroundColorSpan[i];
      int m = ((Spannable)getText()).getSpanStart(localStatableForegroundColorSpan);
      int n = ((Spannable)getText()).getSpanEnd(localStatableForegroundColorSpan);
      if ((j <= m) || (j >= n)) {
        break label138;
      }
    }
    for (;;)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        label138:
        i += 1;
        break;
        if (localStatableForegroundColorSpan != null)
        {
          localStatableForegroundColorSpan.a(StatableSpanTextView.StatableForegroundColorSpan.a);
          this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = localStatableForegroundColorSpan;
          invalidate();
          return true;
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan == localStatableForegroundColorSpan) && (this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null)) {
            return true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan == localStatableForegroundColorSpan) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$SpanClickListener != null)) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$SpanClickListener.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan);
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan.a(StateSet.WILD_CARD);
            this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null;
            invalidate();
          }
        }
      }
      label247:
      localStatableForegroundColorSpan = null;
    }
  }
  
  public void setSpanClickListener(ClickableColorSpanTextView.SpanClickListener paramSpanClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$SpanClickListener = paramSpanClickListener;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramCharSequence != null) && ((paramCharSequence instanceof Spannable)))
    {
      paramBufferType = (Spannable)paramCharSequence;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = ((StatableSpanTextView.StatableForegroundColorSpan[])paramBufferType.getSpans(0, paramBufferType.length(), StatableSpanTextView.StatableForegroundColorSpan.class));
      paramBufferType = TextView.BufferType.SPANNABLE;
    }
    for (;;)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickableColorSpanTextView
 * JD-Core Version:    0.7.0.1
 */