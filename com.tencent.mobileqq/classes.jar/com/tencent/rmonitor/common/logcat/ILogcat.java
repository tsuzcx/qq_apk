package com.tencent.rmonitor.common.logcat;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logcat/ILogcat;", "", "getLogcatFile", "", "setArgs", "", "args", "", "([Ljava/lang/String;)V", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface ILogcat
{
  @Nullable
  public abstract String a();
  
  public abstract void a(@Nullable String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logcat.ILogcat
 * JD-Core Version:    0.7.0.1
 */