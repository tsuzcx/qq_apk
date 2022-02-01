package com.tencent.xaction.openapi.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IXAGlobal;", "", "getVersion", "", "pauseAll", "", "registerAnim", "", "name", "clazzName", "registerDrawable", "registerGlobalRule", "rule", "value", "registerTrigger", "registerView", "resumeAll", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IXAGlobal
{
  @NotNull
  public abstract String getVersion();
  
  public abstract void pauseAll();
  
  public abstract boolean registerAnim(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void registerDrawable(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void registerGlobalRule(@NotNull String paramString, @NotNull Object paramObject);
  
  public abstract boolean registerTrigger(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void registerView(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void resumeAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IXAGlobal
 * JD-Core Version:    0.7.0.1
 */