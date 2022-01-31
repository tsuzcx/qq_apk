package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.os.ResultReceiver;
import axhg;
import com.tencent.mobileqq.app.QQAppInterface;

public class RedTouchReciver
  extends ResultReceiver
{
  QQAppInterface a;
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    axhg localaxhg = axhg.a(paramBundle);
    if (localaxhg != null) {
      localaxhg.a(this.a, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchReciver
 * JD-Core Version:    0.7.0.1
 */