package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ReadInJoyCommentListFragment$8
  implements GuidePopuppWindow.OnGuideDismissListener
{
  ReadInJoyCommentListFragment$8(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 2) {
      this.a.i();
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2 = localReportR5Builder1.addOS().addStringNotThrow("rowkey", ReadInJoyCommentListFragment.k(this.a).innerUniqueID).addStringNotThrow("entry", "2");
    String str;
    if (paramInt == 2) {
      str = "1";
    } else {
      str = "0";
    }
    localReportR5Builder2.addStringNotThrow("result", str);
    ReadInJoyCommentUtils.a("0X800A00F", ReadInJoyCommentListFragment.k(this.a), localReportR5Builder1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.8
 * JD-Core Version:    0.7.0.1
 */