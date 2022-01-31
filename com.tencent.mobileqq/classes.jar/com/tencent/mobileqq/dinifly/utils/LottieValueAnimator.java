package com.tencent.mobileqq.dinifly.utils;

import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
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
    if (this.composition == null) {
      return 3.4028235E+38F;
    }
    return 1.0E+009F / this.composition.getFrameRate() / Math.abs(this.speed);
  }
  
  private boolean isReversed()
  {
    return getSpeed() < 0.0F;
  }
  
  private void verifyFrame()
  {
    if (this.composition == null) {}
    while ((this.frame >= this.minFrame) && (this.frame <= this.maxFrame)) {
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
    boolean bool = true;
    postFrameCallback();
    if ((this.composition == null) || (!isRunning())) {
      return;
    }
    paramLong = System.nanoTime();
    long l = this.lastFrameTimeNs;
    float f1 = getFrameDurationNs();
    float f2 = (float)(paramLong - l) / f1;
    float f3 = this.frame;
    f1 = f2;
    if (isReversed()) {
      f1 = -f2;
    }
    this.frame = (f1 + f3);
    if (!MiscUtils.contains(this.frame, getMinFrame(), getMaxFrame())) {}
    for (int i = 1;; i = 0)
    {
      this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
      this.lastFrameTimeNs = paramLong;
      notifyUpdate();
      if (i != 0)
      {
        if ((getRepeatCount() == -1) || (this.repeatCount < getRepeatCount())) {
          break;
        }
        this.frame = getMaxFrame();
        removeFrameCallback();
        notifyEnd(isReversed());
      }
      verifyFrame();
      return;
    }
    notifyRepeat();
    this.repeatCount += 1;
    if (getRepeatMode() == 2)
    {
      if (!this.speedReversedForRepeatMode) {}
      for (;;)
      {
        this.speedReversedForRepeatMode = bool;
        reverseAnimationSpeed();
        this.lastFrameTimeNs = paramLong;
        break;
        bool = false;
      }
    }
    if (isReversed()) {}
    for (f1 = getMaxFrame();; f1 = getMinFrame())
    {
      this.frame = f1;
      break;
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
    if (isReversed()) {
      return (getMaxFrame() - this.frame) / (getMaxFrame() - getMinFrame());
    }
    return (this.frame - getMinFrame()) / (getMaxFrame() - getMinFrame());
  }
  
  public Object getAnimatedValue()
  {
    return Float.valueOf(getAnimatedValueAbsolute());
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getAnimatedValueAbsolute()
  {
    if (this.composition == null) {
      return 0.0F;
    }
    return (this.frame - this.composition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
  }
  
  public long getDuration()
  {
    if (this.composition == null) {
      return 0L;
    }
    return this.composition.getDuration();
  }
  
  public float getFrame()
  {
    return this.frame;
  }
  
  public float getMaxFrame()
  {
    if (this.composition == null) {
      return 0.0F;
    }
    if (this.maxFrame == 2.147484E+009F) {
      return this.composition.getEndFrame();
    }
    return this.maxFrame;
  }
  
  public float getMinFrame()
  {
    if (this.composition == null) {
      return 0.0F;
    }
    if (this.minFrame == -2.147484E+009F) {
      return this.composition.getStartFrame();
    }
    return this.minFrame;
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
    if (isReversed()) {}
    for (float f = getMaxFrame();; f = getMinFrame())
    {
      setFrame((int)f);
      this.lastFrameTimeNs = System.nanoTime();
      this.repeatCount = 0;
      postFrameCallback();
      return;
    }
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
    this.lastFrameTimeNs = System.nanoTime();
    if ((isReversed()) && (getFrame() == getMinFrame())) {
      this.frame = getMaxFrame();
    }
    while ((isReversed()) || (getFrame() != getMaxFrame())) {
      return;
    }
    this.frame = getMinFrame();
  }
  
  public void reverseAnimationSpeed()
  {
    setSpeed(-getSpeed());
  }
  
  public void setComposition(LottieComposition paramLottieComposition)
  {
    int i;
    if (this.composition == null)
    {
      i = 1;
      this.composition = paramLottieComposition;
      if (i == 0) {
        break label70;
      }
      setMinAndMaxFrames((int)Math.max(this.minFrame, paramLottieComposition.getStartFrame()), (int)Math.min(this.maxFrame, paramLottieComposition.getEndFrame()));
    }
    for (;;)
    {
      float f = this.frame;
      this.frame = 0.0F;
      setFrame((int)f);
      return;
      i = 0;
      break;
      label70:
      setMinAndMaxFrames((int)paramLottieComposition.getStartFrame(), (int)paramLottieComposition.getEndFrame());
    }
  }
  
  public void setFrame(int paramInt)
  {
    if (this.frame == paramInt) {
      return;
    }
    this.frame = MiscUtils.clamp(paramInt, getMinFrame(), getMaxFrame());
    this.lastFrameTimeNs = System.nanoTime();
    notifyUpdate();
  }
  
  public void setMaxFrame(float paramFloat)
  {
    setMinAndMaxFrames(this.minFrame, paramFloat);
  }
  
  public void setMinAndMaxFrames(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
    }
    float f1;
    if (this.composition == null)
    {
      f1 = -3.402824E+038F;
      if (this.composition != null) {
        break label106;
      }
    }
    label106:
    for (float f2 = 3.4028235E+38F;; f2 = this.composition.getEndFrame())
    {
      this.minFrame = MiscUtils.clamp(paramFloat1, f1, f2);
      this.maxFrame = MiscUtils.clamp(paramFloat2, f1, f2);
      setFrame((int)MiscUtils.clamp(this.frame, paramFloat1, paramFloat2));
      return;
      f1 = this.composition.getStartFrame();
      break;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.LottieValueAnimator
 * JD-Core Version:    0.7.0.1
 */