package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class NormalVideoDeliverController$4
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  NormalVideoDeliverController$4(NormalVideoDeliverController paramNormalVideoDeliverController) {}
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131905435));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
        ShortVideoErrorReport.a(2, paramInt);
      }
      else
      {
        NormalVideoDeliverController.a(this.a, true);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131905434));
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", localStringBuilder.toString(), null);
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131905432), null);
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.NormalVideoDeliverController.4
 * JD-Core Version:    0.7.0.1
 */