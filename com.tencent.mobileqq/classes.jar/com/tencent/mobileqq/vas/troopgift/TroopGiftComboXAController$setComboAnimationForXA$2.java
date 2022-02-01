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
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "pagView", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class TroopGiftComboXAController$setComboAnimationForXA$2
  extends Lambda
  implements Function1<PAGView, Unit>
{
  TroopGiftComboXAController$setComboAnimationForXA$2(TroopGiftComboXAController paramTroopGiftComboXAController, String paramString, ValueAnimator paramValueAnimator, int paramInt)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "pagView");
    Object localObject2 = PAGFont.RegisterFont(this.$fontPath);
    Object localObject1 = paramPAGView.getFile();
    if (localObject1 != null) {
      localObject1 = ((PAGFile)localObject1).getTextData(0);
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      ((PAGText)localObject1).fontFamily = ((PAGFont)localObject2).fontFamily;
    }
    if (localObject1 != null) {
      ((PAGText)localObject1).fontStyle = ((PAGFont)localObject2).fontStyle;
    }
    if (TroopGiftComboXAController.a(this.this$0) > 0L)
    {
      localObject1 = this.$animator;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "animator");
      ((ValueAnimator)localObject1).setDuration(TroopGiftComboXAController.a(this.this$0));
    }
    else
    {
      localObject1 = this.$animator;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "animator");
      ((ValueAnimator)localObject1).setDuration(TroopGiftComboXAController.a(this.this$0, this.$comboTimes));
      localObject1 = TroopGiftComboXAController.a(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Get troopgift combo pag duration failed. comboTimes: ");
      ((StringBuilder)localObject2).append(this.$comboTimes);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    this.$animator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new TroopGiftComboXAController.setComboAnimationForXA.2.1(this, paramPAGView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboXAController.setComboAnimationForXA.2
 * JD-Core Version:    0.7.0.1
 */