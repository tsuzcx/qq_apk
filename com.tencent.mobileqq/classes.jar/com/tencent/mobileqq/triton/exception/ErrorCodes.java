package com.tencent.mobileqq.triton.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "", "category", "Lcom/tencent/mobileqq/triton/exception/ErrorCategory;", "severity", "Lcom/tencent/mobileqq/triton/exception/ErrorSeverity;", "(Ljava/lang/String;ILcom/tencent/mobileqq/triton/exception/ErrorCategory;Lcom/tencent/mobileqq/triton/exception/ErrorSeverity;)V", "getCategory", "()Lcom/tencent/mobileqq/triton/exception/ErrorCategory;", "getSeverity", "()Lcom/tencent/mobileqq/triton/exception/ErrorSeverity;", "success", "", "getSuccess", "()Z", "toString", "", "SUCCESS", "UNKNOWN", "INITIALIZE", "SCRIPT_LOAD_FAIL", "SCRIPT_PLUGIN_CALL_FAIL", "RENDER_INIT_FAIL", "RENDER_BLACK_SCREEN", "NATIVE_LOAD_LIBRARY", "NATIVE_FUNCTION_CALL", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum ErrorCodes
{
  @NotNull
  private final ErrorCategory category;
  @NotNull
  private final ErrorSeverity severity;
  
  static
  {
    ErrorCodes localErrorCodes1 = new ErrorCodes("SUCCESS", 0, ErrorCategory.UNKNOWN, ErrorSeverity.NONE);
    SUCCESS = localErrorCodes1;
    ErrorCodes localErrorCodes2 = new ErrorCodes("UNKNOWN", 1, ErrorCategory.UNKNOWN, ErrorSeverity.MODERATE);
    UNKNOWN = localErrorCodes2;
    ErrorCodes localErrorCodes3 = new ErrorCodes("INITIALIZE", 2, ErrorCategory.INITIALIZE, ErrorSeverity.SEVER);
    INITIALIZE = localErrorCodes3;
    ErrorCodes localErrorCodes4 = new ErrorCodes("SCRIPT_LOAD_FAIL", 3, ErrorCategory.SCRIPT, ErrorSeverity.SEVER);
    SCRIPT_LOAD_FAIL = localErrorCodes4;
    ErrorCodes localErrorCodes5 = new ErrorCodes("SCRIPT_PLUGIN_CALL_FAIL", 4, ErrorCategory.SCRIPT, ErrorSeverity.MODERATE);
    SCRIPT_PLUGIN_CALL_FAIL = localErrorCodes5;
    ErrorCodes localErrorCodes6 = new ErrorCodes("RENDER_INIT_FAIL", 5, ErrorCategory.RENDER, ErrorSeverity.SEVER);
    RENDER_INIT_FAIL = localErrorCodes6;
    ErrorCodes localErrorCodes7 = new ErrorCodes("RENDER_BLACK_SCREEN", 6, ErrorCategory.RENDER, ErrorSeverity.MODERATE);
    RENDER_BLACK_SCREEN = localErrorCodes7;
    ErrorCodes localErrorCodes8 = new ErrorCodes("NATIVE_LOAD_LIBRARY", 7, ErrorCategory.NATIVE, ErrorSeverity.SEVER);
    NATIVE_LOAD_LIBRARY = localErrorCodes8;
    ErrorCodes localErrorCodes9 = new ErrorCodes("NATIVE_FUNCTION_CALL", 8, ErrorCategory.NATIVE, ErrorSeverity.SEVER);
    NATIVE_FUNCTION_CALL = localErrorCodes9;
    $VALUES = new ErrorCodes[] { localErrorCodes1, localErrorCodes2, localErrorCodes3, localErrorCodes4, localErrorCodes5, localErrorCodes6, localErrorCodes7, localErrorCodes8, localErrorCodes9 };
  }
  
  private ErrorCodes(ErrorCategory paramErrorCategory, ErrorSeverity paramErrorSeverity)
  {
    this.category = paramErrorCategory;
    this.severity = paramErrorSeverity;
  }
  
  @NotNull
  public final ErrorCategory getCategory()
  {
    return this.category;
  }
  
  @NotNull
  public final ErrorSeverity getSeverity()
  {
    return this.severity;
  }
  
  public final boolean getSuccess()
  {
    return (ErrorCodes)this == SUCCESS;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(name());
    localStringBuilder.append("(category = ");
    localStringBuilder.append(this.category);
    localStringBuilder.append(", severity = ");
    localStringBuilder.append(this.severity);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.exception.ErrorCodes
 * JD-Core Version:    0.7.0.1
 */