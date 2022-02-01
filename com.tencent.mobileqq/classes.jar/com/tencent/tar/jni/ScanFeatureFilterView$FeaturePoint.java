package com.tencent.tar.jni;

public final class ScanFeatureFilterView$FeaturePoint
{
  public int a;
  public int b;
  public float c;
  public float d;
  public long e;
  public long f;
  public boolean g;
  public boolean h;
  
  public float a(int paramInt, long paramLong)
  {
    long l = this.f;
    if (paramLong < l) {
      return 0.0F;
    }
    if (paramLong - l > paramInt) {
      this.g = true;
    }
    return (float)(paramLong - this.f) / paramInt % 1.0F;
  }
  
  public void a()
  {
    this.e = ScanFeatureFilterView.b();
    this.g = false;
    this.h = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tar.jni.ScanFeatureFilterView.FeaturePoint
 * JD-Core Version:    0.7.0.1
 */