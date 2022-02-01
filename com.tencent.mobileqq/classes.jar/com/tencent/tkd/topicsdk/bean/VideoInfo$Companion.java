package com.tencent.tkd.topicsdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/VideoInfo$Companion;", "", "()V", "COVER_FROM_DEFAULT", "", "COVER_FROM_SELECT", "RETRY_TIME_LIMIT", "getRETRY_TIME_LIMIT", "()I", "setRETRY_TIME_LIMIT", "(I)V", "STATUS_FAILED", "getSTATUS_FAILED", "setSTATUS_FAILED", "STATUS_FINISH", "getSTATUS_FINISH", "setSTATUS_FINISH", "STATUS_IDLE", "getSTATUS_IDLE", "setSTATUS_IDLE", "STATUS_PAUSE", "getSTATUS_PAUSE", "setSTATUS_PAUSE", "STATUS_UPLOADING", "getSTATUS_UPLOADING", "setSTATUS_UPLOADING", "SUB_STATUS_COMPRESS_VIDEO", "getSUB_STATUS_COMPRESS_VIDEO", "setSUB_STATUS_COMPRESS_VIDEO", "SUB_STATUS_IDLE_VIDEO", "getSUB_STATUS_IDLE_VIDEO", "setSUB_STATUS_IDLE_VIDEO", "SUB_STATUS_UPLOADING_VIDEO", "getSUB_STATUS_UPLOADING_VIDEO", "setSUB_STATUS_UPLOADING_VIDEO", "serialVersionUID", "", "parseFromDisplayItem", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "item", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoInfo$Companion
{
  @NotNull
  public final VideoInfo a(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "item");
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.setFilePath(paramDisplayItem.getRealPath());
    localVideoInfo.setCoverPath(paramDisplayItem.getCoverPath());
    localVideoInfo.setDuration(paramDisplayItem.getRealDuration());
    localVideoInfo.setBackupCoverPath(paramDisplayItem.getBackupCoverPath());
    paramDisplayItem = paramDisplayItem.getMedia();
    localVideoInfo.setCoverWidth(paramDisplayItem.getWidth());
    localVideoInfo.setCoverHeight(paramDisplayItem.getHeight());
    localVideoInfo.setWidth(paramDisplayItem.getWidth());
    localVideoInfo.setHeight(paramDisplayItem.getHeight());
    localVideoInfo.setFileSize(paramDisplayItem.getSize());
    return localVideoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.VideoInfo.Companion
 * JD-Core Version:    0.7.0.1
 */