package com.tencent.mobileqq.flashshow.report.dc;

import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class FSLpReportDc11001$1
  implements Runnable
{
  FSLpReportDc11001$1(DataBuilder paramDataBuilder) {}
  
  List<FeedCloudCommon.Entry> a()
  {
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("touin", this.a.getToUin()), QCircleReportHelper.newEntry("actiontype", String.valueOf(this.a.getActionType())), QCircleReportHelper.newEntry("subactiontype", String.valueOf(this.a.getSubActionType())), QCircleReportHelper.newEntry("thr_action", String.valueOf(this.a.getThrActionType())), QCircleReportHelper.newEntry("vid", String.valueOf(this.a.getVid())), QCircleReportHelper.newEntry("ext1", this.a.getExt1()), QCircleReportHelper.newEntry("ext2", this.a.getExt2()), QCircleReportHelper.newEntry("ext3", this.a.getExt3()), QCircleReportHelper.newEntry("ext4", this.a.getExt4()), QCircleReportHelper.newEntry("ext5", this.a.getExt5()), QCircleReportHelper.newEntry("ext6", this.a.getExt6()), QCircleReportHelper.newEntry("ext7", this.a.getExt7()), QCircleReportHelper.newEntry("ext8", this.a.getExt8()), QCircleReportHelper.newEntry("ext9", this.a.getExt9()), QCircleReportHelper.newEntry("ext10", this.a.getExt10()), QCircleReportHelper.newEntry("ext11", this.a.getExt11()), QCircleReportHelper.newEntry("ext12", this.a.getExt12()), QCircleReportHelper.newEntry("ext13", this.a.getExt13()), QCircleReportHelper.newEntry("ext14", this.a.getExt14()), QCircleReportHelper.newEntry("ext15", this.a.getExt15()), QCircleReportHelper.newEntry("ext16", this.a.getExt16()), QCircleReportHelper.newEntry("ext17", this.a.getExt17()), QCircleReportHelper.newEntry("ext18", this.a.getExt18()), QCircleReportHelper.newEntry("dt_pgid", String.valueOf(this.a.getDtPgId())), QCircleReportHelper.newEntry("dt_ref_pgid", String.valueOf(this.a.getDtRefPgId())) }));
  }
  
  public void run()
  {
    Object localObject = a();
    ((List)localObject).addAll(FSReportHelper.a());
    ((List)localObject).addAll(FSReportHelper.a(this.a.getExtras()));
    localObject = FSReportHelper.a(FSLpReportDc11001.a(), (List)localObject, null, FSReportHelper.a(this.a.getFeedReportInfo(), this.a.getMsgReportInfo(), this.a.getCommExtReportInfo()));
    FSReporter.a().a((QQCircleReport.SingleDcData)localObject, FSLpReportDc11001.a(this.a.getActionType(), this.a.getSubActionType()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001.1
 * JD-Core Version:    0.7.0.1
 */