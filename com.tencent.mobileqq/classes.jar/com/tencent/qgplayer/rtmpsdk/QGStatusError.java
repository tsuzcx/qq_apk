package com.tencent.qgplayer.rtmpsdk;

import java.io.Serializable;

public class QGStatusError
  implements Serializable
{
  private static final long serialVersionUID = 8454690331235126998L;
  public int errorType;
  public int mainErrorCode;
  public String message;
  public int subErrorCode;
  
  public String toString()
  {
    return "QGStatusError{type=" + this.errorType + "mainErrorCode=" + this.mainErrorCode + ", subErrorCode=" + this.subErrorCode + ", message='" + this.message + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGStatusError
 * JD-Core Version:    0.7.0.1
 */