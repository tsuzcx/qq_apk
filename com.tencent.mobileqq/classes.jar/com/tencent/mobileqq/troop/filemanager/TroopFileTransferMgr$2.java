package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import java.util.Set;

class TroopFileTransferMgr$2
  extends TroopFileDownloadMgr.FileDownloadMgrObserver
{
  TroopFileTransferMgr$2(TroopFileTransferMgr paramTroopFileTransferMgr) {}
  
  public void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(TroopFileTransferMgr.c(this.a))))) {
      this.a.b = 2;
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        TroopFileError.a(TroopFileTransferMgr.b(this.a), TroopFileTransferMgr.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.2
 * JD-Core Version:    0.7.0.1
 */