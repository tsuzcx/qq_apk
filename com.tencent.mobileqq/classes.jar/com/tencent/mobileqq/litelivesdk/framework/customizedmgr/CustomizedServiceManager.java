package com.tencent.mobileqq.litelivesdk.framework.customizedmgr;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilive.base.bizmodule.BizModulesBuilder;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CustomizedServiceManager
{
  public static CustomizedServiceManager a;
  Map<String, Map<Class<? extends ServiceBaseInterface>, Class<? extends BaseServiceBuilder>>> a;
  Map<String, Map<Integer, Class<? extends BaseSDKPageBizBootModules>>> b = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkCustomizedmgrCustomizedServiceManager = new CustomizedServiceManager();
  }
  
  private CustomizedServiceManager()
  {
    this.jdField_a_of_type_JavaUtilMap = new Hashtable();
  }
  
  public Map<Integer, Class<? extends BaseSDKPageBizBootModules>> a(String paramString)
  {
    return (Map)this.b.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    this.b.remove(paramString);
  }
  
  public void a(String paramString, int paramInt, Class<? extends BaseSDKPageBizBootModules> paramClass)
  {
    Map localMap = (Map)this.b.get(paramString);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.b.put(paramString, localObject);
    }
    ((Map)localObject).put(Integer.valueOf(paramInt), paramClass);
  }
  
  public void a(String paramString, Class<? extends ServiceBaseInterface> paramClass, Class<? extends BaseServiceBuilder> paramClass1)
  {
    Map localMap = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    ((Map)localObject).put(paramClass, paramClass1);
  }
  
  public void a(String paramString, Map<Class<? extends ServiceBaseInterface>, BaseServiceBuilder> paramMap)
  {
    paramString = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.keySet().iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        if (paramMap.containsKey(localClass)) {
          paramMap.remove(localClass);
        }
        try
        {
          paramMap.put(localClass, (BaseServiceBuilder)((Class)paramString.get(localClass)).newInstance());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        catch (InstantiationException localInstantiationException)
        {
          localInstantiationException.printStackTrace();
        }
      }
    }
  }
  
  public Map<Class<? extends ServiceBaseInterface>, Class<? extends BaseServiceBuilder>> b(String paramString)
  {
    return (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void b(String paramString, Map<Integer, BizModulesBuilder> paramMap)
  {
    paramString = (Map)this.b.get(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        paramMap.put(Integer.valueOf(i), new CustomizedServiceManager.1(this, i, paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.customizedmgr.CustomizedServiceManager
 * JD-Core Version:    0.7.0.1
 */