package com.tencent.raft.codegenmeta.service;

import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RAServiceMeta
{
  private static final String TAG = "RAServiceMeta";
  public List<RAServiceMeta.ArgsDescription> constructorArgsDesc = new ArrayList();
  public String factoryClass;
  public String factoryMethod;
  public List<RAServiceMeta.ArgsDescription> factoryMethodArgsDesc = new ArrayList();
  public List<String> interfaces = new ArrayList();
  public String itemClass;
  public List<Map<String, Object>> methodInjection;
  public List<Map<String, List<RAServiceMeta.ArgsDescription>>> methods = new ArrayList();
  public List<RAServiceMeta.ArgsDescription> properties = new ArrayList();
  
  private static Object defaultIfEmpty(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2;
    }
    return paramObject1;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.equals(""));
  }
  
  private void parseConstructorArgs(Map<String, Object> paramMap)
  {
    paramMap = (List)((Map)defaultIfEmpty(paramMap.get("init-method"), new HashMap())).get("args");
    if (paramMap != null)
    {
      int i = 0;
      while (i < paramMap.size())
      {
        Object localObject = (Map)paramMap.get(i);
        String str = (String)localObject.keySet().toArray()[0];
        localObject = (String)((Map)localObject).get(str);
        this.constructorArgsDesc.add(new RAServiceMeta.ArgsDescription(str, (String)localObject));
        i += 1;
      }
    }
  }
  
  private void parseFactory(Map<String, Object> paramMap)
  {
    this.factoryClass = ((String)defaultIfEmpty(paramMap.get("factory-class"), null));
    paramMap = (Map)defaultIfEmpty(paramMap.get("factory-method"), null);
    if (paramMap != null) {
      this.factoryMethod = ((String)paramMap.get("name"));
    }
    if (paramMap != null)
    {
      paramMap = (List)paramMap.get("args");
      if (paramMap != null)
      {
        int i = 0;
        while (i < paramMap.size())
        {
          Object localObject = (Map)paramMap.get(i);
          String str = (String)localObject.keySet().toArray()[0];
          localObject = (String)((Map)localObject).get(str);
          this.factoryMethodArgsDesc.add(new RAServiceMeta.ArgsDescription(str, (String)localObject));
          i += 1;
        }
      }
    }
  }
  
  private void parseInterface(Map<String, Object> paramMap)
  {
    paramMap = paramMap.get("interface");
    if (paramMap != null)
    {
      if ((paramMap instanceof List)) {
        this.interfaces.addAll((List)paramMap);
      }
    }
    else {
      return;
    }
    if ((paramMap instanceof String))
    {
      this.interfaces.add((String)paramMap);
      return;
    }
    throw new IllegalArgumentException("interface parse error :" + paramMap);
  }
  
  private void parseMethods(Map<String, Object> paramMap)
  {
    paramMap = paramMap.get("methods");
    if (!(paramMap instanceof List)) {}
    for (;;)
    {
      return;
      paramMap = ((List)paramMap).iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map)paramMap.next();
        String str1 = (String)((Map)localObject1).get("name");
        Object localObject2 = ((Map)localObject1).get("args");
        localObject1 = new ArrayList();
        if ((localObject2 instanceof List))
        {
          localObject2 = (List)localObject2;
          int i = 0;
          while (i < ((List)localObject2).size())
          {
            Map localMap = (Map)((List)localObject2).get(i);
            String str2 = (String)localMap.keySet().toArray()[0];
            ((List)localObject1).add(new RAServiceMeta.ArgsDescription(str2, (String)localMap.get(str2)));
            i += 1;
          }
        }
        localObject2 = new HashMap();
        ((Map)localObject2).put(str1, localObject1);
        this.methods.add(localObject2);
      }
    }
  }
  
  private void parseProperties(Map<String, Object> paramMap)
  {
    paramMap = (List)defaultIfEmpty(paramMap.get("properties"), null);
    if (paramMap != null)
    {
      int i = 0;
      while (i < paramMap.size())
      {
        Object localObject = (Map)paramMap.get(i);
        String str = (String)localObject.keySet().toArray()[0];
        localObject = (String)((Map)localObject).get(str);
        this.properties.add(new RAServiceMeta.ArgsDescription(str, (String)localObject));
        i += 1;
      }
    }
  }
  
  public String getServiceKey()
  {
    if (!TextUtils.isEmpty(this.itemClass)) {
      return this.itemClass;
    }
    if (!TextUtils.isEmpty(this.factoryClass)) {
      return this.factoryClass;
    }
    return null;
  }
  
  public void parse(Map<String, Object> paramMap)
  {
    this.itemClass = ((String)defaultIfEmpty(paramMap.get("class"), null));
    this.methodInjection = ((List)defaultIfEmpty(paramMap.get("replaced-method"), null));
    parseInterface(paramMap);
    parseConstructorArgs(paramMap);
    parseFactory(paramMap);
    parseProperties(paramMap);
    parseMethods(paramMap);
  }
  
  public void parseDeclare(Map<String, Object> paramMap)
  {
    this.itemClass = ((String)defaultIfEmpty(paramMap.get("class"), null));
    this.methodInjection = ((List)defaultIfEmpty(paramMap.get("replaced-method"), null));
    parseInterface(paramMap);
    parseConstructorArgs(paramMap);
    parseFactory(paramMap);
    parseProperties(paramMap);
  }
  
  public String toString()
  {
    return "RAServiceMeta{interfaces=" + this.interfaces + ", itemClass='" + this.itemClass + '\'' + ", factoryClass='" + this.factoryClass + '\'' + ", factoryMethod='" + this.factoryMethod + '\'' + ", factoryMethodArgsDesc=" + this.factoryMethodArgsDesc + ", constructorArgsDesc=" + this.constructorArgsDesc + ", properties=" + this.properties + ", methodInjection=" + this.methodInjection + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.service.RAServiceMeta
 * JD-Core Version:    0.7.0.1
 */