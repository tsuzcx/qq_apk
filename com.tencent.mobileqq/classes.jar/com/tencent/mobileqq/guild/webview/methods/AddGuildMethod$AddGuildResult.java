package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import com.google.gson.annotations.SerializedName;

class AddGuildMethod$AddGuildResult
{
  @SerializedName("result")
  public int a;
  @SerializedName("msg")
  public String b;
  @SerializedName("guildId")
  public String c;
  @SerializedName("key")
  public String d;
  @SerializedName("actionCode")
  public long e;
  @SerializedName("strPrompt")
  public String f;
  @SerializedName("strDetail")
  public String g;
  
  public static AddGuildResult a(Bundle paramBundle)
  {
    AddGuildResult localAddGuildResult = new AddGuildResult();
    localAddGuildResult.a = paramBundle.getInt("errCode");
    localAddGuildResult.b = paramBundle.getString("errMsg");
    localAddGuildResult.c = paramBundle.getString("key");
    localAddGuildResult.d = paramBundle.getString("key");
    localAddGuildResult.e = paramBundle.getLong("actionCode");
    localAddGuildResult.f = paramBundle.getString("strPrompt");
    localAddGuildResult.g = paramBundle.getString("strDetail");
    return localAddGuildResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.AddGuildMethod.AddGuildResult
 * JD-Core Version:    0.7.0.1
 */