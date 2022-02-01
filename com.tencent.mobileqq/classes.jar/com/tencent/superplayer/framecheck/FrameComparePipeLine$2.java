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
      int i = FrameComparePipeLine.access$300(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkTaskResultList resultCode:");
      localStringBuilder.append(i);
      localStringBuilder.append("\n");
      localStringBuilder.append(FrameComparePipeLine.access$400(this.this$0));
      LogUtil.d("SuperPlayer-.FrameComparePipeLine", localStringBuilder.toString());
      if (FrameComparePipeLine.access$500(this.this$0) != null) {
        FrameComparePipeLine.access$500(this.this$0).onVideoFrameCheckResult(i);
      }
    }
    else if (this.val$isAllTaskRun)
    {
      LogUtil.w("SuperPlayer-.FrameComparePipeLine", "No end task, when mQueue is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.FrameComparePipeLine.2
 * JD-Core Version:    0.7.0.1
 */