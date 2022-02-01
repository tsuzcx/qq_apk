package com.tencent.mobileqq.kandian.biz.video.danmaku;

import com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJBaseDanmaku;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJDanmakuManager$cancelClickRunnable$1
  implements Runnable
{
  RIJDanmakuManager$cancelClickRunnable$1(RIJDanmakuManager paramRIJDanmakuManager) {}
  
  public final void run()
  {
    RIJBaseDanmaku localRIJBaseDanmaku = this.this$0.c();
    if (localRIJBaseDanmaku != null) {
      RIJDanmakuManager.a(this.this$0, localRIJBaseDanmaku);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager.cancelClickRunnable.1
 * JD-Core Version:    0.7.0.1
 */