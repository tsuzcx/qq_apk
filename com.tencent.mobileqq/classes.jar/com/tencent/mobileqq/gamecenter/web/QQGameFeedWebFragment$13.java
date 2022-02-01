package com.tencent.mobileqq.gamecenter.web;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$13
  implements Runnable
{
  QQGameFeedWebFragment$13(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = QQGameFeedWebFragment.a(this.this$0);
    QLog.e("GameWebPage", 2, "#### height:" + localMessage.arg2);
    QQGameFeedWebFragment.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.13
 * JD-Core Version:    0.7.0.1
 */