package com.tencent.mobileqq.qqgamepub.fragment;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$14
  implements Runnable
{
  QQGameFeedWebFragment$14(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = -1;
    localMessage.arg2 = QQGameFeedWebFragment.a(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#### height:");
    localStringBuilder.append(localMessage.arg2);
    QLog.e("GameWebPage", 2, localStringBuilder.toString());
    QQGameFeedWebFragment.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.14
 * JD-Core Version:    0.7.0.1
 */