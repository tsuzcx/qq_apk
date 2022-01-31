package com.tencent.upload.network.session;

import android.os.Handler;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.utils.UploadLog;

class SessionPool$1
  implements UploadConfiguration.NetworkStateObserver
{
  SessionPool$1(SessionPool paramSessionPool) {}
  
  public void onStateChanged(boolean paramBoolean)
  {
    UploadLog.d("SessionPool", "hasNetwork: " + paramBoolean);
    if (!paramBoolean) {
      return;
    }
    SessionPool.access$100(this.this$0).postDelayed(new SessionPool.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.session.SessionPool.1
 * JD-Core Version:    0.7.0.1
 */