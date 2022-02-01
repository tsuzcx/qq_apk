package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/GiftResourceManager;", "", "()V", "TAG", "", "callbackMap", "", "", "", "Lcom/tencent/timi/game/gift/impl/timi/GiftResourceManager$IGiftResourceListener;", "getCacheList", "", "businessId", "getGiftServiceDataList", "getSDK", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftSDK;", "notifyListener", "giftServiceData", "", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "registerListener", "listener", "unregisterListener", "IGiftResourceListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftResourceManager
{
  public static final GiftResourceManager a = new GiftResourceManager();
  private static final Map<Integer, List<GiftResourceManager.IGiftResourceListener>> b = (Map)new LinkedHashMap();
  
  private final void a(int paramInt, List<? extends GiftServiceData> paramList)
  {
    Object localObject = (List)b.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((GiftResourceManager.IGiftResourceListener)((Iterator)localObject).next()).a(paramList);
      }
    }
  }
  
  private final IQQGiftSDK b(int paramInt)
  {
    IQQGiftSDK localIQQGiftSDK = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localIQQGiftSDK, "giftSDK");
    if ((localIQQGiftSDK.a()) && (!localIQQGiftSDK.k())) {
      return localIQQGiftSDK;
    }
    Logger.c("GiftResourceManager", "giftSDK not inited or has destroyed");
    return null;
  }
  
  public final void a(int paramInt)
  {
    GiftListData localGiftListData = new GiftListData(1, String.valueOf(paramInt), "", "");
    Object localObject = b(paramInt);
    if (localObject != null)
    {
      localObject = ((IQQGiftSDK)localObject).d();
      if (localObject != null) {
        ((IQQGiftServiceModule)localObject).a(localGiftListData, (IQQGiftListCallback)new GiftResourceManager.getCacheList.1(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.GiftResourceManager
 * JD-Core Version:    0.7.0.1
 */