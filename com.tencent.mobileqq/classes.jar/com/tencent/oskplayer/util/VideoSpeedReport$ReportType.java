package com.tencent.oskplayer.util;

import com.tencent.oskplayer.PlayerConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoSpeedReport$ReportType
{
  public static final String TYPE_VIDEO_PLAY = "videoplay";
  private static Map<String, ReportType> sReportTypeMap = new HashMap(5, 0.75F);
  private List<VideoSpeedReport.ReportPoint> reportPoints;
  private String tag;
  
  public VideoSpeedReport$ReportType(String paramString, List<VideoSpeedReport.ReportPoint> paramList)
  {
    this.tag = paramString;
    this.reportPoints = paramList;
  }
  
  public static void addToVideoReportType(String paramString, VideoSpeedReport.ReportPoint paramReportPoint)
  {
    try
    {
      paramString = getVideoReportType(paramString);
      if (paramString != null)
      {
        paramString = paramString.getReportPoints();
        if (paramString != null) {
          paramString.add(paramReportPoint);
        }
      }
      return;
    }
    finally {}
  }
  
  private List<VideoSpeedReport.ReportPoint> getReportPoints()
  {
    return this.reportPoints;
  }
  
  public static ReportType getVideoReportType(String paramString)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = (ReportType)sReportTypeMap.get(paramString)) {
      for (;;)
      {
        return paramString;
        try
        {
          if (sReportTypeMap.get(paramString) == null)
          {
            ReportType localReportType = new ReportType(paramString, new ArrayList());
            sReportTypeMap.put(paramString, localReportType);
            paramString = localReportType;
          }
        }
        finally {}
      }
    }
  }
  
  public static void removeVideoReportType(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        sReportTypeMap.remove(paramString);
      }
      finally {}
    }
  }
  
  public String getReportStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.reportPoints.size())
    {
      VideoSpeedReport.ReportPoint localReportPoint = (VideoSpeedReport.ReportPoint)this.reportPoints.get(i);
      if ((localReportPoint.getEndTime() - localReportPoint.getStartTime() < 0L) && (PlayerConfig.g().isDebugVersion())) {
        PlayerUtils.log(3, "VideoSpeedReport", localReportPoint.getName() + "(" + localReportPoint.hashCode() + ") 错误：结束时间小于开始时间 " + localReportPoint.getStartTime() + "," + localReportPoint.getEndTime());
      }
      if ((localReportPoint.getStartTime() > 10000000L) || (localReportPoint.getEndTime() > 10000000L)) {
        if (PlayerConfig.g().isDebugVersion()) {
          PlayerUtils.log(3, "VideoSpeedReport", localReportPoint.getName() + "(" + localReportPoint.hashCode() + ") 错误：开始或结束时间大于最大值" + localReportPoint.getStartTime() + "," + localReportPoint.getEndTime());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localReportPoint.getStartTime() != 0L) || (localReportPoint.getEndTime() != 0L)) {
          break label324;
        }
        if (PlayerConfig.g().isDebugVersion()) {
          PlayerUtils.log(3, "VideoSpeedReport", localReportPoint.getName() + "(" + localReportPoint.hashCode() + ") 丢弃：开始时间、结束时间都为0" + localReportPoint.getStartTime() + "," + localReportPoint.getEndTime());
        }
      }
      label324:
      if (localStringBuilder.length() != 0) {}
      for (str = ";\n";; str = "\n")
      {
        localStringBuilder.append(str);
        localStringBuilder.append(localReportPoint.getName() + ":");
        localStringBuilder.append(localReportPoint.getStartTime() + ",");
        localStringBuilder.append(localReportPoint.getEndTime() + ",");
        if (localReportPoint.getExtraInfo() == null) {
          break;
        }
        localStringBuilder.append(localReportPoint.getExtraInfo());
        break;
      }
    }
    String str = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    return str;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public boolean isLaunchType()
  {
    return this.tag.contains("startupSpeed_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.VideoSpeedReport.ReportType
 * JD-Core Version:    0.7.0.1
 */