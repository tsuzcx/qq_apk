package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.filecommon.api.R.styleable;
import com.tencent.theme.ISkinIgnoreTypeface;

public class EllipsizingTextView
  extends TextView
  implements ISkinIgnoreTypeface
{
  private int jdField_a_of_type_Int = 1;
  private EllipsizingTextView.EllipsizingHelper jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView$EllipsizingHelper;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.P);
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.o) {
          this.jdField_b_of_type_Int = paramContext.getDimensionPixelOffset(k, this.jdField_b_of_type_Int);
        } else if (k == R.styleable.p) {
          this.jdField_a_of_type_Int = paramContext.getInt(k, this.jdField_a_of_type_Int);
        } else if (k == R.styleable.n) {
          this.jdField_a_of_type_Boolean = paramContext.getBoolean(k, this.jdField_a_of_type_Boolean);
        }
        i += 1;
      }
      paramContext.recycle();
    }
    setTypeface(null);
  }
  
  private EllipsizingTextView.EllipsizingHelper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView$EllipsizingHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView$EllipsizingHelper = new EllipsizingTextView.EllipsizingHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView$EllipsizingHelper;
  }
  
  public void a()
  {
    this.c = true;
  }
  
  public int getLineCount()
  {
    return a().a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = a();
    ((EllipsizingTextView.EllipsizingHelper)localObject).a(getText(), this, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
    if (getEllipsize() == TextUtils.TruncateAt.END)
    {
      ((EllipsizingTextView.EllipsizingHelper)localObject).a(paramCanvas, TextUtils.TruncateAt.END);
      return;
    }
    if (getEllipsize() == TextUtils.TruncateAt.MIDDLE)
    {
      ((EllipsizingTextView.EllipsizingHelper)localObject).a(paramCanvas, TextUtils.TruncateAt.MIDDLE);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setEndStrWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */