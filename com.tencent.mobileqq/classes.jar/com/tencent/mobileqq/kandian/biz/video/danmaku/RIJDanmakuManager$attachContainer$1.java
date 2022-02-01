package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.kandian.glue.viola.components.ViolaDanmakuView;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.component.VDiv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJDanmakuManager$attachContainer$1
  implements Runnable
{
  RIJDanmakuManager$attachContainer$1(RIJDanmakuManager paramRIJDanmakuManager, ViewGroup paramViewGroup) {}
  
  public final void run()
  {
    Object localObject1 = this.a;
    label43:
    Object localObject2;
    if ((localObject1 instanceof ViolaDanmakuView))
    {
      localObject1 = ((ViolaDanmakuView)localObject1).getComponent();
      if (localObject1 != null)
      {
        localObject1 = ((VDiv)localObject1).getInstance();
        if (localObject1 != null)
        {
          localObject1 = ((ViolaInstance)localObject1).getRootView();
          break label43;
        }
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup)localObject2;
    }
    else
    {
      localObject2 = ((ViewGroup)localObject1).getParent();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
    }
    if ((Intrinsics.areEqual(localObject1, RIJDanmakuManager.a(this.this$0).getParent()) ^ true))
    {
      ViewParent localViewParent = RIJDanmakuManager.a(this.this$0).getParent();
      localObject2 = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject2 = null;
      }
      localObject2 = (ViewGroup)localObject2;
      if (localObject2 != null) {
        ((ViewGroup)localObject2).removeView(RIJDanmakuManager.a(this.this$0));
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView(RIJDanmakuManager.a(this.this$0), -1, -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager.attachContainer.1
 * JD-Core Version:    0.7.0.1
 */