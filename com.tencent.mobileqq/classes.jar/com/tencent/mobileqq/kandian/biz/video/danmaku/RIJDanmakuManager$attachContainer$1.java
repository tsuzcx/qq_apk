package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJDanmakuManager$attachContainer$1
  implements Runnable
{
  RIJDanmakuManager$attachContainer$1(RIJDanmakuManager paramRIJDanmakuManager, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    if ((Intrinsics.areEqual(this.a.getRootView(), RIJDanmakuManager.a(this.this$0).getParent()) ^ true))
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
      localObject = this.a.getRootView();
      if (localObject != null)
      {
        ((ViewGroup)localObject).addView(RIJDanmakuManager.a(this.this$0), -1, -1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager.attachContainer.1
 * JD-Core Version:    0.7.0.1
 */