package com.tencent.mobileqq.shortvideo.ml.decisiontree;

public class ID3$ChiSquareTest
{
  double a;
  
  ID3$ChiSquareTest(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public boolean a(int[][] paramArrayOfInt)
  {
    double d2 = 0.0D;
    int k = paramArrayOfInt.length;
    int m = paramArrayOfInt[0].length;
    double[] arrayOfDouble1 = new double[k];
    double[] arrayOfDouble2 = new double[m];
    double d1 = 0.0D;
    int i = 0;
    int j;
    while (i < k)
    {
      j = 0;
      while (j < m)
      {
        arrayOfDouble1[i] += paramArrayOfInt[i][j];
        d1 += paramArrayOfInt[i][j];
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        arrayOfDouble2[i] += paramArrayOfInt[j][i];
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      j = 0;
      while (j < m)
      {
        double d4 = 1.0D * arrayOfDouble1[i] * arrayOfDouble2[j] / d1;
        double d5 = paramArrayOfInt[i][j];
        double d3 = d2;
        if (d4 > 0.0D) {
          d3 = d2 + (d4 - d5) * (d4 - d5) / d4;
        }
        j += 1;
        d2 = d3;
      }
      i += 1;
    }
    return d2 > this.a + 1.0E-008D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ml.decisiontree.ID3.ChiSquareTest
 * JD-Core Version:    0.7.0.1
 */