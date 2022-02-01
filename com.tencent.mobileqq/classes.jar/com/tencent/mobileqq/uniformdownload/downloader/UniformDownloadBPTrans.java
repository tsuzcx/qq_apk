package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadBPTrans
{
  private static UniformDownloadBPTrans a = null;
  
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
  
  public UniformDownloadBPTrans.BreakpointTransInfo a(String paramString)
  {
    if (UniformDownloadMgr.a().a() == null) {
      QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] getBPTransItem failed APP=null. url[" + paramString + "]");
    }
    for (;;)
    {
      return null;
      if (UniformDownloadBPTransProxy.a() != null) {}
      for (paramString = UniformDownloadBPTransProxy.a().a(paramString); paramString != null; paramString = null)
      {
        UniformDownloadBPTrans.BreakpointTransInfo localBreakpointTransInfo = new UniformDownloadBPTrans.BreakpointTransInfo();
        localBreakpointTransInfo.jdField_a_of_type_JavaLangString = paramString.mFileName;
        localBreakpointTransInfo.jdField_a_of_type_Long = paramString.mFileSize;
        localBreakpointTransInfo.c = paramString.mFilePath;
        localBreakpointTransInfo.b = paramString.mTempPath;
        return localBreakpointTransInfo;
        QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] getUDLBPTransProxy=null.");
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("UniformDownloadBPTrans", 1, "[UniformDL] delBPTransItem. url[" + paramString + "]");
    if (UniformDownloadMgr.a().a() == null) {
      QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] delBPTransItem failed APP=null. url[" + paramString + "]");
    }
    while (UniformDownloadBPTransProxy.a() == null) {
      return;
    }
    UniformDownloadBPTransProxy.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
    localUniformDownloadBPTransEntity.mUrl = paramString1;
    localUniformDownloadBPTransEntity.mFileName = paramString2;
    localUniformDownloadBPTransEntity.mFileSize = paramLong;
    localUniformDownloadBPTransEntity.mFilePath = paramString4;
    localUniformDownloadBPTransEntity.mTempPath = paramString3;
    if (UniformDownloadMgr.a().a() == null)
    {
      QLog.e("UniformDownloadBPTrans", 1, "[UniformDL] addBPTransItem.failed APP=null, filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
      return;
    }
    if (UniformDownloadBPTransProxy.a() != null) {
      UniformDownloadBPTransProxy.a().a(localUniformDownloadBPTransEntity);
    }
    QLog.i("UniformDownloadBPTrans", 1, "[UniformDL] addBPTransItem.filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloadBPTrans
 * JD-Core Version:    0.7.0.1
 */