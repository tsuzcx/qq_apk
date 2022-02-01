package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;

class FastWebRequestUtil$6$1
  implements Runnable
{
  FastWebRequestUtil$6$1(FastWebRequestUtil.6 param6, int paramInt, String paramString) {}
  
  public void run()
  {
    FeedbackCallback localFeedbackCallback = this.this$0.b;
    boolean bool;
    if (this.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localFeedbackCallback.b(bool, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.6.1
 * JD-Core Version:    0.7.0.1
 */