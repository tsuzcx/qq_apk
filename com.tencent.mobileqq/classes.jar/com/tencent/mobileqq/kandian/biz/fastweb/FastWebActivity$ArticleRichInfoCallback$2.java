package com.tencent.mobileqq.kandian.biz.fastweb;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$2
  implements Runnable
{
  public void run()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.b)) && (this.d.a.g != null) && (this.b.equals(this.d.a.g.innerUniqueID)))
    {
      ItemDatasListUtils.a(this.c, FastWebActivity.m(this.d.a), this.a, this.d.a.g);
      FastWebActivity.n(this.d.a);
      QLog.d("FastWebActivity", 2, "get article topic info success! notify ui bindData");
      return;
    }
    QLog.d("FastWebActivity", 2, "get article topic info fail, msg not match !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.2
 * JD-Core Version:    0.7.0.1
 */