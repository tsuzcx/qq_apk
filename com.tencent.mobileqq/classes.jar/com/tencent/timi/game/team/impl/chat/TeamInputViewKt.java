package com.tencent.timi.game.team.impl.chat;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"resetRightMargin", "", "Landroid/view/View;", "marginRight", "", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class TeamInputViewKt
{
  public static final void a(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$resetRightMargin");
    Object localObject = paramView.getLayoutParams();
    if (localObject != null)
    {
      localObject = (ConstraintLayout.LayoutParams)localObject;
      ((ConstraintLayout.LayoutParams)localObject).rightMargin = paramInt;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamInputViewKt
 * JD-Core Version:    0.7.0.1
 */