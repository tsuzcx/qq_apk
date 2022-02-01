package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class VideoJsProxyImpl$6
  implements FFmpegExecuteResponseCallback
{
  VideoJsProxyImpl$6(VideoJsProxyImpl paramVideoJsProxyImpl, long paramLong1, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt, String paramString2, long paramLong2) {}
  
  public void onFailure(String paramString)
  {
    paramString = paramString.split("\n");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFailure: ");
      localStringBuilder.append(str);
      QLog.w("VideoJsPlugin", 1, localStringBuilder.toString());
      i += 1;
    }
    if (this.b.contains("-vf"))
    {
      VideoJsProxyImpl.a(this.g, this.c, false);
      return;
    }
    paramString = ((IMiniAppFileManager)VideoJsProxyImpl.c(this.g).getManager(IMiniAppFileManager.class)).getWxFilePath(this.c.path);
    VideoJsProxyImpl.a(this.g, paramString, this.c.fileSize, this.c);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("compress finish ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(System.currentTimeMillis() - this.a);
      QLog.d("VideoJsPlugin", 2, localStringBuilder.toString());
    }
  }
  
  public void onProgress(String paramString)
  {
    if (paramString.length() >= 90)
    {
      if (paramString.length() > 150) {
        return;
      }
      paramString = new Scanner(paramString).findWithinHorizon(VideoJsProxyImpl.b(), 0);
      if (paramString != null)
      {
        paramString = paramString.split(":");
        if (paramString.length <= 2) {}
      }
    }
    try
    {
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      double d1 = Double.parseDouble(paramString[2]);
      i = (int)((float)(TimeUnit.HOURS.toMillis(i) + TimeUnit.MINUTES.toMillis(j) + (d1 * 1000.0D)) * 100.0F / (float)this.f);
      if (i < 100)
      {
        paramString = this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131913502));
        localStringBuilder.append(i);
        localStringBuilder.append("%");
        VideoJsProxyImpl.a(paramString, localStringBuilder.toString());
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("compress success ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.b);
      QLog.d("VideoJsPlugin", 2, localStringBuilder.toString());
    }
    if (this.b.contains("-vf"))
    {
      paramString = this.c;
      paramString.mediaWidth /= this.d;
      paramString = this.c;
      paramString.mediaHeight /= this.d;
    }
    paramString = ((IMiniAppFileManager)VideoJsProxyImpl.c(this.g).getManager(IMiniAppFileManager.class)).getWxFilePath(this.e);
    VideoJsProxyImpl.a(this.g, paramString, new File(this.e).length(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */