package com.tencent.mobileqq.webview.webso;

import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import wns_proxy.HttpReq;

public class WebSoRequest
  extends QzoneExternalRequest
{
  private String a;
  private String b;
  private JceStruct c;
  
  public WebSoRequest() {}
  
  public WebSoRequest(String paramString1, long paramLong, HttpReq paramHttpReq, String paramString2)
  {
    super.setRefer(paramString2);
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.c = paramHttpReq;
    this.a = paramString1;
    this.needCompress = false;
    this.b = WebSoUtils.n(paramString1);
  }
  
  public String getCmdString()
  {
    return this.a;
  }
  
  public JceStruct getReq()
  {
    return this.c;
  }
  
  public String uniKey()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoRequest
 * JD-Core Version:    0.7.0.1
 */