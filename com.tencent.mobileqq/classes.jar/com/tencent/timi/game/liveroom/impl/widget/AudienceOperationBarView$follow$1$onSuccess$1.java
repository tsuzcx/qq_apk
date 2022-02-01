package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.observable.FollowStatusWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AudienceOperationBarView$follow$1$onSuccess$1
  implements View.OnClickListener
{
  AudienceOperationBarView$follow$1$onSuccess$1(AudienceOperationBarView.follow.1 param1) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = AudienceOperationBarView.a(this.a.a);
    if ((localObject != null) && (!((FollowStatusWrapper)localObject).a()))
    {
      AudienceOperationBarView.a(this.a.a, this.a.c);
    }
    else
    {
      localObject = AudienceOperationBarView.a(this.a.a);
      if ((localObject != null) && (((FollowStatusWrapper)localObject).a() == true))
      {
        localObject = this.a.a;
        Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
        AudienceOperationBarView.a((AudienceOperationBarView)localObject, paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.follow.1.onSuccess.1
 * JD-Core Version:    0.7.0.1
 */