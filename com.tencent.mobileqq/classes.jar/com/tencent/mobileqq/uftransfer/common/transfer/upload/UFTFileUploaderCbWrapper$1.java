package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;

class UFTFileUploaderCbWrapper$1
  implements Runnable
{
  UFTFileUploaderCbWrapper$1(UFTFileUploaderCbWrapper paramUFTFileUploaderCbWrapper, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    if (this.this$0.n) {
      return;
    }
    this.this$0.a(true);
    if (this.this$0.l != null) {
      this.this$0.l.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.1
 * JD-Core Version:    0.7.0.1
 */