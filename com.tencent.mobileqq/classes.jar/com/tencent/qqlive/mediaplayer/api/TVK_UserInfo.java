package com.tencent.qqlive.mediaplayer.api;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

public class TVK_UserInfo
  implements Serializable
{
  public static int LOGIN_QQ = 2;
  public static int LOGIN_WX = 3;
  public static int OTHERS = 1;
  private static final long serialVersionUID = 4925138540725095302L;
  private String a;
  private String b;
  private String c;
  private Map<String, String> d;
  private boolean e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private int l;
  
  public TVK_UserInfo()
  {
    this.a = "";
    this.b = "";
    this.e = false;
    this.f = "";
    this.l = OTHERS;
  }
  
  public TVK_UserInfo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = false;
    this.f = "";
    this.l = OTHERS;
  }
  
  public String getAccessToken()
  {
    return this.j;
  }
  
  public String getCdnCookies()
  {
    return this.c;
  }
  
  public Map<String, String> getCdnHttpHeader()
  {
    return this.d;
  }
  
  public String getLoginCookie()
  {
    return this.b;
  }
  
  public int getLogintype()
  {
    return this.l;
  }
  
  public String getOauthConsumeKey()
  {
    return this.k;
  }
  
  public String getOpenId()
  {
    return this.h;
  }
  
  public String getPf()
  {
    return this.i;
  }
  
  public String getUin()
  {
    if (TextUtils.isEmpty(this.a)) {
      return "";
    }
    return this.a;
  }
  
  public String getVuserId()
  {
    return this.g;
  }
  
  public String getWx_openID()
  {
    if (TextUtils.isEmpty(this.f)) {
      return "";
    }
    return this.f;
  }
  
  public boolean isVip()
  {
    return this.e;
  }
  
  public void setCdnCookie(String paramString)
  {
    this.c = paramString;
  }
  
  public void setCdnHttpHeader(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public void setLoginCookie(String paramString)
  {
    this.b = paramString;
  }
  
  public void setLogintype(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setOpenApi(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.h = paramString1;
    this.j = paramString2;
    this.k = paramString3;
    this.i = paramString4;
  }
  
  public void setUin(String paramString)
  {
    this.a = paramString;
  }
  
  public void setVip(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setVuserId(String paramString)
  {
    this.g = paramString;
  }
  
  public void setWx_openID(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_UserInfo
 * JD-Core Version:    0.7.0.1
 */