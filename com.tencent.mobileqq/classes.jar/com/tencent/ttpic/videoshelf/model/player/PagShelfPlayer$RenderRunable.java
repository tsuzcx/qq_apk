package com.tencent.ttpic.videoshelf.model.player;

import android.util.Log;
import org.libpag.PAGRenderer;

class PagShelfPlayer$RenderRunable
  implements Runnable
{
  private PagShelfPlayer$RenderRunable(PagShelfPlayer paramPagShelfPlayer) {}
  
  public void run()
  {
    PagShelfPlayer.access$1100(this.this$0);
    PagShelfPlayer.access$300(this.this$0).flush();
    Log.i("PagShelfPlayer", "progress:" + PagShelfPlayer.access$300(this.this$0).getProgress());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.RenderRunable
 * JD-Core Version:    0.7.0.1
 */