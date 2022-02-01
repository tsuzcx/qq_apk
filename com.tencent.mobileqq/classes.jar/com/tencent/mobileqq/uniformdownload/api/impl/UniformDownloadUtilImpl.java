package com.tencent.mobileqq.uniformdownload.api.impl;

import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.IGetFileInfoCallBack;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;

public class UniformDownloadUtilImpl
  implements IUniformDownloadUtil
{
  public String getApkName(String paramString)
  {
    return UniformDownloadUtil.c(paramString);
  }
  
  public void getFileInfoOfUrlAsync(String paramString, IGetFileInfoCallBack paramIGetFileInfoCallBack)
  {
    UniformDownloadUtil.a(paramString, paramIGetFileInfoCallBack);
  }
  
  public void installAPK(String paramString)
  {
    UniformDownloadUtil.d(paramString);
  }
  
  public int openApk(String paramString)
  {
    return UniformDownloadUtil.e(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.api.impl.UniformDownloadUtilImpl
 * JD-Core Version:    0.7.0.1
 */