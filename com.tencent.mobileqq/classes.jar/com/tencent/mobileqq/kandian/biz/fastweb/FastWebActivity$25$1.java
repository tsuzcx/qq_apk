package com.tencent.mobileqq.kandian.biz.fastweb;

import android.os.Build.VERSION;
import com.tencent.mobileqq.swipe.SwipeLayoutUtils;

class FastWebActivity$25$1
  implements Runnable
{
  FastWebActivity$25$1(FastWebActivity.25 param25) {}
  
  public void run()
  {
    if ((Build.VERSION.SDK_INT > 26) && (FastWebActivity.J(this.a.a) == null))
    {
      SwipeLayoutUtils.a(this.a.a, new FastWebActivity.25.1.1(this));
      return;
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.25.1
 * JD-Core Version:    0.7.0.1
 */