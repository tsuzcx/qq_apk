package com.tencent.mobileqq.ecshop.ad.api;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/ad/api/IEcshopAdApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bindViewForGdtReport", "", "app", "Lcom/tencent/common/app/AppInterface;", "message", "Lcom/tencent/mobileqq/data/ChatMessage;", "result", "Landroid/view/View;", "getAdSourceView", "", "context", "Landroid/content/Context;", "Lcom/tencent/mobileqq/data/MessageRecord;", "textView", "Landroid/widget/TextView;", "sourceAd", "", "getAdSourceViewWithName", "adSourceName", "adSourceMenu", "getEcshopAdHandlerClassName", "rebuildReportParam", "Lcom/tencent/mobileqq/ecshop/ad/IEcshopAdHandler$ReportInfo;", "info", "updateRequestInterval", "millis", "", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopAdApi
  extends QRouteApi
{
  public abstract void bindViewForGdtReport(@NotNull AppInterface paramAppInterface, @NotNull ChatMessage paramChatMessage, @NotNull View paramView);
  
  public abstract boolean getAdSourceView(@NotNull Context paramContext, @Nullable MessageRecord paramMessageRecord, @Nullable TextView paramTextView, @Nullable String paramString);
  
  @NotNull
  public abstract View getAdSourceViewWithName(@NotNull Context paramContext, @NotNull MessageRecord paramMessageRecord, @Nullable String paramString1, @Nullable String paramString2);
  
  @NotNull
  public abstract String getEcshopAdHandlerClassName();
  
  @NotNull
  public abstract IEcshopAdHandler.ReportInfo rebuildReportParam(@NotNull IEcshopAdHandler.ReportInfo paramReportInfo, @Nullable MessageRecord paramMessageRecord);
  
  public abstract void updateRequestInterval(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi
 * JD-Core Version:    0.7.0.1
 */