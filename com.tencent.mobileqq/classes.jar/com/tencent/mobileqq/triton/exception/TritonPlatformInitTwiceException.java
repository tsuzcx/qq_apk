package com.tencent.mobileqq.triton.exception;

import com.tencent.mobileqq.triton.TritonPlatform;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/exception/TritonPlatformInitTwiceException;", "Lcom/tencent/mobileqq/triton/exception/TritonInitException;", "message", "", "previouslyBuiltPlatform", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "previouslyBuildingStackTrace", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/TritonPlatform;Ljava/lang/Throwable;)V", "getPreviouslyBuildingStackTrace", "()Ljava/lang/Throwable;", "getPreviouslyBuiltPlatform", "()Lcom/tencent/mobileqq/triton/TritonPlatform;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class TritonPlatformInitTwiceException
  extends TritonInitException
{
  @NotNull
  private final Throwable previouslyBuildingStackTrace;
  @NotNull
  private final TritonPlatform previouslyBuiltPlatform;
  
  public TritonPlatformInitTwiceException(@NotNull String paramString, @NotNull TritonPlatform paramTritonPlatform, @NotNull Throwable paramThrowable)
  {
    super(paramString, null, paramThrowable, 2, null);
    this.previouslyBuiltPlatform = paramTritonPlatform;
    this.previouslyBuildingStackTrace = paramThrowable;
  }
  
  @NotNull
  public final Throwable getPreviouslyBuildingStackTrace()
  {
    return this.previouslyBuildingStackTrace;
  }
  
  @NotNull
  public final TritonPlatform getPreviouslyBuiltPlatform()
  {
    return this.previouslyBuiltPlatform;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.exception.TritonPlatformInitTwiceException
 * JD-Core Version:    0.7.0.1
 */