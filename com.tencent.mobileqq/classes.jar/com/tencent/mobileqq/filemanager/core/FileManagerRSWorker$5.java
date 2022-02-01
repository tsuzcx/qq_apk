package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.app.FileUploadInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.List;

class FileManagerRSWorker$5
  extends FileTransferObserver
{
  FileManagerRSWorker$5(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  public void a()
  {
    this.a.j();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    FileManagerRSWorker.a(this.a, (float)paramLong1, (float)paramLong2);
  }
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    FileManagerRSWorker.a(this.a, paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramList, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    FileManagerRSWorker.a(this.a, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle);
  }
  
  protected void b(boolean paramBoolean, FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo)
  {
    super.b(paramBoolean, paramFileUploadInfo, paramStatictisInfo);
    FileManagerRSWorker.a(this.a, paramBoolean, paramFileUploadInfo);
  }
  
  protected void b(boolean paramBoolean, FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo, List<String> paramList)
  {
    FileManagerRSWorker.a(this.a, paramFileUploadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.5
 * JD-Core Version:    0.7.0.1
 */