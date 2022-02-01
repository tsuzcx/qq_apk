package cooperation.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class QCircleAlphaUserReporter$1
  implements Runnable
{
  QCircleAlphaUserReporter$1(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder) {}
  
  public void run()
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(QCircleAlphaUserReporter.access$000());
    localSingleDcData.report_data.addAll(QCircleAlphaUserReporter.createBaseEntries("client_report_cmd_success_rate_event"));
    ArrayList localArrayList = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("cmd", this.val$builder.cmd), QCircleReportHelper.newEntry("svr_ret_code", this.val$builder.svrRetCode), QCircleReportHelper.newEntry("ret_code", this.val$builder.retCode), QCircleReportHelper.newEntry("info", this.val$builder.info), QCircleReportHelper.newEntry("msg", this.val$builder.msg), QCircleReportHelper.newEntry("time_cost", String.valueOf(this.val$builder.timeCost)), QCircleReportHelper.newEntry("url", this.val$builder.url), QCircleReportHelper.newEntry("rate", String.valueOf(this.val$builder.rate)), QCircleReportHelper.newEntry("type", this.val$builder.type), QCircleReportHelper.newEntry("refer", this.val$builder.refer), QCircleReportHelper.newEntry("attach_info", this.val$builder.attachInfo), QCircleReportHelper.newEntry("extra_info", this.val$builder.extraInfo), QCircleReportHelper.newEntry("count", String.valueOf(this.val$builder.count)), QCircleReportHelper.newEntry("state", this.val$builder.state), QCircleReportHelper.newEntry("feed_id", this.val$builder.feedId), QCircleReportHelper.newEntry("user", this.val$builder.user), QCircleReportHelper.newEntry("gw_rp_transfer", this.val$builder.gwRpTransfer) }));
    localArrayList.addAll(QCircleReportHelper.convertEntryList(this.val$builder.extras));
    localSingleDcData.report_data.addAll(localArrayList);
    QCircleReporter.getInstance().addQualityReportData(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleAlphaUserReporter.1
 * JD-Core Version:    0.7.0.1
 */