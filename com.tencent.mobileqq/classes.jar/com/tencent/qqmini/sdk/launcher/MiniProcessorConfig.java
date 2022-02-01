package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.shell.ProcessType;

public class MiniProcessorConfig
{
  public Class<?> appPreLoadClass;
  public Class<?> appUIClass;
  public Class<?> internalUIClass;
  public String processName;
  public ProcessType processType;
  public int supportRuntimeType;
  
  public MiniProcessorConfig(ProcessType paramProcessType, String paramString, Class paramClass1, Class paramClass2, Class paramClass3, int paramInt)
  {
    this.processType = paramProcessType;
    this.processName = paramString;
    this.appUIClass = paramClass1;
    this.internalUIClass = paramClass2;
    this.appPreLoadClass = paramClass3;
    this.supportRuntimeType = paramInt;
  }
  
  public String toString()
  {
    return "pName:" + this.processName + " pType:" + this.processType + " UI:" + this.appUIClass + " Internal:" + this.internalUIClass + " receiver:" + this.appPreLoadClass + " supportRuntimeType:" + this.supportRuntimeType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniProcessorConfig
 * JD-Core Version:    0.7.0.1
 */