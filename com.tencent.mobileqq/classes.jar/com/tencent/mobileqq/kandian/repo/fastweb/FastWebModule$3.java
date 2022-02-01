package com.tencent.mobileqq.kandian.repo.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.List;

class FastWebModule$3
  implements Runnable
{
  FastWebModule$3(FastWebModule paramFastWebModule, List paramList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)this.a.get(i);
      FastWebModule.a(this.this$0, localAbsBaseArticleInfo);
      FastWebModule.b(this.this$0, localAbsBaseArticleInfo);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.3
 * JD-Core Version:    0.7.0.1
 */