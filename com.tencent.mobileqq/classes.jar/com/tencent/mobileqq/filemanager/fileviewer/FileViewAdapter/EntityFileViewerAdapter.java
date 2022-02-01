package com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class EntityFileViewerAdapter
  extends FileViewerAdapterBase
{
  protected boolean a;
  protected boolean b;
  protected long c;
  private final QQAppInterface d;
  private FileManagerEntity e;
  
  public EntityFileViewerAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.d = paramQQAppInterface;
    this.e = paramFileManagerEntity;
    int i = m();
    boolean bool2 = true;
    if ((1 == i) || (2 == m())) {
      this.a = FileManagerUtil.a(this.d.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    }
    this.c = 3145728L;
    boolean bool1;
    if (3 == m())
    {
      bool1 = bool2;
      if (FileManagerUtil.b(this)) {}
    }
    else if ((6 == m()) && (n() == 1) && (FileUtils.fileExistsAndNotEmpty(o())))
    {
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    this.b = bool1;
  }
  
  public long a()
  {
    return this.e.nSessionId;
  }
  
  public void a(String paramString)
  {
    this.e.strLargeThumPath = paramString;
  }
  
  public String b()
  {
    return this.e.fileName;
  }
  
  public long c()
  {
    return this.e.fileSize;
  }
  
  public int d()
  {
    return this.e.nFileType;
  }
  
  public long e()
  {
    return this.e.srvTime;
  }
  
  public int f()
  {
    return this.e.peerType;
  }
  
  public String g()
  {
    if ((this.e.nFileType == 5) && (FileUtil.b(this.e.getFilePath()))) {
      return this.e.getFilePath();
    }
    return null;
  }
  
  public String h()
  {
    return this.e.Uuid;
  }
  
  public String i()
  {
    return this.e.peerUin;
  }
  
  public String j()
  {
    return this.e.WeiYunFileId;
  }
  
  public boolean k()
  {
    return this.e.bSend;
  }
  
  public String l()
  {
    if (FileUtil.b(this.e.getFilePath())) {
      return this.e.getFilePath();
    }
    return this.e.strLargeThumPath;
  }
  
  public int m()
  {
    int j = this.e.getCloudType();
    int i;
    if (2 != j)
    {
      i = j;
      if (5 != j) {}
    }
    else
    {
      i = j;
      if (FileUtil.b(o())) {
        i = 3;
      }
    }
    return i;
  }
  
  public int n()
  {
    if ((this.e.isZipInnerFile) && (FileUtil.b(this.e.getFilePath()))) {
      this.e.status = 1;
    }
    return this.e.status;
  }
  
  public String o()
  {
    return this.e.getFilePath();
  }
  
  public String p()
  {
    if (FileUtil.b(this.e.getFilePath())) {
      return this.e.getFilePath();
    }
    return this.e.strThumbPath;
  }
  
  public int q()
  {
    return this.e.nOpType;
  }
  
  public FileManagerEntity r()
  {
    return this.e;
  }
  
  public WeiYunFileInfo s()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EntityFileViewerAdapter", 4, "getWeiyunInfo should not be called on EntityFileViewAdapter");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.EntityFileViewerAdapter
 * JD-Core Version:    0.7.0.1
 */