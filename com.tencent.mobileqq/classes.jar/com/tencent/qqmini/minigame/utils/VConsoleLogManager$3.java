package com.tencent.qqmini.minigame.utils;

class VConsoleLogManager$3
  implements Runnable
{
  VConsoleLogManager$3(VConsoleLogManager paramVConsoleLogManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    VConsoleLogManager localVConsoleLogManager = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:console.");
    localStringBuilder.append(this.val$logLevel);
    localStringBuilder.append("(\"");
    localStringBuilder.append(this.val$logContent);
    localStringBuilder.append("\")");
    VConsoleLogManager.access$200(localVConsoleLogManager, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.VConsoleLogManager.3
 * JD-Core Version:    0.7.0.1
 */