package com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.List;

class C2CFileDownloader$1
  extends FileTransferObserver
{
  C2CFileDownloader$1(C2CFileDownloader paramC2CFileDownloader, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  public void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (paramBoolean2) {
      paramString4 = paramString4 + "&isthumb=0";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloaderC2cdownloaderC2CFileDownloader.a(paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramList, paramString5, paramBundle, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader.C2CFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */