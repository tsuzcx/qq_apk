package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.facedetect.AgeType;

class AgeDetector$AgeResultInfo
{
  static final int MAX_DETECT_TIMES = 5;
  int ageResult = AgeType.DEFAULT.value;
  int[] agesDetected = new int[5];
  int detectTimes = 0;
  long faceID = -1L;
  
  public AgeDetector$AgeResultInfo(AgeDetector paramAgeDetector, long paramLong)
  {
    this.faceID = paramLong;
    this.detectTimes = 0;
  }
  
  private int calculateAge()
  {
    int[] arrayOfInt1 = new int[AgeDetector.AGE_RANGS.length];
    int k = 0;
    int i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfInt1[i] = 0;
      i += 1;
    }
    int[] arrayOfInt2 = this.agesDetected;
    int i1 = arrayOfInt2.length;
    int m = 0;
    int j = 0;
    i = k;
    while (i < i1)
    {
      int n = AgeDetector.getRangeIndex(arrayOfInt2[i]);
      arrayOfInt1[n] += 1;
      k = j;
      if (arrayOfInt1[n] > j)
      {
        k = arrayOfInt1[n];
        m = n;
      }
      i += 1;
      j = k;
    }
    return calculateAvg(AgeDetector.AGE_RANGS[m]) / j;
  }
  
  private int calculateAvg(AgeDetector.AgeRang paramAgeRang)
  {
    if (paramAgeRang == null) {
      return AgeType.DEFAULT.value;
    }
    int[] arrayOfInt = this.agesDetected;
    int m = arrayOfInt.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = arrayOfInt[i];
      k = j;
      if (paramAgeRang.isMatch(n)) {
        k = j + n;
      }
      i += 1;
    }
    return j;
  }
  
  public int getAge()
  {
    return this.ageResult;
  }
  
  public int getDetectTimes()
  {
    return this.detectTimes;
  }
  
  public boolean needDetectAge()
  {
    return this.detectTimes < 5;
  }
  
  public void setAgeResult(int paramInt)
  {
    this.ageResult = paramInt;
  }
  
  public void updateAge(int paramInt)
  {
    int i = this.detectTimes;
    if (i < 5)
    {
      int[] arrayOfInt = this.agesDetected;
      this.detectTimes = (i + 1);
      arrayOfInt[i] = paramInt;
      if (this.detectTimes == 5) {
        this.ageResult = calculateAge();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AgeDetector.AgeResultInfo
 * JD-Core Version:    0.7.0.1
 */