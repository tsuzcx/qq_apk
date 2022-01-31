package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajjy;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import vnq;

class VideoJsPlugin$4
  implements vnq
{
  VideoJsPlugin$4(VideoJsPlugin paramVideoJsPlugin, long paramLong1, String paramString1, LocalMediaInfo paramLocalMediaInfo, String paramString2, long paramLong2, AppBrandRuntime paramAppBrandRuntime) {}
  
  public void onFailure(String paramString)
  {
    paramString = paramString.split("\n");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      QLog.i("VideoJsPlugin", 2, "onFailure: " + str);
      i += 1;
    }
    if (this.val$cmd.contains("-vf"))
    {
      VideoJsPlugin.access$500(this.this$0, this.val$info, false);
      return;
    }
    paramString = MiniAppFileManager.getInstance().getWxFilePath(this.val$info.path);
    VideoJsPlugin.access$600(this.this$0, paramString, this.val$info.fileSize, this.val$info);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress finish " + paramBoolean + " " + (System.currentTimeMillis() - this.val$now));
    }
  }
  
  public void onProgress(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress progress " + paramString);
    }
    if ((paramString.length() < 90) || (paramString.length() > 150)) {}
    for (;;)
    {
      return;
      String str = new Scanner(paramString).findWithinHorizon(VideoJsPlugin.access$1200(), 0);
      if (QLog.isColorLevel()) {
        QLog.i("VideoJsPlugin", 2, "onProgress: " + paramString.length());
      }
      if (str != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoJsPlugin", 2, "onProgress: valid " + paramString.length());
        }
        paramString = str.split(":");
        if (paramString.length > 2) {
          try
          {
            int i = Integer.parseInt(paramString[0]);
            int j = Integer.parseInt(paramString[1]);
            double d = Double.parseDouble(paramString[2]);
            i = (int)((float)(TimeUnit.HOURS.toMillis(i) + TimeUnit.MINUTES.toMillis(j) + (1000.0D * d)) * 100.0F / (float)this.val$duration);
            if ((i < 100) && (this.val$runtime != null))
            {
              VideoJsPlugin.access$700(this.this$0, this.val$runtime, ajjy.a(2131650508) + i + "%");
              return;
            }
          }
          catch (NumberFormatException paramString) {}
        }
      }
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress success " + paramString + " " + this.val$cmd);
    }
    if (this.val$cmd.contains("-vf"))
    {
      paramString = this.val$info;
      paramString.mediaWidth /= 2;
      paramString = this.val$info;
      paramString.mediaHeight /= 2;
    }
    paramString = MiniAppFileManager.getInstance().getWxFilePath(this.val$outPath);
    VideoJsPlugin.access$600(this.this$0, paramString, new File(this.val$outPath).length(), this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */