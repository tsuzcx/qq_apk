package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class FlashChatManager$GlobalConfig
  implements IQStorageSafable<String>
{
  public String a = "1";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "1";
  public int i = 2;
  public int j = 2;
  public int k = 2;
  public int l = 3;
  public int m = 3;
  public int n = 60;
  public int o = 60;
  public boolean p;
  public boolean q;
  public String r = "";
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optString("entry", "1");
      this.b = paramString.optString("name", null);
      this.d = paramString.optString("icon", null);
      this.f = paramString.optString("actionI", null);
      this.g = paramString.optString("actionA", null);
      this.c = paramString.optString("url", null);
      this.i = paramString.optInt("scC", 2);
      this.j = paramString.optInt("hiC", 2);
      this.k = paramString.optInt("flC", 2);
      this.l = paramString.optInt("piC", 3);
      this.m = paramString.optInt("tvC", 3);
      this.h = paramString.optString("recordRule", "1");
      this.n = paramString.optInt("pIn", 60);
      this.o = paramString.optInt("tvI", 60);
      this.p = "1".equals(paramString.optString("qimNotifyEnable", "0"));
      this.q = "1".equals(paramString.optString("qimPopUpEnable", "0"));
      this.r = paramString.optString("qimNotifySource", "");
      this.e = paramString.optString("qimNotifyLogo", "");
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFlashChatConfig failed");
      localStringBuilder.append(paramString);
      QLog.e("FlashChat", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig
 * JD-Core Version:    0.7.0.1
 */