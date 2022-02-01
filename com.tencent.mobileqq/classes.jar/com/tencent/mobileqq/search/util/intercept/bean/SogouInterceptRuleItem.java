package com.tencent.mobileqq.search.util.intercept.bean;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class SogouInterceptRuleItem
{
  private List<String> a;
  private List<String> b;
  private Map<String, String> c;
  private Map<String, String> d;
  private Map<String, String> e;
  private String f;
  private String g;
  
  private Map<String, String> a(JSONObject paramJSONObject, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!c(paramJSONObject, paramString)) {
      return localHashMap;
    }
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    paramString = paramJSONObject.keys();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
  
  private List<String> b(JSONObject paramJSONObject, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!c(paramJSONObject, paramString)) {
      return localArrayList;
    }
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private List<String> c(List<String> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    return localObject;
  }
  
  private boolean c(JSONObject paramJSONObject, String paramString)
  {
    return (paramJSONObject != null) && (!TextUtils.isEmpty(paramString)) && (paramJSONObject.has(paramString));
  }
  
  private Map<String, String> d(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    return localObject;
  }
  
  private boolean i()
  {
    if (b().size() > 0) {
      return true;
    }
    if (d().size() > 0) {
      return true;
    }
    if (e().size() > 0) {
      return true;
    }
    if (f().size() > 0) {
      return true;
    }
    if (!TextUtils.isEmpty(g())) {
      return true;
    }
    return c().size() > 0;
  }
  
  public String a()
  {
    return c(this.g);
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.c = paramMap;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    a(b(paramJSONObject, "startWith"));
    b(b(paramJSONObject, "queryParams"));
    a(a(paramJSONObject, "paramsPairAnd"));
    b(a(paramJSONObject, "paramsPairOr"));
    c(a(paramJSONObject, "headRegular"));
    b(paramJSONObject.optString("pureRegular"));
    a(paramJSONObject.optString("dataID"));
  }
  
  @NonNull
  public List<String> b()
  {
    return c(this.a);
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(List<String> paramList)
  {
    this.b = paramList;
  }
  
  public void b(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  @NonNull
  public List<String> c()
  {
    return c(this.b);
  }
  
  public void c(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  @NonNull
  public Map<String, String> d()
  {
    return d(this.c);
  }
  
  @NonNull
  public Map<String, String> e()
  {
    return d(this.d);
  }
  
  @NonNull
  public Map<String, String> f()
  {
    return d(this.e);
  }
  
  @NonNull
  public String g()
  {
    return c(this.f);
  }
  
  public boolean h()
  {
    if (TextUtils.isEmpty(a())) {
      return false;
    }
    return i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.intercept.bean.SogouInterceptRuleItem
 * JD-Core Version:    0.7.0.1
 */