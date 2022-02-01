package com.tencent.mobileqq.qqgamepub.fragment;

import android.os.SystemClock;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.web.QQGameWebViewBuilder;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

class QQGameFeedWebFragment$16
  implements Runnable
{
  QQGameFeedWebFragment$16(QQGameFeedWebFragment paramQQGameFeedWebFragment, int paramInt) {}
  
  public void run()
  {
    if (QQGameFeedWebFragment.a(this.this$0) != null)
    {
      String str = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getFeedWebUrl();
      if (URLUtil.a(str))
      {
        Object localObject = this.this$0;
        str = QQGameFeedWebFragment.a((QQGameFeedWebFragment)localObject, str, QQGameFeedWebFragment.a((QQGameFeedWebFragment)localObject), this.a);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("paramUrl = ");
          ((StringBuilder)localObject).append(str);
          QLog.d("GameWebPage", 1, ((StringBuilder)localObject).toString());
        }
        this.this$0.f = SystemClock.elapsedRealtime();
        this.this$0.d = System.currentTimeMillis();
        QQGameFeedWebFragment.a(this.this$0).setTimeBeforeLoadUrl(System.currentTimeMillis());
        QQGameFeedWebFragment.a(this.this$0).loadUrl(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.16
 * JD-Core Version:    0.7.0.1
 */