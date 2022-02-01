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
  
  private long smoothUseTime(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 30L) {
      l = 30L;
    }
    return l;
  }
  
  public void enterStatus(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (this.mStatus == 0);
      this.mStatus = 0;
      performLoadingStart();
      return;
    case 1: 
      performPartOneFinish();
      return;
    }
    if ((this.mStatus == 0) || (this.mStatus == 1)) {
      performLoadingFinish();
    }
    this.mStatus = 2;
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
    if (this.mCurrentProgress <= 60.0F) {
      this.mProgressRate = ((40.0F + (60.0F - this.mCurrentProgress) * 0.5F) / 300.0F);
    }
    for (this.mCurrAlphaRate = 0.8166667F;; this.mCurrAlphaRate = (245.0F * this.mProgressRate / (100.0F - this.mCurrentProgress)))
    {
      refreshUI();
      return;
    }
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
    if (this.mProgressBar != null) {
      this.mProgressBar.setVisibility(0);
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
    long l1;
    if (this.mStep != 6)
    {
      l1 = System.currentTimeMillis();
      if (this.mCurrentProgress < 100.0F) {
        break label66;
      }
      reset();
    }
    for (;;)
    {
      this.mHandler.removeMessages(200);
      this.mHandler.sendEmptyMessageDelayed(200, 20L);
      if (this.mProgressBar != null) {
        this.mProgressBar.invalidate();
      }
      return;
      label66:
      long l2;
      float f;
      switch (this.mStep)
      {
      default: 
        break;
      case 0: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 20.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 1;
          this.mProgressRate /= 5.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 1: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 98.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 4;
          this.mCurrentProgress = 98.0F;
          this.mProgressRate = 0.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 2: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 80.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 3;
          this.mProgressRate /= 20.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 3: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        f = this.mCurrentProgress;
        this.mCurrentProgress = ((float)l2 * this.mProgressRate + f);
        this.mStartLoadingTime = l1;
        if (this.mCurrentProgress >= 98.0F)
        {
          this.mStartLoadingTime = l1;
          this.mStep = 4;
          this.mProgressRate = 0.0F;
        }
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        break;
      case 5: 
        l2 = smoothUseTime(l1 - this.mStartLoadingTime);
        this.mCurrentProgress += (float)l2 * this.mProgressRate;
        this.mStartLoadingTime = l1;
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
        if (this.mFinishAllWidth)
        {
          if (this.mCurrWidth >= this.mProgressBarWidth) {
            this.mCurrWidth = this.mProgressBarWidth;
          }
        }
        else
        {
          this.mAlpha -= (int)((float)l2 * this.mCurrAlphaRate);
          if (this.mAlpha <= 0)
          {
            reset();
            this.mAlpha = 0;
          }
        }
        break;
      case 4: 
        this.mCurrWidth = (this.mProgressBarWidth * this.mCurrentProgress / 100.0F);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.WebViewProgressBarController
 * JD-Core Version:    0.7.0.1
 */