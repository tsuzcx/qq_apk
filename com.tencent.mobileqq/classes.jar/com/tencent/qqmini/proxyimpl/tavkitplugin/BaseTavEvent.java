package com.tencent.qqmini.proxyimpl.tavkitplugin;

import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public abstract class BaseTavEvent
{
  private String a;
  private String b;
  private JSONObject c;
  
  BaseTavEvent(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("methodName")) {
      this.b = paramJSONObject.getString("methodName");
    }
    if (paramJSONObject.has("param")) {
      this.c = paramJSONObject.getJSONObject("param");
    }
  }
  
  String a()
  {
    return this.a;
  }
  
  String a(JSONObject paramJSONObject)
  {
    return a(paramJSONObject, "tavobject");
  }
  
  String a(JSONObject paramJSONObject, String paramString)
  {
    if (!paramJSONObject.has(paramString)) {
      return null;
    }
    return paramJSONObject.getJSONObject(paramString).getString("identifier");
  }
  
  void a(String paramString)
  {
    this.a = paramString;
  }
  
  @Nullable
  public Object b(String paramString)
  {
    paramString = a(this.c, paramString);
    return TavObjPool.a().a(paramString);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public JSONObject c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseEvent{className='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", methodName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", param=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", objPool=");
    localStringBuilder.append(TavObjPool.a());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.BaseTavEvent
 * JD-Core Version:    0.7.0.1
 */