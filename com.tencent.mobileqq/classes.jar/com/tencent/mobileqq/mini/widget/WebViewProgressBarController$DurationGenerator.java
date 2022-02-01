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
  private int[] mSampleDuration = null;
  private long mStartingTime;
  
  public WebViewProgressBarController$DurationGenerator(int paramInt)
  {
    this.mPhaseType = paramInt;
    this.mNetType = 0;
    if (this.mPhaseType == 0)
    {
      this.m2GDuration = 9000;
      this.mNon2GDuration = 1800;
    }
    else
    {
      this.m2GDuration = 6000;
      this.mNon2GDuration = 1200;
    }
    this.mStartingTime = 0L;
    this.mLastSampleIndex = 0;
    this.mSampleDuration = new int[3];
    paramInt = 0;
    while (paramInt < 3)
    {
      this.mSampleDuration[paramInt] = 0;
      paramInt += 1;
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
    int i1 = 0;
    int j = 0;
    int k = 0;
    int m;
    for (int i = 0; j < 3; i = m)
    {
      int[] arrayOfInt = this.mSampleDuration;
      int n = k;
      m = i;
      if (arrayOfInt[j] > 0)
      {
        n = k + 1;
        m = i + arrayOfInt[j];
      }
      j += 1;
      k = n;
    }
    j = i1;
    if (k > 0) {
      j = i / k;
    }
    return j;
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
    if (this.mNetType == 2) {
      i = this.m2GDuration;
    } else {
      i = this.mNon2GDuration;
    }
    if (k == 0) {
      i *= 3;
    } else {
      i = k * 3;
    }
    if (j > 100)
    {
      if (j <= i) {
        i = j;
      }
      int[] arrayOfInt = this.mSampleDuration;
      j = this.mLastSampleIndex;
      arrayOfInt[j] = ((int)(i * 1.2F));
      i = j + 1;
      this.mLastSampleIndex = i;
      this.mLastSampleIndex = (i % 3);
    }
  }
  
  public int recordStart()
  {
    this.mStartingTime = System.currentTimeMillis();
    int k = HttpUtil.getNetWorkType();
    int i = this.mNetType;
    int j = 0;
    if (i != k) {
      i = 1;
    } else {
      i = 0;
    }
    this.mNetType = k;
    if (i != 0)
    {
      if (this.mNetType == 2) {
        i = this.m2GDuration;
      } else {
        i = this.mNon2GDuration;
      }
      clearSampleDuration();
      return i;
    }
    k = getSampleDuration();
    i = j;
    if (k > 0) {
      i = k;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.WebViewProgressBarController.DurationGenerator
 * JD-Core Version:    0.7.0.1
 */