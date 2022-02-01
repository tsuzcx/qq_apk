package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.comment.ICommentNumChangedListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

class FastWebActivity$14
  implements ICommentNumChangedListener
{
  FastWebActivity$14(FastWebActivity paramFastWebActivity) {}
  
  public void onCommentNumChanged(long paramLong)
  {
    if (FastWebActivity.d(this.a) != null)
    {
      FastWebActivity.d(this.a).d = paramLong;
      if (FastWebActivity.d(this.a).d <= 0L)
      {
        FastWebActivity.d(this.a).d = 0L;
        this.a.f();
      }
      ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = FastWebActivity.p(this.a);
      FastWebActivity localFastWebActivity = this.a;
      localReadInJoyFastWebBottomSocialViewNew.a(localFastWebActivity, FastWebActivity.d(localFastWebActivity), this.a.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.14
 * JD-Core Version:    0.7.0.1
 */