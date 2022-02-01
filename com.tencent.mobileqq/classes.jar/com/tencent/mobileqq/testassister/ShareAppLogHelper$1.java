package com.tencent.mobileqq.testassister;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ShareAppLogHelper$1
  extends Handler
{
  ShareAppLogHelper$1(ShareAppLogHelper paramShareAppLogHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1002: 
      if (ShareAppLogHelper.a(this.a) != null)
      {
        ShareAppLogHelper.a(this.a).b(((Integer)paramMessage.obj).intValue());
        return;
      }
      break;
    case 1001: 
      if (ShareAppLogHelper.a(this.a) != null)
      {
        ShareAppLogHelper.a(this.a).a(((Integer)paramMessage.obj).intValue());
        return;
      }
      break;
    case 1000: 
      if (ShareAppLogHelper.a(this.a) != null) {
        ShareAppLogHelper.a(this.a).a((String)paramMessage.obj);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper.1
 * JD-Core Version:    0.7.0.1
 */