package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;

class UFTFileUploaderCbWrapper$2
  implements Runnable
{
  UFTFileUploaderCbWrapper$2(UFTFileUploaderCbWrapper paramUFTFileUploaderCbWrapper, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.this$0.j()) {
      return;
    }
    if (this.this$0.l != null) {
      this.this$0.l.a(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.2
 * JD-Core Version:    0.7.0.1
 */