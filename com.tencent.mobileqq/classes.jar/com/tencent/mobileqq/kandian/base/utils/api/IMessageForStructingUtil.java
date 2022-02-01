package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IMessageForStructingUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getArticleId", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "getReportEventFolderStatusValue", "getStructingMsg", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IMessageForStructingUtil
  extends QRouteApi
{
  @Nullable
  public abstract String getArticleId(@NotNull MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract String getReportEventFolderStatusValue(@NotNull MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract Object getStructingMsg(@NotNull MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IMessageForStructingUtil
 * JD-Core Version:    0.7.0.1
 */