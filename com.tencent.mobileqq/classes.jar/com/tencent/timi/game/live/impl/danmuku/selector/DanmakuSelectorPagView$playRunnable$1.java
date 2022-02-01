package com.tencent.timi.game.live.impl.danmuku.selector;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DanmakuSelectorPagView$playRunnable$1
  implements Runnable
{
  DanmakuSelectorPagView$playRunnable$1(DanmakuSelectorPagView paramDanmakuSelectorPagView) {}
  
  public final void run()
  {
    if (!DanmakuSelectorPagView.b(this.this$0).get())
    {
      this.this$0.setProgress(0.0D);
      this.this$0.play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorPagView.playRunnable.1
 * JD-Core Version:    0.7.0.1
 */