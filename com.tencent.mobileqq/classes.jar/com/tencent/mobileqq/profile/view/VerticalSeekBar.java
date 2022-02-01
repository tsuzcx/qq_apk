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
import com.tencent.mobileqq.util.DisplayUtil;
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
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(localResources, 2130847646, localOptions);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label90:
      break label90;
    }
    QLog.e("VerticalSeekBar", 1, "thumb picture decode failed");
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.b = DisplayUtil.a(getContext(), 5.0F);
    this.c = DisplayUtil.a(getContext(), 30.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getMeasuredWidth();
    int i = getMeasuredHeight();
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = ((int)((i - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / this.d * this.e));
    }
    float f4 = j / 2;
    int m = this.jdField_a_of_type_Int;
    int n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    int k = this.b;
    float f2 = m + n + k;
    m = this.jdField_a_of_type_Int;
    float f1;
    if (m < k) {
      f1 = 0.0F;
    } else {
      f1 = m - k;
    }
    paramCanvas.drawLine(f4, 0.0F, f4, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    j = (j - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2;
    this.jdField_a_of_type_AndroidGraphicsRect.set(j, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + j, this.jdField_a_of_type_Int + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    float f3 = i;
    if (f2 > f3) {
      f1 = f3;
    } else {
      f1 = f2;
    }
    paramCanvas.drawLine(f4, f1, f4, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
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
    int j = this.c;
    i = paramInt1;
    if (paramInt1 < j) {
      i = j;
    }
    setMeasuredDimension(i, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    float f1;
    if (i != 0)
    {
      float f2;
      SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener;
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          f1 = paramMotionEvent.getY() - this.jdField_a_of_type_Float;
          f2 = getMeasuredHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          i = this.jdField_a_of_type_Int;
          if ((i + f1 <= f2) && (i + f1 >= 0.0F))
          {
            this.jdField_a_of_type_Int = ((int)(i + f1));
            localOnSeekBarChangeListener = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
            if (localOnSeekBarChangeListener != null)
            {
              this.e = ((int)(this.jdField_a_of_type_Int / f2 * this.d));
              localOnSeekBarChangeListener.onProgressChanged(null, this.e, false);
            }
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getY();
          invalidate();
          return true;
        }
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          localOnSeekBarChangeListener = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
          if (localOnSeekBarChangeListener != null) {
            localOnSeekBarChangeListener.onStopTrackingTouch(null);
          }
        }
        this.jdField_a_of_type_Boolean = false;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 100L)
        {
          float f3 = getMeasuredHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          f2 = paramMotionEvent.getY() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2;
          f1 = f2;
          if (f2 > f3) {
            f1 = f3;
          }
          f2 = f1;
          if (f1 < 0.0F) {
            f2 = 0.0F;
          }
          this.jdField_a_of_type_Int = ((int)f2);
          paramMotionEvent = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
          if (paramMotionEvent != null)
          {
            this.e = ((int)(this.jdField_a_of_type_Int / f3 * this.d));
            paramMotionEvent.onProgressChanged(null, this.e, false);
          }
          invalidate();
          return true;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      f1 = this.jdField_a_of_type_Float;
      i = this.jdField_a_of_type_Int;
      if ((f1 > i - this.b) && (f1 < i + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + this.b))
      {
        this.jdField_a_of_type_Boolean = true;
        paramMotionEvent = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.onStartTrackingTouch(null);
        }
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    return true;
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
      SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
      if (localOnSeekBarChangeListener != null) {
        localOnSeekBarChangeListener.onProgressChanged(null, paramInt, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VerticalSeekBar
 * JD-Core Version:    0.7.0.1
 */