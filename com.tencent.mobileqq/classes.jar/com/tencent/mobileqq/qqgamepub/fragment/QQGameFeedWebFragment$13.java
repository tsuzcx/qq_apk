package com.tencent.mobileqq.qqgamepub.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;

class QQGameFeedWebFragment$13
  extends Handler
{
  QQGameFeedWebFragment$13(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
    {
      if (i != 100)
      {
        if (i != 102) {
          return;
        }
        i = paramMessage.arg1;
        try
        {
          QQGameFeedWebFragment.a(this.a, i);
          return;
        }
        catch (Throwable paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
      }
      QQGameFeedWebFragment.a(this.a).setVisibility(8);
      return;
    }
    this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.13
 * JD-Core Version:    0.7.0.1
 */