package com.tencent.mobileqq.qshadow.core;

import com.tencent.shadow.dynamic.host.DynamicPluginManager;

class DefaultPluginManager$2
  implements Runnable
{
  DefaultPluginManager$2(DefaultPluginManager paramDefaultPluginManager) {}
  
  public void run()
  {
    if (DefaultPluginManager.access$300(this.this$0) != null)
    {
      DefaultPluginManager.access$300(this.this$0).release();
      DefaultPluginManager.access$302(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.DefaultPluginManager.2
 * JD-Core Version:    0.7.0.1
 */