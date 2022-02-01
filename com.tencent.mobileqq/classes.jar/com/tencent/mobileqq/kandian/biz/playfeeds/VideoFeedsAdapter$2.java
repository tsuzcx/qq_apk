package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import java.util.HashMap;

class VideoFeedsAdapter$2
  implements Runnable
{
  VideoFeedsAdapter$2(VideoFeedsAdapter paramVideoFeedsAdapter, long paramLong) {}
  
  public void run()
  {
    if (VideoFeedsAdapter.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      RIJStatisticCollectorReport.d(VideoFeedsAdapter.a(this.this$0), RIJQQAppInterfaceUtil.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */