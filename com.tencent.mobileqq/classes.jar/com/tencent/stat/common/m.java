package com.tencent.stat.common;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class m
  implements Comparator<ScanResult>
{
  public int a(ScanResult paramScanResult1, ScanResult paramScanResult2)
  {
    int i = Math.abs(paramScanResult1.level);
    int j = Math.abs(paramScanResult2.level);
    if (i > j) {
      return 1;
    }
    if (i == j) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.common.m
 * JD-Core Version:    0.7.0.1
 */