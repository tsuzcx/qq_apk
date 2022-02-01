package com.tencent.mobileqq.troop.aioapp;

import com.tencent.qphone.base.util.QLog;

class AioGroupAppsManager$1
  implements Runnable
{
  AioGroupAppsManager$1(AioGroupAppsManager paramAioGroupAppsManager) {}
  
  public void run()
  {
    AioGroupAppsManager.a(this.this$0).b();
    AioGroupAppsManager.a(this.this$0).a();
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "login fullList from db " + LogUtil.a(this.this$0.a));
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.1
 * JD-Core Version:    0.7.0.1
 */