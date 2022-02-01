package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJDanmakuManager$destroy$1
  implements Runnable
{
  RIJDanmakuManager$destroy$1(RIJDanmakuManager paramRIJDanmakuManager) {}
  
  public final void run()
  {
    ViewParent localViewParent = RIJDanmakuManager.a(this.this$0).getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(RIJDanmakuManager.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager.destroy.1
 * JD-Core Version:    0.7.0.1
 */