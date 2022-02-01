package com.tencent.youtu.ytagreflectlivecheck.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class YTReflectLayout
  extends RelativeLayout
{
  private static String TAG = "YTReflectLayout";
  private ColorMatrixColorFilter mColorMatrixColorFilter;
  private Paint mPaint = new Paint(1);
  private Rect mRect = new Rect();
  
  public YTReflectLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(Color.argb(200, 0, 0, 0));
    this.mColorMatrixColorFilter = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    setWillNotDraw(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setColorFilter(this.mColorMatrixColorFilter);
    this.mRect.set(0, 0, getWidth(), getHeight());
    paramCanvas.drawRect(this.mRect, this.mPaint);
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout
 * JD-Core Version:    0.7.0.1
 */