package com.tencent.timi.game.api.impl;

import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGameApp$startTask$initTaskWrapper$1$initTask$1
  implements Runnable
{
  TimiGameApp$startTask$initTaskWrapper$1$initTask$1(TimiGameApp.startTask.initTaskWrapper.1 param1, CountDownLatch paramCountDownLatch, Ref.ObjectRef paramObjectRef1, Ref.ObjectRef paramObjectRef2) {}
  
  public final void run()
  {
    ((IniterService)ServiceCenter.a(IniterService.class)).a((InitCallback)new TimiGameApp.startTask.initTaskWrapper.1.initTask.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp.startTask.initTaskWrapper.1.initTask.1
 * JD-Core Version:    0.7.0.1
 */