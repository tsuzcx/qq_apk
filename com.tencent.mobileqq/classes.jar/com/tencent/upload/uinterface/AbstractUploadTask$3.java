package com.tencent.upload.uinterface;

class AbstractUploadTask$3
  implements Runnable
{
  AbstractUploadTask$3(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.uploadTaskCallback != null) {
      this.this$0.uploadTaskCallback.onUploadError(this.this$0, this.val$errorCode, this.val$errorMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.uinterface.AbstractUploadTask.3
 * JD-Core Version:    0.7.0.1
 */