package com.tencent.xaction.openapi.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IDynamicLoader;", "", "getClassLoader", "Ljava/lang/ClassLoader;", "isLoaded", "", "loadSync", "", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IDynamicLoader
{
  @Nullable
  public abstract ClassLoader getClassLoader();
  
  public abstract boolean isLoaded();
  
  public abstract void loadSync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IDynamicLoader
 * JD-Core Version:    0.7.0.1
 */