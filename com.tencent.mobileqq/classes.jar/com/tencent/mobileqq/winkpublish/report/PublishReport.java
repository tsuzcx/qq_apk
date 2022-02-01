package com.tencent.mobileqq.winkpublish.report;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleTaskReportInfo;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PublishReport
{
  public static void a(QCircleTaskReportInfo paramQCircleTaskReportInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("vid:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.vid);
    localStringBuilder1.append(",");
    localStringBuilder1.append("trace_id:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.traceId);
    localStringBuilder1.append(",");
    localStringBuilder1.append("orig_video_width:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.origPicWidth);
    localStringBuilder1.append(",");
    localStringBuilder1.append("orig_video_height:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.origPicHeight);
    localStringBuilder1.append(",");
    localStringBuilder1.append("orig_video_size:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.origPicSize);
    localStringBuilder1.append(",");
    localStringBuilder1.append("orig_video_bitrate:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.mediaOriginBitrate);
    localStringBuilder1.append(",");
    localStringBuilder1.append("edited_video_width:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.editedPicWidth);
    localStringBuilder1.append(",");
    localStringBuilder1.append("edited_video_height:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.editedPicHeight);
    localStringBuilder1.append(",");
    localStringBuilder1.append("edited_video_size:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.editedPicSize);
    localStringBuilder1.append(",");
    localStringBuilder1.append("edited_video_bitrate:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.editedVideoMediaBitrate);
    localStringBuilder1.append(",");
    localStringBuilder1.append("client_compress_video_width:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.clientCompressPicWidth);
    localStringBuilder1.append(",");
    localStringBuilder1.append("client_compress_video_height:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.clientCompressPicHeight);
    localStringBuilder1.append(",");
    localStringBuilder1.append("client_compress_video_size:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.clientCompressPicSize);
    localStringBuilder1.append(",");
    localStringBuilder1.append("client_compress_video_bitrate:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.clientCompressMediaBitrate);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("reportPicQuality video quality:");
    localStringBuilder2.append(localStringBuilder1.toString());
    QLog.i("[QcirclePublish]QCirclePublishReport", 1, localStringBuilder2.toString());
    QCircleQualityReporter.reportQualityEvent(5530, "video_publish_full_link", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("attach_info", localStringBuilder1.toString()), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramQCircleTaskReportInfo.retCode)) }), false);
  }
  
  public static void a(ArrayList<QCircleTaskReportInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QCircleTaskReportInfo localQCircleTaskReportInfo = (QCircleTaskReportInfo)paramArrayList.next();
      if (localQCircleTaskReportInfo != null) {
        if (localQCircleTaskReportInfo.is_video == 0) {
          b(localQCircleTaskReportInfo);
        } else if (localQCircleTaskReportInfo.is_video == 1) {
          a(localQCircleTaskReportInfo);
        }
      }
    }
  }
  
  public static void b(QCircleTaskReportInfo paramQCircleTaskReportInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("album_id:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.albumId);
    localStringBuilder1.append(",");
    localStringBuilder1.append("photo_id:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.lloc);
    localStringBuilder1.append(",");
    localStringBuilder1.append("trace_id:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.traceId);
    localStringBuilder1.append(",");
    localStringBuilder1.append("orig_pic_width:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.origPicWidth);
    localStringBuilder1.append(",");
    localStringBuilder1.append("orig_pic_height:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.origPicHeight);
    localStringBuilder1.append(",");
    localStringBuilder1.append("orig_pic_size:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.origPicSize);
    localStringBuilder1.append(",");
    localStringBuilder1.append("edited_pic_width:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.editedPicWidth);
    localStringBuilder1.append(",");
    localStringBuilder1.append("edited_pic_height:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.editedPicHeight);
    localStringBuilder1.append(",");
    localStringBuilder1.append("edited_pic_size:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.editedPicSize);
    localStringBuilder1.append(",");
    localStringBuilder1.append("client_compress_pic_width:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.clientCompressPicWidth);
    localStringBuilder1.append(",");
    localStringBuilder1.append("client_compress_pic_height:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.clientCompressPicHeight);
    localStringBuilder1.append(",");
    localStringBuilder1.append("client_compress_pic_size:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.clientCompressPicSize);
    localStringBuilder1.append(",");
    localStringBuilder1.append("backend_pic_width:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.backendPicWidth);
    localStringBuilder1.append(",");
    localStringBuilder1.append("backend_pic_height:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.backendPicHeight);
    localStringBuilder1.append(",");
    localStringBuilder1.append("hasCompress:");
    localStringBuilder1.append(paramQCircleTaskReportInfo.hasCompress);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("reportPicQuality pic quality:");
    localStringBuilder2.append(localStringBuilder1.toString());
    QLog.i("[QcirclePublish]QCirclePublishReport", 1, localStringBuilder2.toString());
    QCircleQualityReporter.reportQualityEvent("image_publish_full_link", Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("attach_info", localStringBuilder1.toString()), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramQCircleTaskReportInfo.retCode)) }), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.report.PublishReport
 * JD-Core Version:    0.7.0.1
 */