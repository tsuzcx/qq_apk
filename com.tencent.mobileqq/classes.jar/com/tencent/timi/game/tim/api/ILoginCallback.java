package com.tencent.timi.game.tim.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/ILoginCallback;", "", "onError", "", "errorCode", "", "errorMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ILoginCallback
{
  public abstract void a();
  
  public abstract void a(int paramInt, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.ILoginCallback
 * JD-Core Version:    0.7.0.1
 */