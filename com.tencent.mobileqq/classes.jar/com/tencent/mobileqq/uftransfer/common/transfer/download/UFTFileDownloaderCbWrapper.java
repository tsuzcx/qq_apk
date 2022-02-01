package com.tencent.mobileqq.uftransfer.common.transfer.download;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileDownloaderCallback;

public abstract class UFTFileDownloaderCbWrapper
  implements IUFTFileDownloaderCallback
{
  protected IUFTFileDownloaderCallback i;
  protected boolean j = true;
  protected long k = 0L;
  protected boolean l = false;
  
  public void a(long paramLong)
  {
    if (a()) {
      return;
    }
    if (this.j)
    {
      IUFTFileDownloaderCallback localIUFTFileDownloaderCallback = this.i;
      if (localIUFTFileDownloaderCallback != null) {
        localIUFTFileDownloaderCallback.a(paramLong);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (a()) {
      return;
    }
    if (this.j)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.k;
      if ((l2 == 0L) || (l1 - l2 >= 1000L))
      {
        this.k = l1;
        IUFTFileDownloaderCallback localIUFTFileDownloaderCallback = this.i;
        if (localIUFTFileDownloaderCallback != null) {
          localIUFTFileDownloaderCallback.a(paramLong1, paramLong2);
        }
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if (a()) {
      return;
    }
    UFTLogicThread.a().a(new UFTFileDownloaderCbWrapper.5(this, paramObject));
  }
  
  public void a(String paramString)
  {
    if (a()) {
      return;
    }
    UFTLogicThread.a().a(new UFTFileDownloaderCbWrapper.3(this, paramString));
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (a()) {
      return;
    }
    UFTLogicThread.a().a(new UFTFileDownloaderCbWrapper.1(this, paramString, paramObject));
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject)
  {
    if (a()) {
      return;
    }
    UFTLogicThread.a().a(new UFTFileDownloaderCbWrapper.2(this, paramBoolean, paramInt, paramLong, paramString1, paramString2, paramObject));
  }
  
  public abstract boolean a();
  
  public void b(String paramString)
  {
    if (a()) {
      return;
    }
    UFTLogicThread.a().a(new UFTFileDownloaderCbWrapper.4(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFileDownloaderCbWrapper
 * JD-Core Version:    0.7.0.1
 */