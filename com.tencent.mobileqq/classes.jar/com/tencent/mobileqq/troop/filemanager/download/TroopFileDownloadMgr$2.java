package com.tencent.mobileqq.troop.filemanager.download;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

class TroopFileDownloadMgr$2
  implements Runnable
{
  TroopFileDownloadMgr$2(TroopFileDownloadMgr paramTroopFileDownloadMgr) {}
  
  public void run()
  {
    if (!this.this$0.a) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.this$0);
    this.this$0.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */