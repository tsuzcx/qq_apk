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
    int j = 0;
    int[] arrayOfInt1 = new int[AgeDetector.AGE_RANGS.length];
    int i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfInt1[i] = 0;
      i += 1;
    }
    int[] arrayOfInt2 = this.agesDetected;
    int n = arrayOfInt2.length;
    int k = 0;
    i = 0;
    int m;
    if (k < n)
    {
      m = AgeDetector.getRangeIndex(arrayOfInt2[k]);
      arrayOfInt1[m] += 1;
      if (arrayOfInt1[m] <= i) {
        break label120;
      }
      j = arrayOfInt1[m];
      i = m;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      return calculateAvg(AgeDetector.AGE_RANGS[j]) / i;
      label120:
      m = i;
      i = j;
      j = m;
    }
  }
  
  private int calculateAvg(AgeDetector.AgeRang paramAgeRang)
  {
    int i = 0;
    int k;
    if (paramAgeRang == null)
    {
      k = AgeType.DEFAULT.value;
      return k;
    }
    int[] arrayOfInt = this.agesDetected;
    int m = arrayOfInt.length;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      int n = arrayOfInt[j];
      k = i;
      if (paramAgeRang.isMatch(n)) {
        k = i + n;
      }
      j += 1;
      i = k;
    }
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
    if (this.detectTimes < 5)
    {
      int[] arrayOfInt = this.agesDetected;
      int i = this.detectTimes;
      this.detectTimes = (i + 1);
      arrayOfInt[i] = paramInt;
      if (this.detectTimes == 5) {
        this.ageResult = calculateAge();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AgeDetector.AgeResultInfo
 * JD-Core Version:    0.7.0.1
 */