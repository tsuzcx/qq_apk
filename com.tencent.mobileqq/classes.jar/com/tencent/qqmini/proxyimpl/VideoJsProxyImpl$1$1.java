package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVideoSoDownloadModule.DownloadResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;

class VideoJsProxyImpl$1$1
  implements QzoneVideoSoDownloadModule.DownloadResultCallback
{
  VideoJsProxyImpl$1$1(VideoJsProxyImpl.1 param1) {}
  
  public void callback(int paramInt, Bundle paramBundle)
  {
    boolean bool;
    if (paramInt == 0)
    {
      QLog.i("VideoJsPlugin", 1, "callback: load ok " + paramInt);
      if (VideoEnvironment.loadAVCodecSo() == 0)
      {
        bool = true;
        VideoJsProxyImpl.a(bool);
      }
    }
    for (;;)
    {
      VideoJsProxyImpl.a().compareAndSet(true, false);
      return;
      bool = false;
      break;
      QLog.w("VideoJsPlugin", 1, "callback: load failed " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */