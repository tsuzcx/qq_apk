package com.tencent.mobileqq.vas.troopgift;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/TroopGiftComboXAController;", "", "xaEngine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "(Lcom/tencent/xaction/openapi/api/IXAEngine;)V", "TAG", "", "comboState", "Lcom/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$PlayState;", "pagState", "textAnimationDuration", "", "wholeState", "getWholeState$AQQLiteApp_release", "()Lcom/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$PlayState;", "setWholeState$AQQLiteApp_release", "(Lcom/tencent/mobileqq/vas/troopgift/TroopGiftPAGAnimationController$PlayState;)V", "getXaEngine", "()Lcom/tencent/xaction/openapi/api/IXAEngine;", "getDefDuration", "comboTimes", "", "setAvatar", "", "senderDrawable", "Landroid/graphics/drawable/Drawable;", "receiverDrawable", "setComboAnimationForXA", "fontPath", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftComboXAController
{
  private long jdField_a_of_type_Long;
  @NotNull
  private TroopGiftPAGAnimationController.PlayState jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$PlayState;
  @NotNull
  private final IXAEngine jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine;
  private final String jdField_a_of_type_JavaLangString;
  private TroopGiftPAGAnimationController.PlayState b;
  private TroopGiftPAGAnimationController.PlayState c;
  
  public TroopGiftComboXAController(@NotNull IXAEngine paramIXAEngine)
  {
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine = paramIXAEngine;
    this.jdField_a_of_type_JavaLangString = "TroopGiftComboXAController";
    this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$PlayState = TroopGiftPAGAnimationController.PlayState.PLAY_NONE;
    this.b = TroopGiftPAGAnimationController.PlayState.PLAY_NONE;
    this.c = TroopGiftPAGAnimationController.PlayState.PLAY_NONE;
  }
  
  private final long a(int paramInt)
  {
    long l = 1500L;
    if ((1 <= paramInt) && (9 >= paramInt)) {
      return 1500L;
    }
    if ((10 <= paramInt) && (100 >= paramInt)) {
      return 2500L;
    }
    if ((100 <= paramInt) && (999 >= paramInt)) {
      return 4000L;
    }
    if (paramInt > 999) {
      l = 5000L;
    }
    return l;
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "fontPath");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startComboAnimation");
    }
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "animator");
    localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    localValueAnimator.addListener((Animator.AnimatorListener)new TroopGiftComboXAController.setComboAnimationForXA.1(this));
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine.getRuleManager().registerRuleLine("$COMBO_BLOCK", new TroopGiftComboXAController.setComboAnimationForXA.2(this, paramString, localValueAnimator, paramInt));
    localValueAnimator.start();
  }
  
  public final void a(@NotNull Drawable paramDrawable1, @NotNull Drawable paramDrawable2)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable1, "senderDrawable");
    Intrinsics.checkParameterIsNotNull(paramDrawable2, "receiverDrawable");
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine.getRuleManager().registerRuleLine("$SENDER_AVATAR", new TroopGiftComboXAController.setAvatar.1(paramDrawable1));
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIXAEngine.getRuleManager().registerRuleLine("$RECEIVER_AVATAR", new TroopGiftComboXAController.setAvatar.2(paramDrawable2));
  }
  
  public final void a(@NotNull TroopGiftPAGAnimationController.PlayState paramPlayState)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayState, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftPAGAnimationController$PlayState = paramPlayState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboXAController
 * JD-Core Version:    0.7.0.1
 */