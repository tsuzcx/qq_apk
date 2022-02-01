package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class LocalFileViewerAdapter
  extends FileViewerAdapterBase
{
  private FileInfo a;
  
  public LocalFileViewerAdapter(FileInfo paramFileInfo)
  {
    this.a = paramFileInfo;
  }
  
  public long a()
  {
    return -1L;
  }
  
  public void a(String paramString) {}
  
  public String b()
  {
    return this.a.e();
  }
  
  public long c()
  {
    return this.a.f();
  }
  
  public int d()
  {
    if (this.a.l() == 5) {
      return 5;
    }
    return FileManagerUtil.c(this.a.e());
  }
  
  public long e()
  {
    return MessageCache.c() * 1000L;
  }
  
  public int f()
  {
    return 0;
  }
  
  public String g()
  {
    if ((this.a.l() == 5) && (FileUtil.b(this.a.d()))) {
      return this.a.d();
    }
    return null;
  }
  
  public String h()
  {
    return null;
  }
  
  public String i()
  {
    return null;
  }
  
  public String j()
  {
    return null;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public int m()
  {
    return 3;
  }
  
  public int n()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getFileStatus: has not status");
    }
    return -1;
  }
  
  public String o()
  {
    return this.a.d();
  }
  
  public String p()
  {
    return this.a.d();
  }
  
  public int q()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public FileManagerEntity r()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getEntity should not be called on LocalFileViewAdapter");
    }
    return QQFileManagerUtil.a(this.a);
  }
  
  public WeiYunFileInfo s()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getWeiyunInfo should not be called on LocalFileViewAdapter");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.LocalFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */