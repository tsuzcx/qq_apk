package com.tencent.timi.game.live.impl.danmuku;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.Random.Default;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TestDanmakuFragment$onCreateView$1
  implements View.OnClickListener
{
  TestDanmakuFragment$onCreateView$1(TestDanmakuFragment paramTestDanmakuFragment) {}
  
  public final void onClick(View paramView)
  {
    Object localObject2 = this.a.getActivity();
    if (localObject2 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity ?: return@setOnClickListener");
      Object localObject1 = TestDanmakuFragment.a(this.a);
      if (localObject1 != null)
      {
        localObject1 = (EsportsDanmakuView)((View)localObject1).findViewById(2131431569);
        if (localObject1 != null)
        {
          localObject2 = (Context)localObject2;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("测试");
          localStringBuilder.append(Random.Default.nextInt(100));
          ((EsportsDanmakuView)localObject1).b((Context)localObject2, localStringBuilder.toString(), -1, 1);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.TestDanmakuFragment.onCreateView.1
 * JD-Core Version:    0.7.0.1
 */