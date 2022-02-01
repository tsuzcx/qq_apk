package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$7
  implements Runnable
{
  public void run()
  {
    if ((this.a != null) && (FastWebActivity.d(this.b.a) != null) && (this.a.equals(FastWebActivity.d(this.b.a).q)))
    {
      QLog.d("FastWebActivity", 2, "get related search words success! notify ui bindData");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRelatedSearchWordsResp, msg not match !");
    localStringBuilder.append(this.a);
    QLog.d("FastWebActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.7
 * JD-Core Version:    0.7.0.1
 */