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
  
  private Map<String, String> a()
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
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.d)) {
      this.d = EncodeUtil.a(this.d);
    }
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
    return paramString.substring(0, paramString.length() - 1);
  }
  
  public UserInfoReq a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String a()
  {
    return b("", a());
  }
  
  public String a(String paramString)
  {
    Map localMap = a();
    localMap.put("sign", this.g);
    a();
    return a(paramString, localMap);
  }
  
  public UserInfoReq b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.g = paramString;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.bean.UserInfoReq
 * JD-Core Version:    0.7.0.1
 */