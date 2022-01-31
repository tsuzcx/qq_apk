package com.tencent.upload.uinterface;

class AbstractUploadTask$2
  implements Runnable
{
  AbstractUploadTask$2(AbstractUploadTask paramAbstractUploadTask, Object paramObject) {}
  
  public void run()
  {
    if (this.this$0.uploadTaskCallback != null) {
      this.this$0.uploadTaskCallback.onUploadSucceed(this.this$0, this.val$result);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.AbstractUploadTask.2
 * JD-Core Version:    0.7.0.1
 */