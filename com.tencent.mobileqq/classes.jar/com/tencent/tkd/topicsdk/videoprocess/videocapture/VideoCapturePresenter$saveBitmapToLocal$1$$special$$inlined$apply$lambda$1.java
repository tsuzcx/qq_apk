package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.util.Log;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter$saveBitmapToLocal$1$savePicTask$1$1", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/SavePicTask$DownloadListener;", "onFileDownloadFailed", "", "errorCode", "", "onFileDownloadStarted", "onFileDownloadSucceed", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter$saveBitmapToLocal$1$$special$$inlined$apply$lambda$1
  implements SavePicTask.DownloadListener
{
  VideoCapturePresenter$saveBitmapToLocal$1$$special$$inlined$apply$lambda$1(VideoCapturePresenter.saveBitmapToLocal.1 param1) {}
  
  public void a() {}
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePicTask succeed: ");
    localStringBuilder.append(this.a.$relativePath);
    localStringBuilder.append('.');
    Log.d("VideoCapturePresenter", localStringBuilder.toString());
    if (VideoCapturePresenter.a(this.a.this$0)) {
      VideoCapturePresenter.a(this.a.this$0, this.a.$relativePath);
    }
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePicTask failed: ");
    localStringBuilder.append(this.a.$relativePath);
    localStringBuilder.append('.');
    Log.e("VideoCapturePresenter", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.saveBitmapToLocal.1..special..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */