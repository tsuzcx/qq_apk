package com.tencent.mobileqq.vas.troopgift;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/TroopGiftComboView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "comboState", "Lcom/tencent/mobileqq/vas/troopgift/PlayState;", "pagState", "textAnimationDuration", "", "<set-?>", "wholeState", "getWholeState$AQQLiteApp_release", "()Lcom/tencent/mobileqq/vas/troopgift/PlayState;", "getDefDuration", "comboTimes", "setAvatars", "", "senderAvatar", "Landroid/graphics/Bitmap;", "receiverAvatar", "setPAGResource", "pagPath", "fontPath", "setReceiverAvatar", "setSenderAvatar", "startComboAnimation", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftComboView
  extends VasPagView
{
  @NotNull
  private final String a = "TroopGiftComboView";
  @NotNull
  private PlayState b = PlayState.PLAY_NONE;
  private PlayState c = PlayState.PLAY_NONE;
  private PlayState e = PlayState.PLAY_NONE;
  private long f;
  
  public TroopGiftComboView(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopGiftComboView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopGiftComboView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final long b(int paramInt)
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
  
  public final void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "startComboAnimation");
    }
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "animator");
    localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    localValueAnimator.addListener((Animator.AnimatorListener)new TroopGiftComboView.startComboAnimation.1(this));
    g().a((Function1)new TroopGiftComboView.startComboAnimation.2(this, localValueAnimator, paramInt));
    localValueAnimator.start();
  }
  
  @NotNull
  public final String getTAG()
  {
    return this.a;
  }
  
  @NotNull
  public final PlayState getWholeState$AQQLiteApp_release()
  {
    return this.b;
  }
  
  public final void setAvatars(@NotNull Bitmap paramBitmap1, @NotNull Bitmap paramBitmap2)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap1, "senderAvatar");
    Intrinsics.checkParameterIsNotNull(paramBitmap2, "receiverAvatar");
    g().a((Function1)new TroopGiftComboView.setAvatars.1(this, paramBitmap1, paramBitmap2));
  }
  
  public final void setPAGResource(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "pagPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "fontPath");
    g().a((Function1)new TroopGiftComboView.setPAGResource.1(this, paramString1, paramString2));
  }
  
  public final void setReceiverAvatar(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "receiverAvatar");
    g().a((Function1)new TroopGiftComboView.setReceiverAvatar.1(this, paramBitmap));
  }
  
  public final void setSenderAvatar(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "senderAvatar");
    g().a((Function1)new TroopGiftComboView.setSenderAvatar.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView
 * JD-Core Version:    0.7.0.1
 */