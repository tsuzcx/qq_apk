package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import azvs;
import azvt;
import azwb;
import ved;
import vzl;

public class ArithResultView
  extends BaseScaleAndMoveBitmapView
{
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private azvs jdField_a_of_type_Azvs;
  private azwb jdField_a_of_type_Azwb;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  
  public ArithResultView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ArithResultView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ArithResultView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 20;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(vzl.a(paramContext, 1.0F));
    this.jdField_b_of_type_Int = vzl.a(paramContext, 1.0F);
    this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int * 5);
    try
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130845326);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      ved.e("QQ.Troop.homework.ArithResultView", "create the mark bitmap out of memory:" + paramContext.toString());
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Canvas paramCanvas)
  {
    paramCanvas.drawRoundRect(new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      Rect localRect1 = new Rect(0, 0, this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
      Rect localRect2 = new Rect(paramInt1 + paramInt3 + this.jdField_b_of_type_Int * 2, paramInt4 / 4 + paramInt2, paramInt1 + paramInt3 + this.jdField_b_of_type_Int * 2 + paramInt4 / 2, paramInt4 * 3 / 4 + paramInt2);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, localRect1, localRect2, null);
    }
  }
  
  private void a(azvt paramazvt)
  {
    if (this.jdField_a_of_type_Azwb != null) {
      this.jdField_a_of_type_Azwb.a(paramazvt);
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = 0;
    if (i < this.jdField_a_of_type_Azvs.a())
    {
      paramMotionEvent = this.jdField_a_of_type_Azvs.a(i);
      if (paramMotionEvent.a) {}
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      float f8;
      do
      {
        i += 1;
        break;
        f3 = (paramMotionEvent.jdField_b_of_type_Int + this.jdField_a_of_type_Float) * this.c;
        f4 = (paramMotionEvent.c + this.jdField_b_of_type_Float) * this.c;
        f5 = paramMotionEvent.d + this.jdField_b_of_type_Int * 5 + paramMotionEvent.e / 2;
        f6 = this.c;
        f7 = paramMotionEvent.e;
        f8 = this.c;
      } while ((f1 <= f3) || (f2 <= f4) || (f1 >= f3 + f5 * f6) || (f2 >= f4 + f7 * f8));
      a(paramMotionEvent);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.save();
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Azvs != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_Azvs.a())
      {
        azvt localazvt = this.jdField_a_of_type_Azvs.a(i);
        if (localazvt.a) {}
        for (;;)
        {
          i += 1;
          break;
          int j = (int)(localazvt.jdField_b_of_type_Int + this.jdField_a_of_type_Float - this.jdField_b_of_type_Int);
          int k = (int)(localazvt.c + this.jdField_b_of_type_Float - this.jdField_b_of_type_Int);
          int m = localazvt.d;
          int n = this.jdField_b_of_type_Int;
          int i1 = localazvt.e;
          a(j, k, m + n * 2, this.jdField_b_of_type_Int * 2 + i1, paramCanvas);
        }
      }
    }
    paramCanvas.restore();
  }
  
  public void setData(azvs paramazvs)
  {
    this.jdField_a_of_type_Azvs = paramazvs;
    invalidate();
  }
  
  public void setOnItemClickListener(azwb paramazwb)
  {
    this.jdField_a_of_type_Azwb = paramazwb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithResultView
 * JD-Core Version:    0.7.0.1
 */