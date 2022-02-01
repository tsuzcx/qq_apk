package com.tencent.timi.game.sp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/sp/TGPersonalFloatSp;", "Lcom/tencent/timi/game/sp/BaseTGSpDelegate;", "", "tag", "", "default", "(Ljava/lang/String;F)V", "getValue", "saveTag", "defaultValue", "(Ljava/lang/String;F)Ljava/lang/Float;", "saveValue", "", "value", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGPersonalFloatSp
  extends BaseTGSpDelegate<Float>
{
  @NotNull
  public Float a(@NotNull String paramString, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    return Float.valueOf(TGSharedPreferenceUtil.b(paramString, paramFloat));
  }
  
  public void b(@NotNull String paramString, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "saveTag");
    TGSharedPreferenceUtil.a(paramString, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.sp.TGPersonalFloatSp
 * JD-Core Version:    0.7.0.1
 */