package com.tencent.qqmini.sdk.launcher;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;

public class MiniProcessorConfig
{
  @NonNull
  public final Class<?> appPreLoadClass;
  @NonNull
  public final Class<?> appUIClass;
  @Nullable
  public final Class<?> internalUIClass;
  @NonNull
  public final String processName;
  @NonNull
  public final ProcessType processType;
  public final int supportRuntimeType;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pName:");
    localStringBuilder.append(this.processName);
    localStringBuilder.append(" pType:");
    localStringBuilder.append(this.processType);
    localStringBuilder.append(" UI:");
    localStringBuilder.append(this.appUIClass);
    localStringBuilder.append(" Internal:");
    localStringBuilder.append(this.internalUIClass);
    localStringBuilder.append(" receiver:");
    localStringBuilder.append(this.appPreLoadClass);
    localStringBuilder.append(" supportRuntimeType:");
    localStringBuilder.append(this.supportRuntimeType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniProcessorConfig
 * JD-Core Version:    0.7.0.1
 */