package com.tencent.mobileqq.uniformdownload.util;

import android.os.Handler;
import android.os.Looper;

final class UniformDownloadUtil$4
  implements UniformDownloadUtil.GetApkNameCallback
{
  UniformDownloadUtil$4(String paramString1, String paramString2) {}
  
  public void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new UniformDownloadUtil.4.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.4
 * JD-Core Version:    0.7.0.1
 */