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
  public static final VideoSpeedReport.ReportPoint POINT_VIDEO_LIST_IDLE;
  public static final VideoSpeedReport.ReportPoint POINT_VIDEO_PREPARE_ASYNC;
  public static final VideoSpeedReport.ReportPoint POINT_VIDEO_VISIBLE = new VideoSpeedReport.ReportPoint("video_list_idle<->update_videoview", false);
  public static boolean isLaunchReported = false;
  private VideoSpeedReport.ReportType currentLaunchType = null;
  private VideoSpeedReport.ReportType currentReportType = null;
  private long launchStartTime;
  private final List<VideoSpeedReport.ReportPoint> mReportPoints = Collections.synchronizedList(new ArrayList());
  private long reportStartTime = 0L;
  
  static
  {
    POINT_VIDEO_LIST_IDLE = new VideoSpeedReport.ReportPoint("video_list_idle<->set_datasource", false);
    POINT_VIDEO_PREPARE_ASYNC = new VideoSpeedReport.ReportPoint("video_prepare_async<->mediaplayer_onprepared", false);
  }
  
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
    }
  }
  
  private void collectReport(VideoSpeedReport.ReportType paramReportType)
  {
    if (paramReportType == null) {}
    String str;
    do
    {
      return;
      str = paramReportType.getReportStr();
    } while (TextUtils.isEmpty(str));
    PlayerUtils.log(4, "VideoSpeedReport", "reportType: " + VideoSpeedReport.ReportType.access$500(paramReportType) + ", reportStr: " + str);
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
    if ((VideoSpeedReport.ReportPoint.access$400(paramReportPoint)) || ((VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) && (isLaunchReported)) || ((!VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) && ((paramReportPoint.getEndTime() != 0L) || (this.reportStartTime == 0L))))
    {
      PlayerUtils.log(5, "VideoSpeedReport", "end point failed " + paramReportPoint.hashCode());
      return;
    }
    long l2 = System.currentTimeMillis();
    if (VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) {}
    for (long l1 = this.launchStartTime;; l1 = this.reportStartTime)
    {
      paramReportPoint.setEndTime(l2 - l1);
      VideoSpeedReport.ReportPoint.access$402(paramReportPoint, true);
      return;
    }
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
  
  /* Error */
  public void reportEnd(VideoSpeedReport.ReportType paramReportType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 63	com/tencent/oskplayer/util/VideoSpeedReport:currentReportType	Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportType;
    //   7: invokevirtual 190	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +14 -> 24
    //   13: aload_0
    //   14: getfield 65	com/tencent/oskplayer/util/VideoSpeedReport:reportStartTime	J
    //   17: lstore_2
    //   18: lload_2
    //   19: lconst_0
    //   20: lcmp
    //   21: ifne +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 63	com/tencent/oskplayer/util/VideoSpeedReport:currentReportType	Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportType;
    //   32: invokespecial 184	com/tencent/oskplayer/util/VideoSpeedReport:collectReport	(Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportType;)V
    //   35: aload_0
    //   36: invokespecial 192	com/tencent/oskplayer/util/VideoSpeedReport:cleanReport	()V
    //   39: goto -15 -> 24
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	VideoSpeedReport
    //   0	47	1	paramReportType	VideoSpeedReport.ReportType
    //   17	2	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	18	42	finally
    //   27	39	42	finally
  }
  
  /* Error */
  public void reportStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 65	com/tencent/oskplayer/util/VideoSpeedReport:reportStartTime	J
    //   10: lstore_3
    //   11: lload_1
    //   12: lload_3
    //   13: lsub
    //   14: ldc2_w 194
    //   17: lcmp
    //   18: ifge +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: invokespecial 192	com/tencent/oskplayer/util/VideoSpeedReport:cleanReport	()V
    //   28: aload_0
    //   29: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   32: putfield 65	com/tencent/oskplayer/util/VideoSpeedReport:reportStartTime	J
    //   35: goto -14 -> 21
    //   38: astore 5
    //   40: aload_0
    //   41: monitorexit
    //   42: aload 5
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	VideoSpeedReport
    //   5	7	1	l1	long
    //   10	3	3	l2	long
    //   38	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	38	finally
    //   24	35	38	finally
  }
  
  public void setReportType(VideoSpeedReport.ReportType paramReportType)
  {
    if (paramReportType.isLaunchType()) {
      this.currentLaunchType = paramReportType;
    }
    while (this.currentReportType != null) {
      return;
    }
    this.currentReportType = paramReportType;
  }
  
  public void start(VideoSpeedReport.ReportPoint paramReportPoint)
  {
    long l2 = 0L;
    label206:
    for (;;)
    {
      try
      {
        if ((VideoSpeedReport.ReportPoint.access$100(paramReportPoint)) || ((VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) && (isLaunchReported)) || ((!VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) && ((paramReportPoint.getStartTime() != 0L) || (this.reportStartTime == 0L))))
        {
          PlayerUtils.log(5, "VideoSpeedReport", "start point failed " + paramReportPoint.hashCode());
          return;
        }
        long l3 = System.currentTimeMillis();
        if (VideoSpeedReport.ReportPoint.access$200(paramReportPoint))
        {
          l1 = this.launchStartTime;
          l1 = l3 - l1;
          if ((VideoSpeedReport.ReportPoint.access$300(paramReportPoint) <= 0) || (l1 < VideoSpeedReport.ReportPoint.access$300(paramReportPoint)) || (!VideoSpeedReport.ReportPoint.access$200(paramReportPoint)) || (this.launchStartTime == 0L)) {
            break label206;
          }
          this.launchStartTime = System.currentTimeMillis();
          cleanBrokenPoints();
          l1 = l2;
          paramReportPoint.setStartTime(l1);
          VideoSpeedReport.ReportPoint.access$102(paramReportPoint, true);
          synchronized (this.mReportPoints)
          {
            this.mReportPoints.add(paramReportPoint);
          }
        }
        long l1 = this.reportStartTime;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.util.VideoSpeedReport
 * JD-Core Version:    0.7.0.1
 */