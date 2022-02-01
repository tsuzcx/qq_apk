package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadBPTrans
{
  private static UniformDownloadBPTrans a;
  
  public static UniformDownloadBPTrans a()
  {
    try
    {
      if (a == null) {
        a = new UniformDownloadBPTrans();
      }
      UniformDownloadBPTrans localUniformDownloadBPTrans = a;
      return localUniformDownloadBPTrans;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] delBPTransItem. url[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.i("UniformDownloadBPTrans", 1, localStringBuilder.toString());
    if (UniformDownloadMgr.a().b() == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] delBPTransItem failed APP=null. url[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.e("UniformDownloadBPTrans", 1, localStringBuilder.toString());
      return;
    }
    if (UniformDownloadBPTransProxy.a() != null) {
      UniformDownloadBPTransProxy.a().b(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    Object localObject = new UniformDownloadBPTransEntity();
    ((UniformDownloadBPTransEntity)localObject).mUrl = paramString1;
    ((UniformDownloadBPTransEntity)localObject).mFileName = paramString2;
    ((UniformDownloadBPTransEntity)localObject).mFileSize = paramLong;
    ((UniformDownloadBPTransEntity)localObject).mFilePath = paramString4;
    ((UniformDownloadBPTransEntity)localObject).mTempPath = paramString3;
    if (UniformDownloadMgr.a().b() == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL] addBPTransItem.failed APP=null, filename[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("] fillesize[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] tempPath[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("] strPath[");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append("] url[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("]");
      QLog.e("UniformDownloadBPTrans", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (UniformDownloadBPTransProxy.a() != null) {
      UniformDownloadBPTransProxy.a().a((UniformDownloadBPTransEntity)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL] addBPTransItem.filename[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("] fillesize[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("] tempPath[");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("] strPath[");
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append("] url[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("]");
    QLog.i("UniformDownloadBPTrans", 1, ((StringBuilder)localObject).toString());
  }
  
  public UniformDownloadBPTrans.BreakpointTransInfo b(String paramString)
  {
    Object localObject;
    if (UniformDownloadMgr.a().b() == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL] getBPTransItem failed APP=null. url[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.e("UniformDownloadBPTrans", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    if (UniformDownloadBPTransProxy.a() != null)
    {
      paramString = UniformDownloadBPTransProxy.a().a(paramString);
    }
    else
    {
      QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] getUDLBPTransProxy=null.");
      paramString = null;
    }
    if (paramString != null)
    {
      localObject = new UniformDownloadBPTrans.BreakpointTransInfo();
      ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).a = paramString.mFileName;
      ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).b = paramString.mFileSize;
      ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).d = paramString.mFilePath;
      ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).c = paramString.mTempPath;
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloadBPTrans
 * JD-Core Version:    0.7.0.1
 */