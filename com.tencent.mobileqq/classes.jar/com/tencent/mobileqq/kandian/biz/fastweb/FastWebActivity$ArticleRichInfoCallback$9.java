package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FastWebActivity$ArticleRichInfoCallback$9
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$9(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, String paramString, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleTopicTag], rowKey = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("FastWebActivity", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if ((localObject != null) && (((FastWebArticleInfo)localObject).I != null) && (this.b.I.size() > 0))
    {
      if (!ReadInJoyHelper.l())
      {
        QLog.i("FastWebActivity", 1, "[handleTopicTag] topic switch is off.");
        return;
      }
      localObject = FastWebPTSDataConverter.b(this.c.a.g, this.b, this.c.a.n);
      if ((FastWebActivity.m(this.c.a) != null) && (localObject != null))
      {
        ItemDatasListUtils.d(FastWebActivity.m(this.c.a));
        ItemDatasListUtils.a(FastWebActivity.m(this.c.a), (BaseData)localObject);
        FastWebActivity.n(this.c.a);
      }
      return;
    }
    QLog.i("FastWebActivity", 1, "[handleTopicTag] topicTagList is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.9
 * JD-Core Version:    0.7.0.1
 */