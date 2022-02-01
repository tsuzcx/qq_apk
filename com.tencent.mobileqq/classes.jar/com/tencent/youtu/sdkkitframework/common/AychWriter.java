package com.tencent.youtu.sdkkitframework.common;

import java.io.PrintStream;

public class AychWriter
  extends Thread
{
  private String content;
  private String dirPath;
  private String filePath;
  
  public AychWriter(String paramString1, String paramString2, String paramString3)
  {
    this.content = paramString1;
    this.filePath = paramString2;
    this.dirPath = paramString3;
  }
  
  public void run()
  {
    System.out.println("开始执行run()");
    long l1 = System.currentTimeMillis();
    try
    {
      LogWriter.getLogWriter(this.filePath, this.dirPath).log(this.content);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    LogWriter.logWriter = null;
    long l2 = System.currentTimeMillis();
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("总消耗时间：");
    localStringBuilder.append(l2 - l1);
    localPrintStream.println(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.AychWriter
 * JD-Core Version:    0.7.0.1
 */