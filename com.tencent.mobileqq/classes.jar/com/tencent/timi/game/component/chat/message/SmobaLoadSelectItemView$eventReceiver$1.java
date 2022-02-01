package com.tencent.timi.game.component.chat.message;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.timi.game.team.impl.event.TeamLaneEvent;
import com.tencent.timi.game.tim.api.message.IMsg;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/SmobaLoadSelectItemView$eventReceiver$1", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/team/impl/event/TeamLaneEvent;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaLoadSelectItemView$eventReceiver$1
  implements SimpleEventReceiver<TeamLaneEvent>
{
  @NotNull
  public ArrayList<Class<TeamLaneEvent>> getEventClass()
  {
    return CollectionsKt.arrayListOf(new Class[] { TeamLaneEvent.class });
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof TeamLaneEvent))
    {
      IMsg localIMsg = this.a.getMsg();
      if ((localIMsg != null) && (localIMsg.m() == 0))
      {
        Object localObject1 = (Iterable)SmobaLoadSelectItemView.e(this.a);
        int i = 0;
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          int j = i + 1;
          if (i < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          if (((Number)localObject2).intValue() == ((TeamLaneEvent)paramSimpleBaseEvent).getLaneId())
          {
            localIMsg.a(j);
            this.a.b(localIMsg);
          }
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SmobaLoadSelectItemView.eventReceiver.1
 * JD-Core Version:    0.7.0.1
 */