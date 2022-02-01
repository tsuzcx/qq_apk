package com.tencent.timi.game.smoba.api;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onChanged"}, k=3, mv={1, 1, 16})
final class SmobaAuthAndDefaultAccountChecker$observerOfDefaultAccount$1<T>
  implements Observer<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  public static final 1 a = new 1();
  
  public final void a(@Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    SmobaAuthAndDefaultAccountChecker.a(SmobaAuthAndDefaultAccountChecker.a, paramGetSmobaDefaultRoleRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.SmobaAuthAndDefaultAccountChecker.observerOfDefaultAccount.1
 * JD-Core Version:    0.7.0.1
 */