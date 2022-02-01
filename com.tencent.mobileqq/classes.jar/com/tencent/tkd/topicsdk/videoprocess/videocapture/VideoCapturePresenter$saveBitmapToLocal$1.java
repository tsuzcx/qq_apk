package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCapturePresenter$saveBitmapToLocal$1
  extends Lambda
  implements Function0<Unit>
{
  VideoCapturePresenter$saveBitmapToLocal$1(VideoCapturePresenter paramVideoCapturePresenter, String paramString, Bitmap paramBitmap)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (FileUtils.a.a(this.$relativePath))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveBitmapToLocal: ");
      ((StringBuilder)localObject).append(this.$relativePath);
      ((StringBuilder)localObject).append(" is existed.");
      Log.d("VideoCapturePresenter", ((StringBuilder)localObject).toString());
      ThreadManagerKt.a((Function0)new VideoCapturePresenter.saveBitmapToLocal.1.1(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveBitmapToLocal: ");
    ((StringBuilder)localObject).append(this.$relativePath);
    ((StringBuilder)localObject).append(" is not existed.");
    Log.d("VideoCapturePresenter", ((StringBuilder)localObject).toString());
    localObject = new SavePicTask(this.$resultBitmap, this.$relativePath);
    ((SavePicTask)localObject).a((SavePicTask.DownloadListener)new VideoCapturePresenter.saveBitmapToLocal.1..special..inlined.apply.lambda.1(this));
    ((SavePicTask)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.saveBitmapToLocal.1
 * JD-Core Version:    0.7.0.1
 */