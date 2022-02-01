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
    if (paramString == null) {
      return null;
    }
    try
    {
      if (sReportTypeMap.get(paramString) == null)
      {
        ReportType localReportType = new ReportType(paramString, new ArrayList());
        sReportTypeMap.put(paramString, localReportType);
        return localReportType;
      }
      paramString = (ReportType)sReportTypeMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public static void removeVideoReportType(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      sReportTypeMap.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getReportStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.reportPoints.size())
    {
      VideoSpeedReport.ReportPoint localReportPoint = (VideoSpeedReport.ReportPoint)this.reportPoints.get(i);
      if ((localReportPoint.getEndTime() - localReportPoint.getStartTime() < 0L) && (PlayerConfig.g().isDebugVersion()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localReportPoint.getName());
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(localReportPoint.hashCode());
        ((StringBuilder)localObject).append(") 错误：结束时间小于开始时间 ");
        ((StringBuilder)localObject).append(localReportPoint.getStartTime());
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(localReportPoint.getEndTime());
        PlayerUtils.log(3, "VideoSpeedReport", ((StringBuilder)localObject).toString());
      }
      if ((localReportPoint.getStartTime() <= 10000000L) && (localReportPoint.getEndTime() <= 10000000L))
      {
        if ((localReportPoint.getStartTime() == 0L) && (localReportPoint.getEndTime() == 0L))
        {
          if (PlayerConfig.g().isDebugVersion())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localReportPoint.getName());
            ((StringBuilder)localObject).append("(");
            ((StringBuilder)localObject).append(localReportPoint.hashCode());
            ((StringBuilder)localObject).append(") 丢弃：开始时间、结束时间都为0");
            ((StringBuilder)localObject).append(localReportPoint.getStartTime());
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(localReportPoint.getEndTime());
            PlayerUtils.log(3, "VideoSpeedReport", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          if (localStringBuilder.length() != 0) {
            localObject = ";\n";
          } else {
            localObject = "\n";
          }
          localStringBuilder.append((String)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localReportPoint.getName());
          ((StringBuilder)localObject).append(":");
          localStringBuilder.append(((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localReportPoint.getStartTime());
          ((StringBuilder)localObject).append(",");
          localStringBuilder.append(((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localReportPoint.getEndTime());
          ((StringBuilder)localObject).append(",");
          localStringBuilder.append(((StringBuilder)localObject).toString());
          if (localReportPoint.getExtraInfo() != null) {
            localStringBuilder.append(localReportPoint.getExtraInfo());
          }
        }
      }
      else if (PlayerConfig.g().isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localReportPoint.getName());
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(localReportPoint.hashCode());
        ((StringBuilder)localObject).append(") 错误：开始或结束时间大于最大值");
        ((StringBuilder)localObject).append(localReportPoint.getStartTime());
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(localReportPoint.getEndTime());
        PlayerUtils.log(3, "VideoSpeedReport", ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
    Object localObject = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    return localObject;
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