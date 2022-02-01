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
import asbl;
import com.tencent.qphone.base.util.QLog;

public class DatingCommentTextView
  extends TextView
{
  private int jdField_a_of_type_Int = -1;
  private ClickableSpan jdField_a_of_type_AndroidTextStyleClickableSpan;
  private int b = -1;
  
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
    ClickableSpan[] arrayOfClickableSpan;
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
      if ((TextUtils.isEmpty(paramMotionEvent)) || (!(paramMotionEvent instanceof Spannable))) {
        break label455;
      }
      paramMotionEvent = (Spannable)getText();
      arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
      if ((arrayOfClickableSpan == null) || (arrayOfClickableSpan.length == 0)) {
        break label360;
      }
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidTextStyleClickableSpan = arrayOfClickableSpan[0];
        this.jdField_a_of_type_Int = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
        this.b = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
        if ((this.jdField_a_of_type_Int < 0) || (this.b < this.jdField_a_of_type_Int)) {
          break label458;
        }
        if ((arrayOfClickableSpan[0] instanceof asbl)) {
          ((asbl)arrayOfClickableSpan[0]).a(true);
        } else {
          paramMotionEvent.setSpan(new BackgroundColorSpan(Color.parseColor("#d5d5d5")), this.jdField_a_of_type_Int, this.b, 33);
        }
      }
    }
    catch (Exception paramMotionEvent)
    {
      if (QLog.isDevelopLevel()) {
        paramMotionEvent.printStackTrace();
      }
      return bool;
    }
    if ((i == 1) || (i == 3))
    {
      this.jdField_a_of_type_AndroidTextStyleClickableSpan = null;
      if ((this.jdField_a_of_type_Int >= 0) && (this.b >= this.jdField_a_of_type_Int))
      {
        if ((arrayOfClickableSpan[0] instanceof asbl)) {
          ((asbl)arrayOfClickableSpan[0]).a(false);
        }
        for (;;)
        {
          Selection.removeSelection(paramMotionEvent);
          this.jdField_a_of_type_Int = -1;
          this.b = -1;
          break;
          paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.jdField_a_of_type_Int, this.b, 33);
        }
        label360:
        if ((this.jdField_a_of_type_Int < 0) || (this.b < this.jdField_a_of_type_Int)) {
          break label460;
        }
        if ((this.jdField_a_of_type_AndroidTextStyleClickableSpan != null) && ((this.jdField_a_of_type_AndroidTextStyleClickableSpan instanceof asbl)))
        {
          ((asbl)this.jdField_a_of_type_AndroidTextStyleClickableSpan).a(false);
          this.jdField_a_of_type_AndroidTextStyleClickableSpan = null;
        }
        for (;;)
        {
          Selection.removeSelection(paramMotionEvent);
          this.jdField_a_of_type_Int = -1;
          this.b = -1;
          break;
          paramMotionEvent.setSpan(new BackgroundColorSpan(0), this.jdField_a_of_type_Int, this.b, 33);
        }
        label455:
        return bool;
      }
    }
    label458:
    return true;
    label460:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingCommentTextView
 * JD-Core Version:    0.7.0.1
 */