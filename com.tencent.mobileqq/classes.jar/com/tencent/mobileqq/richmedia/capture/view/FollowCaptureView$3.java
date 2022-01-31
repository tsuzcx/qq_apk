package com.tencent.mobileqq.richmedia.capture.view;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.qphone.base.util.QLog;

class FollowCaptureView$3
  implements Runnable
{
  FollowCaptureView$3(FollowCaptureView paramFollowCaptureView) {}
  
  public void run()
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(FollowCaptureView.a(this.this$0).videoPath);
      FollowCaptureView.a(this.this$0, Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue());
      FollowCaptureView.b(this.this$0, Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue());
      Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(0L);
      this.this$0.queueEvent(new FollowCaptureView.3.1(this, localBitmap));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FollowCaptureView", 1, "get original video width and height error.", localException);
      return;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView.3
 * JD-Core Version:    0.7.0.1
 */