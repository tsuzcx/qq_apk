package com.tencent.rmonitor.fd.dump;

import com.tencent.rmonitor.fd.data.FdBaseResult;
import java.io.Serializable;

public class FdLeakDumpResult
  extends FdBaseResult
  implements Serializable
{
  private Object data;
  private long dumpDurationMillis;
  private final int dumpType;
  private String filePath;
  
  public FdLeakDumpResult(int paramInt1, int paramInt2, String paramString)
  {
    this.dumpType = paramInt1;
    this.errorCode = paramInt2;
    this.errorMessage = paramString;
  }
  
  public FdLeakDumpResult(int paramInt, String paramString, Object paramObject)
  {
    this.dumpType = paramInt;
    this.data = paramObject;
    this.filePath = paramString;
  }
  
  public static FdLeakDumpResult failure(int paramInt1, int paramInt2)
  {
    return new FdLeakDumpResult(paramInt1, paramInt2, "");
  }
  
  public static FdLeakDumpResult failure(int paramInt1, int paramInt2, String paramString)
  {
    return new FdLeakDumpResult(paramInt1, paramInt2, paramString);
  }
  
  public <T> T getData()
  {
    return this.data;
  }
  
  public long getDumpDurationMillis()
  {
    return this.dumpDurationMillis;
  }
  
  public String getDumpFilePath()
  {
    return this.filePath;
  }
  
  public int getDumpType()
  {
    return this.dumpType;
  }
  
  public void setData(Object paramObject)
  {
    this.data = paramObject;
  }
  
  public void setDumpDurationMillis(long paramLong)
  {
    this.dumpDurationMillis = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FdLeakDumpResult{errorCode=");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append(", dumpFilePath='");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", errorMessage='");
    localStringBuilder.append(this.errorMessage);
    localStringBuilder.append('\'');
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.FdLeakDumpResult
 * JD-Core Version:    0.7.0.1
 */