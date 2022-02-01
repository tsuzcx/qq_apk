package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.live.impl.WifiOr4GStateHolder;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$4
  implements View.OnClickListener
{
  TGLiveAudienceFloatingView$4(TGLiveAudienceFloatingView paramTGLiveAudienceFloatingView, Context paramContext) {}
  
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
    WifiOr4GStateHolder.a.b();
    QQToast.makeText(this.b, (CharSequence)"正在使用流量观看", 0).show();
    TGLiveAudienceFloatingView.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.4
 * JD-Core Version:    0.7.0.1
 */