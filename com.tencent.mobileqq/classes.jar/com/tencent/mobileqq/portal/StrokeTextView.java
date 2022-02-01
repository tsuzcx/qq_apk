package com.tencent.mobileqq.portal;

import agej;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class StrokeTextView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  
  public StrokeTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  @TargetApi(11)
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidTextTextPaint = getPaint();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = agej.a(2.0F, getResources());
    if (Build.VERSION.SDK_INT > 11) {
      setLayerType(1, null);
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mCurTextColor");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      localField.setAccessible(false);
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StrokeTextView", 2, "innerSetTextColor, exception=" + localThrowable.getMessage());
          localThrowable.printStackTrace();
        }
        int i = 1;
      }
      this.jdField_a_of_type_Boolean = false;
      setTextColor(this.jdField_a_of_type_Int);
      setShadowLayer(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.d);
      invalidate();
    }
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.d);
      super.onDraw(paramCanvas);
      a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(0.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(false);
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setInnerTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    setTextColor(paramInt);
  }
  
  public void setShadow(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.d = paramInt;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setStrokeEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setStrokeSize(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(paramBoolean);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    super.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */