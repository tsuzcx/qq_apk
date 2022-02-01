package com.tencent.mobileqq.intervideo.yiqikan;

import java.io.Serializable;

public final class TogetherBusinessServlet$RspOpenIdentify
  implements Serializable
{
  public final int businessType;
  public final String buttonText;
  public final String confirmText;
  public final TogetherBusinessServlet.ResultInfo resultInfo;
  
  public TogetherBusinessServlet$RspOpenIdentify(TogetherBusinessServlet.ResultInfo paramResultInfo, String paramString1, String paramString2, int paramInt)
  {
    this.resultInfo = paramResultInfo;
    this.buttonText = paramString1;
    this.confirmText = paramString2;
    this.businessType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RspOpenIdentify=");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" buttonText=");
    localStringBuilder.append(this.buttonText);
    localStringBuilder.append(" confirmText=");
    localStringBuilder.append(this.confirmText);
    localStringBuilder.append(" resultInfo=");
    localStringBuilder.append(this.resultInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenIdentify
 * JD-Core Version:    0.7.0.1
 */