package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftLayerView;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "giftBannerContainer", "giftBannerContainerHeight", "giftBannerViewHolderHeight", "giftFullScreenEffectContainer", "giftLayerHeight", "giftPanelHeight", "giftSdkProvider", "Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "isGiftBannerAdded", "", "isGiftEffectAdded", "isGiftPanelAdded", "adjustGiftBanner", "", "dismissGiftPanel", "ensureGiftBannerAdded", "ensureGiftEffectAdded", "ensureGiftPanelAdded", "init", "provider", "setGiftBannerViewHolder", "giftBannerViewHolder", "Landroid/view/View;", "setGiftPanelView", "giftPanelView", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftLayerView
  extends FrameLayout
{
  public static final TimiGiftLayerView.Companion a = new TimiGiftLayerView.Companion(null);
  private final FrameLayout b = new FrameLayout(getContext());
  private final FrameLayout c = new FrameLayout(getContext());
  private boolean d;
  private boolean e;
  private GiftSdkProvider f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  @JvmOverloads
  public TimiGiftLayerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TimiGiftLayerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TimiGiftLayerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = (View)this.c;
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 48;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = (View)this.b;
    paramAttributeSet = new FrameLayout.LayoutParams(-1, LayoutExKt.b(350));
    paramAttributeSet.gravity = 80;
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    post((Runnable)new TimiGiftLayerView.3(this));
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.g == paramInt1) && (this.h == paramInt2) && (this.i == paramInt3) && (this.j == paramInt4)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustGiftBanner# giftLayerHeight: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" giftBannerViewHolderHeight： ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" giftBannerContainerHeight: ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" giftPanelHeight: ");
    localStringBuilder.append(paramInt4);
    Logger.c("TimiGiftLayerView", localStringBuilder.toString());
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramInt4;
    paramInt2 = paramInt1 - paramInt2;
    paramInt1 -= paramInt4;
    if (paramInt4 == 0)
    {
      this.c.setTranslationY(paramInt2);
      return;
    }
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      if (paramInt1 - paramInt2 < paramInt3)
      {
        this.c.setTranslationY(paramInt1 - paramInt3);
        return;
      }
      this.c.setTranslationY(paramInt2);
    }
  }
  
  private final void b()
  {
    if (this.e) {
      return;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      this.e = true;
      localObject = ((GiftSdkProvider)localObject).a().e();
      this.b.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
  }
  
  public final void a()
  {
    if (this.d) {
      return;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      this.d = true;
      localObject = ((GiftSdkProvider)localObject).a().f();
      this.c.addView((View)localObject, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    this.c.post((Runnable)new TimiGiftLayerView.ensureGiftBannerAdded.2(this));
  }
  
  public final void a(@Nullable GiftSdkProvider paramGiftSdkProvider)
  {
    this.f = paramGiftSdkProvider;
    a();
    b();
  }
  
  public final void setGiftBannerViewHolder(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "giftBannerViewHolder");
    paramView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new TimiGiftLayerView.setGiftBannerViewHolder.1(this, paramView));
  }
  
  public final void setGiftPanelView(@Nullable View paramView)
  {
    if (paramView == null)
    {
      a(this.g, this.h, this.i, 0);
      return;
    }
    paramView.post((Runnable)new TimiGiftLayerView.setGiftPanelView.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftLayerView
 * JD-Core Version:    0.7.0.1
 */