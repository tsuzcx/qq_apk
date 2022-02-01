package com.tencent.mobileqq.cmshow.engine.resource.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/resource/exception/ScriptNotFoundException;", "Ljava/lang/RuntimeException;", "message", "", "path", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ScriptNotFoundException
  extends RuntimeException
{
  @NotNull
  private final String path;
  
  public ScriptNotFoundException(@NotNull String paramString1, @NotNull String paramString2)
  {
    super(paramString1);
    this.path = paramString2;
  }
  
  @NotNull
  public final String getPath()
  {
    return this.path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.exception.ScriptNotFoundException
 * JD-Core Version:    0.7.0.1
 */