package com.tencent.thumbplayer.adapter.player.systemplayer;

class TPSystemMediaPlayer$5
  implements Runnable
{
  TPSystemMediaPlayer$5(TPSystemMediaPlayer paramTPSystemMediaPlayer, TPSystemMediaPlayer.BufferCheck paramBufferCheck) {}
  
  public void run()
  {
    while (!this.val$bc.mCheckAbort)
    {
      TPSystemMediaPlayer.access$1400(this.this$0);
      try
      {
        Thread.sleep(400L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.5
 * JD-Core Version:    0.7.0.1
 */