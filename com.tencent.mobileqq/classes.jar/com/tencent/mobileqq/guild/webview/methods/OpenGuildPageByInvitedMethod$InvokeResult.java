package com.tencent.mobileqq.guild.webview.methods;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

class OpenGuildPageByInvitedMethod$InvokeResult
{
  @SerializedName("result")
  public int a;
  @SerializedName("msg")
  public String b;
  
  public static InvokeResult a(int paramInt, String paramString)
  {
    InvokeResult localInvokeResult = new InvokeResult();
    localInvokeResult.a = paramInt;
    localInvokeResult.b = paramString;
    return localInvokeResult;
  }
  
  public String a()
  {
    return new Gson().toJson(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.OpenGuildPageByInvitedMethod.InvokeResult
 * JD-Core Version:    0.7.0.1
 */