package com.tencent.mobileqq.config;

import amow;
import java.util.TimerTask;

public class ConfigManager$1
  extends TimerTask
{
  int a;
  
  public void run()
  {
    synchronized (amow.a(this.this$0))
    {
      this.a += 1;
      if (this.a > 30)
      {
        this.this$0.d();
        cancel();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ConfigManager.1
 * JD-Core Version:    0.7.0.1
 */