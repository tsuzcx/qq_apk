package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.timi.game.gift.api.OnSelectGiftToUserListener;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.gift.impl.receiver.IReceiverCore;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/gift/impl/timi/TimiGiftController$panelEventListener$1$onPanelItemSelected$1", "Lcom/tencent/mobileqq/qqgift/callback/IQQGiftPanelResDownloadCallback;", "onLoadFail", "", "id", "", "errorCode", "httpCode", "errorMessage", "", "onLoadSuccess", "panelResource", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "onProgress", "progress", "", "progressMax", "progressRate", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftController$panelEventListener$1$onPanelItemSelected$1
  implements IQQGiftPanelResDownloadCallback
{
  public void a(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorCode: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("; errorMessage: ");
    localStringBuilder.append(paramString);
    Logger.c("TimiGiftPresenter", localStringBuilder.toString());
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, @Nullable QQGiftPanelResource paramQQGiftPanelResource)
  {
    Object localObject1 = this.a.a;
    if (paramQQGiftPanelResource != null)
    {
      paramQQGiftPanelResource = paramQQGiftPanelResource.b;
      if (paramQQGiftPanelResource != null)
      {
        TimiGiftController.a((TimiGiftController)localObject1, paramQQGiftPanelResource);
        paramQQGiftPanelResource = TimiGiftController.c(this.a.a);
        if (paramQQGiftPanelResource != null)
        {
          Object localObject2 = (Iterable)TimiGiftController.d(this.a.a).a();
          localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(((ReceiverInfoModel)((Iterator)localObject2).next()).a());
          }
          paramQQGiftPanelResource.a((List)localObject1, TimiGiftController.e(this.a.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftController.panelEventListener.1.onPanelItemSelected.1
 * JD-Core Version:    0.7.0.1
 */