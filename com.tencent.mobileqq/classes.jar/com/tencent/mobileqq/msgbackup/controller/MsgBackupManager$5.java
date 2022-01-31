package com.tencent.mobileqq.msgbackup.controller;

import askz;
import aslg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.List;

public class MsgBackupManager$5
  implements Runnable
{
  public MsgBackupManager$5(aslg paramaslg) {}
  
  public void run()
  {
    List localList = aslg.a(this.this$0).a().b();
    if (aslg.a(this.this$0) != null) {
      aslg.a(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5
 * JD-Core Version:    0.7.0.1
 */