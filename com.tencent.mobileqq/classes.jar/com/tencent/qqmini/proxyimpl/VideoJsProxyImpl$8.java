package com.tencent.qqmini.proxyimpl;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class VideoJsProxyImpl$8
  implements IActivityResultListener
{
  VideoJsProxyImpl$8(VideoJsProxyImpl paramVideoJsProxyImpl, File paramFile, IActivityResultManager paramIActivityResultManager, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.a.deleteOnExit();
      paramIntent = this.d;
      VideoJsProxyImpl.a(paramIntent, VideoJsProxyImpl.b(paramIntent), "chooseVideo", null);
      this.b.removeActivityResultListener(this);
      return true;
    }
    VideoJsProxyImpl.a(this.d, this.a, this.c);
    this.b.removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.8
 * JD-Core Version:    0.7.0.1
 */