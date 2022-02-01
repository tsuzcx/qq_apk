package com.tencent.mobileqq.kandian.repo.fastweb;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

final class FastWebArticleInfoUtils$1
  implements Runnable
{
  FastWebArticleInfoUtils$1(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
    if (localFastWebModule == null) {
      return;
    }
    localFastWebModule.a(this.a.mArticleContentUrl, this.a.innerUniqueID, this.a.mSubscribeID, 2, new FastWebArticleInfoUtils.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebArticleInfoUtils.1
 * JD-Core Version:    0.7.0.1
 */