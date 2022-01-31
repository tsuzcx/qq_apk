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
    return "RspOpenIdentify=" + super.toString() + " buttonText=" + this.buttonText + " confirmText=" + this.confirmText + " resultInfo=" + this.resultInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenIdentify
 * JD-Core Version:    0.7.0.1
 */