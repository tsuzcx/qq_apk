package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import org.json.JSONObject;

class FastWebActivity$37
  implements Runnable
{
  FastWebActivity$37(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    FastWebActivity.aa(this.this$0);
    FastWebActivity.ab(this.this$0);
    AbsBaseArticleInfo localAbsBaseArticleInfo1 = this.this$0.g;
    FastWebActivity localFastWebActivity = this.this$0;
    AbsBaseArticleInfo localAbsBaseArticleInfo2 = localFastWebActivity.g;
    int i = (int)this.this$0.g.mChannelID;
    String str;
    if (FastWebActivity.d(this.this$0).a()) {
      str = "2";
    } else {
      str = "1";
    }
    ReportUtil.a(localAbsBaseArticleInfo1, "0X800A09E", RIJTransMergeKanDianReport.a(localFastWebActivity, localAbsBaseArticleInfo2, i, str).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.37
 * JD-Core Version:    0.7.0.1
 */