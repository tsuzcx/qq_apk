package com.tencent.mobileqq.vas.qvip.fragment;

import android.os.SystemClock;
import aqhr;
import aqhs;
import com.tencent.mobileqq.vas.qvip.view.QQVipWebview;

class QQVipFeedWedFragment$3
  implements Runnable
{
  QQVipFeedWedFragment$3(QQVipFeedWedFragment paramQQVipFeedWedFragment) {}
  
  public void run()
  {
    if (QQVipFeedWedFragment.a(this.this$0) != null)
    {
      aqhs.c();
      String str = aqhr.a();
      this.this$0.a = SystemClock.elapsedRealtime();
      QQVipFeedWedFragment.a(this.this$0).loadUrl(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.3
 * JD-Core Version:    0.7.0.1
 */