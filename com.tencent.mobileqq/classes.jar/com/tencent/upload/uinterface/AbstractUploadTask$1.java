package com.tencent.upload.uinterface;

class AbstractUploadTask$1
  implements Runnable
{
  AbstractUploadTask$1(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.this$0.uploadTaskCallback != null) {
      this.this$0.uploadTaskCallback.onUploadProgress(this.this$0, this.val$totalSize, this.val$recvDataSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.uinterface.AbstractUploadTask.1
 * JD-Core Version:    0.7.0.1
 */