package com.tencent.timi.game.liveroom.impl.view;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorMessageLayout$onEnterRoom$2
  implements Runnable
{
  AnchorMessageLayout$onEnterRoom$2(AnchorMessageLayout paramAnchorMessageLayout, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    Object localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).l(this.a);
    if (localObject != null)
    {
      AnchorMessageLayout.c(this.this$0).addAll((Collection)localObject);
      localObject = AnchorMessageLayout.d(this.this$0).getAdapter();
      if (localObject != null) {
        ((RecyclerView.Adapter)localObject).notifyDataSetChanged();
      }
    }
    this.this$0.e();
    if (AnchorMessageLayout.c(this.this$0).isEmpty())
    {
      Logger.a("AnchorMessageLayout", "datas is empty");
      SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)AnchorMessageLayout.e(this.this$0));
      localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).k(this.a);
      if (localObject != null) {
        ((ILiveRoomOperation)localObject).getRoomAnnounce(this.a, (IQQLiveGetAnnounceCallback)new AnchorMessageLayout.onEnterRoom.2.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.onEnterRoom.2
 * JD-Core Version:    0.7.0.1
 */