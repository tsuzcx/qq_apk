package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class VideoJsProxyImpl$7
  implements IActivityResultListener
{
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = PreferenceManager.getDefaultSharedPreferences(this.a).getString("miniapp_video_path", "");
        VideoJsProxyImpl.a(this.d, new File(paramIntent), this.b);
      }
      else
      {
        paramIntent = this.d;
        VideoJsProxyImpl.a(paramIntent, VideoJsProxyImpl.b(paramIntent), "chooseVideo", null);
      }
      this.c.removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */