package com.tencent.timi.game.live.impl.danmuku;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TestDanmakuFragment$onCreateView$2
  implements View.OnClickListener
{
  TestDanmakuFragment$onCreateView$2(TestDanmakuFragment paramTestDanmakuFragment) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = TestDanmakuFragment.a(this.a);
    if (localObject != null)
    {
      localObject = (EsportsDanmakuView)((View)localObject).findViewById(2131431569);
      if (localObject != null) {
        ((EsportsDanmakuView)localObject).f();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.TestDanmakuFragment.onCreateView.2
 * JD-Core Version:    0.7.0.1
 */