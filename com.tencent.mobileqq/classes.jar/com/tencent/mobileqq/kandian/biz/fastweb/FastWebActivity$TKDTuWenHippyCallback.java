package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.TKDHippy2TuWenEventSimpleReceiver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

class FastWebActivity$TKDTuWenHippyCallback
  extends TKDHippy2TuWenEventSimpleReceiver
{
  private FastWebActivity$TKDTuWenHippyCallback(FastWebActivity paramFastWebActivity) {}
  
  public void onCommentNumChanged(long paramLong)
  {
    if (FastWebActivity.a(this.a) != null)
    {
      FastWebActivity.a(this.a).b = paramLong;
      if (FastWebActivity.a(this.a).b <= 0L) {
        FastWebActivity.a(this.a).b = 0L;
      }
      ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = FastWebActivity.a(this.a);
      FastWebActivity localFastWebActivity = this.a;
      localReadInJoyFastWebBottomSocialViewNew.a(localFastWebActivity, FastWebActivity.a(localFastWebActivity), this.a.a);
    }
  }
  
  public void onHippyForbiddenChanged(int paramInt)
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    ReadInJoyFastWebBottomSocialViewNew localReadInJoyFastWebBottomSocialViewNew = FastWebActivity.a(this.a);
    FastWebActivity localFastWebActivity = this.a;
    localReadInJoyFastWebBottomSocialViewNew.a(localFastWebActivity, FastWebActivity.a(localFastWebActivity), this.a.a, paramInt);
  }
  
  public void openSubCommentPage(String paramString1, String paramString2)
  {
    this.a.a(true, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.TKDTuWenHippyCallback
 * JD-Core Version:    0.7.0.1
 */