package com.tencent.mobileqq.troop.aioapp;

import azjq;
import azjr;
import azjs;
import azjw;
import com.tencent.qphone.base.util.QLog;

public class AioGroupAppsManager$1
  implements Runnable
{
  public AioGroupAppsManager$1(azjq paramazjq) {}
  
  public void run()
  {
    azjq.a(this.this$0).b();
    azjq.a(this.this$0).a();
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "login fullList from db " + azjw.a(this.this$0.a));
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.1
 * JD-Core Version:    0.7.0.1
 */