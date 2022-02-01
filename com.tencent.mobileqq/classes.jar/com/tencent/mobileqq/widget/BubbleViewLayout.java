package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import java.util.Arrays;

public class BubbleViewLayout
  extends RelativeLayout
{
  private static final String TAG = "BubbleViewLayout";
  public static final float TRIANGLE_WIDTH = 10.0F;
  private Paint imagePaint;
  public boolean mIsSend = true;
  Path mPath;
  private float mRadius = 30.0F;
  float[] mRadiusList;
  RectF mRect;
  private Resources mRes;
  private boolean mShowRoundCorner = true;
  private boolean mShowSharpCorner = true;
  private Paint roundPaint;
  
  public BubbleViewLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BubbleViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init()
  {
    this.roundPaint = new Paint();
    this.roundPaint.setColor(-1);
    this.roundPaint.setAntiAlias(true);
    this.roundPaint.setStyle(Paint.Style.FILL);
    this.roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.imagePaint = new Paint();
    this.imagePaint.setXfermode(null);
    this.mPath = new Path();
    this.mRect = new RectF();
    this.mRadiusList = new float[8];
    this.mRes = getResources();
    setRadius(15.0F);
    setWillNotDraw(false);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((Build.VERSION.SDK_INT == 28) || (Build.VERSION.SDK_INT == 29))
    {
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.clipPath(this.mPath);
      super.dispatchDraw(paramCanvas);
      return;
    }
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.imagePaint, 31);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawPath(this.mPath, this.roundPaint);
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      onResize(getWidth(), getHeight());
    }
  }
  
  public void onResize(float paramFloat1, float paramFloat2)
  {
    if (!this.mShowSharpCorner)
    {
      this.mRect.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      if (this.mShowRoundCorner)
      {
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, this.mRadiusList, Path.Direction.CW);
      }
      return;
    }
    Resources localResources = this.mRes;
    float f1 = dp2px(10.0F, localResources);
    float f2;
    if (this.mIsSend)
    {
      this.mRect.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
      this.mPath.reset();
      paramFloat2 = dp2px(5.0F, localResources);
      if (!this.mIsSend) {
        break label267;
      }
      this.mPath.addRoundRect(this.mRect, this.mRadiusList, Path.Direction.CW);
      f1 = dp2px(14.0F, localResources);
      f2 = dp2px(8.0F, localResources);
      this.mPath.moveTo(paramFloat1 - f1, f2);
      f1 = dp2px(4.0F, localResources);
      f2 = dp2px(10.0F, localResources);
      this.mPath.quadTo(paramFloat1 - f1, f2, paramFloat1, paramFloat2);
      paramFloat2 = dp2px(10.0F, localResources);
      f1 = dp2px(16.0F, localResources);
      f2 = dp2px(1.0F, localResources);
      float f3 = dp2px(14.0F, localResources);
      this.mPath.quadTo(paramFloat1 - f2, f3, paramFloat1 - paramFloat2, f1);
    }
    for (;;)
    {
      this.mPath.close();
      return;
      this.mRect.set(f1, 0.0F, paramFloat1, paramFloat2);
      break;
      label267:
      this.mPath.addRoundRect(this.mRect, this.mRadiusList, Path.Direction.CCW);
      paramFloat1 = dp2px(14.0F, localResources);
      f1 = dp2px(8.0F, localResources);
      this.mPath.moveTo(paramFloat1, f1);
      paramFloat1 = dp2px(4.0F, localResources);
      f1 = dp2px(10.0F, localResources);
      this.mPath.quadTo(paramFloat1, f1, 0.0F, paramFloat2);
      paramFloat1 = dp2px(10.0F, localResources);
      paramFloat2 = dp2px(16.0F, localResources);
      f1 = dp2px(1.0F, localResources);
      f2 = dp2px(14.0F, localResources);
      this.mPath.quadTo(f1, f2, paramFloat1, paramFloat2);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.mRadiusList != null) {
      Arrays.fill(this.mRadiusList, this.mRadius);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.mRadiusList != null)
    {
      Arrays.fill(this.mRadiusList, 0, 4, this.mRadius);
      Arrays.fill(this.mRadiusList, 4, 8, 0.0F);
    }
  }
  
  public void showRoundCorner(boolean paramBoolean)
  {
    this.mShowRoundCorner = paramBoolean;
  }
  
  public void showSharpCorner(boolean paramBoolean)
  {
    this.mShowSharpCorner = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleViewLayout
 * JD-Core Version:    0.7.0.1
 */