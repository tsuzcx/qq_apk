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
    return "RspOpenStart=" + super.toString() + " jumpType=" + this.jumpType + " jumpUrl=" + this.jumpUrl + " resultInfo=" + this.resultInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenStart
 * JD-Core Version:    0.7.0.1
 */