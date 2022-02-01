package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.TKDHippy2TuWenEventSimpleReceiver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

class FastWebActivity$TKDTuWenHippyCallback
  extends TKDHippy2TuWenEventSimpleReceiver
{
  private FastWebActivity$TKDTuWenHippyCallback(FastWebActivity paramFastWebActivity) {}
  
  public void onCommentNumChanged(long paramLong)
  {
    if (FastWebActivity.d(this.a) != null)
    {
      FastWebActivity.d(this.a).d = paramLong;
      if (FastWebActivity.d(this.a).d <= 0L) {
        FastWebActivity.d(this.a).d = 0L;
      }
      ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = FastWebActivity.p(this.a);
      FastWebActivity localFastWebActivity = this.a;
      localReadInJoyFastWebBottomSocialViewNew.a(localFastWebActivity, FastWebActivity.d(localFastWebActivity), this.a.g);
    }
  }
  
  public void onHippyForbiddenChanged(int paramInt)
  {
    if (FastWebActivity.d(this.a) == null) {
      return;
    }
    ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = FastWebActivity.p(this.a);
    FastWebActivity localFastWebActivity = this.a;
    localReadInJoyFastWebBottomSocialViewNew.a(localFastWebActivity, FastWebActivity.d(localFastWebActivity), this.a.g, paramInt);
  }
  
  public void openSubCommentPage(String paramString1, String paramString2)
  {
    this.a.a(true, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.TKDTuWenHippyCallback
 * JD-Core Version:    0.7.0.1
 */