package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.os.Handler;
import android.os.Message;

class GamePAHippyFragmentV2$1
  extends Handler
{
  GamePAHippyFragmentV2$1(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4)) {
      return;
    }
    this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.1
 * JD-Core Version:    0.7.0.1
 */