package com.tencent.mobileqq.troop.filemanager.download;

import bfvp;
import bfvr;
import bfwl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileDownloadMgr$1
  implements Runnable
{
  public TroopFileDownloadMgr$1(bfwl parambfwl) {}
  
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
    bfvr.a("TroopFileDownloadMgr", bfvr.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */