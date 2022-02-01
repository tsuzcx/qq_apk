package com.tencent.timi.game.sp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/sp/TGPersonalIntSp;", "Lcom/tencent/timi/game/sp/BaseTGSpDelegate;", "", "tag", "", "default", "(Ljava/lang/String;I)V", "getValue", "saveTag", "defaultValue", "(Ljava/lang/String;I)Ljava/lang/Integer;", "saveValue", "", "value", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGPersonalIntSp
  extends BaseTGSpDelegate<Integer>
{
  @NotNull
  public Integer a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    return Integer.valueOf(TGSharedPreferenceUtil.b(paramString, paramInt));
  }
  
  public void b(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    TGSharedPreferenceUtil.a(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.sp.TGPersonalIntSp
 * JD-Core Version:    0.7.0.1
 */