package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.qphone.base.util.QLog;

class FastWebActivity$34
  implements Runnable
{
  FastWebActivity$34(FastWebActivity paramFastWebActivity, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      if (this.a) {
        FastWebActivity.S(this.this$0);
      } else {
        FastWebActivity.T(this.this$0);
      }
      FastWebActivity.h(this.this$0, this.a);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jump error, msg=");
      localStringBuilder.append(localException);
      QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.34
 * JD-Core Version:    0.7.0.1
 */