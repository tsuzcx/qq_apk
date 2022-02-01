package com.tencent.mobileqq.profilecard.bussiness.circle.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class DynamicEffectTextView
  extends TextView
{
  private static final int DEF_EFFECT_DURATION = 1200;
  private static final String TAG = "DynamicEffectTextView";
  private Paint mAnimationPaint = null;
  private ValueAnimator mAnimator;
  private BitmapShader mBitmapShader = null;
  private float mDrawOffsetY = 0.0F;
  private long mDuration = 1200L;
  private Matrix mGradientMatrix;
  private int mTranslate = 0;
  private int mViewHeight = 0;
  private int mViewWidth = 0;
  
  public DynamicEffectTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DynamicEffectTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DynamicEffectTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void cancelAnimation()
  {
    if ((this.mAnimator != null) && (this.mAnimator.isRunning()))
    {
      QLog.d("DynamicEffectTextView", 1, "cancelAnimation");
      this.mAnimator.cancel();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mGradientMatrix != null)
    {
      this.mGradientMatrix.setTranslate(this.mTranslate, 0.0F);
      if (this.mAnimationPaint != null) {
        paramCanvas.drawText(getText().toString(), 0.0F, this.mDrawOffsetY, this.mAnimationPaint);
      }
      if (this.mBitmapShader != null) {
        this.mBitmapShader.setLocalMatrix(this.mGradientMatrix);
      }
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mViewWidth == 0)
    {
      this.mViewWidth = getMeasuredWidth();
      this.mViewHeight = getMeasuredHeight();
      QLog.d("DynamicEffectTextView", 1, new Object[] { "onSizeChanged mViewWidth:", Integer.valueOf(this.mViewWidth), " | mViewHeight: ", Integer.valueOf(this.mViewHeight) });
      if ((this.mViewWidth > 0) && (this.mViewHeight > 0))
      {
        this.mGradientMatrix = new Matrix();
        float f = (this.mAnimationPaint.descent() + this.mAnimationPaint.ascent()) / 2.0F;
        this.mDrawOffsetY = (this.mViewHeight / 2.0F - f + UIUtils.a(getContext(), 0.5F));
        startAnimation();
      }
    }
  }
  
  public void setDrawableResource(int paramInt)
  {
    QLog.d("DynamicEffectTextView", 1, new Object[] { "setDrawableResource drawableId: ", Integer.valueOf(paramInt) });
    try
    {
      Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
      Bitmap localBitmap = null;
      if ((localDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
      if (localBitmap == null)
      {
        QLog.d("DynamicEffectTextView", 1, "setDrawableResource bitmap not is null.");
        return;
      }
      this.mBitmapShader = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.mAnimationPaint = new Paint(getPaint());
      this.mAnimationPaint.setShader(this.mBitmapShader);
      this.mAnimationPaint.setAntiAlias(true);
      this.mAnimationPaint.setFlags(1);
      startAnimation();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DynamicEffectTextView", 1, localThrowable, new Object[0]);
    }
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void startAnimation()
  {
    cancelAnimation();
    if (this.mBitmapShader == null)
    {
      QLog.w("DynamicEffectTextView", 1, "startAnimation bitmap shader is null.");
      return;
    }
    if (this.mGradientMatrix == null)
    {
      QLog.w("DynamicEffectTextView", 1, "startAnimation gradient matrix is null.");
      return;
    }
    this.mAnimator = ValueAnimator.ofInt(new int[] { -this.mViewWidth / 2, this.mViewWidth + this.mViewWidth / 2 });
    this.mAnimator.setDuration(this.mDuration);
    this.mAnimator.setInterpolator(new LinearInterpolator());
    this.mAnimator.setRepeatCount(-1);
    this.mAnimator.addUpdateListener(new DynamicEffectTextView.1(this));
    QLog.d("DynamicEffectTextView", 1, "startAnimation");
    this.mAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.view.DynamicEffectTextView
 * JD-Core Version:    0.7.0.1
 */