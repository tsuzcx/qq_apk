package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar.OnSeekBarChangeListener;
import baxn;
import com.tencent.qphone.base.util.QLog;

public class VerticalSeekBar
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d = 100;
  int e = 0;
  
  public VerticalSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VerticalSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VerticalSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public int a()
  {
    return this.e;
  }
  
  void a()
  {
    Resources localResources = super.getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = localResources.getDisplayMetrics().densityDpi;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(localResources, 2130846498, localOptions);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.b = baxn.a(getContext(), 5.0F);
      this.c = baxn.a(getContext(), 30.0F);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("VerticalSeekBar", 1, "thumb picture decode failed");
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getMeasuredWidth();
    int i = getMeasuredHeight();
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = ((int)((i - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / this.d * this.e));
    }
    float f3 = j / 2;
    float f2 = this.jdField_a_of_type_Int + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + this.b;
    if (this.jdField_a_of_type_Int < this.b)
    {
      f1 = 0.0F;
      paramCanvas.drawLine(f3, 0.0F, f3, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      j = (j - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2;
      this.jdField_a_of_type_AndroidGraphicsRect.set(j, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + j, this.jdField_a_of_type_Int + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (f2 <= i) {
        break label214;
      }
    }
    label214:
    for (float f1 = i;; f1 = f2)
    {
      paramCanvas.drawLine(f3, f1, f3, i, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      f1 = this.jdField_a_of_type_Int - this.b;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredWidth();
    int i = getMeasuredHeight();
    paramInt1 = paramInt2;
    if (paramInt2 < this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) {
      paramInt1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    }
    paramInt2 = i;
    if (i < this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) {
      paramInt2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    i = paramInt1;
    if (paramInt1 < this.c) {
      i = this.c;
    }
    setMeasuredDimension(i, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    if (!isEnabled()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        if ((this.jdField_a_of_type_Float > this.jdField_a_of_type_Int - this.b) && (this.jdField_a_of_type_Float < this.jdField_a_of_type_Int + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + this.b))
        {
          this.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null) {
            this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onStartTrackingTouch(null);
          }
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        continue;
        if (this.jdField_a_of_type_Boolean)
        {
          f1 = paramMotionEvent.getY() - this.jdField_a_of_type_Float;
          f2 = getMeasuredHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          if ((this.jdField_a_of_type_Int + f1 <= f2) && (this.jdField_a_of_type_Int + f1 >= 0.0F))
          {
            this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int + f1));
            if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null)
            {
              this.e = ((int)(this.jdField_a_of_type_Int / f2 * this.d));
              this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onProgressChanged(null, this.e, false);
            }
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getY();
          invalidate();
        }
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null)) {
        this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onStopTrackingTouch(null);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 100L);
    float f2 = getMeasuredHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    float f4 = paramMotionEvent.getY() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
    float f1 = f4;
    if (f4 > f2) {
      f1 = f2;
    }
    if (f1 < 0.0F) {
      f1 = f3;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = ((int)f1);
      if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null)
      {
        this.e = ((int)(this.jdField_a_of_type_Int / f2 * this.d));
        this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onProgressChanged(null, this.e, false);
      }
      invalidate();
      break;
    }
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = paramOnSeekBarChangeListener;
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.d))
    {
      this.e = paramInt;
      if (getMeasuredHeight() >= 0) {
        this.jdField_a_of_type_Int = ((int)((getMeasuredHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / this.d * this.e));
      }
      if (this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener != null) {
        this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener.onProgressChanged(null, paramInt, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VerticalSeekBar
 * JD-Core Version:    0.7.0.1
 */