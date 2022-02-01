package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoFitTextView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private AutoFitTextView.OnGetMaxWidthCallback jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView$OnGetMaxWidthCallback;
  
  public AutoFitTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.set(getPaint());
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramInt <= 0) {
        return;
      }
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = getTextSize();
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView$OnGetMaxWidthCallback;
      if (localObject != null) {
        paramInt = ((AutoFitTextView.OnGetMaxWidthCallback)localObject).a();
      } else {
        paramInt = getWidth();
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getCompoundDrawablePadding();
      localObject = new Rect();
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramString, 0, paramString.length(), (Rect)localObject);
      float f1 = ((Rect)localObject).width();
      float f2 = this.jdField_a_of_type_Float;
      while (f1 > paramInt - i - j - k)
      {
        f2 -= 1.0F;
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f2);
        f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString);
      }
      setTextSize(0, f2);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(getText().toString(), getWidth());
  }
  
  public void setOnGetMaxWidthCallback(AutoFitTextView.OnGetMaxWidthCallback paramOnGetMaxWidthCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView$OnGetMaxWidthCallback = paramOnGetMaxWidthCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AutoFitTextView
 * JD-Core Version:    0.7.0.1
 */