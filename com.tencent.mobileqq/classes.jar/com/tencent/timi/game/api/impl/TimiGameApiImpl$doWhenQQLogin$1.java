package com.tencent.timi.game.api.impl;

import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInitFinish"}, k=3, mv={1, 1, 16})
final class TimiGameApiImpl$doWhenQQLogin$1
  implements InitCallback
{
  public static final 1 a = new 1();
  
  public final void a(boolean paramBoolean)
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl.doWhenQQLogin.1
 * JD-Core Version:    0.7.0.1
 */