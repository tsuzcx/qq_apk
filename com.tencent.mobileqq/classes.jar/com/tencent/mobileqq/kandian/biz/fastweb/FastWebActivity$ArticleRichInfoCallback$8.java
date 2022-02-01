package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class FastWebActivity$ArticleRichInfoCallback$8
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$8(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get article business success, busiFlag:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("FastWebActivity", 2, ((StringBuilder)localObject).toString());
      this.b.B = this.a;
      this.b.C = this.c;
      if (RIJCommentAdUtils.a()) {
        FastWebActivity.o(this.d.a).a(this.d.a.g, FastWebActivity.O(this.d.a), 1);
      }
      if ((this.a == 0) && (FastWebActivity.m(this.d.a) != null) && (!FastWebActivity.m(this.d.a).isEmpty()))
      {
        if (FastWebActivity.Y(this.d.a).compareAndSet(false, true))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData onGetRecommendsResult handleArticleBusiness");
          ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).removeInnerAd(FastWebActivity.m(this.d.a));
        }
        localObject = ReadInJoyLogicEngine.a().d();
        if (localObject != null) {
          ((FastWebModule)localObject).a(FastWebActivity.d(this.d.a).q, FastWebActivity.m(this.d.a));
        }
        ItemDatasListUtils.a(FastWebActivity.m(this.d.a));
        FastWebActivity.n(this.d.a);
        FastWebActivity.v(this.d.a).a(FastWebActivity.w(this.d.a), 0);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get article business fail, Exception:");
      localStringBuilder.append(localException.toString());
      QLog.d("FastWebActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.8
 * JD-Core Version:    0.7.0.1
 */