package com.tencent.mobileqq.ecshop.view.api;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.PromotionConfBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/api/IEcshopRainViewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addRainView", "", "contentView", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "getMsgPromotion", "", "adInfoJson", "", "handlePreload", "record", "Lcom/tencent/mobileqq/data/MessageRecord;", "isInPromotionTime", "", "confBean", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$PromotionConfBean;", "message", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopRainViewApi
  extends QRouteApi
{
  public abstract void addRainView(@NotNull RelativeLayout paramRelativeLayout, @NotNull Context paramContext);
  
  public abstract int getMsgPromotion(@Nullable String paramString);
  
  public abstract void handlePreload(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean isInPromotionTime(@NotNull EcshopConfBean.PromotionConfBean paramPromotionConfBean, @NotNull MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.api.IEcshopRainViewApi
 * JD-Core Version:    0.7.0.1
 */