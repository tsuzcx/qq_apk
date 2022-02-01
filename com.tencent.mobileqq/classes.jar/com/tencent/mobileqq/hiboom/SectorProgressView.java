package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import bheg;
import com.tencent.mobileqq.util.DisplayUtil;

public class SectorProgressView
  extends View
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static int jdField_b_of_type_Int;
  private static Rect jdField_b_of_type_AndroidGraphicsRect;
  private static int jdField_c_of_type_Int;
  private static int d;
  private static int e;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public boolean a;
  private boolean jdField_b_of_type_Boolean;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  
  public SectorProgressView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public SectorProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public SectorProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    if (jdField_b_of_type_Int == 0) {
      jdField_b_of_type_Int = DisplayUtil.dip2px(getContext(), 26.0F);
    }
    if (jdField_c_of_type_Int == 0) {
      jdField_c_of_type_Int = DisplayUtil.dip2px(getContext(), 3.0F);
    }
    if (d == 0) {
      d = DisplayUtil.dip2px(getContext(), 18.0F);
    }
    if (e == 0) {
      e = DisplayUtil.dip2px(getContext(), 8.0F);
    }
    if (jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      jdField_a_of_type_AndroidGraphicsBitmap = bheg.a(getResources(), 2130847413);
      jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    }
  }
  
  public void a()
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = true;
    if (!bool) {
      invalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = false;
    if (bool) {
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1073741824);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      f = this.jdField_a_of_type_Int * 360 / 100;
      i = (getMeasuredWidth() - jdField_b_of_type_Int) / 2;
      j = (getMeasuredHeight() - jdField_b_of_type_Int) / 2;
      k = (getMeasuredWidth() + jdField_b_of_type_Int) / 2;
      m = (getMeasuredWidth() + jdField_b_of_type_Int) / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(i, j, k, m);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-8354924);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, jdField_b_of_type_Int / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-13646081);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, -f, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    while (!this.jdField_a_of_type_Boolean)
    {
      float f;
      int k;
      int m;
      return;
    }
    int i = getMeasuredWidth() - e - d;
    int j = getMeasuredHeight() - e - d;
    this.jdField_c_of_type_AndroidGraphicsRect.set(i, j, d + i, d + j);
    paramCanvas.drawBitmap(jdField_a_of_type_AndroidGraphicsBitmap, jdField_b_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setProgress(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (i != this.jdField_a_of_type_Int) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.SectorProgressView
 * JD-Core Version:    0.7.0.1
 */