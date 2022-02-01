package com.tencent.mobileqq.mini.reuse;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class MiniAppBannerIPCModule$1
  extends Handler
{
  MiniAppBannerIPCModule$1(MiniAppBannerIPCModule paramMiniAppBannerIPCModule, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (1 != paramMessage.what) {
      return;
    }
    MiniAppBannerIPCModule.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule.1
 * JD-Core Version:    0.7.0.1
 */