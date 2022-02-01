package com.tencent.mobileqq.guild.webview.methods;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

class FetchGuildIdByInvitedMethod$InvokeResult
{
  @SerializedName("result")
  public int a;
  @SerializedName("msg")
  public String b;
  @SerializedName("guildId")
  public String c;
  
  public static InvokeResult a(int paramInt, String paramString1, String paramString2)
  {
    InvokeResult localInvokeResult = new InvokeResult();
    localInvokeResult.a = paramInt;
    localInvokeResult.b = paramString1;
    localInvokeResult.c = paramString2;
    return localInvokeResult;
  }
  
  public String a()
  {
    return new Gson().toJson(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.FetchGuildIdByInvitedMethod.InvokeResult
 * JD-Core Version:    0.7.0.1
 */