package com.tencent.qqmini.proxyimpl.tavkitplugin;

import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public abstract class BaseTavEvent
{
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private String b;
  
  BaseTavEvent(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("methodName")) {
      this.b = paramJSONObject.getString("methodName");
    }
    if (paramJSONObject.has("param")) {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.getJSONObject("param");
    }
  }
  
  @Nullable
  public Object a(String paramString)
  {
    paramString = a(this.jdField_a_of_type_OrgJsonJSONObject, paramString);
    return TavObjPool.a().a(paramString);
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
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
  
  public JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "BaseEvent{className='" + this.jdField_a_of_type_JavaLangString + '\'' + ", methodName='" + this.b + '\'' + ", param=" + this.jdField_a_of_type_OrgJsonJSONObject + ", objPool=" + TavObjPool.a() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.BaseTavEvent
 * JD-Core Version:    0.7.0.1
 */