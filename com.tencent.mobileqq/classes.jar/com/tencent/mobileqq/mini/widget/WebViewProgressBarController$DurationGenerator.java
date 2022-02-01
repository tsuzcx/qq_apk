package com.tencent.mobileqq.mini.widget;

import com.tencent.mobileqq.mini.util.HttpUtil;

class WebViewProgressBarController$DurationGenerator
{
  private static final int DEFAULT_DURATION_FOR_PHASEONE_2G = 9000;
  private static final int DEFAULT_DURATION_FOR_PHASEONE_NON_2G = 1800;
  private static final int DEFAULT_DURATION_FOR_PHASETWO_2G = 6000;
  private static final int DEFAULT_DURATION_FOR_PHASETWO_NON_2G = 1200;
  private static final int FINISHED_TIME_MAX_FACTOR = 3;
  private static final int MAX_STATISTICS_COUNT = 3;
  private static final int MIN_EXPECTED_FINISH_TIME = 100;
  public static final int PHASE_ONE = 0;
  public static final int PHASE_TWO = 1;
  private static DurationGenerator sPhaseOne;
  private static DurationGenerator sPhaseTwo;
  private int m2GDuration = 9000;
  private int mLastSampleIndex;
  private int mNetType = 0;
  private int mNon2GDuration = 1800;
  private int mPhaseType = 0;
  private int[] mSampleDuration;
  private long mStartingTime;
  
  public WebViewProgressBarController$DurationGenerator(int paramInt)
  {
    this.mPhaseType = paramInt;
    this.mNetType = 0;
    if (this.mPhaseType == 0) {
      this.m2GDuration = 9000;
    }
    for (this.mNon2GDuration = 1800;; this.mNon2GDuration = 1200)
    {
      this.mStartingTime = 0L;
      this.mLastSampleIndex = 0;
      this.mSampleDuration = new int[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        this.mSampleDuration[paramInt] = 0;
        paramInt += 1;
      }
      this.m2GDuration = 6000;
    }
  }
  
  private void clearSampleDuration()
  {
    int i = 0;
    while (i < 3)
    {
      this.mSampleDuration[i] = 0;
      i += 1;
    }
    this.mLastSampleIndex = 0;
  }
  
  public static DurationGenerator getInstance(int paramInt)
  {
    if (paramInt == 0)
    {
      if (sPhaseOne == null) {
        sPhaseOne = new DurationGenerator(0);
      }
      return sPhaseOne;
    }
    if (sPhaseTwo == null) {
      sPhaseTwo = new DurationGenerator(1);
    }
    return sPhaseTwo;
  }
  
  private int getSampleDuration()
  {
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; i < 3; k = m)
    {
      int n = j;
      m = k;
      if (this.mSampleDuration[i] > 0)
      {
        m = k + 1;
        n = j + this.mSampleDuration[i];
      }
      i += 1;
      j = n;
    }
    if (k > 0) {
      return j / k;
    }
    return 0;
  }
  
  public int getDefaultDuration()
  {
    if (2 == this.mNetType) {
      return this.m2GDuration;
    }
    return this.mNon2GDuration;
  }
  
  public void recordFinish()
  {
    int j = (int)(System.currentTimeMillis() - this.mStartingTime);
    int k = getSampleDuration();
    int i;
    if (this.mNetType == 2)
    {
      i = this.m2GDuration;
      if (k != 0) {
        break label90;
      }
      i *= 3;
      label36:
      if (j > 100) {
        if (j <= i) {
          break label97;
        }
      }
    }
    for (;;)
    {
      this.mSampleDuration[this.mLastSampleIndex] = ((int)(i * 1.2F));
      i = this.mLastSampleIndex + 1;
      this.mLastSampleIndex = i;
      this.mLastSampleIndex = (i % 3);
      return;
      i = this.mNon2GDuration;
      break;
      label90:
      i = k * 3;
      break label36;
      label97:
      i = j;
    }
  }
  
  public int recordStart()
  {
    this.mStartingTime = System.currentTimeMillis();
    int j = HttpUtil.getNetWorkType();
    int i;
    if (this.mNetType != j)
    {
      i = 1;
      this.mNetType = j;
      if (i == 0) {
        break label62;
      }
      if (this.mNetType != 2) {
        break label54;
      }
      i = this.m2GDuration;
      label43:
      clearSampleDuration();
    }
    label54:
    label62:
    do
    {
      return i;
      i = 0;
      break;
      i = this.mNon2GDuration;
      break label43;
      j = getSampleDuration();
      i = j;
    } while (j > 0);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.WebViewProgressBarController.DurationGenerator
 * JD-Core Version:    0.7.0.1
 */