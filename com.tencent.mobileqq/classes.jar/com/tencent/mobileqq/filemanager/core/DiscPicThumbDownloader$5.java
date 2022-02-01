package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DiscPicThumbDownloader$5
  extends FileTransferObserver
{
  DiscPicThumbDownloader$5(DiscPicThumbDownloader paramDiscPicThumbDownloader) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    paramList = new StringBuilder();
    paramList.append("[downloadThumb]  ID[");
    paramList.append(paramLong2);
    paramList.append("] OnDiscDownloadInfo");
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, paramList.toString());
    DiscPicThumbDownloader.a(this.a, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramString6, paramLong2, paramBundle);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    paramString2 = new StringBuilder();
    paramString2.append("[downloadThumb]  ID[");
    paramString2.append(paramLong2);
    paramString2.append("] OnDiscDownloadInfo");
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, paramString2.toString());
    this.a.a(paramBoolean, paramLong1, paramString1, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.5
 * JD-Core Version:    0.7.0.1
 */