package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$5
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$5(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback) {}
  
  public void run()
  {
    if (FastWebActivity.d(this.a.a) == null) {
      return;
    }
    FastWebActivity.n(this.a.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" handleLikeCntInfoResp shareCount : ");
      localStringBuilder.append(FastWebActivity.d(this.a.a).g);
      QLog.i("FastWebActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.5
 * JD-Core Version:    0.7.0.1
 */