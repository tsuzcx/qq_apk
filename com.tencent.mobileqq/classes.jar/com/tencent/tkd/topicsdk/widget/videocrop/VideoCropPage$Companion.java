package com.tencent.tkd.topicsdk.widget.videocrop;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoCropPage$Companion;", "", "()V", "BUNDLE_KEY_MAX_VIDEO_LENGTH", "", "BUNDLE_KEY_MERGE_PATH", "BUNDLE_KEY_MIN_VIDEO_LENGTH", "BUNDLE_KEY_VIDEO_PATH", "TAG", "openForResult", "", "context", "Landroid/app/Activity;", "videoPath", "minVideoLength", "", "maxVideoLength", "requestCode", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCropPage$Companion
{
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "videoPath");
    Bundle localBundle = new Bundle();
    localBundle.putString("video_path", paramString);
    localBundle.putInt("min_video_length", paramInt1);
    localBundle.putInt("max_video_length", paramInt2);
    TopicSDKHelperKt.a(paramActivity, VideoCropPage.class, paramInt3, localBundle, null, null, 48, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.Companion
 * JD-Core Version:    0.7.0.1
 */