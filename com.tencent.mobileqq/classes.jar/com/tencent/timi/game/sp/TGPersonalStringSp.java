package com.tencent.timi.game.sp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/sp/TGPersonalStringSp;", "Lcom/tencent/timi/game/sp/BaseTGSpDelegate;", "", "tag", "default", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "saveTag", "defaultValue", "saveValue", "", "value", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGPersonalStringSp
  extends BaseTGSpDelegate<String>
{
  @NotNull
  public String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "saveTag");
    Intrinsics.checkParameterIsNotNull(paramString2, "defaultValue");
    paramString1 = TGSharedPreferenceUtil.b(paramString1, paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "TGSharedPreferenceUtil.g…ng(saveTag, defaultValue)");
    return paramString1;
  }
  
  public void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "saveTag");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    TGSharedPreferenceUtil.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.sp.TGPersonalStringSp
 * JD-Core Version:    0.7.0.1
 */