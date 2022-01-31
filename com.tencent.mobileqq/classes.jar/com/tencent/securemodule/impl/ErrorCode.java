package com.tencent.securemodule.impl;

public class ErrorCode
{
  public static final int ERR_ARGUMENT = -6;
  public static final int ERR_CANCEL = -3;
  public static final int ERR_FILE_OP = -7000;
  public static final int ERR_GENERAL = -2;
  public static final int ERR_GET = -3000;
  public static final int ERR_ILLEGAL_ACCESS = -60;
  public static final int ERR_ILLEGAL_ARG = -57;
  public static final int ERR_ILLEGAL_STATE = -61;
  public static final int ERR_IO_EXCEPTION = -56;
  public static final int ERR_NONE = 0;
  public static final int ERR_NOT_COMPLETED = -7;
  public static final int ERR_NOT_FOUND = -1;
  public static final int ERR_NOT_SUPPORTED = -5;
  public static final int ERR_NO_CONNECTION = -52;
  public static final int ERR_NO_MEMORY = -4;
  public static final int ERR_OPEN_CONNECTION = -1000;
  public static final int ERR_POST = -2000;
  public static final int ERR_PROTOCOL = -51;
  public static final int ERR_RECEIVE = -5000;
  public static final int ERR_RESPONSE = -4000;
  public static final int ERR_SECURITY = -58;
  public static final int ERR_SOCKET = -54;
  public static final int ERR_SOCKET_TIMEOUT = -55;
  public static final int ERR_UNSUPPORTED_OP = -59;
  public static final int ERR_URL_MALFORMED = -53;
  public static final int ERR_WUP = -6000;
  
  public static ErrorCode.a judgeErrorCode(int paramInt)
  {
    ErrorCode.a locala = ErrorCode.a.d;
    if (-(-paramInt % 100) == -3) {
      return ErrorCode.a.c;
    }
    switch (-(-paramInt / 1000 * 1000))
    {
    default: 
      return locala;
    }
    return ErrorCode.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.securemodule.impl.ErrorCode
 * JD-Core Version:    0.7.0.1
 */