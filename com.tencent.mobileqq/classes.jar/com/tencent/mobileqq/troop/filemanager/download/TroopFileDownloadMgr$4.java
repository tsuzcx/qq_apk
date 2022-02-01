package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class TroopFileDownloadMgr$4
  extends TroopFileGetOneFileInfoObserver
{
  TroopFileDownloadMgr$4(TroopFileDownloadMgr paramTroopFileDownloadMgr, long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    TroopFileDownloadMgr.a(this.d, this.a, this.b, this.c, paramBoolean, paramInt, paramFileInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.4
 * JD-Core Version:    0.7.0.1
 */