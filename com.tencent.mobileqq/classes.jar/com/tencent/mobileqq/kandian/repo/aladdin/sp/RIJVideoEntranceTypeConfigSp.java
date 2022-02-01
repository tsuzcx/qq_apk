package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

public class RIJVideoEntranceTypeConfigSp
{
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateVideoRecommendEntranceDirect value=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_video_recommend_entrance_direct", Integer.valueOf(paramInt));
    ReadInJoyLogicEngineEventDispatcher.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoEntranceTypeConfigSp
 * JD-Core Version:    0.7.0.1
 */