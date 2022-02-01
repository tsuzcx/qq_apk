package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$4
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$4(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, int paramInt) {}
  
  public void run()
  {
    if (FastWebActivity.d(this.b.a) == null) {
      return;
    }
    FastWebActivity.d(this.b.a).f = this.a;
    FastWebActivity.p(this.b.a).a(FastWebActivity.d(this.b.a).f);
    FastWebActivity.n(this.b.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" handleLikeCntInfoResp likeCnt : ");
    localStringBuilder.append(FastWebActivity.d(this.b.a).f);
    QLog.d("FastWebActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.4
 * JD-Core Version:    0.7.0.1
 */