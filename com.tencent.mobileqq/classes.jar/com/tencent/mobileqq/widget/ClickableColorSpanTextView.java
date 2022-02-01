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
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null) && ((getText() instanceof Spannable)))
    {
      int j = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
      int k = localObject2.length;
      int i = 0;
      while (i < k)
      {
        localObject1 = localObject2[i];
        int m = ((Spannable)getText()).getSpanStart(localObject1);
        int n = ((Spannable)getText()).getSpanEnd(localObject1);
        if ((j > m) && (j < n)) {
          break label112;
        }
        i += 1;
      }
      Object localObject1 = null;
      label112:
      i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label245;
            }
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
            if ((localObject2 == localObject1) && (localObject2 != null)) {
              return true;
            }
          }
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
        if (localObject2 != null)
        {
          if (localObject2 == localObject1)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView$SpanClickListener;
            if (localObject1 != null) {
              ((ClickableColorSpanTextView.SpanClickListener)localObject1).a(this, (StatableSpanTextView.StatableForegroundColorSpan)localObject2);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan.a(StateSet.WILD_CARD);
          this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null;
          invalidate();
        }
      }
      else if (localObject1 != null)
      {
        ((StatableSpanTextView.StatableForegroundColorSpan)localObject1).a(StatableSpanTextView.StatableForegroundColorSpan.a);
        this.jdField_a_of_type_ComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = ((StatableSpanTextView.StatableForegroundColorSpan)localObject1);
        invalidate();
        return true;
      }
    }
    label245:
    return super.onTouchEvent(paramMotionEvent);
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
    else
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ClickableColorSpanTextView
 * JD-Core Version:    0.7.0.1
 */