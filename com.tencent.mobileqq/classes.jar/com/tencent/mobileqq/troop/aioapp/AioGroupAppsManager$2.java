package com.tencent.mobileqq.troop.aioapp;

class AioGroupAppsManager$2
  implements Runnable
{
  AioGroupAppsManager$2(AioGroupAppsManager paramAioGroupAppsManager, long paramLong) {}
  
  public void run()
  {
    AioGroupAppsManager.a(this.this$0).a();
    if (!GroupUtil.a(this.this$0.a(this.a))) {
      GroupAppsServlet.a(AioGroupAppsManager.a(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.2
 * JD-Core Version:    0.7.0.1
 */