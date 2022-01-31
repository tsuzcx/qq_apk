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
    long l3 = 0L;
    long l1;
    long l2;
    if (this.compressEndTime <= this.compressStartTime)
    {
      l1 = 0L;
      if (this.calShaEndTime > this.calShaStartTime) {
        break label73;
      }
      l2 = 0L;
      label31:
      if (this.fetchUrlEndTime > this.fetchUrlStartTime) {
        break label86;
      }
    }
    for (;;)
    {
      return new long[] { l1, l2, l3 };
      l1 = this.compressEndTime - this.compressStartTime;
      break;
      label73:
      l2 = this.calShaEndTime - this.calShaStartTime;
      break label31;
      label86:
      l3 = this.fetchUrlEndTime - this.fetchUrlStartTime;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobContext.StatisticsTimes
 * JD-Core Version:    0.7.0.1
 */