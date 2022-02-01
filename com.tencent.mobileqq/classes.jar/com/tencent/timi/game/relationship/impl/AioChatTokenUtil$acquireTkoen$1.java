package com.tencent.timi.game.relationship.impl;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/relationship/impl/AioChatTokenUtil$acquireTkoen$1", "Lcom/tencent/timi/game/utils/IResultListener;", "", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AioChatTokenUtil$acquireTkoen$1
  implements IResultListener<byte[]>
{
  AioChatTokenUtil$acquireTkoen$1(AioChatTokenUtil.TokenListener paramTokenListener, WeakReference paramWeakReference) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    this.a.a((QBaseActivity)this.b.get());
  }
  
  public void a(@Nullable byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.a.a((QBaseActivity)this.b.get(), paramArrayOfByte);
      return;
    }
    this.a.a((QBaseActivity)this.b.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.relationship.impl.AioChatTokenUtil.acquireTkoen.1
 * JD-Core Version:    0.7.0.1
 */