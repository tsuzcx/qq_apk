package com.tencent.treasurecard.bean;

import android.text.TextUtils;
import com.tencent.treasurecard.util.EncodeUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class UserInfoReq
{
  public String a;
  public String b;
  public String c = "";
  public String d;
  public String e = "";
  public String f = "";
  public String g = "";
  
  public UserInfoReq(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.d = paramString2;
    this.b = UUID.randomUUID().toString();
  }
  
  private String a(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramString;
    if (paramMap != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("?");
      localObject = b(((StringBuilder)localObject).toString(), paramMap);
    }
    return localObject;
  }
  
  private String b(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramMap.get(str));
      localStringBuilder.append("&");
      paramString = localStringBuilder.toString();
    }
    int i = paramString.length();
    if (i < 1) {
      return "";
    }
    return paramString.substring(0, i - 1);
  }
  
  private Map<String, String> b()
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("channelId", this.a);
    localTreeMap.put("msgId", this.b);
    localTreeMap.put("userId", this.c);
    localTreeMap.put("openType", this.d);
    localTreeMap.put("message", this.e);
    localTreeMap.put("expandParams", this.f);
    return localTreeMap;
  }
  
  private void c()
  {
    if (!TextUtils.isEmpty(this.e)) {
      this.e = EncodeUtil.a(this.e);
    }
    if (!TextUtils.isEmpty(this.g)) {
      this.g = EncodeUtil.a(this.g);
    }
    if (!TextUtils.isEmpty(this.f)) {
      this.f = EncodeUtil.a(this.f);
    }
  }
  
  public UserInfoReq a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.g = paramString;
    }
    return this;
  }
  
  public String a()
  {
    return b("", b());
  }
  
  public String b(String paramString)
  {
    c();
    Map localMap = b();
    localMap.put("sign", this.g);
    return a(paramString, localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.bean.UserInfoReq
 * JD-Core Version:    0.7.0.1
 */