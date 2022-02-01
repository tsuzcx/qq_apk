package com.tencent.mobileqq.wxmini.impl.loader;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class WxDFLoader$3
  implements Downloader.DownloadListener
{
  WxDFLoader$3(WxDFLoader paramWxDFLoader) {}
  
  public void onDownloadCanceled(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadDF onDownloadCanceled:");
    localStringBuilder.append(paramString);
    QLog.e("wxmini.WxDFLoader", 1, localStringBuilder.toString());
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadDF onDownloadFailed:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" result:");
    localStringBuilder.append(paramDownloadResult.getContent());
    QLog.e("wxmini.WxDFLoader", 1, localStringBuilder.toString());
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadDF onDownloadSucceed");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" result:");
    localStringBuilder.append(paramDownloadResult.getContent());
    QLog.e("wxmini.WxDFLoader", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.loader.WxDFLoader.3
 * JD-Core Version:    0.7.0.1
 */