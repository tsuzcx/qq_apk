package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;

public class BaseScaleAndMoveBitmapView
  extends View
{
  protected float a;
  protected Bitmap a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new BaseScaleAndMoveBitmapView.SimpleGestureListenerImpl(this, null));
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new BaseScaleAndMoveBitmapView.SimpleScaleListenerImpl(this, null));
  private boolean jdField_a_of_type_Boolean = false;
  protected float b;
  private boolean b;
  protected float c = 1.0F;
  private float d = 5.0F;
  private float e = 0.1F;
  
  public BaseScaleAndMoveBitmapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseScaleAndMoveBitmapView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseScaleAndMoveBitmapView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      AssertUtils.a("call resize when bitmap is invalid", new Object[0]);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.c = Math.min(getWidth() * 0.1F / (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.1F), getHeight() * 0.1F / (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 0.1F));
    float f1 = getHeight() * 0.1F / (getWidth() * 0.1F);
    float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 0.1F / (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.1F);
    if (f1 > f2)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = ((int)((getHeight() - f2 * getWidth()) / 2.0F / this.c));
    }
    for (;;)
    {
      setScaleRange(1.0F, 4.0F);
      SLog.d("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "setImageBitmap mScaleFactor=" + this.c + ",mPosX=" + this.jdField_a_of_type_Float + ",mPosY=" + this.jdField_b_of_type_Float);
      return;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Float = ((int)((getWidth() - getHeight() / f2) / 2.0F / this.c));
    }
  }
  
  protected float a(float paramFloat)
  {
    return (this.jdField_a_of_type_Float + paramFloat) * this.c;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  protected void a(MotionEvent paramMotionEvent) {}
  
  protected float b(float paramFloat)
  {
    return (this.jdField_b_of_type_Float + paramFloat) * this.c;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      paramCanvas.scale(this.c, this.c, 0.0F, 0.0F);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, null);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1)) {
        SLog.d("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "when on touch the mBitmap is null");
      }
      return false;
    }
    this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_b_of_type_Boolean = true;
      continue;
      if (this.jdField_b_of_type_Boolean)
      {
        a(paramMotionEvent);
        continue;
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void setImageBitmap(@NonNull Bitmap paramBitmap)
  {
    SLog.d("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "setImageBitmap bitmap w=" + paramBitmap.getWidth() + ",h=" + paramBitmap.getHeight());
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap.copy(paramBitmap.getConfig(), false);
    if ((getWidth() <= 0) || (getHeight() <= 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    a();
    invalidate();
  }
  
  public void setScaleRange(float paramFloat1, float paramFloat2)
  {
    this.e = (this.c * paramFloat1);
    this.d = (this.c * paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.BaseScaleAndMoveBitmapView
 * JD-Core Version:    0.7.0.1
 */