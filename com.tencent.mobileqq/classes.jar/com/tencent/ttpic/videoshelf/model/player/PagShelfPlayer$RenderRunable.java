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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("progress:");
    localStringBuilder.append(PagShelfPlayer.access$300(this.this$0).getProgress());
    Log.i("PagShelfPlayer", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.RenderRunable
 * JD-Core Version:    0.7.0.1
 */