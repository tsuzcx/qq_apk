package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJVideoSingleModeConfigSp
{
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSingleVideoConfig() value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("VIDEO_FEEDS_SINGLE_VIDEO_CONFIG", paramString);
  }
  
  public static boolean a(int paramInt)
  {
    return RIJMultiVideoConfigSp.b(paramInt, ",", "VIDEO_FEEDS_SINGLE_VIDEO_CONFIG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSingleModeConfigSp
 * JD-Core Version:    0.7.0.1
 */