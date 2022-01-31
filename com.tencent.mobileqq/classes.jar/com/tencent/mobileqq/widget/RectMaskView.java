package com.tencent.mobileqq.widget;

import akih;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class RectMaskView
  extends View
{
  int jdField_a_of_type_Int = 0;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 0;
  Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  int jdField_c_of_type_Int;
  Paint jdField_c_of_type_AndroidGraphicsPaint;
  
  public RectMaskView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(1291845632);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(DisplayUtil.a(paramContext, 19.0F));
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localRect == null) {
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    do
    {
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, localRect.top, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(localRect.right, localRect.top, this.jdField_a_of_type_Int, localRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.bottom, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.left, localRect.top, localRect.left + 26, localRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.left, localRect.top, localRect.left, localRect.top + 26, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.right, localRect.top, localRect.right - 26, localRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.right, localRect.top, localRect.right, localRect.top + 26, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.left, localRect.bottom, localRect.left + 26, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.left, localRect.bottom, localRect.left, localRect.bottom - 26, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.right, localRect.bottom, localRect.right - 26, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(localRect.right, localRect.bottom, localRect.right, localRect.bottom - 26, this.jdField_a_of_type_AndroidGraphicsPaint);
    } while (this.jdField_a_of_type_JavaLangString == null);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int * 0.5F, localRect.top - DisplayUtil.a(getContext(), this.jdField_c_of_type_Int), this.jdField_c_of_type_AndroidGraphicsPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    invalidate();
  }
  
  public void postInvalidateDelayed(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.postInvalidateDelayed(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    postDelayed(new akih(this, paramInt1, paramInt2, paramInt3, paramInt4), paramLong);
  }
  
  public void setRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
  }
  
  public void setText(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RectMaskView
 * JD-Core Version:    0.7.0.1
 */