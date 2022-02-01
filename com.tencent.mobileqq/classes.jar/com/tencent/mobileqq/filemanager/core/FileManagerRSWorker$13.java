package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class FileManagerRSWorker$13
  implements FMSettingInterface.MoveFileCallback
{
  FileManagerRSWorker$13(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void a()
  {
    this.a.g();
  }
  
  public void a(int paramInt)
  {
    this.a.a(2005);
    this.a.a.getFileManagerNotifyCenter().a(this.a.q, this.a.r, this.a.f, this.a.g, 12, null, paramInt, null);
    FileManagerUtil.a(this.a.a, this.a.B.nSessionId, this.a.K, this.a.C, FileManagerRSWorker.a(this.a), this.a.f, this.a.i, this.a.B.strFileMd5, 9040L, "", this.a.Q, this.a.o, this.a.s, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "sdcard full", null);
    FileManagerUtil.a(this.a.a, this.a.B.nSessionId, this.a.L, this.a.C, FileManagerRSWorker.a(this.a), this.a.f, this.a.i, this.a.B.strFileMd5, 9040L, "", this.a.Q, this.a.o, this.a.s, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.c(this.a), "sdcard full", null);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a.e.equalsIgnoreCase(paramString1))
    {
      this.a.e = paramString2;
      return;
    }
    if (this.a.c.equalsIgnoreCase(paramString1))
    {
      paramString1 = this.a;
      paramString1.c = paramString2;
      paramString1.B.setFilePath(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.13
 * JD-Core Version:    0.7.0.1
 */