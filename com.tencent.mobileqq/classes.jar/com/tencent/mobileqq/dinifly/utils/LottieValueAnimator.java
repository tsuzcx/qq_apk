package com.tencent.mobileqq.dinifly.utils;

import android.os.Build.VERSION;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.LottieComposition;

public class LottieValueAnimator
  extends BaseLottieAnimator
{
  @Nullable
  private LottieComposition composition;
  private float frame = 0.0F;
  private long lastFrameTimeNs = 0L;
  private Object mCallback;
  private float maxFrame = 2.147484E+009F;
  private float minFrame = -2.147484E+009F;
  private int repeatCount = 0;
  @VisibleForTesting
  protected boolean running = false;
  private float speed = 1.0F;
  private boolean speedReversedForRepeatMode = false;
  
  private float getFrameDurationNs()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return 3.4028235E+38F;
    }
    return 1.0E+009F / localLottieComposition.getFrameRate() / Math.abs(this.speed);
  }
  
  private boolean isReversed()
  {
    return getSpeed() < 0.0F;
  }
  
  private void verifyFrame()
  {
    if (this.composition == null) {
      return;
    }
    float f = this.frame;
    if ((f >= this.minFrame) && (f <= this.maxFrame)) {
      return;
    }
    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[] { Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame) }));
  }
  
  @MainThread
  public void cancel()
  {
    notifyCancel();
    removeFrameCallback();
  }
  
  public void clearComposition()
  {
    this.composition = null;
    this.minFrame = -2.147484E+009F;
    this.maxFrame = 2.147484E+009F;
  }
  
  public void doFrame(long paramLong)
  {
    postFrameCallback();
    if (this.composition != null)
    {
      if (!isRunning()) {
        return;
      }
      L.beginSection("LottieValueAnimator#doFrame");
      long l2 = this.lastFrameTimeNs;
      long l1 = 0L;
      if (l2 != 0L) {
        l1 = paramLong - l2;
      }
      float f1 = getFrameDurationNs();
      float f2 = (float)l1 / f1;
      float f3 = this.frame;
      f1 = f2;
      if (isReversed()) {
        f1 = -f2;
      }
      this.frame = (f3 + f1);
      boolean bool = MiscUtils.contains(this.frame, getMinFrame(), getMaxFrame());
      this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
      this.lastFrameTimeNs = paramLong;
      notifyUpdate();
      if ((bool ^ true)) {
        if ((getRepeatCount() != -1) && (this.repeatCount >= getRepeatCount()))
        {
          if (this.speed < 0.0F) {
            f1 = getMinFrame();
          } else {
            f1 = getMaxFrame();
          }
          this.frame = f1;
          removeFrameCallback();
          notifyEnd(isReversed());
        }
        else
        {
          notifyRepeat();
          this.repeatCount += 1;
          if (getRepeatMode() == 2)
          {
            this.speedReversedForRepeatMode ^= true;
            reverseAnimationSpeed();
          }
          else
          {
            if (isReversed()) {
              f1 = getMaxFrame();
            } else {
              f1 = getMinFrame();
            }
            this.frame = f1;
          }
          this.lastFrameTimeNs = paramLong;
        }
      }
      verifyFrame();
      L.endSection("LottieValueAnimator#doFrame");
    }
  }
  
  @MainThread
  public void endAnimation()
  {
    removeFrameCallback();
    notifyEnd(isReversed());
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getAnimatedFraction()
  {
    if (this.composition == null) {
      return 0.0F;
    }
    float f1;
    float f2;
    if (isReversed())
    {
      f1 = getMaxFrame() - this.frame;
      f2 = getMaxFrame();
    }
    for (float f3 = getMinFrame();; f3 = getMinFrame())
    {
      return f1 / (f2 - f3);
      f1 = this.frame - getMinFrame();
      f2 = getMaxFrame();
    }
  }
  
  public Object getAnimatedValue()
  {
    return Float.valueOf(getAnimatedValueAbsolute());
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getAnimatedValueAbsolute()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return 0.0F;
    }
    return (this.frame - localLottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
  }
  
  public long getDuration()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return 0L;
    }
    return localLottieComposition.getDuration();
  }
  
  public float getFrame()
  {
    return this.frame;
  }
  
  public float getMaxFrame()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return 0.0F;
    }
    float f2 = this.maxFrame;
    float f1 = f2;
    if (f2 == 2.147484E+009F) {
      f1 = localLottieComposition.getEndFrame();
    }
    return f1;
  }
  
  public float getMinFrame()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return 0.0F;
    }
    float f2 = this.minFrame;
    float f1 = f2;
    if (f2 == -2.147484E+009F) {
      f1 = localLottieComposition.getStartFrame();
    }
    return f1;
  }
  
  public float getSpeed()
  {
    return this.speed;
  }
  
  public boolean isRunning()
  {
    return this.running;
  }
  
  @MainThread
  public void pauseAnimation()
  {
    removeFrameCallback();
  }
  
  @MainThread
  public void playAnimation()
  {
    this.running = true;
    notifyStart(isReversed());
    float f;
    if (isReversed()) {
      f = getMaxFrame();
    } else {
      f = getMinFrame();
    }
    setFrame((int)f);
    this.lastFrameTimeNs = 0L;
    this.repeatCount = 0;
    postFrameCallback();
  }
  
  protected void postFrameCallback()
  {
    if (isRunning())
    {
      removeFrameCallback(false);
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.mCallback = new LottieValueAnimator.1(this);
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)this.mCallback);
      }
    }
  }
  
  @MainThread
  protected void removeFrameCallback()
  {
    removeFrameCallback(true);
  }
  
  @MainThread
  protected void removeFrameCallback(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (this.mCallback != null)) {
      Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback)this.mCallback);
    }
    if (paramBoolean) {
      this.running = false;
    }
  }
  
  @MainThread
  public void resumeAnimation()
  {
    this.running = true;
    postFrameCallback();
    this.lastFrameTimeNs = 0L;
    if ((isReversed()) && (getFrame() == getMinFrame()))
    {
      this.frame = getMaxFrame();
      return;
    }
    if ((!isReversed()) && (getFrame() == getMaxFrame())) {
      this.frame = getMinFrame();
    }
  }
  
  public void reverseAnimationSpeed()
  {
    setSpeed(-getSpeed());
  }
  
  public void setComposition(LottieComposition paramLottieComposition)
  {
    int i;
    if (this.composition == null) {
      i = 1;
    } else {
      i = 0;
    }
    this.composition = paramLottieComposition;
    if (i != 0) {
      setMinAndMaxFrames((int)Math.max(this.minFrame, paramLottieComposition.getStartFrame()), (int)Math.min(this.maxFrame, paramLottieComposition.getEndFrame()));
    } else {
      setMinAndMaxFrames((int)paramLottieComposition.getStartFrame(), (int)paramLottieComposition.getEndFrame());
    }
    float f = this.frame;
    this.frame = 0.0F;
    setFrame((int)f);
    notifyUpdate();
  }
  
  public void setFrame(float paramFloat)
  {
    if (this.frame == paramFloat) {
      return;
    }
    this.frame = MiscUtils.clamp(paramFloat, getMinFrame(), getMaxFrame());
    this.lastFrameTimeNs = 0L;
    notifyUpdate();
  }
  
  public void setMaxFrame(float paramFloat)
  {
    setMinAndMaxFrames(this.minFrame, paramFloat);
  }
  
  public void setMinAndMaxFrames(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 <= paramFloat2)
    {
      LottieComposition localLottieComposition = this.composition;
      float f1;
      if (localLottieComposition == null) {
        f1 = -3.402824E+038F;
      } else {
        f1 = localLottieComposition.getStartFrame();
      }
      localLottieComposition = this.composition;
      float f2;
      if (localLottieComposition == null) {
        f2 = 3.4028235E+38F;
      } else {
        f2 = localLottieComposition.getEndFrame();
      }
      this.minFrame = MiscUtils.clamp(paramFloat1, f1, f2);
      this.maxFrame = MiscUtils.clamp(paramFloat2, f1, f2);
      setFrame((int)MiscUtils.clamp(this.frame, paramFloat1, paramFloat2));
      return;
    }
    throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
  }
  
  public void setMinFrame(int paramInt)
  {
    setMinAndMaxFrames(paramInt, (int)this.maxFrame);
  }
  
  public void setRepeatMode(int paramInt)
  {
    super.setRepeatMode(paramInt);
    if ((paramInt != 2) && (this.speedReversedForRepeatMode))
    {
      this.speedReversedForRepeatMode = false;
      reverseAnimationSpeed();
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    this.speed = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.LottieValueAnimator
 * JD-Core Version:    0.7.0.1
 */