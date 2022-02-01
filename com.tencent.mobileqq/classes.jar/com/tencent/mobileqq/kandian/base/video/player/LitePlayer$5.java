package com.tencent.mobileqq.kandian.base.video.player;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class LitePlayer$5
  implements Runnable
{
  LitePlayer$5(LitePlayer paramLitePlayer) {}
  
  public void run()
  {
    Iterator localIterator = LitePlayer.b(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((PlayerStatusListener)localIterator.next()).onVideoStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.LitePlayer.5
 * JD-Core Version:    0.7.0.1
 */