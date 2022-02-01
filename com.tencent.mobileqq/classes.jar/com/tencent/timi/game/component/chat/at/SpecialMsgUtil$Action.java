package com.tencent.timi.game.component.chat.at;

import android.app.Dialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/at/SpecialMsgUtil$Action;", "", "actionStr", "", "action", "Lkotlin/Function1;", "Landroid/app/Dialog;", "Lkotlin/ParameterName;", "name", "dialog", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "getActionStr", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SpecialMsgUtil$Action
{
  @NotNull
  private final String a;
  @NotNull
  private final Function1<Dialog, Unit> b;
  
  public SpecialMsgUtil$Action(@NotNull String paramString, @NotNull Function1<? super Dialog, Unit> paramFunction1)
  {
    this.a = paramString;
    this.b = paramFunction1;
  }
  
  @NotNull
  public final Function1<Dialog, Unit> a()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Action))
      {
        paramObject = (Action)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Action(actionStr=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.SpecialMsgUtil.Action
 * JD-Core Version:    0.7.0.1
 */