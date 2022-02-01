package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.swipe.OnPageSwipeListener;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$7
  implements OnPageSwipeListener
{
  FastWebActivity$7(FastWebActivity paramFastWebActivity) {}
  
  public void a()
  {
    FastWebActivity.b(this.a, true);
    QLog.d("FastWebActivity", 1, "onPageSwipeClose");
  }
  
  public void b()
  {
    if (FastWebActivity.a(this.a) == 0L)
    {
      FastWebActivity.a(this.a, NetConnInfoCenter.getServerTime());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSwipeNotClose time :");
      localStringBuilder.append(FastWebActivity.a(this.a));
      QLog.d("FastWebActivity", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.7
 * JD-Core Version:    0.7.0.1
 */