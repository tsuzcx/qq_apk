package com.tencent.mobileqq.kandian.biz.ugc.capture;

import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;

public class ReadInJoyVideoCompositeManager
{
  private ReadInJoyVideoCompositeManager.OnVideoCompositeListener a;
  private VideoCompositeHelper b = new VideoCompositeHelper();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    ReadInJoyVideoCompositeManager.OnVideoCompositeListener localOnVideoCompositeListener = this.a;
    if (localOnVideoCompositeListener != null) {
      localOnVideoCompositeListener.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    ReadInJoyVideoCompositeManager.OnVideoCompositeListener localOnVideoCompositeListener = this.a;
    if (localOnVideoCompositeListener != null) {
      localOnVideoCompositeListener.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(ReadInJoyVideoCompositeManager.OnVideoCompositeListener paramOnVideoCompositeListener)
  {
    this.a = paramOnVideoCompositeListener;
  }
  
  public void a(String paramString)
  {
    VideoCompositeHelper.a(VideoCompositeHelper.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = VideoCompositeHelper.a(paramString1);
    long l = System.currentTimeMillis();
    VideoCompositeHelper localVideoCompositeHelper = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".tmp.mp4");
    localVideoCompositeHelper.a(paramString1, localStringBuilder.toString(), false, true, new ReadInJoyVideoCompositeManager.1(this, l, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyVideoCompositeManager
 * JD-Core Version:    0.7.0.1
 */