package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class WeiyunFileViewerAdapter
  extends FileViewerAdapterBase
{
  private final QQAppInterface a;
  private WeiYunFileInfo b;
  private FileManagerEntity c;
  
  public WeiyunFileViewerAdapter(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.a = paramQQAppInterface;
    this.b = paramWeiYunFileInfo;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    this.c = paramFileManagerEntity;
    QQFileManagerUtil.j(paramFileManagerEntity);
  }
  
  public long a()
  {
    FileManagerEntity localFileManagerEntity = this.c;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.nSessionId;
    }
    return -1L;
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public String b()
  {
    return this.b.c;
  }
  
  public void b(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.c;
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.strThumbPath = paramString;
      return;
    }
    this.b.l = paramString;
  }
  
  public long c()
  {
    return this.b.d;
  }
  
  public int d()
  {
    if ((this.b.o) && (this.b.c.toLowerCase().endsWith("heic"))) {
      return 0;
    }
    return FileManagerUtil.c(this.b.c);
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
    FileManagerEntity localFileManagerEntity = this.c;
    if ((localFileManagerEntity != null) && (localFileManagerEntity.nFileType == 5) && (FileUtil.b(this.c.getFilePath()))) {
      return this.c.getFilePath();
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
    return this.b.a;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public String l()
  {
    return p();
  }
  
  public int m()
  {
    Object localObject = this.c;
    int i;
    if (localObject != null)
    {
      i = ((FileManagerEntity)localObject).getCloudType();
    }
    else
    {
      FileManagerEntity localFileManagerEntity = this.a.getFileManagerRSCenter().a(this.b.a);
      localObject = localFileManagerEntity;
      if (localFileManagerEntity == null) {
        localObject = this.a.getFileManagerDataCenter().c(this.b.a);
      }
      if (localObject != null)
      {
        a((FileManagerEntity)localObject);
        i = ((FileManagerEntity)localObject).getCloudType();
      }
      else
      {
        i = 2;
      }
    }
    int j = i;
    if (2 == i)
    {
      j = i;
      if (FileUtil.b(o())) {
        j = 3;
      }
    }
    return j;
  }
  
  public int n()
  {
    FileManagerEntity localFileManagerEntity = this.c;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.status;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getFileStatus: has not status");
    }
    return -1;
  }
  
  public String o()
  {
    Object localObject = this.c;
    if (localObject != null) {
      return ((FileManagerEntity)localObject).getFilePath();
    }
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerRSCenter().a(this.b.a);
    localObject = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      localObject = this.a.getFileManagerDataCenter().c(this.b.a);
    }
    if (localObject != null)
    {
      a((FileManagerEntity)localObject);
      return this.c.getFilePath();
    }
    return null;
  }
  
  public String p()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (FileUtil.b(((FileManagerEntity)localObject).getFilePath())) {
        return this.c.getFilePath();
      }
      return this.c.strThumbPath;
    }
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerRSCenter().a(this.b.a);
    localObject = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      localObject = this.a.getFileManagerDataCenter().c(this.b.a);
    }
    if (localObject != null)
    {
      a((FileManagerEntity)localObject);
      if (FileUtil.b(((FileManagerEntity)localObject).getFilePath())) {
        return ((FileManagerEntity)localObject).getFilePath();
      }
      return ((FileManagerEntity)localObject).strThumbPath;
    }
    return this.b.l;
  }
  
  public int q()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public FileManagerEntity r()
  {
    Object localObject1 = this.c;
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = this.a.getFileManagerRSCenter().a(this.b.a);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.a.getFileManagerDataCenter().c(this.b.a);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = FileManagerUtil.a(this.b);
    }
    if (localObject2 != null) {
      a((FileManagerEntity)localObject2);
    }
    return this.c;
  }
  
  public WeiYunFileInfo s()
  {
    return this.b;
  }
  
  public String t()
  {
    return FileUtil.a(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.WeiyunFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */