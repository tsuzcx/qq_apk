package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ExtfDownloadFileInfo
{
  private String a;
  private long b = 0L;
  private byte[] c;
  private List<ExcitingTransferHostInfo> d = null;
  private String e = null;
  private String f = null;
  private boolean g = false;
  private String h = null;
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<ExcitingTransferHostInfo> paramList)
  {
    this.d = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.a))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "mFilePath is null");
      return false;
    }
    if (0L == this.b)
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "mFileSize is 0");
      return false;
    }
    List localList = this.d;
    if ((localList != null) && (localList.size() != 0))
    {
      if (TextUtils.isEmpty(this.e))
      {
        QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "serverPath is null");
        return false;
      }
      if (TextUtils.isEmpty(this.f))
      {
        QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "strCookie is null");
        return false;
      }
      return true;
    }
    QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "hostList is null");
    return false;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
  
  public byte[] d()
  {
    return this.c;
  }
  
  public List<ExcitingTransferHostInfo> e()
  {
    return this.d;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public String i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfDownloadFileInfo
 * JD-Core Version:    0.7.0.1
 */