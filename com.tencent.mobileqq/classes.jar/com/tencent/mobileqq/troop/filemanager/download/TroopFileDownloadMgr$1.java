package com.tencent.mobileqq.troop.filemanager.download;

import azsr;
import azst;
import aztn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileDownloadMgr$1
  implements Runnable
{
  public TroopFileDownloadMgr$1(aztn paramaztn) {}
  
  public void run()
  {
    if (this.this$0.a) {
      return;
    }
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.this$0);
      this.this$0.a = true;
      return;
    }
    azst.a("TroopFileDownloadMgr", azst.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */