package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.FileUploadMgrObserver;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import java.util.Set;

class TroopFileTransferMgr$1
  extends TroopFileUploadMgr.FileUploadMgrObserver
{
  TroopFileTransferMgr$1(TroopFileTransferMgr paramTroopFileTransferMgr) {}
  
  public void a(Set<Long> paramSet)
  {
    this.a.a = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(TroopFileTransferMgr.a(this.a))))) {
      this.a.a = 2;
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "onW2MPausedUpload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.b > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        TroopFileError.a(TroopFileTransferMgr.a(this.a), TroopFileTransferMgr.b(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.1
 * JD-Core Version:    0.7.0.1
 */