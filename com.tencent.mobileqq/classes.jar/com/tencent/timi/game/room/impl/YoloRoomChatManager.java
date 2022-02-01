package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.INewMsgListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/room/impl/YoloRoomChatManager;", "", "()V", "actionMessageListener", "Lcom/tencent/timi/game/room/impl/YoloRoomChatManager$MessageListener;", "getActionMessageListener", "()Lcom/tencent/timi/game/room/impl/YoloRoomChatManager$MessageListener;", "setActionMessageListener", "(Lcom/tencent/timi/game/room/impl/YoloRoomChatManager$MessageListener;)V", "newMsgListener", "com/tencent/timi/game/room/impl/YoloRoomChatManager$newMsgListener$1", "Lcom/tencent/timi/game/room/impl/YoloRoomChatManager$newMsgListener$1;", "onDestroy", "", "MessageListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class YoloRoomChatManager
{
  @Nullable
  private YoloRoomChatManager.MessageListener a;
  private final YoloRoomChatManager.newMsgListener.1 b = new YoloRoomChatManager.newMsgListener.1(this);
  
  public YoloRoomChatManager()
  {
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a((INewMsgListener)this.b);
  }
  
  @Nullable
  public final YoloRoomChatManager.MessageListener a()
  {
    return this.a;
  }
  
  public final void a(@Nullable YoloRoomChatManager.MessageListener paramMessageListener)
  {
    this.a = paramMessageListener;
  }
  
  public final void b()
  {
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b((INewMsgListener)this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomChatManager
 * JD-Core Version:    0.7.0.1
 */