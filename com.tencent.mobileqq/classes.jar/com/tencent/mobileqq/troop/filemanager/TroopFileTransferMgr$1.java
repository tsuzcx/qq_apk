package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import java.util.Set;

class TroopFileTransferMgr$1
  extends TroopFileDownloadMgr.FileDownloadMgrObserver
{
  TroopFileTransferMgr$1(TroopFileTransferMgr paramTroopFileTransferMgr) {}
  
  protected void a(Set<Long> paramSet)
  {
    TroopFileTransferMgr localTroopFileTransferMgr = this.a;
    localTroopFileTransferMgr.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(TroopFileTransferMgr.a(localTroopFileTransferMgr))))) {
      this.a.b = 2;
    }
    int i = TroopFileTransferUtil.Log.a;
    paramSet = new StringBuilder();
    paramSet.append("onW2MPausedDownload mW2MPausedUploadState:");
    paramSet.append(this.a.a);
    paramSet.append(" mW2MPausedDownloadState:");
    paramSet.append(this.a.b);
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", i, paramSet.toString());
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        TroopFileError.a(TroopFileTransferMgr.a(this.a), TroopFileTransferMgr.b(this.a), 107);
      }
      paramSet = this.a;
      paramSet.a = 0;
      paramSet.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.1
 * JD-Core Version:    0.7.0.1
 */