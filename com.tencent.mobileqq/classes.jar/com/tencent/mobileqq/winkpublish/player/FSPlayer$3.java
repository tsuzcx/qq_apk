package com.tencent.mobileqq.winkpublish.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class FSPlayer$3
  implements Runnable
{
  FSPlayer$3(FSPlayer paramFSPlayer) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FSPlayer", 1, "[release]");
    }
    if (FSPlayer.b(this.this$0) != null)
    {
      FSPlayer.b(this.this$0).stop();
      FSPlayer.b(this.this$0).release();
    }
    FSPlayer.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSPlayer.3
 * JD-Core Version:    0.7.0.1
 */