package com.tencent.mobileqq.flashshow.report.dc;

import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

final class FSLpReportDc11002$1
  implements Runnable
{
  FSLpReportDc11002$1(FSLpReportDc11002.DataBuilder paramDataBuilder) {}
  
  List<FeedCloudCommon.Entry> a()
  {
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("touin", FSLpReportDc11002.DataBuilder.e(this.a));
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("actiontype", String.valueOf(FSLpReportDc11002.DataBuilder.c(this.a)));
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("subactiontype", String.valueOf(FSLpReportDc11002.DataBuilder.d(this.a)));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("feedid", FSLpReportDc11002.DataBuilder.f(this.a));
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("author_uin", FSLpReportDc11002.DataBuilder.g(this.a));
    FeedCloudCommon.Entry localEntry6 = QCircleReportHelper.newEntry("play_scene", String.valueOf(FSLpReportDc11002.DataBuilder.h(this.a)));
    FeedCloudCommon.Entry localEntry7 = QCircleReportHelper.newEntry("position_id", String.valueOf(FSLpReportDc11002.DataBuilder.i(this.a) + 1));
    FeedCloudCommon.Entry localEntry8 = QCircleReportHelper.newEntry("feed_tag", FSLpReportDc11002.DataBuilder.j(this.a));
    FeedCloudCommon.Entry localEntry9 = QCircleReportHelper.newEntry("play_url", FSLpReportDc11002.DataBuilder.k(this.a));
    FeedCloudCommon.Entry localEntry10 = QCircleReportHelper.newEntry("video_tag", FSLpReportDc11002.DataBuilder.l(this.a));
    FeedCloudCommon.Entry localEntry11 = QCircleReportHelper.newEntry("pic_info", FSLpReportDc11002.DataBuilder.m(this.a));
    FeedCloudCommon.Entry localEntry12 = QCircleReportHelper.newEntry("item_detail", FSLpReportDc11002.DataBuilder.n(this.a));
    FeedCloudCommon.Entry localEntry13 = QCircleReportHelper.newEntry("acttime", String.valueOf(FSLpReportDc11002.DataBuilder.o(this.a)));
    FeedCloudCommon.Entry localEntry14 = QCircleReportHelper.newEntry("vid", FSLpReportDc11002.DataBuilder.p(this.a));
    FeedCloudCommon.Entry localEntry15 = QCircleReportHelper.newEntry("lloc", FSLpReportDc11002.DataBuilder.q(this.a));
    FeedCloudCommon.Entry localEntry16 = QCircleReportHelper.newEntry("ext1", FSLpReportDc11002.DataBuilder.r(this.a));
    FeedCloudCommon.Entry localEntry17 = QCircleReportHelper.newEntry("ext2", FSLpReportDc11002.DataBuilder.s(this.a));
    FeedCloudCommon.Entry localEntry18 = QCircleReportHelper.newEntry("ext3", FSLpReportDc11002.DataBuilder.t(this.a));
    FeedCloudCommon.Entry localEntry19 = QCircleReportHelper.newEntry("ext4", FSLpReportDc11002.DataBuilder.u(this.a));
    FeedCloudCommon.Entry localEntry20 = QCircleReportHelper.newEntry("ext5", FSLpReportDc11002.DataBuilder.v(this.a));
    FeedCloudCommon.Entry localEntry21 = QCircleReportHelper.newEntry("ext6", FSLpReportDc11002.DataBuilder.w(this.a));
    FeedCloudCommon.Entry localEntry22 = QCircleReportHelper.newEntry("ext7", FSLpReportDc11002.DataBuilder.x(this.a));
    FeedCloudCommon.Entry localEntry23 = QCircleReportHelper.newEntry("ext8", FSLpReportDc11002.DataBuilder.y(this.a));
    FeedCloudCommon.Entry localEntry24 = QCircleReportHelper.newEntry("ext9", FSLpReportDc11002.DataBuilder.z(this.a));
    FeedCloudCommon.Entry localEntry25 = QCircleReportHelper.newEntry("ext10", FSLpReportDc11002.DataBuilder.A(this.a));
    FeedCloudCommon.Entry localEntry26 = QCircleReportHelper.newEntry("ext11", FSLpReportDc11002.DataBuilder.B(this.a));
    FeedCloudCommon.Entry localEntry27 = QCircleReportHelper.newEntry("rule_id", FSLpReportDc11002.DataBuilder.C(this.a));
    FeedCloudCommon.Entry localEntry28 = QCircleReportHelper.newEntry("feeds_url", FSLpReportDc11002.DataBuilder.D(this.a));
    FeedCloudCommon.Entry localEntry29 = QCircleReportHelper.newEntry("requestid", FSLpReportDc11002.DataBuilder.E(this.a));
    FeedCloudCommon.Entry localEntry30 = QCircleReportHelper.newEntry("feedtype1", String.valueOf(FSLpReportDc11002.DataBuilder.F(this.a)));
    FeedCloudCommon.Entry localEntry31 = QCircleReportHelper.newEntry("feedtype2", String.valueOf(FSLpReportDc11002.DataBuilder.G(this.a)));
    FeedCloudCommon.Entry localEntry32 = QCircleReportHelper.newEntry("feedtype3", String.valueOf(FSLpReportDc11002.DataBuilder.H(this.a)));
    FeedCloudCommon.Entry localEntry33 = QCircleReportHelper.newEntry("video_total_time", String.valueOf(FSLpReportDc11002.DataBuilder.I(this.a)));
    FeedCloudCommon.Entry localEntry34 = QCircleReportHelper.newEntry("video_type", FSLpReportDc11002.DataBuilder.J(this.a));
    FeedCloudCommon.Entry localEntry35 = QCircleReportHelper.newEntry("cubage", String.valueOf(FSLpReportDc11002.DataBuilder.K(this.a)));
    FeedCloudCommon.Entry localEntry36 = QCircleReportHelper.newEntry("width", String.valueOf(FSLpReportDc11002.DataBuilder.L(this.a)));
    FeedCloudCommon.Entry localEntry37 = QCircleReportHelper.newEntry("height", String.valueOf(FSLpReportDc11002.DataBuilder.M(this.a)));
    FeedCloudCommon.Entry localEntry38 = QCircleReportHelper.newEntry("clear", String.valueOf(FSLpReportDc11002.DataBuilder.N(this.a)));
    FeedCloudCommon.Entry localEntry39 = QCircleReportHelper.newEntry("play_id", FSLpReportDc11002.DataBuilder.O(this.a));
    FeedCloudCommon.Entry localEntry40 = QCircleReportHelper.newEntry("video_play_time", String.valueOf(FSLpReportDc11002.DataBuilder.P(this.a)));
    FeedCloudCommon.Entry localEntry41 = QCircleReportHelper.newEntry("video_solo_time", String.valueOf(FSLpReportDc11002.DataBuilder.Q(this.a)));
    String str;
    if (FSLpReportDc11002.DataBuilder.R(this.a)) {
      str = "1";
    } else {
      str = "0";
    }
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, localEntry8, localEntry9, localEntry10, localEntry11, localEntry12, localEntry13, localEntry14, localEntry15, localEntry16, localEntry17, localEntry18, localEntry19, localEntry20, localEntry21, localEntry22, localEntry23, localEntry24, localEntry25, localEntry26, localEntry27, localEntry28, localEntry29, localEntry30, localEntry31, localEntry32, localEntry33, localEntry34, localEntry35, localEntry36, localEntry37, localEntry38, localEntry39, localEntry40, localEntry41, QCircleReportHelper.newEntry("is_auto_play", str), QCircleReportHelper.newEntry("errorcode", FSLpReportDc11002.DataBuilder.S(this.a)), QCircleReportHelper.newEntry("dt_pgid", String.valueOf(FSLpReportDc11002.DataBuilder.T(this.a))), QCircleReportHelper.newEntry("dt_ref_pgid", String.valueOf(FSLpReportDc11002.DataBuilder.U(this.a))) }));
  }
  
  public void run()
  {
    this.a.b();
    Object localObject = a();
    if (FSLpReportDc11002.DataBuilder.a(this.a) != null) {
      ((List)localObject).addAll(FSReportHelper.a(FSLpReportDc11002.DataBuilder.a(this.a)));
    }
    ((List)localObject).addAll(FSReportHelper.a());
    localObject = FSReportHelper.a(FSLpReportDc11002.a(), (List)localObject, null, FSReportHelper.a(FSLpReportDc11002.DataBuilder.b(this.a), null, null));
    FSReporter.a().a((QQCircleReport.SingleDcData)localObject, FSLpReportDc11002.a(FSLpReportDc11002.DataBuilder.c(this.a), FSLpReportDc11002.DataBuilder.d(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.1
 * JD-Core Version:    0.7.0.1
 */