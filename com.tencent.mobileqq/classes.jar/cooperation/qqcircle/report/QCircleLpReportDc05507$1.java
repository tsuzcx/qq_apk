package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleLpReportDc05507$1
  implements Runnable
{
  QCircleLpReportDc05507$1(QCircleLpReportDc05507.DataBuilder paramDataBuilder) {}
  
  public void run()
  {
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("touin", this.val$builder.toUin);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("actiontype", String.valueOf(this.val$builder.actionType));
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("subactiontype", String.valueOf(this.val$builder.subActionType));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("feedid", this.val$builder.feedId);
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("author_uin", this.val$builder.authorUin);
    FeedCloudCommon.Entry localEntry6 = QCircleReportHelper.newEntry("play_scene", String.valueOf(this.val$builder.playScene));
    FeedCloudCommon.Entry localEntry7 = QCircleReportHelper.newEntry("position_id", String.valueOf(this.val$builder.position + 1));
    FeedCloudCommon.Entry localEntry8 = QCircleReportHelper.newEntry("feed_tag", this.val$builder.feedTag);
    FeedCloudCommon.Entry localEntry9 = QCircleReportHelper.newEntry("play_url", this.val$builder.playUrl);
    FeedCloudCommon.Entry localEntry10 = QCircleReportHelper.newEntry("video_tag", this.val$builder.videoTag);
    FeedCloudCommon.Entry localEntry11 = QCircleReportHelper.newEntry("pic_info", this.val$builder.picInfo);
    FeedCloudCommon.Entry localEntry12 = QCircleReportHelper.newEntry("item_detail", this.val$builder.itemDetail);
    FeedCloudCommon.Entry localEntry13 = QCircleReportHelper.newEntry("acttime", String.valueOf(this.val$builder.actTime));
    FeedCloudCommon.Entry localEntry14 = QCircleReportHelper.newEntry("vid", this.val$builder.vid);
    FeedCloudCommon.Entry localEntry15 = QCircleReportHelper.newEntry("lloc", this.val$builder.lloc);
    FeedCloudCommon.Entry localEntry16 = QCircleReportHelper.newEntry("ext1", this.val$builder.ext1);
    FeedCloudCommon.Entry localEntry17 = QCircleReportHelper.newEntry("ext2", this.val$builder.ext2);
    FeedCloudCommon.Entry localEntry18 = QCircleReportHelper.newEntry("ext3", this.val$builder.ext3);
    FeedCloudCommon.Entry localEntry19 = QCircleReportHelper.newEntry("ext4", this.val$builder.ext4);
    FeedCloudCommon.Entry localEntry20 = QCircleReportHelper.newEntry("ext5", this.val$builder.ext5);
    FeedCloudCommon.Entry localEntry21 = QCircleReportHelper.newEntry("ext6", this.val$builder.ext6);
    FeedCloudCommon.Entry localEntry22 = QCircleReportHelper.newEntry("ext7", this.val$builder.ext7);
    FeedCloudCommon.Entry localEntry23 = QCircleReportHelper.newEntry("ext8", this.val$builder.ext8);
    FeedCloudCommon.Entry localEntry24 = QCircleReportHelper.newEntry("ext9", this.val$builder.ext9);
    FeedCloudCommon.Entry localEntry25 = QCircleReportHelper.newEntry("ext10", this.val$builder.ext10);
    FeedCloudCommon.Entry localEntry26 = QCircleReportHelper.newEntry("rule_id", this.val$builder.ruleId);
    FeedCloudCommon.Entry localEntry27 = QCircleReportHelper.newEntry("feeds_url", this.val$builder.feedUrl);
    FeedCloudCommon.Entry localEntry28 = QCircleReportHelper.newEntry("requestid", this.val$builder.requestId);
    FeedCloudCommon.Entry localEntry29 = QCircleReportHelper.newEntry("feedtype1", String.valueOf(this.val$builder.feedType1));
    FeedCloudCommon.Entry localEntry30 = QCircleReportHelper.newEntry("feedtype2", String.valueOf(this.val$builder.feedType2));
    FeedCloudCommon.Entry localEntry31 = QCircleReportHelper.newEntry("feedtype3", String.valueOf(this.val$builder.feedType3));
    FeedCloudCommon.Entry localEntry32 = QCircleReportHelper.newEntry("video_total_time", String.valueOf(this.val$builder.videoTotalTime));
    FeedCloudCommon.Entry localEntry33 = QCircleReportHelper.newEntry("video_type", this.val$builder.videoType);
    FeedCloudCommon.Entry localEntry34 = QCircleReportHelper.newEntry("cubage", String.valueOf(this.val$builder.cubage));
    FeedCloudCommon.Entry localEntry35 = QCircleReportHelper.newEntry("width", String.valueOf(this.val$builder.width));
    FeedCloudCommon.Entry localEntry36 = QCircleReportHelper.newEntry("height", String.valueOf(this.val$builder.height));
    FeedCloudCommon.Entry localEntry37 = QCircleReportHelper.newEntry("clear", String.valueOf(this.val$builder.clear));
    FeedCloudCommon.Entry localEntry38 = QCircleReportHelper.newEntry("play_id", this.val$builder.playId);
    FeedCloudCommon.Entry localEntry39 = QCircleReportHelper.newEntry("video_play_time", String.valueOf(this.val$builder.videoPlayTime));
    FeedCloudCommon.Entry localEntry40 = QCircleReportHelper.newEntry("video_solo_time", String.valueOf(this.val$builder.videoSoloTime));
    Object localObject;
    if (this.val$builder.isAutoPlay)
    {
      localObject = "1";
      localObject = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, localEntry9, localEntry10, localEntry11, localEntry12, localEntry13, localEntry14, localEntry15, localEntry16, localEntry17, localEntry18, localEntry19, localEntry20, localEntry21, localEntry22, localEntry23, localEntry24, localEntry25, localEntry26, localEntry27, localEntry28, localEntry29, localEntry30, localEntry31, localEntry32, localEntry33, localEntry34, localEntry35, localEntry36, localEntry37, localEntry38, localEntry39, localEntry40, QCircleReportHelper.newEntry("is_auto_play", (String)localObject), QCircleReportHelper.newEntry("errorcode", this.val$builder.errorCode) }));
      if (this.val$builder.pageId <= -1) {
        break label1103;
      }
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", String.valueOf(this.val$builder.pageId)));
      label925:
      if (this.val$builder.fPageId <= -1) {
        break label1121;
      }
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(this.val$builder.fPageId)));
      label959:
      if (this.val$builder.ffPageId <= -1) {
        break label1140;
      }
      ((List)localObject).add(QCircleReportHelper.newEntry("ffpage_id", String.valueOf(this.val$builder.ffPageId)));
    }
    for (;;)
    {
      if (this.val$builder.extras != null) {
        ((List)localObject).addAll(QCircleReportHelper.convertEntryList(this.val$builder.extras));
      }
      ((List)localObject).addAll(QCircleReportHelper.getInstance().newBaseEntries());
      localObject = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05507.access$000(), (List)localObject, null, QCircleReportHelper.getInstance().newSessionEntries(this.val$builder.pageId, this.val$builder.reportInfo));
      if (!QCircleReportHelper.getInstance().hasValidSession()) {
        break label1159;
      }
      QCircleReporter.getInstance().add((QQCircleReport.SingleDcData)localObject, QCircleLpReportDc05507.access$100(this.val$builder.actionType, this.val$builder.subActionType));
      return;
      localObject = "0";
      break;
      label1103:
      ((List)localObject).add(QCircleReportHelper.newEntry("page_id", "0"));
      break label925;
      label1121:
      ((List)localObject).add(QCircleReportHelper.newEntry("fpage_id", "0"));
      break label959;
      label1140:
      ((List)localObject).add(QCircleReportHelper.newEntry("ffpage_id", "0"));
    }
    label1159:
    QLog.w("QCircleReporter", 1, "QCircleLpReportDc05507 report miss Session: actiontype:" + this.val$builder.actionType + ",subActionType:" + this.val$builder.subActionType + ",add Miss Session report cache list");
    QCircleReporter.getInstance().addMissSessionReportDataCache((QQCircleReport.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05507.1
 * JD-Core Version:    0.7.0.1
 */