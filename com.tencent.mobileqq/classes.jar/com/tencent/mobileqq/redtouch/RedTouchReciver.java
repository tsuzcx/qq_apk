package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import avpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class RedTouchReciver
  extends ResultReceiver
{
  QQAppInterface a;
  
  public RedTouchReciver(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramQQAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    avpl localavpl = avpl.a(paramBundle);
    if (localavpl != null) {
      localavpl.a(this.a, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchReciver
 * JD-Core Version:    0.7.0.1
 */