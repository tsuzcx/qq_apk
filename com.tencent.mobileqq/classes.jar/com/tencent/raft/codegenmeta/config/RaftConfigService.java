package com.tencent.raft.codegenmeta.config;

import com.tencent.raft.codegenmeta.utils.Constants.ConfigFrom;
import com.tencent.raft.codegenmeta.utils.Constants.Scope;
import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RaftConfigService
  implements Serializable
{
  private static final String TAG = "RaftConfigService";
  private static final long serialVersionUID = 1000L;
  public String className;
  public Map<String, Object> constructorArgs = null;
  public String factoryClass;
  public String factoryMethod;
  public Map<String, Object> factoryMethodArgs = null;
  public Constants.ConfigFrom from;
  public List<Map<String, Map<String, Object>>> methods = null;
  public Map<String, Object> properties = null;
  public Constants.Scope scope;
  
  private void handleArgs(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if (paramMap2 == null) {}
    String str;
    do
    {
      return;
      str = (String)paramMap2.keySet().toArray()[0];
      paramMap2 = paramMap2.get(str);
      if (!(paramMap2 instanceof HashMap)) {
        break;
      }
      paramMap2 = (Map)((Map)paramMap2).get("service");
    } while (paramMap2 == null);
    RaftConfigService localRaftConfigService = new RaftConfigService();
    localRaftConfigService.parse(paramMap2);
    paramMap1.put(str, localRaftConfigService);
    return;
    paramMap1.put(str, paramMap2);
  }
  
  private Object handleValueWithDefault(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    return paramObject2;
  }
  
  private void parseConstructorArgs(Map<String, Object> paramMap)
  {
    paramMap = paramMap.get("init-method");
    if (!(paramMap instanceof HashMap)) {}
    for (;;)
    {
      return;
      paramMap = ((Map)paramMap).get("args");
      if ((paramMap instanceof List))
      {
        paramMap = (List)paramMap;
        this.constructorArgs = new HashMap(1);
        int i = 0;
        while (i < paramMap.size())
        {
          handleArgs(this.constructorArgs, (Map)paramMap.get(i));
          i += 1;
        }
      }
    }
  }
  
  private void parseFactory(Map<String, Object> paramMap)
  {
    this.factoryClass = ((String)handleValueWithDefault(paramMap.get("factory-class"), null));
    paramMap = paramMap.get("factory-method");
    if (!(paramMap instanceof HashMap)) {}
    for (;;)
    {
      return;
      paramMap = (HashMap)paramMap;
      this.factoryMethod = ((String)paramMap.get("name"));
      paramMap = paramMap.get("args");
      if ((paramMap instanceof List))
      {
        paramMap = (List)paramMap;
        this.factoryMethodArgs = new HashMap(1);
        int i = 0;
        while (i < paramMap.size())
        {
          handleArgs(this.factoryMethodArgs, (Map)paramMap.get(i));
          i += 1;
        }
      }
    }
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
        String str = (String)((Map)localObject1).get("name");
        Object localObject2 = ((Map)localObject1).get("args");
        localObject1 = new HashMap(1);
        if ((localObject2 instanceof List))
        {
          localObject2 = (List)localObject2;
          int i = 0;
          while (i < ((List)localObject2).size())
          {
            handleArgs((Map)localObject1, (Map)((List)localObject2).get(i));
            i += 1;
          }
        }
        if (this.methods == null) {
          this.methods = new ArrayList();
        }
        localObject2 = new HashMap();
        ((Map)localObject2).put(str, localObject1);
        this.methods.add(localObject2);
      }
    }
  }
  
  private void parseProperties(Map<String, Object> paramMap)
  {
    paramMap = paramMap.get("properties");
    if (!(paramMap instanceof List)) {}
    for (;;)
    {
      return;
      paramMap = (List)paramMap;
      this.properties = new HashMap(1);
      int i = 0;
      while (i < paramMap.size())
      {
        handleArgs(this.properties, (Map)paramMap.get(i));
        i += 1;
      }
    }
  }
  
  public String getServiceKey()
  {
    if (!TextUtils.isEmpty(this.className)) {
      return this.className;
    }
    if (!TextUtils.isEmpty(this.factoryClass)) {
      return this.factoryClass;
    }
    return null;
  }
  
  public void parse(Map<String, Object> paramMap)
  {
    this.className = ((String)handleValueWithDefault(paramMap.get("class"), null));
    this.from = Constants.ConfigFrom.CONFIG_YAML;
    this.scope = Constants.Scope.parse((String)handleValueWithDefault(paramMap.get("scope"), Constants.Scope.PROTOTYPE.getAlias()));
    parseConstructorArgs(paramMap);
    parseFactory(paramMap);
    parseProperties(paramMap);
    parseMethods(paramMap);
  }
  
  public String toString()
  {
    return "RaftConfigService{from='" + this.from + '\'' + ", className='" + this.className + '\'' + ", scope=" + this.scope + ", factoryClass='" + this.factoryClass + '\'' + ", factoryMethod='" + this.factoryMethod + '\'' + ", factoryMethodArgs=" + this.factoryMethodArgs + ", constructorArgs=" + this.constructorArgs + ", properties=" + this.properties + ", methods=" + this.methods + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.config.RaftConfigService
 * JD-Core Version:    0.7.0.1
 */