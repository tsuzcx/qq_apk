package com.tencent.mobileqq.uniformdownload.util;

final class UniformDownloadUtil$1
  implements Runnable
{
  UniformDownloadUtil$1(String paramString, IGetFileInfoCallBack paramIGetFileInfoCallBack) {}
  
  public void run()
  {
    UniformDownloadUtil.FileInfo localFileInfo = UniformDownloadUtil.b(this.a);
    IGetFileInfoCallBack localIGetFileInfoCallBack = this.b;
    if ((localIGetFileInfoCallBack != null) && (localFileInfo != null)) {
      localIGetFileInfoCallBack.a(localFileInfo.a, localFileInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */