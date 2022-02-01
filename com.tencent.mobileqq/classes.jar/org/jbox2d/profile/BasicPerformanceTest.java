package org.jbox2d.profile;

import java.io.PrintStream;

public abstract class BasicPerformanceTest
{
  private final int iters;
  private final int numTests;
  protected final long[] times;
  
  public BasicPerformanceTest(int paramInt1, int paramInt2)
  {
    this.numTests = paramInt1;
    this.iters = paramInt2;
    this.times = new long[paramInt1];
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      this.times[paramInt2] = 0L;
      paramInt2 += 1;
    }
  }
  
  public int getFrames(int paramInt)
  {
    return 0;
  }
  
  public abstract String getTestName(int paramInt);
  
  public double getTestTime(int paramInt)
  {
    double d = this.times[paramInt];
    Double.isNaN(d);
    return d * 1.0D / 1000000.0D;
  }
  
  public void go()
  {
    int k = 0;
    int i = 0;
    int j;
    Object localObject;
    for (;;)
    {
      j = k;
      if (i >= this.iters) {
        break;
      }
      localObject = new StringBuilder();
      double d1 = i;
      Double.isNaN(d1);
      double d2 = this.iters;
      Double.isNaN(d2);
      ((StringBuilder)localObject).append(d1 * 100.0D / d2);
      ((StringBuilder)localObject).append("%");
      println(((StringBuilder)localObject).toString());
      j = 0;
      while (j < this.numTests)
      {
        long l1 = System.nanoTime();
        runTest(j);
        long l2 = System.nanoTime();
        localObject = this.times;
        localObject[j] += l2 - l1;
        j += 1;
      }
      i += 1;
    }
    while (j < this.numTests)
    {
      localObject = this.times;
      localObject[j] /= this.iters;
      j += 1;
    }
    printResults();
  }
  
  public void printResults()
  {
    printf("%-20s%20s%20s\n", new Object[] { "Test Name", "Milliseconds Avg", "FPS (optional)" });
    int i = 0;
    while (i < this.numTests)
    {
      double d1 = this.times[i];
      Double.isNaN(d1);
      d1 = d1 * 1.0D / 1000000.0D;
      if (getFrames(i) != 0)
      {
        double d2 = getFrames(i);
        Double.isNaN(d2);
        d2 = d2 * 1000.0D / d1;
        printf("%-20s%20.4f%20.4f\n", new Object[] { getTestName(i), Double.valueOf(d1), Double.valueOf(d2) });
      }
      else
      {
        printf("%-20s%20.4f\n", new Object[] { getTestName(i), Double.valueOf(d1) });
      }
      i += 1;
    }
  }
  
  public void printf(String paramString, Object... paramVarArgs)
  {
    System.out.printf(paramString, paramVarArgs);
  }
  
  public void println(String paramString)
  {
    System.out.println(paramString);
  }
  
  public abstract void runTest(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.profile.BasicPerformanceTest
 * JD-Core Version:    0.7.0.1
 */