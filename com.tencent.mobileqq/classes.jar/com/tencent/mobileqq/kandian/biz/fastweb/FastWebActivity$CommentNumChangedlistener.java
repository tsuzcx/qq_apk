package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.comment.ICommentNumChangedListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

class FastWebActivity$CommentNumChangedlistener
  implements ICommentNumChangedListener
{
  private FastWebActivity$CommentNumChangedlistener(FastWebActivity paramFastWebActivity) {}
  
  public void onCommentNumChanged(long paramLong)
  {
    if (FastWebActivity.a(this.a) != null)
    {
      FastWebActivity.a(this.a).b = paramLong;
      if (FastWebActivity.a(this.a).b <= 0L)
      {
        FastWebActivity.a(this.a).b = 0L;
        this.a.e();
      }
      ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = FastWebActivity.a(this.a);
      FastWebActivity localFastWebActivity = this.a;
      localReadInJoyFastWebBottomSocialViewNew.a(localFastWebActivity, FastWebActivity.a(localFastWebActivity), this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.CommentNumChangedlistener
 * JD-Core Version:    0.7.0.1
 */