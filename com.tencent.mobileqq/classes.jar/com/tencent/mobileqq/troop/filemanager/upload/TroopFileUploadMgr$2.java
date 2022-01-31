package com.tencent.mobileqq.troop.filemanager.upload;

import bbxo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileUploadMgr$2
  implements Runnable
{
  public TroopFileUploadMgr$2(bbxo parambbxo) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.2
 * JD-Core Version:    0.7.0.1
 */