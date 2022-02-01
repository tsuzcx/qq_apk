package com.tencent.mobileqq.kandian.base.video.player;

import java.util.Iterator;
import java.util.List;

class LitePlayer$4
  implements Runnable
{
  LitePlayer$4(LitePlayer paramLitePlayer) {}
  
  public void run()
  {
    Iterator localIterator = LitePlayer.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((PlayerStatusListener)localIterator.next()).onVideoPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer.4
 * JD-Core Version:    0.7.0.1
 */