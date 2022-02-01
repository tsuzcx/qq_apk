package com.tencent.weiyun.transmission.upload;

public final class UploadJobContext$StatisticsTimes
{
  private long calShaEndTime = 0L;
  private long calShaStartTime = 0L;
  private long compressEndTime = 0L;
  private long compressStartTime = 0L;
  private long fetchUrlEndTime = 0L;
  private long fetchUrlStartTime = 0L;
  
  UploadJobContext$StatisticsTimes(UploadJobContext paramUploadJobContext) {}
  
  public long[] getStatisticsTimes()
  {
    long l1 = this.compressEndTime;
    long l2 = this.compressStartTime;
    long l3 = 0L;
    if (l1 <= l2) {
      l1 = 0L;
    } else {
      l1 -= l2;
    }
    l2 = this.calShaEndTime;
    long l4 = this.calShaStartTime;
    if (l2 <= l4) {
      l2 = 0L;
    } else {
      l2 -= l4;
    }
    l4 = this.fetchUrlEndTime;
    long l5 = this.fetchUrlStartTime;
    if (l4 > l5) {
      l3 = l4 - l5;
    }
    return new long[] { l1, l2, l3 };
  }
  
  public void onCalShaEnd()
  {
    this.calShaEndTime = System.currentTimeMillis();
  }
  
  public void onCalShaStart()
  {
    this.calShaStartTime = System.currentTimeMillis();
  }
  
  public void onCompressEnd()
  {
    this.compressEndTime = System.currentTimeMillis();
  }
  
  public void onCompressStart()
  {
    this.compressStartTime = System.currentTimeMillis();
  }
  
  public void onFetchUrlEnd()
  {
    this.fetchUrlEndTime = System.currentTimeMillis();
  }
  
  public void onFetchUrlStart()
  {
    this.fetchUrlStartTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobContext.StatisticsTimes
 * JD-Core Version:    0.7.0.1
 */