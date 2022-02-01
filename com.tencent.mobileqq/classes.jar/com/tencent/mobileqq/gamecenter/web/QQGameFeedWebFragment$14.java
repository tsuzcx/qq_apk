package com.tencent.mobileqq.gamecenter.web;

import android.os.SystemClock;
import avmc;
import avoc;
import blhn;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$14
  implements Runnable
{
  QQGameFeedWebFragment$14(QQGameFeedWebFragment paramQQGameFeedWebFragment, int paramInt) {}
  
  public void run()
  {
    if (QQGameFeedWebFragment.a(this.this$0) != null)
    {
      String str = avmc.a();
      if (blhn.a(str))
      {
        str = QQGameFeedWebFragment.a(this.this$0, str, QQGameFeedWebFragment.a(this.this$0), this.a);
        if (QLog.isColorLevel()) {
          QLog.d("GameWebPage", 1, "paramUrl = " + str);
        }
        this.this$0.f = SystemClock.elapsedRealtime();
        this.this$0.d = System.currentTimeMillis();
        QQGameFeedWebFragment.a(this.this$0).setmTimeBeforeLoadUrl(System.currentTimeMillis());
        QQGameFeedWebFragment.a(this.this$0).loadUrl(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.14
 * JD-Core Version:    0.7.0.1
 */