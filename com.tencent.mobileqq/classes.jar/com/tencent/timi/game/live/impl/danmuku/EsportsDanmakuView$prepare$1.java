package com.tencent.timi.game.live.impl.danmuku;

import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EsportsDanmakuView$prepare$1
  implements Runnable
{
  EsportsDanmakuView$prepare$1(EsportsDanmakuView paramEsportsDanmakuView) {}
  
  public final void run()
  {
    if (EsportsDanmakuView.a(this.this$0))
    {
      Logger.c("EsportsDanmakuView", "prepare has called");
      return;
    }
    EsportsDanmakuView.a(this.this$0, true);
    EsportsDanmakuView localEsportsDanmakuView = this.this$0;
    EsportsDanmakuView.a(localEsportsDanmakuView, EsportsDanmakuView.b(localEsportsDanmakuView, localEsportsDanmakuView.getHeight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.EsportsDanmakuView.prepare.1
 * JD-Core Version:    0.7.0.1
 */