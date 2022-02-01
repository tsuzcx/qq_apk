package com.tencent.mobileqq.uftransfer.common.transfer.download;

import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileDownloaderCallback;

class UFTFileDownloaderCbWrapper$1
  implements Runnable
{
  UFTFileDownloaderCbWrapper$1(UFTFileDownloaderCbWrapper paramUFTFileDownloaderCbWrapper, String paramString, Object paramObject) {}
  
  public void run()
  {
    if (this.this$0.l) {
      return;
    }
    this.this$0.a(true);
    if (this.this$0.i != null) {
      this.this$0.i.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFileDownloaderCbWrapper.1
 * JD-Core Version:    0.7.0.1
 */