package com.tencent.mobileqq.vas.qvip.fragment;

import android.os.SystemClock;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountProocessor;
import com.tencent.mobileqq.vas.qvip.view.QQVipWebview;

class QQVipFeedWedFragment$7
  implements Runnable
{
  QQVipFeedWedFragment$7(QQVipFeedWedFragment paramQQVipFeedWedFragment) {}
  
  public void run()
  {
    if (QQVipFeedWedFragment.d(this.this$0) != null)
    {
      QVipPubAccountProocessor.e();
      String str = QVipPubAccountConfig.a();
      QQVipFeedWedFragment.c(this.this$0, SystemClock.elapsedRealtime());
      QQVipFeedWedFragment.d(this.this$0).loadUrl(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.7
 * JD-Core Version:    0.7.0.1
 */