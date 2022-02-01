package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.DownloadResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;

class VideoJsProxyImpl$1$1
  implements DownloadResultCallback
{
  VideoJsProxyImpl$1$1(VideoJsProxyImpl.1 param1) {}
  
  public void callback(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("callback: load ok ");
      paramBundle.append(paramInt);
      QLog.i("VideoJsPlugin", 1, paramBundle.toString());
      boolean bool;
      if (VideoEnvironment.loadAVCodecSo() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      VideoJsProxyImpl.a(bool);
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("callback: load failed ");
      paramBundle.append(paramInt);
      QLog.w("VideoJsPlugin", 1, paramBundle.toString());
    }
    VideoJsProxyImpl.a().compareAndSet(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */