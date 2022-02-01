package com.tencent.timi.game.initer.impl;

import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/initer/impl/GiftSdkInitManager$preloadGiftRes$1", "Lcom/tencent/mobileqq/qqgift/callback/service/IQQGiftListCallback;", "onFailed", "", "errCode", "", "errMsg", "", "onReceive", "giftList", "", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftSdkInitManager$preloadGiftRes$1
  implements IQQGiftListCallback
{
  GiftSdkInitManager$preloadGiftRes$1(IQQGiftSDK paramIQQGiftSDK) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadGiftRes#getGiftList#onFailed: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; ");
    localStringBuilder.append(paramString);
    Logger.c("GiftSdkInitManager", localStringBuilder.toString());
  }
  
  public void a(@Nullable List<GiftServiceData> paramList)
  {
    if (paramList == null) {
      Logger.c("GiftSdkInitManager", "preloadGiftRes#getGiftList#onReceive: giftList == null");
    }
    if (paramList != null)
    {
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add(Integer.valueOf(((GiftServiceData)((Iterator)localObject).next()).g));
      }
      paramList = CollectionsKt.toIntArray((Collection)paramList);
      if (paramList != null) {
        this.a.g().a(paramList, (IQQGiftResourceDownloadCallback)new GiftSdkInitManager.preloadGiftRes.1.onReceive.1());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.GiftSdkInitManager.preloadGiftRes.1
 * JD-Core Version:    0.7.0.1
 */