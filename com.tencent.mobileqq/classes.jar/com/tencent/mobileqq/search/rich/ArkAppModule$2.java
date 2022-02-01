package com.tencent.mobileqq.search.rich;

import java.lang.ref.WeakReference;

class ArkAppModule$2
  implements Runnable
{
  ArkAppModule$2(ArkAppModule paramArkAppModule, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (ArkAppModule.a(this.this$0) != null)
    {
      ArkAppModule.ArkAppModuleEvent localArkAppModuleEvent = (ArkAppModule.ArkAppModuleEvent)ArkAppModule.a(this.this$0).get();
      if (localArkAppModuleEvent != null) {
        localArkAppModuleEvent.a(this.a, this.b, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkAppModule.2
 * JD-Core Version:    0.7.0.1
 */