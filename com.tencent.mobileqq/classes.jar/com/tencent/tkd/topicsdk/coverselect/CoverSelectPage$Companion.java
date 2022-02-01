package com.tencent.tkd.topicsdk.coverselect;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectPage$Companion;", "", "()V", "BUNDLE_KEY_FROM_PAGE", "", "BUNDLE_KEY_RESULT_PATH", "TAB_CAPTURE_POSITION", "", "TAB_GALLERY_POSITION", "TAG", "open", "", "activity", "Landroid/app/Activity;", "requestCode", "coverSelectData", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectPage$Companion
{
  public final void a(@NotNull Activity paramActivity, int paramInt, @NotNull CoverSelectData paramCoverSelectData)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramCoverSelectData, "coverSelectData");
    Bundle localBundle = new Bundle();
    localBundle.putInt("from_page", paramCoverSelectData.getCoverFrom());
    localBundle.putFloat("initial_progress", paramCoverSelectData.getInitialProgress());
    localBundle.putString("cover_path", paramCoverSelectData.getCoverPath());
    localBundle.putString("video_path", paramCoverSelectData.getVideoPath());
    localBundle.putInt("video_width", paramCoverSelectData.getVideoWidth());
    localBundle.putInt("video_height", paramCoverSelectData.getVideoHeight());
    TopicSDKHelperKt.a(paramActivity, CoverSelectPage.class, paramInt, localBundle, null, null, 48, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.Companion
 * JD-Core Version:    0.7.0.1
 */