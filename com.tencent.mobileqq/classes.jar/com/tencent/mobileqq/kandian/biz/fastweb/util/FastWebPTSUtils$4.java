package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

final class FastWebPTSUtils$4
  implements Runnable
{
  FastWebPTSUtils$4(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt, ViewBase paramViewBase) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new FastWebPTSUtils.4.1(this));
    RIJ3ClickUtils.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView(), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils.4
 * JD-Core Version:    0.7.0.1
 */