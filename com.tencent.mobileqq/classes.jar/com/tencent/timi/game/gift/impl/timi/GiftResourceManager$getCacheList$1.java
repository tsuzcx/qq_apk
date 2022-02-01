package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.timi.game.utils.Logger;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/timi/GiftResourceManager$getCacheList$1", "Lcom/tencent/mobileqq/qqgift/callback/service/IQQGiftListCallback;", "onFailed", "", "errCode", "", "errMsg", "", "onReceive", "giftList", "", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftResourceManager$getCacheList$1
  implements IQQGiftListCallback
{
  GiftResourceManager$getCacheList$1(int paramInt) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGiftList#onFailed businessId: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("; errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; errMsg: ");
    localStringBuilder.append(paramString);
    Logger.c("GiftResourceManager", localStringBuilder.toString());
  }
  
  public void a(@Nullable List<GiftServiceData> paramList)
  {
    Collection localCollection = (Collection)paramList;
    int i;
    if ((localCollection != null) && (!localCollection.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      Logger.c("GiftResourceManager", "getGiftList#onReceive empty");
      return;
    }
    GiftResourceManager.a(GiftResourceManager.a, this.a, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.GiftResourceManager.getCacheList.1
 * JD-Core Version:    0.7.0.1
 */