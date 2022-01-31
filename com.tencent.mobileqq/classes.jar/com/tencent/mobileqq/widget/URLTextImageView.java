package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class URLTextImageView
  extends URLImageView
{
  float jdField_b_of_type_Float = 0.0F;
  Paint jdField_b_of_type_AndroidGraphicsPaint;
  public String e;
  int i;
  public int j;
  int k = 2131493235;
  
  public URLTextImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public URLTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public URLTextImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!TextUtils.isEmpty(this.e))
    {
      if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(getContext().getResources().getColor(this.k));
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      }
      if (this.j != this.jdField_b_of_type_AndroidGraphicsPaint.getTextSize())
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.j);
        Paint.FontMetricsInt localFontMetricsInt = this.jdField_b_of_type_AndroidGraphicsPaint.getFontMetricsInt();
        this.i = ((getHeight() - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
      }
      int m = this.i;
      if (this.jdField_b_of_type_Float != 0.0F) {
        m = (int)(this.jdField_b_of_type_Float * getHeight());
      }
      paramCanvas.drawText(this.e, getWidth() / 2, m, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.k = paramInt;
    if (this.jdField_b_of_type_AndroidGraphicsPaint != null) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(getContext().getResources().getColor(this.k));
    }
  }
  
  public void setTextSize(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setTopPercent(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.URLTextImageView
 * JD-Core Version:    0.7.0.1
 */