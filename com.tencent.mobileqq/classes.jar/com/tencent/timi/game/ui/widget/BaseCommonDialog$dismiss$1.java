package com.tencent.timi.game.ui.widget;

import android.view.View;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.AnimationCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/ui/widget/BaseCommonDialog$dismiss$1", "Lcom/tencent/timi/game/ui/utils/CommonAnimationUtil$AnimationCallback;", "onAnimationFinish", "", "view", "Landroid/view/View;", "onAnimationStart", "onAnimationUpdate", "percent", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseCommonDialog$dismiss$1
  implements CommonAnimationUtil.AnimationCallback
{
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public void a(@NotNull View paramView, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public void b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    BaseCommonDialog.a(this.a);
    BaseCommonDialog.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.BaseCommonDialog.dismiss.1
 * JD-Core Version:    0.7.0.1
 */