package com.tencent.mobileqq.uniformdownload.util;

final class UniformDownloadUtil$2
  implements Runnable
{
  UniformDownloadUtil$2(String paramString, UniformDownloadUtil.GetApkNameCallback paramGetApkNameCallback) {}
  
  public void run()
  {
    String str = UniformDownloadUtil.c(this.a);
    UniformDownloadUtil.GetApkNameCallback localGetApkNameCallback = this.b;
    if (localGetApkNameCallback != null) {
      localGetApkNameCallback.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.2
 * JD-Core Version:    0.7.0.1
 */