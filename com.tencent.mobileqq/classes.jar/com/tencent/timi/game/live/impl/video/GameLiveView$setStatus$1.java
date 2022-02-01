package com.tencent.timi.game.live.impl.video;

import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameLiveView$setStatus$1
  implements Runnable
{
  GameLiveView$setStatus$1(GameLiveView paramGameLiveView, int paramInt) {}
  
  public final void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setStatus oldStatus: ");
    localStringBuilder.append(GameLiveView.c(this.this$0));
    localStringBuilder.append(" new status ");
    localStringBuilder.append(this.a);
    Logger.a("GameLiveView", localStringBuilder.toString());
    GameLiveView.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.GameLiveView.setStatus.1
 * JD-Core Version:    0.7.0.1
 */