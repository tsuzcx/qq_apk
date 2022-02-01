package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;

class UFTFileUploaderCbWrapper$4
  implements Runnable
{
  UFTFileUploaderCbWrapper$4(UFTFileUploaderCbWrapper paramUFTFileUploaderCbWrapper, boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject) {}
  
  public void run()
  {
    if (this.a)
    {
      if (this.this$0.n) {
        return;
      }
      this.this$0.a(true);
    }
    else if (this.this$0.j())
    {
      return;
    }
    if (this.this$0.l != null) {
      this.this$0.l.a(this.a, this.b, this.c, this.d, this.e, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.4
 * JD-Core Version:    0.7.0.1
 */