package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import com.tencent.qcircle.tavcut.util.Logger;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class VideoImageExtractor$1
  implements CoverListener
{
  VideoImageExtractor$1(VideoImageExtractor paramVideoImageExtractor) {}
  
  public void onCover(int paramInt, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("generated Bitmap = ");
    localStringBuilder.append(paramBitmap.toString());
    Logger.i("Cover", localStringBuilder.toString());
    VideoImageExtractor.access$000(this.this$0).add(paramBitmap);
    VideoImageExtractor.access$100(this.this$0).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.cover.VideoImageExtractor.1
 * JD-Core Version:    0.7.0.1
 */