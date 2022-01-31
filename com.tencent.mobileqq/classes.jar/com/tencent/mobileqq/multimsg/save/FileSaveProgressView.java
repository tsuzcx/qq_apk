package com.tencent.mobileqq.multimsg.save;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;

public class FileSaveProgressView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString = "0%";
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  private int b = -1;
  private int c = -16725252;
  private int d = 5;
  
  public FileSaveProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public FileSaveProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = getWidth();
    int k = getHeight();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.b > 0) {}
    for (float f = this.b;; f = 2.5F)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f, f, j - f, k - f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.d);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      j = this.jdField_a_of_type_Int * 360 / 100;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, j, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restoreToCount(i);
      super.onDraw(paramCanvas);
      return;
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt < 0) {
      this.jdField_a_of_type_Int = 0;
    }
    do
    {
      return;
      if (paramInt > 100)
      {
        this.jdField_a_of_type_Int = 100;
        return;
      }
      if (paramInt >= this.jdField_a_of_type_Int) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileSaveProgressView", 0, "progress < currentProgress, so return;");
    return;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.jdField_a_of_type_JavaLangStringBuffer.length());
    this.jdField_a_of_type_JavaLangString = (paramInt + "%");
    setText(this.jdField_a_of_type_JavaLangString);
    invalidate();
  }
  
  public void setRingColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setRingWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveProgressView
 * JD-Core Version:    0.7.0.1
 */