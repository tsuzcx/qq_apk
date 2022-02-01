package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJSocialBottomUtils$Companion$refreshBottomView$1
  implements Runnable
{
  RIJSocialBottomUtils$Companion$refreshBottomView$1(FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public final void run()
  {
    ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = RIJSocialBottomUtils.c();
    if (localReadInJoyFastWebBottomSocialViewNew != null) {
      localReadInJoyFastWebBottomSocialViewNew.setData(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils.Companion.refreshBottomView.1
 * JD-Core Version:    0.7.0.1
 */