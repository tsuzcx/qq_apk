package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;

class FastWebRequestUtil$5$1
  implements Runnable
{
  FastWebRequestUtil$5$1(FastWebRequestUtil.5 param5, int paramInt, String paramString) {}
  
  public void run()
  {
    FeedbackCallback localFeedbackCallback = this.this$0.b;
    boolean bool;
    if (this.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localFeedbackCallback.a(bool, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.5.1
 * JD-Core Version:    0.7.0.1
 */