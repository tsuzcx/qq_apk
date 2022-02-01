package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

class StoreFileTask$1$1
  implements Runnable
{
  StoreFileTask$1$1(StoreFileTask.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.this$1.val$callback != null)
    {
      if (!"oom".equals(this.val$finalTargetFile))
      {
        String str = this.val$finalTargetFile;
        if (str != null)
        {
          if ("sdcardfull".equals(str))
          {
            this.this$1.val$callback.onFail("SD卡空间不足");
            return;
          }
          this.this$1.val$callback.onSuccess(StoreFileTask.access$200(this.this$1.this$0));
          return;
        }
      }
      this.this$1.val$callback.onFail("内存不足");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask.1.1
 * JD-Core Version:    0.7.0.1
 */