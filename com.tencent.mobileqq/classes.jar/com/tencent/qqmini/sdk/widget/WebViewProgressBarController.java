package com.tencent.qqmini.sdk.widget;

import android.os.Handler;

public class WebViewProgressBarController
{
  private static final float ACCELERATE_MAX_RATE = 40.0F;
  private static final float ACCELERATE_RATE = 0.5F;
  private static final float ACCELERATE_TIME = 300.0F;
  private static final float END_ALPHA = 10.0F;
  private static final String LOG_TAG = "WebViewProgressBarController";
  public static final int MSG_REFRESH_DELAY = 20;
  public static final int MSG_UPDATE_PROGRESS = 200;
  private static final float PART_ONE_END_PROGRESS = 20.0F;
  private static final int PART_ONE_SPEED_REDUCE_RATE = 5;
  private static final float PART_TWO_END_PROGRESS = 80.0F;
  private static final int PART_TWO_SPEED_REDUCE_RATE = 20;
  private static final int PROGRESS_BEFORE_FINISH = 98;
  private static final int START_PROGRESS = 0;
  public static final byte STATUS_FINISH = 2;
  public static final byte STATUS_LOADING = 0;
  public static final byte STATUS_PART1_FINISH = 1;
  public static final byte STEP_ACCELERATE = 5;
  public static final byte STEP_FINISH = 6;
  public static final byte STEP_PART_ONE = 0;
  public static final byte STEP_PART_ONE_WAIT = 1;
  public static final byte STEP_PART_TWO = 2;
  public static final byte STEP_PART_TWO_WAIT = 3;
  public static final byte STEP_WAIT_FINISH = 4;
  private int mAlpha = 255;
  private float mCurrAlphaRate;
  private float mCurrWidth;
  private float mCurrentProgress;
  private boolean mFinishAllWidth = false;
  private Handler mHandler = new WebViewProgressBarController.MainThreadHandler(this);
  protected WebViewProgressBar mProgressBar;
  private int mProgressBarWidth = 0;
  private float mProgressRate;
  private long mStartLoadingTime;
  private float mStartWidth;
  private byte mStatus = -1;
  private byte mStep = 6;
  
  private void doRefreshUI()
  {
    long l1 = System.currentTimeMillis();
    int i = this.mStep;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              stepAccelerate(l1);
              return;
            }
            this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
            return;
          }
          l2 = smoothUseTime(l1 - this.mStartLoadingTime);
          this.mCurrentProgress += (float)l2 * this.mProgressRate;
          this.mStartLoadingTime = l1;
          if (this.mCurrentProgress >= 98.0F)
          {
            this.mStartLoadingTime = l1;
            this.mStep = 4;
            this.mProgressRate = 0.0F;
          }
          this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
          return;
        }
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f1 = this.mCurrentProgress;
        f2 = (float)l2;
        f3 = this.mProgressRate;
        this.mCurrentProgress = (f1 + f2 * f3);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 80.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 3;
          this.mProgressRate = (f3 / 20.0F);
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        return;
      }
      l2 = smoothUseTime(l1 - this.mStartLoadingTime);
      this.mCurrentProgress += (float)l2 * this.mProgressRate;
      this.mStartLoadingTime = l1;
      if (this.mCurrentProgress >= 98.0F)
      {
        this.mStartLoadingTime = l1;
        this.mStep = 4;
        this.mCurrentProgress = 98.0F;
        this.mProgressRate = 0.0F;
      }
      this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
      return;
    }
    long l2 = smoothUseTime(l1 - this.mStartLoadingTime);
    float f1 = this.mCurrentProgress;
    float f2 = (float)l2;
    float f3 = this.mProgressRate;
    this.mCurrentProgress = (f1 + f2 * f3);
    this.mStartLoadingTime = l1;
    if (this.mCurrentProgress >= 20.0F)
    {
      this.mStartLoadingTime = l1;
      this.mStep = 1;
      this.mProgressRate = (f3 / 5.0F);
    }
    this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
  }
  
  private long smoothUseTime(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 30L) {
      l = 30L;
    }
    return l;
  }
  
  private void stepAccelerate(long paramLong)
  {
    long l = smoothUseTime(paramLong - this.mStartLoadingTime);
    float f1 = this.mCurrentProgress;
    float f2 = (float)l;
    this.mCurrentProgress = (f1 + this.mProgressRate * f2);
    this.mStartLoadingTime = paramLong;
    int i = this.mProgressBarWidth;
    this.mCurrWidth = (i * this.mCurrentProgress / 100.0F);
    if (this.mFinishAllWidth)
    {
      if (this.mCurrWidth >= i) {
        this.mCurrWidth = i;
      }
    }
    else
    {
      this.mAlpha -= (int)(f2 * this.mCurrAlphaRate);
      if (this.mAlpha <= 0)
      {
        reset();
        this.mAlpha = 0;
      }
    }
  }
  
  public void enterStatus(byte paramByte)
  {
    if (paramByte != 0)
    {
      if (paramByte != 1)
      {
        if (paramByte != 2) {
          return;
        }
        paramByte = this.mStatus;
        if ((paramByte == 0) || (paramByte == 1)) {
          performLoadingFinish();
        }
        this.mStatus = 2;
        return;
      }
      performPartOneFinish();
      return;
    }
    if (this.mStatus == 0) {
      return;
    }
    this.mStatus = 0;
    performLoadingStart();
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public byte getCurStatus()
  {
    return this.mStatus;
  }
  
  public float getCurrWidth()
  {
    return this.mCurrWidth;
  }
  
  public byte getLoadingStep()
  {
    return this.mStep;
  }
  
  public void performLoadingFinish()
  {
    WebViewProgressBarController.DurationGenerator.getInstance(1).recordFinish();
    this.mStartLoadingTime = System.currentTimeMillis();
    this.mStep = 5;
    this.mProgressRate = 0.1333333F;
    float f = this.mCurrentProgress;
    if (f <= 60.0F)
    {
      this.mProgressRate = (((60.0F - f) * 0.5F + 40.0F) / 300.0F);
      this.mCurrAlphaRate = 0.8166667F;
    }
    else
    {
      this.mCurrAlphaRate = (this.mProgressRate * 245.0F / (100.0F - f));
    }
    refreshUI();
  }
  
  public void performLoadingStart()
  {
    int j = WebViewProgressBarController.DurationGenerator.getInstance(0).recordStart();
    int i = j;
    if (j <= 0) {
      i = WebViewProgressBarController.DurationGenerator.getInstance(0).getDefaultDuration();
    }
    this.mProgressRate = (20.0F / i);
    this.mCurrentProgress = 0.0F;
    this.mStep = 0;
    this.mCurrWidth = this.mStartWidth;
    this.mAlpha = 255;
    this.mStartLoadingTime = System.currentTimeMillis();
    WebViewProgressBar localWebViewProgressBar = this.mProgressBar;
    if (localWebViewProgressBar != null) {
      localWebViewProgressBar.setVisibility(0);
    }
    refreshUI();
  }
  
  public void performPartOneFinish()
  {
    WebViewProgressBarController.DurationGenerator.getInstance(0).recordFinish();
    int j = WebViewProgressBarController.DurationGenerator.getInstance(1).recordStart();
    int i = j;
    if (j <= 0) {
      i = WebViewProgressBarController.DurationGenerator.getInstance(1).getDefaultDuration();
    }
    this.mProgressRate = (60.0F / i);
    this.mStartLoadingTime = System.currentTimeMillis();
    this.mStep = 2;
    this.mStatus = 1;
    refreshUI();
  }
  
  public void refreshUI()
  {
    if (this.mStep != 6)
    {
      if (this.mCurrentProgress >= 100.0F) {
        reset();
      } else {
        doRefreshUI();
      }
      this.mHandler.removeMessages(200);
      this.mHandler.sendEmptyMessageDelayed(200, 20L);
    }
    WebViewProgressBar localWebViewProgressBar = this.mProgressBar;
    if (localWebViewProgressBar != null) {
      localWebViewProgressBar.invalidate();
    }
  }
  
  public void reset()
  {
    this.mStep = 6;
    this.mCurrentProgress = 0.0F;
    this.mStartWidth = ((int)(this.mCurrentProgress * this.mProgressBarWidth / 100.0F));
    this.mAlpha = 255;
    this.mStartLoadingTime = System.currentTimeMillis();
  }
  
  public void setProgressBar(WebViewProgressBar paramWebViewProgressBar)
  {
    this.mProgressBar = paramWebViewProgressBar;
  }
  
  public void setProgressBarWidth(int paramInt)
  {
    this.mProgressBarWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.WebViewProgressBarController
 * JD-Core Version:    0.7.0.1
 */