package com.tencent.tkd.topicsdk.coverselect;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.CaptureVideoInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectPage$Companion;", "", "()V", "BUNDLE_KEY_CAPTURE_END_PROGRESS", "", "BUNDLE_KEY_CAPTURE_START_PROGRESS", "BUNDLE_KEY_COVER_RATIO", "BUNDLE_KEY_FROM_PAGE", "BUNDLE_KEY_INITIAL_PROGRESS", "BUNDLE_KEY_RESULT_PATH", "BUNDLE_KEY_SEEK_VIDEO_POSITION", "BUNDLE_KEY_SELECT_MODE", "BUNDLE_KEY_VIDEO_PATH", "MODE_SHOW_BOTH", "", "MODE_SHOW_CAPTURE", "MODE_SHOW_GALLERY", "TAB_CAPTURE_POSITION", "TAB_GALLERY_POSITION", "TAG", "open", "", "activity", "Landroid/app/Activity;", "requestCode", "coverSelectData", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectPage$Companion
{
  public final void a(@NotNull Activity paramActivity, int paramInt, @NotNull CoverSelectData paramCoverSelectData)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramCoverSelectData, "coverSelectData");
    Bundle localBundle = new Bundle();
    localBundle.putInt("from_page", paramCoverSelectData.getCoverFrom());
    localBundle.putInt("select_mode", paramCoverSelectData.getSelectMode());
    localBundle.putString("cover_path", paramCoverSelectData.getCoverPath());
    localBundle.putInt("video_width", paramCoverSelectData.getVideoWidth());
    localBundle.putInt("video_height", paramCoverSelectData.getVideoHeight());
    float f = paramCoverSelectData.getCoverRatio();
    int i = 0;
    if (f > 0) {
      localBundle.putFloat("cover_ratio", paramCoverSelectData.getCoverRatio());
    }
    localBundle.putString("video_path", paramCoverSelectData.getVideoPath());
    localBundle.putFloat("initial_progress", paramCoverSelectData.getInitialProgress());
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = paramCoverSelectData.getCaptureVideoInfo();
    if (localCaptureVideoInfo != null) {
      i = localCaptureVideoInfo.a();
    }
    localBundle.putInt("capture_start_progress", i);
    localCaptureVideoInfo = paramCoverSelectData.getCaptureVideoInfo();
    if (localCaptureVideoInfo != null) {
      i = localCaptureVideoInfo.b();
    } else {
      i = 2147483647;
    }
    localBundle.putInt("capture_end_progress", i);
    localBundle.putSerializable("global_publisher_config", (Serializable)paramCoverSelectData.getGlobalPublisherConfig());
    TopicSDKHelperKt.a(paramActivity, CoverSelectPage.class, paramInt, localBundle, null, null, 48, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.Companion
 * JD-Core Version:    0.7.0.1
 */