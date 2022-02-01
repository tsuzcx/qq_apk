package com.tencent.timi.game.gift.impl.sdk;

import android.content.Context;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/IQQGiftAnimationEngine;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class GiftSdkProvider$animationEngine$2
  extends Lambda
  implements Function0<IQQGiftAnimationEngine>
{
  GiftSdkProvider$animationEngine$2(GiftSdkProvider paramGiftSdkProvider)
  {
    super(0);
  }
  
  public final IQQGiftAnimationEngine invoke()
  {
    Object localObject = GiftSdkProvider.a(this.this$0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qqSdk");
    localObject = ((IQQGiftSDK)localObject).e().a((Context)GiftSdkProvider.b(this.this$0));
    ((IQQGiftAnimationEngine)localObject).a();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.sdk.GiftSdkProvider.animationEngine.2
 * JD-Core Version:    0.7.0.1
 */