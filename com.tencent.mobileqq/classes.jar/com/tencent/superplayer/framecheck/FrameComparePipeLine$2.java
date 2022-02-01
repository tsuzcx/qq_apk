package com.tencent.superplayer.framecheck;

import com.tencent.superplayer.utils.LogUtil;

class FrameComparePipeLine$2
  implements Runnable
{
  FrameComparePipeLine$2(FrameComparePipeLine paramFrameComparePipeLine, VideoFrameCaptureTask paramVideoFrameCaptureTask, boolean paramBoolean) {}
  
  public void run()
  {
    FrameComparePipeLine.access$100(this.this$0, this.val$task);
    FrameComparePipeLine.access$200(this.this$0);
    if (this.val$task.isEndTask)
    {
      i = FrameComparePipeLine.access$300(this.this$0);
      LogUtil.d("MediaPlayerMgr.FrameComparePipeLine", "checkTaskResultList resultCode:" + i + "\n" + FrameComparePipeLine.access$400(this.this$0));
      if (FrameComparePipeLine.access$500(this.this$0) != null) {
        FrameComparePipeLine.access$500(this.this$0).onVideoFrameCheckResult(i);
      }
    }
    while (!this.val$isAllTaskRun)
    {
      int i;
      return;
    }
    LogUtil.w("MediaPlayerMgr.FrameComparePipeLine", "No end task, when mQueue is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.FrameComparePipeLine.2
 * JD-Core Version:    0.7.0.1
 */