package com.tencent.viola.ui.baseComponent;

import android.util.Pair;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.MethodInvoker;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.component.VRefresh;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ComponentSimpleHolder
  implements IFComponentHolder
{
  public static final String TAG = "ComponentSimpleHolder";
  private final Class<? extends VComponent> mClz;
  private ComponentCreator mCreator;
  private Map<String, Invoker> mMethodInvokers;
  private Map<String, Invoker> mPropertyInvokers;
  private String mRefreshRef;
  
  public ComponentSimpleHolder(Class<? extends VComponent> paramClass)
  {
    this(paramClass, new ComponentSimpleHolder.ClazzComponentCreator(paramClass));
  }
  
  public ComponentSimpleHolder(Class<? extends VComponent> paramClass, ComponentCreator paramComponentCreator)
  {
    this.mClz = paramClass;
    this.mCreator = paramComponentCreator;
  }
  
  private void generate()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Generate Component:");
      ((StringBuilder)localObject1).append(this.mClz.getSimpleName());
      ViolaLogUtils.d("ComponentSimpleHolder", ((StringBuilder)localObject1).toString());
      localObject1 = getMethods(this.mClz);
      this.mPropertyInvokers = ((Map)((Pair)localObject1).first);
      this.mMethodInvokers = ((Map)((Pair)localObject1).second);
      return;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static Pair<Map<String, Invoker>, Map<String, Invoker>> getMethods(Class paramClass)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      try
      {
        Method[] arrayOfMethod = paramClass.getMethods();
        int k = arrayOfMethod.length;
        i = 0;
        if (i < k) {
          localMethod = arrayOfMethod[i];
        }
      }
      catch (IndexOutOfBoundsException paramClass)
      {
        int i;
        Method localMethod;
        JSMethod localJSMethod;
        paramClass.printStackTrace();
      }
      try
      {
        paramClass = localMethod.getDeclaredAnnotations();
        m = paramClass.length;
        j = 0;
      }
      catch (ArrayIndexOutOfBoundsException|IncompatibleClassChangeError paramClass)
      {
        continue;
        if (j >= m) {
          continue;
        }
        str = paramClass[j];
        if (str != null) {
          continue;
        }
        continue;
      }
      if ((str instanceof VComponentProp))
      {
        localHashMap1.put(((VComponentProp)str).name(), new MethodInvoker(localMethod, true));
      }
      else if ((str instanceof JSMethod))
      {
        localJSMethod = (JSMethod)str;
        str = localJSMethod.alias();
        paramClass = str;
        if ("_".equals(str)) {
          paramClass = localMethod.getName();
        }
        localHashMap2.put(paramClass, new MethodInvoker(localMethod, localJSMethod.uiThread()));
      }
      else
      {
        j += 1;
        break label201;
      }
      i += 1;
    }
    return new Pair(localHashMap1, localHashMap2);
  }
  
  public VComponent createInstance(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    paramViolaInstance = this.mCreator.createInstance(paramViolaInstance, paramDomObject, paramVComponentContainer);
    if ((paramViolaInstance instanceof VRefresh)) {
      ViolaBridgeManager.getInstance().setRefreshRef(paramViolaInstance.getDomObject().getRef());
    }
    paramViolaInstance.bindHolder(this);
    return paramViolaInstance;
  }
  
  public Invoker getMethodInvoker(String paramString)
  {
    if (this.mMethodInvokers == null) {
      generate();
    }
    return (Invoker)this.mMethodInvokers.get(paramString);
  }
  
  public String[] getMethods()
  {
    if (this.mMethodInvokers == null) {
      generate();
    }
    Set localSet = this.mMethodInvokers.keySet();
    return (String[])localSet.toArray(new String[localSet.size()]);
  }
  
  public Invoker getPropertyInvoker(String paramString)
  {
    try
    {
      if (this.mPropertyInvokers == null) {
        generate();
      }
      paramString = (Invoker)this.mPropertyInvokers.get(paramString);
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentSimpleHolder
 * JD-Core Version:    0.7.0.1
 */