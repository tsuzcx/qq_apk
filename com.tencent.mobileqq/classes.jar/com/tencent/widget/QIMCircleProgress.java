package com.tencent.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class QIMCircleProgress
  extends ImageView
{
  public static final int ANIM_MODE = 2;
  public static final int CAPTURE_MODE = 1;
  public static final int IDLE_MODE = 0;
  public static final int LOCK_MODE = 3;
  public static int MAX_PROGRESS = 10000;
  public static final int NEXT_SEGMENT_BLINK_ANGLE = 5;
  public static final int SEGMENT_GAP_ANGLE = 4;
  public static final String TAG = "QIMCircleProgress";
  protected int captureSize;
  ValueAnimator capturedSegmentBlinkAnimator;
  protected int idleSize;
  boolean isCapturedSegmentBlink = false;
  boolean isNextSegmentBlink = false;
  int mBgAlpha;
  int mBgColor;
  float mBlinkAlpha = 0.0F;
  Paint mBlinkPaint;
  int mCenterCicleColor;
  protected float mCenterScale = 1.0F;
  float mDensity;
  protected int mHeight;
  float mMaxBlinkShadowRadius = 5.0F;
  protected int mMode = 0;
  protected Paint mPaint;
  protected Paint mPaintOrangeFill;
  protected Paint mPaintWhite;
  protected float mProgress;
  int mProgressAlpha;
  int mProgressColor;
  protected float mProgressOffset;
  private List<Float> mSegmentTimePoints = new ArrayList();
  protected int mStrokeWidth = 10;
  protected int mWidth;
  boolean needNextSegmentAnimation = false;
  ValueAnimator nextSegmentBlinkAnimator;
  protected RectF oval = new RectF();
  
  public QIMCircleProgress(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public void cancelAnimation()
  {
    ValueAnimator localValueAnimator = this.capturedSegmentBlinkAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.needNextSegmentAnimation = false;
      this.capturedSegmentBlinkAnimator.cancel();
    }
    localValueAnimator = this.nextSegmentBlinkAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.nextSegmentBlinkAnimator.cancel();
    }
  }
  
  public void changeMode(int paramInt)
  {
    this.mMode = paramInt;
    if (this.mMode == 1) {
      cancelAnimation();
    }
    invalidate();
  }
  
  protected void drawCenterCircle(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.captureSize / 2, this.mPaintWhite);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.idleSize / 2, this.mPaintOrangeFill);
  }
  
  public void forceNextSegmentAnimatorStart()
  {
    ValueAnimator localValueAnimator = this.capturedSegmentBlinkAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.needNextSegmentAnimation = false;
      this.capturedSegmentBlinkAnimator.cancel();
    }
    localValueAnimator = this.nextSegmentBlinkAnimator;
    if ((localValueAnimator != null) && (!localValueAnimator.isRunning())) {
      this.nextSegmentBlinkAnimator.start();
    }
  }
  
  public float getCurrentProgress()
  {
    return this.mProgress;
  }
  
  public int getMode()
  {
    return this.mMode;
  }
  
  public List<Float> getSegmentPoints()
  {
    return this.mSegmentTimePoints;
  }
  
  protected void init()
  {
    setLayerType(1, null);
    this.mDensity = getResources().getDisplayMetrics().density;
    this.mBgColor = getResources().getColor(2131166114);
    this.mProgressColor = getResources().getColor(2131167113);
    this.mBgAlpha = 51;
    this.mProgressAlpha = 100;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(this.mProgressColor);
    this.mBlinkPaint = new Paint();
    this.mBlinkPaint.setAntiAlias(true);
    this.mBlinkPaint.setStyle(Paint.Style.STROKE);
    this.mBlinkPaint.setColor(getResources().getColor(2131168464));
    this.mPaintOrangeFill = new Paint();
    this.mPaintOrangeFill.setAntiAlias(true);
    this.mPaintOrangeFill.setStyle(Paint.Style.FILL);
    this.mPaintOrangeFill.setColor(this.mProgressColor);
    this.mCenterCicleColor = -1;
    this.mPaintWhite = new Paint();
    this.mPaintWhite.setAntiAlias(true);
    this.mPaintWhite.setStyle(Paint.Style.FILL);
    this.mPaintWhite.setColor(this.mCenterCicleColor);
  }
  
  public void initBlinkAnimator()
  {
    if (this.capturedSegmentBlinkAnimator == null)
    {
      this.capturedSegmentBlinkAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.capturedSegmentBlinkAnimator.setDuration(150L);
      this.capturedSegmentBlinkAnimator.setRepeatCount(3);
      this.capturedSegmentBlinkAnimator.setRepeatMode(2);
      this.capturedSegmentBlinkAnimator.addUpdateListener(new QIMCircleProgress.1(this));
      this.capturedSegmentBlinkAnimator.addListener(new QIMCircleProgress.2(this));
    }
    if (this.nextSegmentBlinkAnimator == null)
    {
      this.nextSegmentBlinkAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.nextSegmentBlinkAnimator.setDuration(400L);
      this.nextSegmentBlinkAnimator.setRepeatCount(-1);
      this.nextSegmentBlinkAnimator.setRepeatMode(2);
      this.nextSegmentBlinkAnimator.addUpdateListener(new QIMCircleProgress.3(this));
      this.nextSegmentBlinkAnimator.addListener(new QIMCircleProgress.4(this));
    }
  }
  
  public void notifyChange()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    int i = this.mWidth;
    if (i <= 0) {
      return;
    }
    Object localObject = this.oval;
    int j = this.mStrokeWidth;
    float f1 = j;
    float f2 = this.mProgressOffset;
    ((RectF)localObject).set(f1 * 1.38F + f2, j * 1.38F + f2, i - j * 1.38F - f2, this.mHeight - j * 1.38F - f2);
    f1 = MAX_PROGRESS * -0.005555556F;
    i = 0;
    while (i < this.mSegmentTimePoints.size())
    {
      f2 = ((Float)this.mSegmentTimePoints.get(i)).floatValue();
      j = MAX_PROGRESS;
      float f3 = 2.0F + (f1 * 360.0F / j - 90.0F);
      f1 = (f2 - f1) * 360.0F / j - 4.0F;
      if (f1 > 0.0F) {
        if ((this.isCapturedSegmentBlink) && (i == this.mSegmentTimePoints.size() - 1))
        {
          localObject = this.mPaint;
          double d1 = this.mStrokeWidth;
          double d2 = this.mBlinkAlpha;
          Double.isNaN(d2);
          Double.isNaN(d1);
          ((Paint)localObject).setStrokeWidth((int)(d1 * (1.0D - d2 * 0.38D)));
          localObject = this.mBlinkPaint;
          d1 = this.mStrokeWidth;
          d2 = this.mBlinkAlpha;
          Double.isNaN(d2);
          Double.isNaN(d1);
          ((Paint)localObject).setStrokeWidth((int)(d1 * (1.0D - d2 * 0.38D)));
          this.mBlinkPaint.setAlpha((int)(this.mBlinkAlpha * 255.0F));
          if (Build.VERSION.SDK_INT >= 21) {
            this.mBlinkPaint.setShadowLayer(this.mMaxBlinkShadowRadius * this.mBlinkAlpha, 0.0F, 0.0F, getResources().getColor(2131168464));
          }
          paramCanvas.drawArc(this.oval, f3, f1, false, this.mPaint);
          paramCanvas.drawArc(this.oval, f3, f1, false, this.mBlinkPaint);
          this.mPaint.setStrokeWidth(this.mStrokeWidth);
        }
        else
        {
          paramCanvas.drawArc(this.oval, f3, f1, false, this.mPaint);
        }
      }
      i += 1;
      f1 = f2;
    }
    f2 = this.mProgress;
    i = MAX_PROGRESS;
    f2 = (f2 - f1) * 360.0F / i - 4.0F;
    if (f2 > 0.0F)
    {
      paramCanvas.drawArc(this.oval, f1 * 360.0F / i - 90.0F + 2.0F, f2, false, this.mPaint);
    }
    else if (this.isNextSegmentBlink)
    {
      this.mPaint.setAlpha((int)(this.mBlinkAlpha * 255.0F));
      paramCanvas.drawArc(this.oval, f1 * 360.0F / MAX_PROGRESS - 90.0F + 2.0F, 5.0F, false, this.mPaint);
      this.mPaint.setAlpha(255);
    }
    if (this.mMode != 2) {
      drawCenterCircle(paramCanvas);
    }
  }
  
  public void setCenterCircleColor(int paramInt)
  {
    this.mCenterCicleColor = paramInt;
    this.mPaintWhite.setColor(this.mCenterCicleColor);
    invalidate();
  }
  
  public void setCenterScaleValue(float paramFloat)
  {
    this.mCenterScale = paramFloat;
    invalidate();
  }
  
  public void setCenterView()
  {
    this.idleSize = ViewUtils.dip2px(24.0F);
    this.captureSize = ViewUtils.dip2px(54.0F);
  }
  
  public void setProgress(float paramFloat)
  {
    int i = MAX_PROGRESS;
    if (paramFloat > i) {
      f = i;
    } else {
      f = paramFloat;
    }
    this.mProgress = f;
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.mProgress = f;
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.mProgressColor = paramInt;
    this.mPaint.setColor(this.mProgressColor);
    this.mPaintOrangeFill.setColor(this.mProgressColor);
    invalidate();
  }
  
  public void setProgressOffset(float paramFloat)
  {
    this.mProgressOffset = paramFloat;
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    double d = paramFloat * this.mDensity;
    Double.isNaN(d);
    this.mStrokeWidth = ((int)(d + 0.5D));
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
    this.mBlinkPaint.setStrokeWidth(this.mStrokeWidth);
  }
  
  public void startBlinkAnimation(float paramFloat)
  {
    if (paramFloat == this.mProgress)
    {
      this.needNextSegmentAnimation = true;
      ValueAnimator localValueAnimator = this.capturedSegmentBlinkAnimator;
      if (localValueAnimator != null) {
        localValueAnimator.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.QIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */