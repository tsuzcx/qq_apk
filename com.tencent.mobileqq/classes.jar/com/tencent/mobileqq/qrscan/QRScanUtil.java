package com.tencent.mobileqq.qrscan;

import android.graphics.Rect;

public class QRScanUtil
{
  public static void a(Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, float paramFloat)
  {
    int j = paramRect1.centerX();
    int i = paramRect1.centerY();
    int m = paramRect1.width();
    int k = paramRect1.height();
    float f1 = m;
    j -= (int)(f1 * 0.5F * paramFloat);
    float f2 = k;
    int n = i - (int)(0.5F * f2 * paramFloat);
    k = (int)(f1 * paramFloat) + j;
    m = (int)(paramFloat * f2) + n;
    int i1 = 0;
    i = j;
    if (j < 0) {
      i = 0;
    }
    if (n < 0) {
      j = i1;
    } else {
      j = n;
    }
    if (k <= paramInt1) {
      paramInt1 = k;
    }
    k = m;
    if (m > paramInt2) {
      k = paramInt2;
    }
    paramRect2.set(i, j, paramInt1, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QRScanUtil
 * JD-Core Version:    0.7.0.1
 */