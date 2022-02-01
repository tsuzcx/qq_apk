package com.tencent.timi.game.api.impl;

import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.LongRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInitFinish"}, k=3, mv={1, 1, 16})
final class TimiGameApiImpl$initLiveModule$1$1
  implements InitCallback
{
  TimiGameApiImpl$initLiveModule$1$1(Ref.LongRef paramLongRef) {}
  
  public final void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a.element;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLiveModule syncEnsureInit costTime = ");
    localStringBuilder.append(l1 - l2);
    Logger.a("TimiGameApiImpl_", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl.initLiveModule.1.1
 * JD-Core Version:    0.7.0.1
 */