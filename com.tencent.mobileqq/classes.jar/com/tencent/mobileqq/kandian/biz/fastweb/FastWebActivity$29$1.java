package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class FastWebActivity$29$1
  implements Runnable
{
  final FastWebArticleInfo a = FastWebActivity.d(this.e.a);
  final AbsBaseArticleInfo b = this.e.a.g;
  
  FastWebActivity$29$1(FastWebActivity.29 param29, long paramLong, List paramList) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      FastWebActivity localFastWebActivity = this.e.a;
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.b;
      if (this.a.a()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      Object localObject = RIJTransMergeKanDianReport.a(localFastWebActivity, localAbsBaseArticleInfo, 0, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("open_speed", this.c);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ReportUtil.a(this.b, "0X8008997", ((JSONObject)localObject).toString());
      FastWebActivity.N(this.e.a);
      FastWebActivity.a(this.e.a, this.b, this.a);
      ReportUtil.a(this.b, this.d);
      FastWebRequestUtil.a(this.b.mArticleContentUrl, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.29.1
 * JD-Core Version:    0.7.0.1
 */