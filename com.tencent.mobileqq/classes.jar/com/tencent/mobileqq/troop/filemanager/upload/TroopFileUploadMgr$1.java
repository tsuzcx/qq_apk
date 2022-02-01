package com.tencent.mobileqq.troop.filemanager.upload;

import bfmd;
import bfmf;
import bfoh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileUploadMgr$1
  implements Runnable
{
  public TroopFileUploadMgr$1(bfoh parambfoh) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.this$0);
      this.this$0.a = true;
      return;
    }
    bfmf.a("TroopFileUploadMgr", bfmf.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.1
 * JD-Core Version:    0.7.0.1
 */