package com.tencent.mobileqq.editor.composite;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;

class VideoCompositeHelper$1
  implements Runnable
{
  VideoCompositeHelper$1(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack) {}
  
  public void run()
  {
    try
    {
      SLog.d(VideoCompositeHelper.a, "composite thread try get lock");
      try
      {
        SLog.c(VideoCompositeHelper.a, "composite thread get lock and start doComposite");
        this.this$0.b(this.a, this.b, this.c, this.d, this.e);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      SLog.c(VideoCompositeHelper.a, "do composite exception", localException);
      this.e.a(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.1
 * JD-Core Version:    0.7.0.1
 */