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
    localTroopFileTransferMgr.c = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(TroopFileTransferMgr.a(localTroopFileTransferMgr))))) {
      this.a.c = 2;
    }
    int i = TroopFileTransferUtil.Log.b;
    paramSet = new StringBuilder();
    paramSet.append("onW2MPausedDownload mW2MPausedUploadState:");
    paramSet.append(this.a.b);
    paramSet.append(" mW2MPausedDownloadState:");
    paramSet.append(this.a.c);
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", i, paramSet.toString());
    if (this.a.b > 0)
    {
      if ((this.a.c == 2) || (this.a.b == 2)) {
        TroopFileError.a(TroopFileTransferMgr.b(this.a), TroopFileTransferMgr.c(this.a), 107);
      }
      paramSet = this.a;
      paramSet.b = 0;
      paramSet.c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.1
 * JD-Core Version:    0.7.0.1
 */