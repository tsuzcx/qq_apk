package com.tencent.mobileqq.search.rich;

import java.lang.ref.WeakReference;

class ArkAppModule$1
  implements Runnable
{
  ArkAppModule$1(ArkAppModule paramArkAppModule, long paramLong, String paramString) {}
  
  public void run()
  {
    if (ArkAppModule.a(this.this$0) != null)
    {
      ArkAppModule.ArkAppModuleEvent localArkAppModuleEvent = (ArkAppModule.ArkAppModuleEvent)ArkAppModule.a(this.this$0).get();
      if (localArkAppModuleEvent != null) {
        localArkAppModuleEvent.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkAppModule.1
 * JD-Core Version:    0.7.0.1
 */