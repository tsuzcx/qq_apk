package com.tencent.timi.game.api.impl;

import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.LongRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGameApiImpl$initLiveModule$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    Ref.LongRef localLongRef = new Ref.LongRef();
    localLongRef.element = System.currentTimeMillis();
    ((IniterService)ServiceCenter.a(IniterService.class)).a((InitCallback)new TimiGameApiImpl.initLiveModule.1.1(localLongRef));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl.initLiveModule.1
 * JD-Core Version:    0.7.0.1
 */