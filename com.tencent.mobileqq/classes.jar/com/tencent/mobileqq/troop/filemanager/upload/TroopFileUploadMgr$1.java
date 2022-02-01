package com.tencent.mobileqq.troop.filemanager.upload;

import bfvp;
import bfvr;
import bfxt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileUploadMgr$1
  implements Runnable
{
  public TroopFileUploadMgr$1(bfxt parambfxt) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    QQAppInterface localQQAppInterface = bfvp.a();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.this$0);
      this.this$0.a = true;
      return;
    }
    bfvr.a("TroopFileUploadMgr", bfvr.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.1
 * JD-Core Version:    0.7.0.1
 */