package com.tencent.timi.game.tim.api.impl.message;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/message/GroupMsgManager;", "Lcom/tencent/timi/game/tim/api/impl/message/BaseMsgManager;", "groupId", "", "(Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "isGroup", "", "markMsgAsRead", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GroupMsgManager
  extends BaseMsgManager
{
  @NotNull
  private final String a;
  
  public GroupMsgManager(@NotNull String paramString)
  {
    super(paramString);
    this.a = paramString;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.GroupMsgManager
 * JD-Core Version:    0.7.0.1
 */