package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView$loadGiftImage$1", "Lcom/tencent/mobileqq/qqgift/callback/service/IQQGiftListCallback;", "onFailed", "", "errCode", "", "errMsg", "", "onReceive", "giftList", "", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SendGiftMessageBaseItemView$loadGiftImage$1
  implements IQQGiftListCallback
{
  SendGiftMessageBaseItemView$loadGiftImage$1(int paramInt, IQQGiftSDK paramIQQGiftSDK) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGiftList#onFailed errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; errMsg: ");
    localStringBuilder.append(paramString);
    Logger.c("SendGiftMessageBaseItemView", localStringBuilder.toString());
  }
  
  public void a(@Nullable List<GiftServiceData> paramList)
  {
    if (this.b != SendGiftMessageBaseItemView.a(this.a)) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramList != null)
    {
      localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramList = ((Iterator)localObject1).next();
        int i;
        if (((GiftServiceData)paramList).a == this.b) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label81;
        }
      }
      paramList = null;
      label81:
      paramList = (GiftServiceData)paramList;
      localObject1 = localObject2;
      if (paramList != null) {
        localObject1 = Integer.valueOf(paramList.g);
      }
    }
    if (localObject1 == null)
    {
      Logger.c("SendGiftMessageBaseItemView", "materialID is null");
      return;
    }
    SendGiftMessageBaseItemView.a(this.a, this.b, ((Integer)localObject1).intValue(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView.loadGiftImage.1
 * JD-Core Version:    0.7.0.1
 */