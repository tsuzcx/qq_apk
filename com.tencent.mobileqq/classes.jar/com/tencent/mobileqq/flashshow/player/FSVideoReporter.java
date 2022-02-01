package com.tencent.mobileqq.flashshow.player;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

public class FSVideoReporter
{
  private static int a;
  private static long b;
  private static long c;
  private List<QQCircleReport.SingleDcData> d = new ArrayList();
  
  public static FSVideoReporter a()
  {
    return FSVideoReporter.SingleHolder.a;
  }
  
  private static void a(Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    StringBuilder localStringBuilder;
    if ((paramObject instanceof FeedCloudMeta.StFeed))
    {
      paramObject = (FeedCloudMeta.StFeed)paramObject;
      paramList.add(QCircleReportHelper.newEntry("video_url", String.valueOf(paramObject.video.playUrl.get())));
      paramList.add(QCircleReportHelper.newEntry("total_time", String.valueOf(paramObject.video.duration.get() / 1000.0F)));
      paramList.add(QCircleReportHelper.newEntry("orig_uin", String.valueOf(paramObject.poster.id.get())));
      paramList.add(QCircleReportHelper.newEntry("feed_id", String.valueOf(paramObject.id.get())));
      paramList.add(QCircleReportHelper.newEntry("feed_type", String.valueOf(paramObject.type.get())));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramObject.video.width.get()));
      localStringBuilder.append("x");
      localStringBuilder.append(String.valueOf(paramObject.video.height.get()));
      paramList.add(QCircleReportHelper.newEntry("video_resolution", String.valueOf(localStringBuilder.toString())));
      return;
    }
    if ((paramObject instanceof FSFeedData))
    {
      paramObject = (FSFeedData)paramObject;
      paramList.add(QCircleReportHelper.newEntry("video_url", String.valueOf(paramObject.b().video.playUrl.get())));
      paramList.add(QCircleReportHelper.newEntry("total_time", String.valueOf(paramObject.b().video.duration.get() / 1000.0F)));
      paramList.add(QCircleReportHelper.newEntry("orig_uin", String.valueOf(paramObject.b().poster.id.get())));
      paramList.add(QCircleReportHelper.newEntry("feed_id", String.valueOf(paramObject.b().id.get())));
      paramList.add(QCircleReportHelper.newEntry("feed_type", String.valueOf(paramObject.b().type.get())));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramObject.b().video.width.get()));
      localStringBuilder.append("x");
      localStringBuilder.append(String.valueOf(paramObject.b().video.height.get()));
      paramList.add(QCircleReportHelper.newEntry("video_resolution", localStringBuilder.toString()));
      return;
    }
    if ((paramObject instanceof String)) {
      return;
    }
    if (!FSTransUtils.d()) {
      return;
    }
    throw new IllegalArgumentException("please adapter feed info");
  }
  
  private static List<FeedCloudCommon.Entry> b(long paramLong, String paramString, Object paramObject)
  {
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("host_uin", String.valueOf(FSTransUtils.a()));
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("qua", FSTransUtils.c());
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType());
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis()));
    paramString = QCircleReportHelper.newEntry("event_id", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.VERSION.RELEASE);
    paramString = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, paramString, QCircleReportHelper.newEntry("mobile_type", localStringBuilder.toString()), QCircleReportHelper.newEntry("version", FSTransUtils.e()), QCircleReportHelper.newEntry("platform", "AND"), QCircleReportHelper.newEntry("video_play_id", String.valueOf(paramLong)), QCircleReportHelper.newEntry("unique_id", String.valueOf(d())), QCircleReportHelper.newEntry("is_flash_show", String.valueOf(1)) }));
    a(paramObject, paramString);
    return paramString;
  }
  
  public static void b()
  {
    long l = System.currentTimeMillis() / 1000L;
    int i = a;
    b = l << 32 | i;
    a = i + 1;
  }
  
  public static long c()
  {
    return b;
  }
  
  public static long d()
  {
    long l = c;
    c = 1L + l;
    return l;
  }
  
  public void a(long paramLong, String paramString, Object paramObject, List<FeedCloudCommon.Entry> paramList)
  {
    QCircleReporter.getInstance().getReportHandler().post(new FSVideoReporter.1(this, paramObject, paramLong, paramString, paramList));
  }
  
  public void e()
  {
    QCircleReporter.getInstance().getReportHandler().post(new FSVideoReporter.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSVideoReporter
 * JD-Core Version:    0.7.0.1
 */