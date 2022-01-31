package com.tencent.mobileqq.troop.filemanager.upload;

import azsr;
import azst;
import azuw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileUploadMgr$1
  implements Runnable
{
  public TroopFileUploadMgr$1(azuw paramazuw) {}
  
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
    azst.a("TroopFileUploadMgr", azst.a, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.1
 * JD-Core Version:    0.7.0.1
 */