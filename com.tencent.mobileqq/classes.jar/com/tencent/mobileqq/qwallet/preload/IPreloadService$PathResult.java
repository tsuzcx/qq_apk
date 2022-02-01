package com.tencent.mobileqq.qwallet.preload;

import java.io.Serializable;

public class IPreloadService$PathResult
  implements Serializable
{
  public String filePath;
  public String folderPath;
  public boolean isAlreadyExist;
  public int subErrCode;
  public String url;
  
  public IPreloadService$PathResult() {}
  
  public IPreloadService$PathResult(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.filePath = paramString1;
    this.folderPath = paramString2;
    this.url = paramString3;
    this.subErrCode = paramInt;
  }
  
  public static PathResult getFailRes(String paramString)
  {
    return getFailRes(paramString, 0);
  }
  
  public static PathResult getFailRes(String paramString, int paramInt)
  {
    return new PathResult(null, null, paramString, paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PathResult{file='");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", folder='");
    localStringBuilder.append(this.folderPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult
 * JD-Core Version:    0.7.0.1
 */