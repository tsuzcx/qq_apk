package com.tencent.mobileqq.troop.filemanager.upload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;

class TroopFileUploadMgr$1
  implements Runnable
{
  TroopFileUploadMgr$1(TroopFileUploadMgr paramTroopFileUploadMgr) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.this$0);
      this.this$0.a = true;
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.1
 * JD-Core Version:    0.7.0.1
 */