package com.tencent.timi.game.liveroom.impl.floating;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$3
  implements View.OnClickListener
{
  TGLiveAudienceFloatingView$3(TGLiveAudienceFloatingView paramTGLiveAudienceFloatingView) {}
  
  public final void onClick(View paramView)
  {
    ILiveRoom localILiveRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).b(0L);
    Object localObject = localILiveRoom;
    if (!(localILiveRoom instanceof ILiveTPPlayerRoom)) {
      localObject = null;
    }
    localObject = (ILiveTPPlayerRoom)localObject;
    if (localObject != null) {
      ((ILiveTPPlayerRoom)localObject).play();
    }
    localObject = (LinearLayout)this.a.a(2131437610);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "load_failed");
    ((LinearLayout)localObject).setVisibility(8);
    localObject = (TextView)this.a.a(2131437625);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingText");
    ((TextView)localObject).setVisibility(0);
    localObject = this.a;
    ((TGLiveAudienceFloatingView)localObject).postDelayed(TGLiveAudienceFloatingView.b((TGLiveAudienceFloatingView)localObject), 10000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.3
 * JD-Core Version:    0.7.0.1
 */