package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
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
  
  public int a()
  {
    if (this.a.a() == 5) {
      return 5;
    }
    return FileManagerUtil.a(this.a.d());
  }
  
  public long a()
  {
    return -1L;
  }
  
  public FileManagerEntity a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getEntity should not be called on LocalFileViewAdapter");
    }
    return null;
  }
  
  public WeiYunFileInfo a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getWeiyunInfo should not be called on LocalFileViewAdapter");
    }
    return null;
  }
  
  public String a()
  {
    return this.a.d();
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.a.a();
  }
  
  public String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.a() == 5)
    {
      localObject1 = localObject2;
      if (FileUtil.b(this.a.c())) {
        localObject1 = this.a.c();
      }
    }
    return localObject1;
  }
  
  public int c()
  {
    return 3;
  }
  
  public long c()
  {
    return MessageCache.a() * 1000L;
  }
  
  public String c()
  {
    return null;
  }
  
  public int d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getFileStatus: has not status");
    }
    return -1;
  }
  
  public String d()
  {
    return null;
  }
  
  public int e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public String e()
  {
    return null;
  }
  
  public String g()
  {
    return this.a.c();
  }
  
  public String h()
  {
    return this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.LocalFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */