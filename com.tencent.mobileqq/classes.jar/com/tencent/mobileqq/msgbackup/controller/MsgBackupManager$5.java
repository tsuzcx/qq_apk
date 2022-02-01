package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class MsgBackupManager$5
  implements Runnable
{
  MsgBackupManager$5(MsgBackupManager paramMsgBackupManager) {}
  
  public void run()
  {
    List localList = MsgBackupManager.a(this.this$0).getMessageFacade().b();
    if (MsgBackupManager.a(this.this$0) != null) {
      MsgBackupManager.a(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */