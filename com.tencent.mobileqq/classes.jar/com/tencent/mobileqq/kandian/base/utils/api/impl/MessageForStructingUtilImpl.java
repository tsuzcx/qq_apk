package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.api.IMessageForStructingUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/MessageForStructingUtilImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IMessageForStructingUtil;", "()V", "getArticleId", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "getReportEventFolderStatusValue", "getStructingMsg", "Lcom/tencent/mobileqq/structmsg/AbsStructMsg;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class MessageForStructingUtilImpl
  implements IMessageForStructingUtil
{
  @Nullable
  public String getArticleId(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    paramMessageRecord = getStructingMsg(paramMessageRecord);
    if (paramMessageRecord != null) {
      return paramMessageRecord.mArticleIds;
    }
    return null;
  }
  
  @Nullable
  public String getReportEventFolderStatusValue(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    paramMessageRecord = getStructingMsg(paramMessageRecord);
    if (paramMessageRecord != null) {
      return paramMessageRecord.reportEventFolderStatusValue;
    }
    return null;
  }
  
  @Nullable
  public AbsStructMsg getStructingMsg(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    boolean bool = paramMessageRecord instanceof MessageForStructing;
    Object localObject = null;
    if (!bool) {
      paramMessageRecord = null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    paramMessageRecord = localObject;
    if (localMessageForStructing != null) {
      paramMessageRecord = localMessageForStructing.structingMsg;
    }
    return paramMessageRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.MessageForStructingUtilImpl
 * JD-Core Version:    0.7.0.1
 */