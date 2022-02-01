package com.tencent.tav.core;

import android.support.annotation.NonNull;

public class ExportRuntimeException
  extends RuntimeException
{
  @NonNull
  private final ExportErrorStatus errorStatus;
  
  public ExportRuntimeException(int paramInt, Throwable paramThrowable)
  {
    this(new ExportErrorStatus(paramInt, paramThrowable));
  }
  
  public ExportRuntimeException(@NonNull ExportErrorStatus paramExportErrorStatus)
  {
    super(paramExportErrorStatus.throwable);
    this.errorStatus = paramExportErrorStatus;
  }
  
  @NonNull
  public ExportErrorStatus getErrorStatus()
  {
    return this.errorStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.ExportRuntimeException
 * JD-Core Version:    0.7.0.1
 */