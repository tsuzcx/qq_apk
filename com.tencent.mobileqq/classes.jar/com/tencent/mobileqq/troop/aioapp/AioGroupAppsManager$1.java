package com.tencent.mobileqq.troop.aioapp;

import bfbz;
import bfca;
import bfcb;
import bfcf;
import com.tencent.qphone.base.util.QLog;

public class AioGroupAppsManager$1
  implements Runnable
{
  public AioGroupAppsManager$1(bfbz parambfbz) {}
  
  public void run()
  {
    bfbz.a(this.this$0).b();
    bfbz.a(this.this$0).a();
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "login fullList from db " + bfcf.a(this.this$0.a));
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.1
 * JD-Core Version:    0.7.0.1
 */