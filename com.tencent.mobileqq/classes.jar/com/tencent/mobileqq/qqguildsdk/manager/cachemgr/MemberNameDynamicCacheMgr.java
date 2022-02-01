package com.tencent.mobileqq.qqguildsdk.manager.cachemgr;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import java.util.List;
import java.util.Map;

public class MemberNameDynamicCacheMgr
  extends DynamicCacheMgr<String>
{
  private GPSManagerEngine b;
  private String c;
  private String d;
  
  public MemberNameDynamicCacheMgr(GPSManagerEngine paramGPSManagerEngine, String paramString)
  {
    this.b = paramGPSManagerEngine;
    this.c = paramString;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.b.m()))
    {
      String str = (String)c(this.b.m());
      if (!TextUtils.isEmpty(str))
      {
        this.d = str;
        return str;
      }
    }
    return this.d;
  }
  
  protected void a(List<String> paramList)
  {
    this.b.d(this.c, paramList);
  }
  
  protected boolean a(Object paramObject)
  {
    return paramObject == null;
  }
  
  protected boolean a(String paramString)
  {
    return (this.a.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.a.get(paramString)));
  }
  
  protected boolean a(String paramString, Object paramObject)
  {
    Object localObject = this.a.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = (String)this.a.get(paramString);
      paramObject = (String)paramObject;
      bool1 = bool2;
      if (!((String)localObject).equals(paramObject))
      {
        bool1 = bool2;
        if (this.a.put(paramString, paramObject) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected String b(String paramString, Object paramObject)
  {
    return (String)paramObject;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
    d(this.b.m(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.cachemgr.MemberNameDynamicCacheMgr
 * JD-Core Version:    0.7.0.1
 */