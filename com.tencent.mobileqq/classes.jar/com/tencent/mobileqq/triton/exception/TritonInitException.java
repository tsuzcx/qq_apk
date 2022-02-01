package com.tencent.mobileqq.triton.exception;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/exception/TritonInitException;", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "message", "", "error", "Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "cause", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/exception/ErrorCodes;Ljava/lang/Throwable;)V", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public class TritonInitException
  extends TritonException
{
  @JvmOverloads
  public TritonInitException(@NotNull String paramString)
  {
    this(paramString, null, null, 6, null);
  }
  
  @JvmOverloads
  public TritonInitException(@NotNull String paramString, @NotNull ErrorCodes paramErrorCodes)
  {
    this(paramString, paramErrorCodes, null, 4, null);
  }
  
  @JvmOverloads
  public TritonInitException(@NotNull String paramString, @NotNull ErrorCodes paramErrorCodes, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramErrorCodes, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.exception.TritonInitException
 * JD-Core Version:    0.7.0.1
 */