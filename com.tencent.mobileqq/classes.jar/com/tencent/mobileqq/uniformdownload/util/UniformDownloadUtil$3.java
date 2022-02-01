package com.tencent.mobileqq.uniformdownload.util;

import android.os.Handler;
import android.os.Looper;

final class UniformDownloadUtil$3
  implements UniformDownloadUtil.GetApkNameCallback
{
  UniformDownloadUtil$3(String paramString1, String paramString2) {}
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new UniformDownloadUtil.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.3
 * JD-Core Version:    0.7.0.1
 */