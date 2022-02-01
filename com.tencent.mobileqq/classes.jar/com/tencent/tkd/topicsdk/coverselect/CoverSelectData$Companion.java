package com.tencent.tkd.topicsdk.coverselect;

import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.CaptureVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData$Companion;", "", "()V", "build", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "displayItem", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectData$Companion
{
  @NotNull
  public final CoverSelectData a(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "displayItem");
    CoverSelectData localCoverSelectData = new CoverSelectData();
    localCoverSelectData.setSelectMode(0);
    localCoverSelectData.setCoverFrom(paramDisplayItem.getFromPage());
    localCoverSelectData.setInitialProgress(paramDisplayItem.getInitialProgress());
    localCoverSelectData.setCoverPath(paramDisplayItem.getCoverPath());
    localCoverSelectData.setVideoPath(paramDisplayItem.getRealPath());
    localCoverSelectData.setVideoWidth(paramDisplayItem.getMedia().getWidth());
    localCoverSelectData.setVideoHeight(paramDisplayItem.getMedia().getHeight());
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = new VideoCaptureView.CaptureVideoInfo(paramDisplayItem.getMedia().getFilePath());
    localCaptureVideoInfo.a(0);
    localCaptureVideoInfo.b((int)paramDisplayItem.getMergeDuration());
    localCoverSelectData.setCaptureVideoInfo(localCaptureVideoInfo);
    return localCoverSelectData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectData.Companion
 * JD-Core Version:    0.7.0.1
 */