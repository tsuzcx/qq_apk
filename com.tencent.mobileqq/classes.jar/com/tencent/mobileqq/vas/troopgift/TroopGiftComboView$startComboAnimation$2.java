package com.tencent.mobileqq.vas.troopgift;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "pagView", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class TroopGiftComboView$startComboAnimation$2
  extends Lambda
  implements Function1<PAGView, Unit>
{
  TroopGiftComboView$startComboAnimation$2(TroopGiftComboView paramTroopGiftComboView, ValueAnimator paramValueAnimator, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "pagView");
    ValueAnimator localValueAnimator;
    if (TroopGiftComboView.a(this.this$0) > 0L)
    {
      localValueAnimator = this.$animator;
      Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "animator");
      localValueAnimator.setDuration(TroopGiftComboView.a(this.this$0));
    }
    for (;;)
    {
      this.$animator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new TroopGiftComboView.startComboAnimation.2.1(this, paramPAGView));
      return;
      localValueAnimator = this.$animator;
      Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "animator");
      localValueAnimator.setDuration(TroopGiftComboView.a(this.this$0, this.$comboTimes));
      QLog.e(this.this$0.a(), 1, "Get troopgift combo pag duration failed. comboTimes: " + this.$comboTimes);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.startComboAnimation.2
 * JD-Core Version:    0.7.0.1
 */