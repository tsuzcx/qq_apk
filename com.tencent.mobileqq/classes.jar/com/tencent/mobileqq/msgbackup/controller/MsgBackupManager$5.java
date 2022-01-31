package com.tencent.mobileqq.msgbackup.controller;

import augh;
import augo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class MsgBackupManager$5
  implements Runnable
{
  public MsgBackupManager$5(augo paramaugo) {}
  
  public void run()
  {
    List localList = augo.a(this.this$0).a().b();
    if (augo.a(this.this$0) != null) {
      augo.a(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */