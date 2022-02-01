package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;

class PlayProgressChecker$1
  implements Runnable
{
  PlayProgressChecker$1(PlayProgressChecker paramPlayProgressChecker, long paramLong) {}
  
  public void run()
  {
    PlayProgressChecker.access$100(this.this$0).onPlayProgress(PlayProgressChecker.access$000(this.this$0), this.val$playPos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.PlayProgressChecker.1
 * JD-Core Version:    0.7.0.1
 */