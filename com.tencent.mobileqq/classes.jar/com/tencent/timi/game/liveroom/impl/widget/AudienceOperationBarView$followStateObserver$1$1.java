package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AudienceOperationBarView$followStateObserver$1$1
  implements View.OnClickListener
{
  AudienceOperationBarView$followStateObserver$1$1(AudienceOperationBarView.followStateObserver.1 param1, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    Object localObject;
    if (!this.b)
    {
      localObject = AudienceOperationBarView.d(this.a.a);
      if (localObject != null) {
        AudienceOperationBarView.a(this.a.a, (ILiveRoom)localObject);
      }
    }
    else
    {
      localObject = this.a.a;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "v");
      AudienceOperationBarView.a((AudienceOperationBarView)localObject, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.followStateObserver.1.1
 * JD-Core Version:    0.7.0.1
 */