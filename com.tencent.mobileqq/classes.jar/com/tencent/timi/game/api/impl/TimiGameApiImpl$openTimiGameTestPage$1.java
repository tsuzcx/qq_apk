package com.tencent.timi.game.api.impl;

import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.test.api.ITimiGameTestService;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInitFinish"}, k=3, mv={1, 1, 16})
final class TimiGameApiImpl$openTimiGameTestPage$1
  implements InitCallback
{
  public static final 1 a = new 1();
  
  public final void a(boolean paramBoolean)
  {
    ((ITimiGameTestService)ServiceCenter.a(ITimiGameTestService.class)).a();
    ((IniterService)ServiceCenter.a(IniterService.class)).a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl.openTimiGameTestPage.1
 * JD-Core Version:    0.7.0.1
 */