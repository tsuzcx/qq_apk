package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Bundle;
import bmvx;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

class VideoJsPlugin$1$1
  implements bmvx
{
  VideoJsPlugin$1$1(VideoJsPlugin.1 param1) {}
  
  public void callback(int paramInt, Bundle paramBundle)
  {
    boolean bool;
    if (paramInt == 0)
    {
      QLog.i("VideoJsPlugin", 1, "callback: load ok " + paramInt);
      if (VideoEnvironment.a("AVCodec", MobileQQ.sMobileQQ.getApplicationContext()) == 0)
      {
        bool = true;
        VideoJsPlugin.access$002(bool);
      }
    }
    for (;;)
    {
      VideoJsPlugin.access$100().compareAndSet(true, false);
      return;
      bool = false;
      break;
      QLog.w("VideoJsPlugin", 1, "callback: load failed " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */