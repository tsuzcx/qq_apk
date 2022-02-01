package com.tencent.mobileqq.uftransfer.common;

import android.text.TextUtils;

public class UFTHashCalculator
  extends UFTRunnableQueue
{
  private static UFTHashCalculator a;
  
  public static UFTHashCalculator a()
  {
    try
    {
      if (a == null) {
        a = new UFTHashCalculator();
      }
      UFTHashCalculator localUFTHashCalculator = a;
      return localUFTHashCalculator;
    }
    finally {}
  }
  
  public long a(String paramString, long paramLong1, long paramLong2, UFTHashCalculator.IHashCalcPrg paramIHashCalcPrg)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramIHashCalcPrg != null))
    {
      if (paramLong1 == 0L) {
        return 0L;
      }
      paramString = new UFTHashCalculator.CalcTask(this, paramString, paramLong1, paramIHashCalcPrg);
      paramString.a(paramLong2);
      a(paramString);
      return paramString.e();
    }
    return 0L;
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  protected int b()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.UFTHashCalculator
 * JD-Core Version:    0.7.0.1
 */