package com.tencent.mqp.app.sec;

import com.tencent.mobileqq.app.QQAppInterface;

class ScConfigManager$LoadLocalConfig
  implements Runnable
{
  private boolean a;
  private String b;
  private QQAppInterface c;
  
  public ScConfigManager$LoadLocalConfig(ScConfigManager paramScConfigManager, QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.c = paramQQAppInterface;
    this.b = paramString;
    this.a = paramBoolean;
  }
  
  public void run()
  {
    ScConfigManager.a(this.this$0, this.b);
    if (this.a) {
      this.this$0.a(this.c, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.ScConfigManager.LoadLocalConfig
 * JD-Core Version:    0.7.0.1
 */