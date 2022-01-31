package com.tencent.mobileqq.msgbackup.controller;

import auby;
import aucf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class MsgBackupManager$5
  implements Runnable
{
  public MsgBackupManager$5(aucf paramaucf) {}
  
  public void run()
  {
    List localList = aucf.a(this.this$0).a().b();
    if (aucf.a(this.this$0) != null) {
      aucf.a(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */