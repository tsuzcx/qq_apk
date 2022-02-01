package com.tencent.timi.game.tim.api.impl.message;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/message/C2CMsgManager;", "Lcom/tencent/timi/game/tim/api/impl/message/BaseMsgManager;", "uid", "", "(Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "isGroup", "", "markMsgAsRead", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class C2CMsgManager
  extends BaseMsgManager
{
  @NotNull
  private final String a;
  
  public C2CMsgManager(@NotNull String paramString)
  {
    super(paramString);
    this.a = paramString;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.C2CMsgManager
 * JD-Core Version:    0.7.0.1
 */