package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$3
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$3(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" update biuView cnt : ");
    localStringBuilder.append(this.a);
    QLog.d("FastWebActivity", 2, localStringBuilder.toString());
    if (FastWebActivity.d(this.b.a) != null) {
      FastWebActivity.p(this.b.a).a(FastWebActivity.d(this.b.a).e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.3
 * JD-Core Version:    0.7.0.1
 */