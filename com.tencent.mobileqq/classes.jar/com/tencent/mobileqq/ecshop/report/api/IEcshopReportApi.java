package com.tencent.mobileqq.ecshop.report.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/report/api/IEcshopReportApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doArrivalArkReport", "", "record", "Lcom/tencent/mobileqq/data/MessageRecord;", "doArrivalReport", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "doClickReport", "index", "", "isReportForClick", "", "reportForClick", "", "report", "opName", "reportArkShow", "chatMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "metaList", "reportEcshopTo644", "opType", "d2", "d1", "reportEcshopToBeacon", "reportSetTopOrCancleSetTop", "uinType", "uin", "isSetTop", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IEcshopReportApi
  extends QRouteApi
{
  public abstract void doArrivalArkReport(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void doArrivalReport(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @Nullable MessageRecord paramMessageRecord);
  
  public abstract void doClickReport(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @Nullable MessageRecord paramMessageRecord, int paramInt);
  
  public abstract boolean isReportForClick(@Nullable String paramString);
  
  public abstract void report(@Nullable String paramString);
  
  public abstract void reportArkShow(@Nullable ChatMessage paramChatMessage, @Nullable String paramString);
  
  public abstract void reportEcshopTo644(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4);
  
  public abstract void reportEcshopToBeacon(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4);
  
  public abstract void reportSetTopOrCancleSetTop(int paramInt, @NotNull String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi
 * JD-Core Version:    0.7.0.1
 */