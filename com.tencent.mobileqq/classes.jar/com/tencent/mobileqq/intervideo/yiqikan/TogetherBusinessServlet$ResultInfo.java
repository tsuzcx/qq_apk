package com.tencent.mobileqq.intervideo.yiqikan;

import java.io.Serializable;

public final class TogetherBusinessServlet$ResultInfo
  implements Serializable
{
  public final String errorMsg;
  public final int resultCode;
  public final boolean showErrorMsg;
  
  public TogetherBusinessServlet$ResultInfo(int paramInt, String paramString, boolean paramBoolean)
  {
    this.resultCode = paramInt;
    this.errorMsg = paramString;
    this.showErrorMsg = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ResultInfo=");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" resultCode=");
    localStringBuilder.append(this.resultCode);
    localStringBuilder.append(" errorMsg=");
    localStringBuilder.append(this.errorMsg);
    localStringBuilder.append(" showErrorMsg=");
    localStringBuilder.append(this.showErrorMsg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.ResultInfo
 * JD-Core Version:    0.7.0.1
 */