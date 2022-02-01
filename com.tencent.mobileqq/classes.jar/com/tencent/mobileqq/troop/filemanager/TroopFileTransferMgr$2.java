package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

class TroopFileTransferMgr$2
  implements Runnable
{
  TroopFileTransferMgr$2(TroopFileTransferMgr paramTroopFileTransferMgr, TroopFileTransferManager.Item paramItem, UUID paramUUID) {}
  
  public void run()
  {
    switch (this.a.Status)
    {
    default: 
      return;
    case 11: 
      if (this.a.LocalFile != null) {
        new VFSFile(this.a.LocalFile).delete();
      }
      break;
    case 9: 
    case 10: 
      if (this.a.TmpFile != null) {
        new VFSFile(this.a.TmpFile).delete();
      }
      break;
    }
    this.this$0.a(this.b, true);
    TroopFileTransferManager.Item localItem = this.a;
    localItem.StatusUpdateTimeMs = 0L;
    localItem.ErrorCode = 0;
    localItem.LocalFile = null;
    this.this$0.b(localItem, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.2
 * JD-Core Version:    0.7.0.1
 */