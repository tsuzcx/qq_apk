package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.text.TextPaint;

public class GLLyricsView
  extends GLImageView
{
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int jdField_c_of_type_Int = 0;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  
  public GLLyricsView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    f(4);
  }
  
  public float a()
  {
    if (this.jdField_b_of_type_Float == 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_b_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)(a() + this.jdField_c_of_type_Int), this.jdField_a_of_type_Int + this.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    float f = Math.abs(this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent) + this.jdField_c_of_type_Int / 2;
    if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new TextPaint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-12779354);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(15.0F);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    }
    if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint = new TextPaint();
      this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
      this.jdField_c_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(30.0F);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-9636865);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
      this.jdField_c_of_type_AndroidGraphicsPaint.setShadowLayer(20.0F, 0.0F, 0.0F, -9636865);
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int / 2, f, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int / 2, f, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int / 2, f, this.jdField_a_of_type_AndroidGraphicsPaint);
    super.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLyricsView
 * JD-Core Version:    0.7.0.1
 */