package com.tencent.mobileqq.troop.filemanager.download;

import aysv;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileDownloadMgr$2
  implements Runnable
{
  public TroopFileDownloadMgr$2(aysv paramaysv) {}
  
  public void run()
  {
    if (!this.this$0.a) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.this$0);
    this.this$0.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */