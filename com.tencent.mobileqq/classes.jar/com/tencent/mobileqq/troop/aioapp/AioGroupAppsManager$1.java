package com.tencent.mobileqq.troop.aioapp;

import bbib;
import bbic;
import bbid;
import bbih;
import com.tencent.qphone.base.util.QLog;

public class AioGroupAppsManager$1
  implements Runnable
{
  public AioGroupAppsManager$1(bbib parambbib) {}
  
  public void run()
  {
    bbib.a(this.this$0).b();
    bbib.a(this.this$0).a();
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "login fullList from db " + bbih.a(this.this$0.a));
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.1
 * JD-Core Version:    0.7.0.1
 */