package com.tencent.mobileqq.gamecenter.hippy;

import android.os.Handler;
import android.os.Message;

class GamePubAccountHippyFragment$11
  extends Handler
{
  GamePubAccountHippyFragment$11(GamePubAccountHippyFragment paramGamePubAccountHippyFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
      return;
    }
    int i = paramMessage.arg1;
    try
    {
      GamePubAccountHippyFragment.a(this.a, i);
      return;
    }
    catch (Throwable paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment.11
 * JD-Core Version:    0.7.0.1
 */