package com.tencent.mobileqq.kandian.repo.feeds.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.api.IKanDianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/impl/KanDianRedDotInfoImpl;", "Lcom/tencent/mobileqq/kandian/repo/feeds/api/IKanDianRedDotInfo;", "()V", "createRedDotFromMessageRecord", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "type", "", "getKanDianRedDotFromDisk", "accountRelated", "", "getMessageRecordFromData", "msgData", "", "getRowKeyFromMessageRecord", "removeKanDianRedDotInfoFromDiskAsync", "", "saveKanDianRedDotInfoToDiskAsync", "obj", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianRedDotInfoImpl
  implements IKanDianRedDotInfo
{
  @NotNull
  public Object createRedDotFromMessageRecord(@NotNull MessageRecord paramMessageRecord, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    paramMessageRecord = RIJKanDianRedDotUtils.a(paramMessageRecord, paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "RIJKanDianRedDotUtils.cr…omMessageRecord(mr, type)");
    return paramMessageRecord;
  }
  
  @Nullable
  public Object getKanDianRedDotFromDisk(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    return RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), paramString, paramBoolean);
  }
  
  @NotNull
  public MessageRecord getMessageRecordFromData(@NotNull byte[] paramArrayOfByte, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "msgData");
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    paramArrayOfByte = RIJKanDianRedDotUtils.b(paramArrayOfByte, paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "RIJKanDianRedDotUtils.pa…rdFromData(msgData, type)");
    return paramArrayOfByte;
  }
  
  @NotNull
  public String getRowKeyFromMessageRecord(@NotNull byte[] paramArrayOfByte, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "msgData");
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    paramArrayOfByte = RIJKanDianRedDotUtils.a(paramArrayOfByte, paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "RIJKanDianRedDotUtils.ge…sageRecord(msgData, type)");
    return paramArrayOfByte;
  }
  
  public void removeKanDianRedDotInfoFromDiskAsync(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    RIJSPUtils.a(paramString, paramBoolean);
  }
  
  public void saveKanDianRedDotInfoToDiskAsync(@NotNull String paramString, @NotNull KandianRedDotInfo paramKandianRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    Intrinsics.checkParameterIsNotNull(paramKandianRedDotInfo, "obj");
    RIJSPUtils.a(paramString, paramKandianRedDotInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.impl.KanDianRedDotInfoImpl
 * JD-Core Version:    0.7.0.1
 */