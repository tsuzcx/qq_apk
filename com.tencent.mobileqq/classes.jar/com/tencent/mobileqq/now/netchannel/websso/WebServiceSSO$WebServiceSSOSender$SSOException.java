package com.tencent.mobileqq.now.netchannel.websso;

class WebServiceSSO$WebServiceSSOSender$SSOException
  extends Exception
{
  final int errorCode;
  final String errorMessage;
  
  WebServiceSSO$WebServiceSSOSender$SSOException(WebServiceSSO.WebServiceSSOSender paramWebServiceSSOSender, int paramInt, String paramString)
  {
    super("errorCode==" + paramInt + " errorMessage==" + paramString);
    this.errorCode = paramInt;
    this.errorMessage = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender.SSOException
 * JD-Core Version:    0.7.0.1
 */