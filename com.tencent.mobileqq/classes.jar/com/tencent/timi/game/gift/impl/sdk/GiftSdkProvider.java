package com.tencent.timi.game.gift.impl.sdk;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/sdk/GiftSdkProvider;", "", "businessId", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "panelStyle", "(ILcom/tencent/mobileqq/app/QBaseActivity;I)V", "animationEngine", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/IQQGiftAnimationEngine;", "getAnimationEngine", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/IQQGiftAnimationEngine;", "animationEngine$delegate", "Lkotlin/Lazy;", "giftResDownloadModule", "Lcom/tencent/mobileqq/qqgift/api/service/IQQGiftResDownloadModule;", "getGiftResDownloadModule", "()Lcom/tencent/mobileqq/qqgift/api/service/IQQGiftResDownloadModule;", "giftServerModule", "Lcom/tencent/mobileqq/qqgift/api/service/IQQGiftServiceModule;", "getGiftServerModule", "()Lcom/tencent/mobileqq/qqgift/api/service/IQQGiftServiceModule;", "giftViewModule", "Lcom/tencent/mobileqq/qqgift/api/view/IQQGiftViewModule;", "getGiftViewModule", "()Lcom/tencent/mobileqq/qqgift/api/view/IQQGiftViewModule;", "qqSdk", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftSDK;", "kotlin.jvm.PlatformType", "destroySdk", "", "isSdkDestroy", "", "generateGiftPanel", "Lcom/tencent/mobileqq/qqgift/mvvm/business/view/IQQGiftPanelView;", "resetAnimationEngine", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftSdkProvider
{
  private final IQQGiftSDK a;
  @NotNull
  private final Lazy b;
  @NotNull
  private final IQQGiftServiceModule c;
  @NotNull
  private final IQQGiftViewModule d;
  @NotNull
  private final IQQGiftResDownloadModule e;
  private final QBaseActivity f;
  private final int g;
  
  public GiftSdkProvider(int paramInt1, @NotNull QBaseActivity paramQBaseActivity, int paramInt2)
  {
    this.f = paramQBaseActivity;
    this.g = paramInt2;
    this.a = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(paramInt1);
    this.b = LazyKt.lazy((Function0)new GiftSdkProvider.animationEngine.2(this));
    paramQBaseActivity = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "qqSdk");
    paramQBaseActivity = paramQBaseActivity.d();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "qqSdk.serviceModule");
    this.c = paramQBaseActivity;
    paramQBaseActivity = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "qqSdk");
    paramQBaseActivity = paramQBaseActivity.e();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "qqSdk.viewModule");
    this.d = paramQBaseActivity;
    paramQBaseActivity = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "qqSdk");
    paramQBaseActivity = paramQBaseActivity.g();
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "qqSdk.resModule");
    this.e = paramQBaseActivity;
  }
  
  @NotNull
  public final IQQGiftAnimationEngine a()
  {
    return (IQQGiftAnimationEngine)this.b.getValue();
  }
  
  public final void a(boolean paramBoolean)
  {
    a().c();
    IQQGiftSDK localIQQGiftSDK = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localIQQGiftSDK, "qqSdk");
    if (localIQQGiftSDK.k()) {
      this.a.j();
    }
  }
  
  @NotNull
  public final IQQGiftServiceModule b()
  {
    return this.c;
  }
  
  @NotNull
  public final IQQGiftResDownloadModule c()
  {
    return this.e;
  }
  
  @NotNull
  public final IQQGiftPanelView d()
  {
    Object localObject = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qqSdk");
    localObject = ((IQQGiftSDK)localObject).e().a(this.f, this.g);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qqSdk.viewModule.createG…nel(activity, panelStyle)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider
 * JD-Core Version:    0.7.0.1
 */