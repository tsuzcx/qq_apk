package com.tencent.mobileqq.troop.filemanager.download;

import bfmd;
import bfmf;
import bfmz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileDownloadMgr$1
  implements Runnable
{
  public TroopFileDownloadMgr$1(bfmz parambfmz) {}
  
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
    bfmf.a("TroopFileDownloadMgr", bfmf.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */