package com.tencent.timi.game.smoba.api;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "onChanged"}, k=3, mv={1, 1, 16})
final class SmobaAuthAndDefaultAccountChecker$observerOfAuthInfo$1<T>
  implements Observer<GameDataServerOuterClass.GetSmobaAuthInfoRsp>
{
  public static final 1 a = new 1();
  
  public final void a(@Nullable GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    SmobaAuthAndDefaultAccountChecker.a(SmobaAuthAndDefaultAccountChecker.a, paramGetSmobaAuthInfoRsp);
    SmobaAuthAndDefaultAccountChecker.a(SmobaAuthAndDefaultAccountChecker.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.SmobaAuthAndDefaultAccountChecker.observerOfAuthInfo.1
 * JD-Core Version:    0.7.0.1
 */