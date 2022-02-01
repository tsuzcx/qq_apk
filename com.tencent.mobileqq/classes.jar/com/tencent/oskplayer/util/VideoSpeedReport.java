package com.tencent.oskplayer.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VideoSpeedReport
{
  private static final String DOUBLE_ARROW_SEP = "<->";
  public static final String LOG_TAG = "VideoSpeedReport";
  private static final int MIN_REFRESH_INTERVAL = 30000;
  public static final VideoSpeedReport.ReportPoint POINT_UPDATE_VIDEOVIEW = new VideoSpeedReport.ReportPoint("video_on_prepared<->update_videoview", false);
  public static final VideoSpeedReport.ReportPoint POINT_VIDEO_LIST_IDLE = new VideoSpeedReport.ReportPoint("video_list_idle<->set_datasource", false);
  public static final VideoSpeedReport.ReportPoint POINT_VIDEO_PREPARE_ASYNC = new VideoSpeedReport.ReportPoint("video_prepare_async<->mediaplayer_onprepared", false);
  public static final VideoSpeedReport.ReportPoint POINT_VIDEO_VISIBLE = new VideoSpeedReport.ReportPoint("video_list_idle<->update_videoview", false);
  public static boolean isLaunchReported = false;
  private VideoSpeedReport.ReportType currentLaunchType = null;
  private VideoSpeedReport.ReportType currentReportType = null;
  private long launchStartTime;
  private final List<VideoSpeedReport.ReportPoint> mReportPoints = Collections.synchronizedList(new ArrayList());
  private long reportStartTime = 0L;
  
  private void cleanReport()
  {
    this.reportStartTime = 0L;
    this.currentReportType = null;
    synchronized (this.mReportPoints)
    {
      Iterator localIterator = this.mReportPoints.iterator();
      while (localIterator.hasNext())
      {
        VideoSpeedReport.ReportPoint localReportPoint = (VideoSpeedReport.ReportPoint)localIterator.next();
        if (!VideoSpeedReport.ReportPoint.access$200(localReportPoint)) {
          localReportPoint.clean();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void collectReport(VideoSpeedReport.ReportType paramReportType)
  {
    if (paramReportType == null) {
      return;
    }
    String str = paramReportType.getReportStr();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportType: ");
    localStringBuilder.append(VideoSpeedReport.ReportType.access$500(paramReportType));
    localStringBuilder.append(", reportStr: ");
    localStringBuilder.append(str);
    PlayerUtils.log(4, "VideoSpeedReport", localStringBuilder.toString());
  }
  
  public static VideoSpeedReport g()
  {
    return VideoSpeedReport.SpeedReportInstance.access$000();
  }
  
  public void cancelStartupReport()
  {
    isLaunchReported = true;
  }
  
  public void cleanBrokenPoints() {}
  
  public void end(VideoSpeedReport.ReportPoint paramReportPoint)
  {
    if ((!VideoSpeedReport.ReportPoint.access$400(paramReportPoint)) && ((!VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) || (!isLaunchReported)) && ((VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) || ((paramReportPoint.getEndTime() == 0L) && (this.reportStartTime != 0L))))
    {
      long l2 = System.currentTimeMillis();
      long l1;
      if (VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) {
        l1 = this.launchStartTime;
      } else {
        l1 = this.reportStartTime;
      }
      paramReportPoint.setEndTime(l2 - l1);
      VideoSpeedReport.ReportPoint.access$402(paramReportPoint, true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("end point failed ");
    localStringBuilder.append(paramReportPoint.hashCode());
    PlayerUtils.log(5, "VideoSpeedReport", localStringBuilder.toString());
  }
  
  public boolean isLaunchTypeSet()
  {
    return this.currentLaunchType != null;
  }
  
  public void launchEnd()
  {
    if (isLaunchReported) {
      return;
    }
    collectReport(this.currentLaunchType);
    isLaunchReported = true;
  }
  
  public void launchStart()
  {
    this.launchStartTime = System.currentTimeMillis();
  }
  
  public void reportEnd(VideoSpeedReport.ReportType paramReportType)
  {
    try
    {
      if ((paramReportType.equals(this.currentReportType)) && (this.reportStartTime != 0L))
      {
        collectReport(this.currentReportType);
        cleanReport();
        return;
      }
      return;
    }
    finally {}
  }
  
  public void reportStart()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.reportStartTime;
      if (l1 - l2 < 30000L) {
        return;
      }
      cleanReport();
      this.reportStartTime = System.currentTimeMillis();
      return;
    }
    finally {}
  }
  
  public void setReportType(VideoSpeedReport.ReportType paramReportType)
  {
    if (paramReportType.isLaunchType())
    {
      this.currentLaunchType = paramReportType;
      return;
    }
    if (this.currentReportType == null) {
      this.currentReportType = paramReportType;
    }
  }
  
  public void start(VideoSpeedReport.ReportPoint paramReportPoint)
  {
    label224:
    for (;;)
    {
      try
      {
        if ((!VideoSpeedReport.ReportPoint.access$100(paramReportPoint)) && ((!VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) || (!isLaunchReported)))
        {
          boolean bool = VideoSpeedReport.ReportPoint.access$200(paramReportPoint);
          long l2 = 0L;
          if ((bool) || ((paramReportPoint.getStartTime() == 0L) && (this.reportStartTime != 0L)))
          {
            long l3 = System.currentTimeMillis();
            if (VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) {
              l1 = this.launchStartTime;
            } else {
              l1 = this.reportStartTime;
            }
            long l1 = l3 - l1;
            if ((VideoSpeedReport.ReportPoint.access$300(paramReportPoint) <= 0) || (l1 < VideoSpeedReport.ReportPoint.access$300(paramReportPoint)) || (!VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) || (this.launchStartTime == 0L)) {
              break label224;
            }
            this.launchStartTime = System.currentTimeMillis();
            cleanBrokenPoints();
            l1 = l2;
            paramReportPoint.setStartTime(l1);
            VideoSpeedReport.ReportPoint.access$102(paramReportPoint, true);
            synchronized (this.mReportPoints)
            {
              this.mReportPoints.add(paramReportPoint);
              return;
            }
          }
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("start point failed ");
        ((StringBuilder)???).append(paramReportPoint.hashCode());
        PlayerUtils.log(5, "VideoSpeedReport", ((StringBuilder)???).toString());
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.VideoSpeedReport
 * JD-Core Version:    0.7.0.1
 */