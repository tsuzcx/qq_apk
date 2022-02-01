package com.tencent.mobileqq.troop.filemanager.thumbnail;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

class TroopFileThumbnailMgr$2
  implements Runnable
{
  TroopFileThumbnailMgr$2(TroopFileThumbnailMgr paramTroopFileThumbnailMgr, TroopFileTransferManager.Item paramItem, long paramLong, int paramInt) {}
  
  public void run()
  {
    String str = this.a.getThumbnailFile(this.b, 640);
    if (FileUtil.b(str))
    {
      TroopFileThumbnailMgr.a(this.this$0).a(this.b, this.a, this.c, str);
      return;
    }
    if ((this.a.LocalFile != null) && (new VFSFile(this.a.LocalFile).exists())) {
      TroopFileThumbnailMgr.a(this.this$0).a(this.b, this.a, this.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.2
 * JD-Core Version:    0.7.0.1
 */