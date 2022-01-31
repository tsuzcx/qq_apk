package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import bgjd;
import bgje;
import java.io.File;

class VideoJsProxyImpl$7
  implements bgje
{
  VideoJsProxyImpl$7(VideoJsProxyImpl paramVideoJsProxyImpl, Activity paramActivity, boolean paramBoolean) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = PreferenceManager.getDefaultSharedPreferences(this.val$activity).getString("miniapp_video_path", "");
        VideoJsProxyImpl.access$1500(this.this$0, new File(paramIntent), this.val$compress);
      }
      for (;;)
      {
        bgjd.a().b(this);
        return true;
        VideoJsProxyImpl.access$600(this.this$0, VideoJsProxyImpl.access$500(this.this$0), "chooseVideo", null);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */