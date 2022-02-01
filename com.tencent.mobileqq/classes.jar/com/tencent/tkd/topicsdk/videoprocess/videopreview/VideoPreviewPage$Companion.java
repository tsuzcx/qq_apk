package com.tencent.tkd.topicsdk.videoprocess.videopreview;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videopreview/VideoPreviewPage$Companion;", "", "()V", "TAG", "", "open", "", "context", "Landroid/content/Context;", "path", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoPreviewPage$Companion
{
  public final void a(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Bundle localBundle = new Bundle();
    localBundle.putString("video_url", paramString);
    TopicSDKHelperKt.a(paramContext, VideoPreviewPage.class, localBundle, null, null, 24, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videopreview.VideoPreviewPage.Companion
 * JD-Core Version:    0.7.0.1
 */