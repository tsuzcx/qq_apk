package com.tencent.mobileqq.pluginsdk;

class f
  implements Runnable
{
  f(PluginManageHandler paramPluginManageHandler) {}
  
  public void run()
  {
    if (PluginManageHandler.a(this.a) == null) {
      synchronized (this.a)
      {
        if ((PluginManageHandler.a(this.a) == null) && (PluginManageHandler.b(this.a) != null))
        {
          PluginManageHandler.a(this.a, PluginManageHandler.b(this.a).onGetPluginManager());
          PluginManageHandler.c(this.a);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.f
 * JD-Core Version:    0.7.0.1
 */