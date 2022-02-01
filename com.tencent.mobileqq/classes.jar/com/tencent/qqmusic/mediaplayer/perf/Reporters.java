package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Reporters
{
  public static PerformanceTracer.Visitor detail(AudioInformation paramAudioInformation, Map<String, String> paramMap)
  {
    return new Reporters.1(paramAudioInformation, paramMap);
  }
  
  private static void generateDetailedPerformance(List<PerformanceTracer.SpeedCheck> paramList, StringBuilder paramStringBuilder, long paramLong)
  {
    paramStringBuilder.append("\n详细性能数据:\n");
    paramStringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15s%15s%15s%15s", new Object[] { "名称", "平均速度(byte/ms)", "耗时(ms)", "数据量(byte)", "占总耗时比" }));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PerformanceTracer.SpeedCheck localSpeedCheck = (PerformanceTracer.SpeedCheck)paramList.next();
      paramStringBuilder.append("\n");
      Locale localLocale = Locale.getDefault();
      String str = localSpeedCheck.getName();
      double d1 = localSpeedCheck.getAvg();
      long l1 = localSpeedCheck.getTotalTimeMs();
      long l2 = localSpeedCheck.getTotalBufferLength();
      double d2 = localSpeedCheck.getTotalTimeMs();
      double d3 = paramLong;
      Double.isNaN(d2);
      Double.isNaN(d3);
      paramStringBuilder.append(String.format(localLocale, "\t%15s%15.0f%15d%15d%13.2f", new Object[] { str, Double.valueOf(d1), Long.valueOf(l1), Long.valueOf(l2), Double.valueOf(d2 / d3) }));
    }
    paramStringBuilder.append("\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.Reporters
 * JD-Core Version:    0.7.0.1
 */