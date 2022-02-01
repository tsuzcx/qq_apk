package com.tencent.qcircle.weseevideo.composition;

import com.tencent.tavkit.report.FilterChainReportSession.IReporter;
import java.util.HashMap;
import java.util.Map;

final class VideoRenderCostTimeHelper$1
  implements FilterChainReportSession.IReporter
{
  VideoRenderCostTimeHelper$1(HashMap paramHashMap) {}
  
  public void onCommit(Map<String, Long> paramMap)
  {
    this.val$costTimeMap.putAll(paramMap);
    VideoRenderCostTimeHelper.access$000(this.val$costTimeMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderCostTimeHelper.1
 * JD-Core Version:    0.7.0.1
 */