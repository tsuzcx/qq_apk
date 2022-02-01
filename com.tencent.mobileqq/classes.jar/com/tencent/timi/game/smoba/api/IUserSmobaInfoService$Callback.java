package com.tencent.timi.game.smoba.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "T", "", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "(ZILjava/lang/String;Ljava/lang/Object;)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IUserSmobaInfoService$Callback<T>
{
  public abstract void a(boolean paramBoolean, int paramInt, @Nullable String paramString, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback
 * JD-Core Version:    0.7.0.1
 */