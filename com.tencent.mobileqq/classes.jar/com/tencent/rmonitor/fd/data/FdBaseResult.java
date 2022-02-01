package com.tencent.rmonitor.fd.data;

import java.io.Serializable;

public class FdBaseResult
  implements Serializable
{
  public static final int REASON_DUMP_FAILED = 1;
  public static final int REASON_DUMP_FILE_PATH_INVALID = 3;
  public static final int REASON_DUMP_IO_EXCEPTION = 5;
  public static final int REASON_DUMP_NO_DUMPER = 2;
  public static final int REASON_DUMP_PARSE_EXCEPTION = 6;
  public static final int REASON_DUMP_PARSE_OOM = 7;
  public static final int REASON_DUMP_ZIP_FAILED = 4;
  public static final int REASON_FD_DUMP_EMPTY = 11;
  public static final int REASON_NULL_DUMP_RESULT = 8;
  public static final int REASON_START_SERVICE_FAILED = 9;
  public static final int REASON_UNEXPECTED_EXCEPTION = 10;
  public static final int REASON_UNKNOWN = -1;
  protected int errorCode;
  protected String errorMessage = "";
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public boolean isSuccess()
  {
    return this.errorCode == 0;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMessage(String paramString)
  {
    this.errorMessage = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.data.FdBaseResult
 * JD-Core Version:    0.7.0.1
 */