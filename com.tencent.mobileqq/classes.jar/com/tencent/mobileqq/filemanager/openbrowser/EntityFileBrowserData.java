package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import mqq.app.MobileQQ;

public class EntityFileBrowserData
  implements IFileBrowserData
{
  protected final FileManagerEntity a;
  protected boolean b;
  
  public EntityFileBrowserData(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.a = paramFileManagerEntity;
    int i = n();
    if ((1 == i) || (2 == i)) {
      this.b = FileManagerUtil.a(paramQQAppInterface.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    }
  }
  
  private int n()
  {
    int j = this.a.getCloudType();
    int i;
    if (2 != j)
    {
      i = j;
      if (5 != j) {}
    }
    else
    {
      i = j;
      if (FileUtil.b(c())) {
        i = 3;
      }
    }
    return i;
  }
  
  public String a()
  {
    return this.a.fileName;
  }
  
  public long b()
  {
    return this.a.fileSize;
  }
  
  public String c()
  {
    return this.a.getFilePath();
  }
  
  public int d()
  {
    return this.a.nFileType;
  }
  
  public int e()
  {
    return this.a.nOpType;
  }
  
  public int f()
  {
    return this.a.peerType;
  }
  
  public int g()
  {
    if ((this.a.isZipInnerFile) && (FileUtil.b(this.a.getFilePath()))) {
      this.a.status = 1;
    }
    return this.a.status;
  }
  
  public String h()
  {
    return this.a.Uuid;
  }
  
  public String i()
  {
    return this.a.WeiYunFileId;
  }
  
  public String j()
  {
    if ((this.a.nFileType == 5) && (FileUtil.b(this.a.getFilePath()))) {
      return this.a.getFilePath();
    }
    return null;
  }
  
  public int k()
  {
    return this.a.apkSafeLevel;
  }
  
  public String l()
  {
    return this.a.apkSafeMsg;
  }
  
  public String m()
  {
    return this.a.apkSafeDetailUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.EntityFileBrowserData
 * JD-Core Version:    0.7.0.1
 */