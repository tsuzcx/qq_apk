package com.tencent.mobileqq.ecshop.ad.api.impl;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/ad/api/impl/EcshopAdApiImpl;", "Lcom/tencent/mobileqq/ecshop/ad/api/IEcshopAdApi;", "()V", "bindViewForGdtReport", "", "app", "Lcom/tencent/common/app/AppInterface;", "message", "Lcom/tencent/mobileqq/data/ChatMessage;", "result", "Landroid/view/View;", "getAdSourceView", "", "context", "Landroid/content/Context;", "Lcom/tencent/mobileqq/data/MessageRecord;", "textView", "Landroid/widget/TextView;", "sourceAd", "", "getAdSourceViewWithName", "adSourceName", "adSourceMenu", "getEcshopAdHandlerClassName", "rebuildReportParam", "Lcom/tencent/mobileqq/ecshop/ad/IEcshopAdHandler$ReportInfo;", "info", "updateRequestInterval", "millis", "", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class EcshopAdApiImpl
  implements IEcshopAdApi
{
  public void bindViewForGdtReport(@NotNull AppInterface paramAppInterface, @NotNull ChatMessage paramChatMessage, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramChatMessage, "message");
    Intrinsics.checkParameterIsNotNull(paramView, "result");
    EcshopAdHandler.a(paramAppInterface, paramChatMessage, paramView);
  }
  
  public boolean getAdSourceView(@NotNull Context paramContext, @Nullable MessageRecord paramMessageRecord, @Nullable TextView paramTextView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new EcshopAdViewHelper().a(paramContext, paramMessageRecord, paramTextView, paramString);
  }
  
  @NotNull
  public View getAdSourceViewWithName(@NotNull Context paramContext, @NotNull MessageRecord paramMessageRecord, @Nullable String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "message");
    paramContext = new EcshopAdViewHelper().a(paramContext, paramMessageRecord, paramString1, paramString2);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "EcshopAdViewHelper().get…SourceName, adSourceMenu)");
    return paramContext;
  }
  
  @NotNull
  public String getEcshopAdHandlerClassName()
  {
    String str = EcshopAdHandler.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "EcshopAdHandler::class.java.name");
    return str;
  }
  
  @NotNull
  public IEcshopAdHandler.ReportInfo rebuildReportParam(@NotNull IEcshopAdHandler.ReportInfo paramReportInfo, @Nullable MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramReportInfo, "info");
    paramReportInfo = EcshopAdHandler.a(paramReportInfo, paramMessageRecord);
    Intrinsics.checkExpressionValueIsNotNull(paramReportInfo, "EcshopAdHandler.rebuildReportParam(info, message)");
    return paramReportInfo;
  }
  
  public void updateRequestInterval(int paramInt)
  {
    if (EcshopAdHandler.a < paramInt) {
      EcshopAdHandler.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.api.impl.EcshopAdApiImpl
 * JD-Core Version:    0.7.0.1
 */