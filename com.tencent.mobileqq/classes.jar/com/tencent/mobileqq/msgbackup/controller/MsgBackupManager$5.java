package com.tencent.mobileqq.msgbackup.controller;

import awnk;
import awnr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class MsgBackupManager$5
  implements Runnable
{
  public MsgBackupManager$5(awnr paramawnr) {}
  
  public void run()
  {
    List localList = awnr.a(this.this$0).a().b();
    if (awnr.a(this.this$0) != null) {
      awnr.a(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */