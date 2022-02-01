package com.tencent.mobileqq.troop.filemanager.upload;

import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import java.util.UUID;

class TroopFileUploadMgr$6
  implements TroopFileUploadMgr.ITroopFileUploadWorkerListener
{
  TroopFileUploadMgr$6(TroopFileUploadMgr paramTroopFileUploadMgr) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileUploadMgr.ITroopFileUploadWorker paramITroopFileUploadWorker)
  {
    TroopFileTransferMgr.a(new TroopFileUploadMgr.6.1(this, paramUUID, paramBoolean, paramInt, paramITroopFileUploadWorker), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.6
 * JD-Core Version:    0.7.0.1
 */