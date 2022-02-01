package com.tencent.timi.game.float_window.impl;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/YesFloatWindowManager$FloatingItem;", "", "ket", "", "mFloatingContainer", "Lcom/tencent/timi/game/float_window/impl/FloatWindowContainer;", "mFloatingWidgetWrapper", "Landroid/widget/FrameLayout;", "(Ljava/lang/String;Lcom/tencent/timi/game/float_window/impl/FloatWindowContainer;Landroid/widget/FrameLayout;)V", "getKet", "()Ljava/lang/String;", "setKet", "(Ljava/lang/String;)V", "getMFloatingContainer", "()Lcom/tencent/timi/game/float_window/impl/FloatWindowContainer;", "setMFloatingContainer", "(Lcom/tencent/timi/game/float_window/impl/FloatWindowContainer;)V", "getMFloatingWidgetWrapper", "()Landroid/widget/FrameLayout;", "setMFloatingWidgetWrapper", "(Landroid/widget/FrameLayout;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class YesFloatWindowManager$FloatingItem
{
  @NotNull
  private String a;
  @NotNull
  private FloatWindowContainer b;
  @NotNull
  private FrameLayout c;
  
  public YesFloatWindowManager$FloatingItem(@NotNull String paramString, @NotNull FloatWindowContainer paramFloatWindowContainer, @NotNull FrameLayout paramFrameLayout)
  {
    this.a = paramString;
    this.b = paramFloatWindowContainer;
    this.c = paramFrameLayout;
    this.b.setBackgroundColor(0);
  }
  
  @NotNull
  public final FloatWindowContainer a()
  {
    return this.b;
  }
  
  @NotNull
  public final FrameLayout b()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FloatingItem))
      {
        paramObject = (FloatingItem)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatingItem(ket=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mFloatingContainer=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mFloatingWidgetWrapper=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.YesFloatWindowManager.FloatingItem
 * JD-Core Version:    0.7.0.1
 */