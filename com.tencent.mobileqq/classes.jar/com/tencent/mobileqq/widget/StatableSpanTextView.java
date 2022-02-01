package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import bbwh;
import bivw;
import java.util.ArrayList;

public class StatableSpanTextView
  extends TextView
{
  private long jdField_a_of_type_Long;
  bbwh jdField_a_of_type_Bbwh;
  private ImageSpan[] jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
  private StatableSpanTextView.StatableForegroundColorSpan[] jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
  
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
    int j = 0;
    super.drawableStateChanged();
    int[] arrayOfInt;
    Object localObject;
    int k;
    int i;
    if (this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan != null)
    {
      arrayOfInt = getDrawableState();
      localObject = this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        Drawable localDrawable = localObject[i].getDrawable();
        if (localDrawable.isStateful()) {
          localDrawable.setState(arrayOfInt);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null)
    {
      arrayOfInt = getDrawableState();
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        localObject[i].a(arrayOfInt);
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject2 = getMovementMethod();
    if (((localObject2 != null) || (onCheckIsTextEditor())) && (isEnabled()) && ((getText() instanceof Spannable)) && (getLayout() != null))
    {
      Object localObject1 = (Spannable)getText();
      if (localObject2 != null)
      {
        int i = paramMotionEvent.getAction();
        if ((i == 1) || (i == 0))
        {
          if (i == 0) {
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
          int j = (int)paramMotionEvent.getX();
          int k = (int)paramMotionEvent.getY();
          int m = getTotalPaddingLeft();
          int n = getTotalPaddingTop();
          int i1 = getScrollX();
          int i2 = getScrollY();
          localObject2 = getLayout();
          j = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(k - n + i2), j - m + i1);
          localObject1 = (bbwh[])((Spannable)localObject1).getSpans(j, j, bbwh.class);
          if (localObject1.length != 0)
          {
            localObject1 = localObject1[0];
            if (i == 1)
            {
              ((bbwh)localObject1).a(this, false);
              if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
                ((bbwh)localObject1).onClick(this);
              }
            }
            for (;;)
            {
              return true;
              return super.onTouchEvent(paramMotionEvent);
              if (i == 0)
              {
                ((bbwh)localObject1).a(this, true);
                this.jdField_a_of_type_Bbwh = ((bbwh)localObject1);
              }
              else
              {
                ((bbwh)localObject1).a(this, false);
              }
            }
          }
          if (this.jdField_a_of_type_Bbwh != null) {
            this.jdField_a_of_type_Bbwh.a(this, false);
          }
        }
      }
    }
    return false;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Spannable localSpannable;
    if ((paramCharSequence != null) && ((paramCharSequence instanceof Spannable)))
    {
      localSpannable = (Spannable)paramCharSequence;
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = ((ImageSpan[])localSpannable.getSpans(0, localSpannable.length(), ImageSpan.class));
      if (this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan != null)
      {
        ArrayList localArrayList = new ArrayList();
        ImageSpan[] arrayOfImageSpan = this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
        int j = arrayOfImageSpan.length;
        int i = 0;
        while (i < j)
        {
          ImageSpan localImageSpan = arrayOfImageSpan[i];
          if (!(localImageSpan instanceof bivw)) {
            localArrayList.add(localImageSpan);
          }
          i += 1;
        }
        if (localArrayList.size() <= 0) {
          break label172;
        }
        this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = new ImageSpan[localArrayList.size()];
        this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = ((ImageSpan[])localArrayList.toArray(this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan));
      }
    }
    for (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = ((StatableSpanTextView.StatableForegroundColorSpan[])localSpannable.getSpans(0, localSpannable.length(), StatableSpanTextView.StatableForegroundColorSpan.class));; this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      label172:
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = null;
      break;
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.StatableSpanTextView
 * JD-Core Version:    0.7.0.1
 */