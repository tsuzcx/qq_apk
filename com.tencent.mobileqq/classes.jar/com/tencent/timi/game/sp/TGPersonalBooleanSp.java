package com.tencent.timi.game.sp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/sp/TGPersonalBooleanSp;", "Lcom/tencent/timi/game/sp/BaseTGSpDelegate;", "", "tag", "", "default", "(Ljava/lang/String;Z)V", "getValue", "saveTag", "defaultValue", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "saveValue", "", "value", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGPersonalBooleanSp
  extends BaseTGSpDelegate<Boolean>
{
  @NotNull
  public Boolean a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    return Boolean.valueOf(TGSharedPreferenceUtil.b(paramString, paramBoolean));
  }
  
  public void b(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    TGSharedPreferenceUtil.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.sp.TGPersonalBooleanSp
 * JD-Core Version:    0.7.0.1
 */