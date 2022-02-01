package com.tencent.timi.game.initer.impl;

import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/initer/impl/GiftSdkInitManager;", "", "()V", "TAG", "", "qqGiftManager", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftManager;", "getQqGiftManager", "()Lcom/tencent/mobileqq/qqgift/api/IQQGiftManager;", "destroySdk", "", "businessId", "", "getSecretKey", "initGiftSdk", "preloadGiftRes", "giftSdk", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftSDK;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftSdkInitManager
{
  public static final GiftSdkInitManager a = new GiftSdkInitManager();
  
  private final IQQGiftManager a()
  {
    QRouteApi localQRouteApi = QRoute.api(IQQGiftManager.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IQQGiftManager::class.java)");
    return (IQQGiftManager)localQRouteApi;
  }
  
  private final void a(IQQGiftSDK paramIQQGiftSDK, int paramInt)
  {
    if (!ArraysKt.contains(new Integer[] { Integer.valueOf(10005), Integer.valueOf(10004), Integer.valueOf(10003) }, Integer.valueOf(paramInt))) {
      return;
    }
    GiftListData localGiftListData = new GiftListData(1, String.valueOf(paramInt), "", "");
    paramIQQGiftSDK.d().a(localGiftListData, (IQQGiftListCallback)new GiftSdkInitManager.preloadGiftRes.1(paramIQQGiftSDK));
  }
  
  private final String c(int paramInt)
  {
    if (paramInt != 10001)
    {
      if (paramInt != 10004)
      {
        if (paramInt != 10005) {
          return "3972178cd6bfbe11e7f3f54e7c3c623d";
        }
        return "8d9a9cd4e6fa29def6af5c4f448d8153";
      }
      return "d16a682ef7c2321aef85f422fdc1fefc";
    }
    return "2ba343368f5483089089ae290adf298f";
  }
  
  public final void a(int paramInt)
  {
    IQQGiftSDK localIQQGiftSDK = a().getSDKImpl(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localIQQGiftSDK, "giftSdk");
    if (!localIQQGiftSDK.a())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initGiftSdk businessId: ");
      ((StringBuilder)localObject).append(paramInt);
      Logger.c("GiftSdkInitManager", ((StringBuilder)localObject).toString());
      localObject = QQGiftSDKConfig.a().a(paramInt).a(c(paramInt)).a();
      localIQQGiftSDK.a(MobileQQ.sMobileQQ.waitAppRuntime(null), (QQGiftSDKConfig)localObject);
      localIQQGiftSDK.i().c();
      a(localIQQGiftSDK, paramInt);
    }
  }
  
  public final void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("try destroy businessId: ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.c("GiftSdkInitManager", ((StringBuilder)localObject).toString());
    localObject = a().getSDKImpl(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "giftSdk");
    if ((((IQQGiftSDK)localObject).a()) && (!((IQQGiftSDK)localObject).k()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy businessId: ");
      localStringBuilder.append(paramInt);
      Logger.c("GiftSdkInitManager", localStringBuilder.toString());
      ((IQQGiftSDK)localObject).j();
      ((IQQGiftSDK)localObject).i().d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.GiftSdkInitManager
 * JD-Core Version:    0.7.0.1
 */