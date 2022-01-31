package com.tencent.upload.uinterface;

class AbstractUploadTask$4
  implements Runnable
{
  AbstractUploadTask$4(AbstractUploadTask paramAbstractUploadTask, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.uploadTaskCallback != null) {
      this.this$0.uploadTaskCallback.onUploadStateChange(this.this$0, this.val$outState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.AbstractUploadTask.4
 * JD-Core Version:    0.7.0.1
 */