package com.tencent.qqmini.proxyimpl;

import android.annotation.SuppressLint;
import android.content.Intent;
import bgnk;
import bgnl;
import java.io.File;

class VideoJsProxyImpl$8
  implements bgnl
{
  VideoJsProxyImpl$8(VideoJsProxyImpl paramVideoJsProxyImpl, File paramFile, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.val$videoFile.deleteOnExit();
      VideoJsProxyImpl.access$600(this.this$0, VideoJsProxyImpl.access$500(this.this$0), "chooseVideo", null);
      return true;
    }
    VideoJsProxyImpl.access$1500(this.this$0, this.val$videoFile, this.val$compress);
    bgnk.a().b(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.8
 * JD-Core Version:    0.7.0.1
 */