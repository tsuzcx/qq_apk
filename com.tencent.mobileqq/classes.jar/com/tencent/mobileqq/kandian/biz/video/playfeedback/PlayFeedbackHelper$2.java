package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploadListener;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

final class PlayFeedbackHelper$2
  implements IImageUploadListener
{
  PlayFeedbackHelper$2(HashMap paramHashMap) {}
  
  public void a(int paramInt, @NotNull String paramString)
  {
    PlayFeedbackHelper.a(this.a);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString)
  {
    this.a.put("capture_url", paramString);
    PlayFeedbackHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper.2
 * JD-Core Version:    0.7.0.1
 */