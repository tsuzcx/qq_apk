package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.os.Handler;
import android.os.Message;

class GamePubAccountHippyFragment$11
  extends Handler
{
  GamePubAccountHippyFragment$11(GamePubAccountHippyFragment paramGamePubAccountHippyFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
    {
      if (i != 102) {
        return;
      }
      i = paramMessage.arg1;
      try
      {
        GamePubAccountHippyFragment.a(this.a, i);
        return;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
    this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment.11
 * JD-Core Version:    0.7.0.1
 */