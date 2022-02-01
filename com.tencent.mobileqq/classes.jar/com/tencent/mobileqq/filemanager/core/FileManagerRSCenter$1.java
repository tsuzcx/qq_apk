package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.core.WeiyunDownloadService;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.vip.OpenWeiyunVipHelper;

class FileManagerRSCenter$1
  extends FMObserver
{
  FileManagerRSCenter$1(FileManagerRSCenter paramFileManagerRSCenter) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSCenter<FileAssistant>", 2, "recive TransferEnd, rmove task[" + String.valueOf(paramLong2) + "]!");
    }
    OpenWeiyunVipHelper.a(null, paramInt2);
    paramString1 = this.a.a.getFileManagerDataCenter().a(paramLong2);
    Bundle localBundle;
    if ((paramString1 != null) && (paramString1.nOpType == 50))
    {
      localBundle = new Bundle();
      localBundle.putString("taskId", paramString1.miniAppDownloadId);
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localBundle.putInt("retCode", paramInt1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localBundle.putString("retMsg", paramString1);
      QIPCServerHelper.getInstance().callClient(WeiyunDownloadService.a, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Complete", localBundle, null);
      this.a.a(paramLong2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSCenter.1
 * JD-Core Version:    0.7.0.1
 */