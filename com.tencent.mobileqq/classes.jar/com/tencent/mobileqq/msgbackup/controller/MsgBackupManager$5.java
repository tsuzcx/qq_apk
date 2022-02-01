package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

class MsgBackupManager$5
  implements Runnable
{
  MsgBackupManager$5(MsgBackupManager paramMsgBackupManager) {}
  
  public void run()
  {
    List localList = ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).getAllMsgTableData(MsgBackupManager.e(this.this$0));
    if (MsgBackupManager.f(this.this$0) != null) {
      MsgBackupManager.f(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */