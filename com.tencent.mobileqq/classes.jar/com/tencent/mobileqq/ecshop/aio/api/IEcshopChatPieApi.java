package com.tencent.mobileqq.ecshop.aio.api;

import android.content.Intent;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieCallback;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieDelegate;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/aio/api/IEcshopChatPieApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createEcshopChatPie", "Lcom/tencent/mobileqq/ecshop/aio/IEcshopChatPieDelegate;", "intent", "Landroid/content/Intent;", "callback", "Lcom/tencent/mobileqq/ecshop/aio/IEcshopChatPieCallback;", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopChatPieApi
  extends QRouteApi
{
  @NotNull
  public abstract IEcshopChatPieDelegate createEcshopChatPie(@NotNull Intent paramIntent, @NotNull IEcshopChatPieCallback paramIEcshopChatPieCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.aio.api.IEcshopChatPieApi
 * JD-Core Version:    0.7.0.1
 */