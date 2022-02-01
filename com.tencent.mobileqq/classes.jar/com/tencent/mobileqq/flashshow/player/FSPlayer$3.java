package com.tencent.mobileqq.flashshow.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class FSPlayer$3
  implements Runnable
{
  FSPlayer$3(FSPlayer paramFSPlayer) {}
  
  public void run()
  {
    if (FSPlayer.b(this.this$0) != null)
    {
      FSPlayer.b(this.this$0).stop();
      FSPlayer.b(this.this$0).release();
      QLog.d("FSPlayer", 1, "[release] really call");
    }
    FSPlayer.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSPlayer.3
 * JD-Core Version:    0.7.0.1
 */