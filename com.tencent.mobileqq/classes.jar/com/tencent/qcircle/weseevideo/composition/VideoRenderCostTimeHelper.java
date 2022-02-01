package com.tencent.qcircle.weseevideo.composition;

import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tavkit.report.FilterChainReportSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VideoRenderCostTimeHelper
{
  private static final String TAG = "VideoRenderCostTimeHelper";
  
  private static void printfAllCostTime(@NonNull Map<String, Long> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("effectNode: ");
        localStringBuilder.append(str);
        localStringBuilder.append(", cost time(us): ");
        localStringBuilder.append(paramMap.get(str));
        Logger.i("VideoRenderCostTimeHelper", localStringBuilder.toString());
      }
    }
  }
  
  public static HashMap<String, Long> reportCostTime()
  {
    HashMap localHashMap = new HashMap();
    FilterChainReportSession.setReporter(new VideoRenderCostTimeHelper.1(localHashMap));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderCostTimeHelper
 * JD-Core Version:    0.7.0.1
 */