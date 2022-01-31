package com.tencent.mobileqq.msgbackup.controller;

import arot;
import arpa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.List;

public class MsgBackupManager$5
  implements Runnable
{
  public MsgBackupManager$5(arpa paramarpa) {}
  
  public void run()
  {
    List localList = arpa.a(this.this$0).a().b();
    if (arpa.a(this.this$0) != null) {
      arpa.a(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */