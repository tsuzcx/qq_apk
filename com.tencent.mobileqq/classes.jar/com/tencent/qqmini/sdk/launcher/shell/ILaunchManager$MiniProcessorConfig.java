package com.tencent.qqmini.sdk.launcher.shell;

public class ILaunchManager$MiniProcessorConfig
{
  public Class<?> appPreLoadClass;
  public Class<?> appUIClass;
  public String processName;
  public ProcessType processType;
  
  public ILaunchManager$MiniProcessorConfig(ProcessType paramProcessType, String paramString, Class paramClass1, Class paramClass2)
  {
    this.processType = paramProcessType;
    this.processName = paramString;
    this.appUIClass = paramClass1;
    this.appPreLoadClass = paramClass2;
  }
  
  public String toString()
  {
    return "pName:" + this.processName + " pType:" + this.processType + " UI:" + this.appUIClass + " receiver:" + this.appPreLoadClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.ILaunchManager.MiniProcessorConfig
 * JD-Core Version:    0.7.0.1
 */