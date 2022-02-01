package com.tencent.timi.game.live.impl.danmuku.ktv;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/ktv/Ktv;", "", "ktvStr", "", "(Ljava/lang/String;)V", "getKtvStr", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class Ktv
{
  @NotNull
  private final String a;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Ktv))
      {
        paramObject = (Ktv)paramObject;
        if (Intrinsics.areEqual(this.a, paramObject.a)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Ktv(ktvStr=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.ktv.Ktv
 * JD-Core Version:    0.7.0.1
 */