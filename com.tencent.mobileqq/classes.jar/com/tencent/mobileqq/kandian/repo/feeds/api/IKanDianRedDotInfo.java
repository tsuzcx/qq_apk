package com.tencent.mobileqq.kandian.repo.feeds.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/api/IKanDianRedDotInfo;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createRedDotFromMessageRecord", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "type", "", "getKanDianRedDotFromDisk", "accountRelated", "", "getMessageRecordFromData", "msgData", "", "getRowKeyFromMessageRecord", "removeKanDianRedDotInfoFromDiskAsync", "", "saveKanDianRedDotInfoToDiskAsync", "obj", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianRedDotInfo
  extends QRouteApi
{
  @NotNull
  public abstract Object createRedDotFromMessageRecord(@NotNull MessageRecord paramMessageRecord, @NotNull String paramString);
  
  @Nullable
  public abstract Object getKanDianRedDotFromDisk(@NotNull String paramString, boolean paramBoolean);
  
  @NotNull
  public abstract MessageRecord getMessageRecordFromData(@NotNull byte[] paramArrayOfByte, @NotNull String paramString);
  
  @NotNull
  public abstract String getRowKeyFromMessageRecord(@NotNull byte[] paramArrayOfByte, @NotNull String paramString);
  
  public abstract void removeKanDianRedDotInfoFromDiskAsync(@NotNull String paramString, boolean paramBoolean);
  
  public abstract void saveKanDianRedDotInfoToDiskAsync(@NotNull String paramString, @NotNull KandianRedDotInfo paramKandianRedDotInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.api.IKanDianRedDotInfo
 * JD-Core Version:    0.7.0.1
 */