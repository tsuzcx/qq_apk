package com.tencent.timi.game.sp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/sp/TGPersonalLongSp;", "Lcom/tencent/timi/game/sp/BaseTGSpDelegate;", "", "tag", "", "default", "(Ljava/lang/String;J)V", "getValue", "saveTag", "defaultValue", "(Ljava/lang/String;J)Ljava/lang/Long;", "saveValue", "", "value", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGPersonalLongSp
  extends BaseTGSpDelegate<Long>
{
  @NotNull
  public Long a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    return Long.valueOf(TGSharedPreferenceUtil.b(paramString, paramLong));
  }
  
  public void b(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    TGSharedPreferenceUtil.a(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.sp.TGPersonalLongSp
 * JD-Core Version:    0.7.0.1
 */