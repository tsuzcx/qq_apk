package com.tencent.mobileqq.kandian.biz.video;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class VideoExtractFrameTask$5
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  VideoExtractFrameTask$5(VideoExtractFrameTask paramVideoExtractFrameTask) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    VideoExtractFrameTask.FrameInfo localFrameInfo = (VideoExtractFrameTask.FrameInfo)VideoExtractFrameTask.a(this.a).get(Integer.valueOf(paramInt));
    if (localFrameInfo != null)
    {
      Object localObject;
      try
      {
        localFrameInfo.jdField_b_of_type_Long = VideoExtractFrameHash.a(paramBitmap, true);
      }
      catch (Throwable paramBitmap)
      {
        if (QLog.isColorLevel())
        {
          localObject = VideoExtractFrameTask.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("VideoExtractFrameHash.dctImageHash ERROR e = ");
          localStringBuilder.append(paramBitmap.getMessage());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
      }
      localFrameInfo.jdField_b_of_type_Int = VideoExtractFrameHash.a(localFrameInfo.a, localFrameInfo.jdField_b_of_type_Long);
      if (QLog.isColorLevel())
      {
        paramBitmap = VideoExtractFrameTask.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onExtractFrame frameIndex = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", localHash = ");
        ((StringBuilder)localObject).append(localFrameInfo.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append(", hashDiff = ");
        ((StringBuilder)localObject).append(localFrameInfo.jdField_b_of_type_Int);
        QLog.d(paramBitmap, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameTask.5
 * JD-Core Version:    0.7.0.1
 */