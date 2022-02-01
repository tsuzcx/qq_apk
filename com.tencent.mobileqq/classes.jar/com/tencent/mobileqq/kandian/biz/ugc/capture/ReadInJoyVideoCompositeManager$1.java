package com.tencent.mobileqq.kandian.biz.ugc.capture;

import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyVideoCompositeManager$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  ReadInJoyVideoCompositeManager$1(ReadInJoyVideoCompositeManager paramReadInJoyVideoCompositeManager, long paramLong, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = (l1 - this.a) / 1000L;
      l1 = this.b.videoDuration;
      if (this.b.isLocalPublish) {
        l1 = this.b.videoRangeEnd - this.b.videoRangeStart;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraCaptureMerge: duration: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", time cost: ");
      localStringBuilder.append(l2);
      localStringBuilder.append("s");
      QLog.d("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      ReadInJoyVideoCompositeManager.a(this.c, this.b, paramString2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videocapture.ReadInJoyVideoCompositeManager", 2, new Object[] { "doCompositeCameraCaptureVideo: errorcode=%s, errorMsg=%s", Integer.valueOf(paramInt), paramString1 });
    }
    ReadInJoyVideoCompositeManager.a(this.c, this.b, paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyVideoCompositeManager.1
 * JD-Core Version:    0.7.0.1
 */