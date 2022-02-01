package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJVideoColumnConfigSp
{
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateVideoChannelFeedsType value=");
      localStringBuilder.append(paramInt);
      QLog.d("RIJVideoColumnConfigSp", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("video_channel_feeds_type", Integer.valueOf(paramInt));
  }
  
  public static void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMultiVideoFeedsType value=");
      localStringBuilder.append(paramInt);
      QLog.d("RIJVideoColumnConfigSp", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("multi_video_feeds_type", Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoColumnConfigSp
 * JD-Core Version:    0.7.0.1
 */