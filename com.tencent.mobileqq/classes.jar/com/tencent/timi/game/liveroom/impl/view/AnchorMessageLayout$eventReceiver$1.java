package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.timi.game.liveroom.impl.AnchorLiveSysMsgEvent;
import com.tencent.timi.game.liveroom.impl.message.AnchorLiveSysMsg;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$eventReceiver$1", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/liveroom/impl/AnchorLiveSysMsgEvent;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$eventReceiver$1
  implements SimpleEventReceiver<AnchorLiveSysMsgEvent>
{
  @NotNull
  public ArrayList<Class<AnchorLiveSysMsgEvent>> getEventClass()
  {
    return CollectionsKt.arrayListOf(new Class[] { AnchorLiveSysMsgEvent.class });
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AnchorLiveSysMsgEvent))
    {
      paramSimpleBaseEvent = (AnchorLiveSysMsgEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.getRoomId() == AnchorMessageLayout.k(this.a)) && ((StringsKt.isBlank((CharSequence)paramSimpleBaseEvent.getSysNotice()) ^ true)))
      {
        this.a.a(new AnchorLiveSysMsg(paramSimpleBaseEvent.getSysNotice()));
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.eventReceiver.1
 * JD-Core Version:    0.7.0.1
 */