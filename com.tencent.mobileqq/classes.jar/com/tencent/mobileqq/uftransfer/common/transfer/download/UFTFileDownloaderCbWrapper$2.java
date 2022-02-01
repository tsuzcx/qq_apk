package com.tencent.mobileqq.uftransfer.common.transfer.download;

import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileDownloaderCallback;

class UFTFileDownloaderCbWrapper$2
  implements Runnable
{
  UFTFileDownloaderCbWrapper$2(UFTFileDownloaderCbWrapper paramUFTFileDownloaderCbWrapper, boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject) {}
  
  public void run()
  {
    if (this.this$0.l) {
      return;
    }
    this.this$0.a(true);
    if (this.this$0.i != null) {
      this.this$0.i.a(this.a, this.b, this.c, this.d, this.e, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFileDownloaderCbWrapper.2
 * JD-Core Version:    0.7.0.1
 */