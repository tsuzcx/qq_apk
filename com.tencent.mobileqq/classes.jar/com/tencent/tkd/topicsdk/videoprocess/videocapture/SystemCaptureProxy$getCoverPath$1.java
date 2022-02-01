package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.ucrop.callback.BitmapCropCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/SystemCaptureProxy$getCoverPath$1", "Lcom/tencent/tkd/topicsdk/ucrop/callback/BitmapCropCallback;", "onBitmapCropped", "", "filePath", "", "onCropFailure", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SystemCaptureProxy$getCoverPath$1
  implements BitmapCropCallback
{
  SystemCaptureProxy$getCoverPath$1(Function1 paramFunction1) {}
  
  public void a()
  {
    String str = AppContext.a.a().getResources().getString(R.string.R);
    Intrinsics.checkExpressionValueIsNotNull(str, "AppContext.instance.reso…g.tips_image_crop_failed)");
    TopicSDKHelperKt.a(str, true, null, 4, null);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    this.a.invoke(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SystemCaptureProxy.getCoverPath.1
 * JD-Core Version:    0.7.0.1
 */