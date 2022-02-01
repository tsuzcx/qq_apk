package com.tencent.mobileqq.intervideo.yiqikan;

import java.io.Serializable;

public final class TogetherBusinessServlet$RspOpenStart
  implements Serializable
{
  public final int jumpType;
  public final String jumpUrl;
  public final TogetherBusinessServlet.ResultInfo resultInfo;
  
  public TogetherBusinessServlet$RspOpenStart(TogetherBusinessServlet.ResultInfo paramResultInfo, int paramInt, String paramString)
  {
    this.resultInfo = paramResultInfo;
    this.jumpType = paramInt;
    this.jumpUrl = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RspOpenStart=");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" jumpType=");
    localStringBuilder.append(this.jumpType);
    localStringBuilder.append(" jumpUrl=");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append(" resultInfo=");
    localStringBuilder.append(this.resultInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenStart
 * JD-Core Version:    0.7.0.1
 */