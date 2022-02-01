package com.tencent.mobileqq.flutter.router;

import java.util.Map;

public class PageRouterBuilder
{
  private PageRouter a = new PageRouter();
  
  public PageRouter a()
  {
    return this.a;
  }
  
  public PageRouterBuilder a(String paramString)
  {
    this.a.a = paramString;
    return this;
  }
  
  public PageRouterBuilder a(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      SerializableMap localSerializableMap = new SerializableMap();
      localSerializableMap.setMap(paramMap);
      this.a.c = localSerializableMap;
    }
    return this;
  }
  
  public PageRouterBuilder a(boolean paramBoolean)
  {
    this.a.g = paramBoolean;
    return this;
  }
  
  public PageRouterBuilder b(String paramString)
  {
    this.a.b = paramString;
    return this;
  }
  
  public PageRouterBuilder b(boolean paramBoolean)
  {
    this.a.e = paramBoolean;
    return this;
  }
  
  public PageRouterBuilder c(boolean paramBoolean)
  {
    this.a.f = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.router.PageRouterBuilder
 * JD-Core Version:    0.7.0.1
 */