package com.tencent.mobileqq.msgbackup.util;

import android.support.annotation.NonNull;

public class MsgBackupReportData$FileError
{
  public int a;
  public int b;
  public int c;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[errorCode = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", fileType = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", fileTrivial = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupReportData.FileError
 * JD-Core Version:    0.7.0.1
 */