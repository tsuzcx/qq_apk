package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

final class FastWebPTSUtils$5
  implements Runnable
{
  FastWebPTSUtils$5(ViewBase paramViewBase, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new FastWebPTSUtils.5.1(this));
    RIJ3ClickUtils.a.a(this.a.getNativeView(), 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils.5
 * JD-Core Version:    0.7.0.1
 */