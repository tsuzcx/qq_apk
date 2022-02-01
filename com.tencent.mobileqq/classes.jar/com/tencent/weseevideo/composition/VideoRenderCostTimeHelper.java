package com.tencent.weseevideo.composition;

import android.support.annotation.NonNull;
import com.tencent.tavcut.util.Logger;
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
      if (str != null) {
        Logger.i("VideoRenderCostTimeHelper", "effectNode: " + str + ", cost time(us): " + paramMap.get(str));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderCostTimeHelper
 * JD-Core Version:    0.7.0.1
 */