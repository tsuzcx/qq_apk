package com.tencent.viola.ui.baseComponent;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComponentFactory
{
  public static String TAG = "ComponentFactory";
  private static Map<String, Set<String>> sComponentTypes = new HashMap();
  
  public static Set<String> getComponentTypesByInstanceId(String paramString)
  {
    return (Set)sComponentTypes.get(paramString);
  }
  
  @Nullable
  public static VComponent newInstance(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    if ((paramViolaInstance != null) && (paramDomObject != null))
    {
      if (TextUtils.isEmpty(paramDomObject.getType())) {
        return null;
      }
      if (sComponentTypes.get(paramViolaInstance.getInstanceId()) == null)
      {
        localObject = new HashSet();
        sComponentTypes.put(paramViolaInstance.getInstanceId(), localObject);
      }
      ((Set)sComponentTypes.get(paramViolaInstance.getInstanceId())).add(paramDomObject.getType());
      IFComponentHolder localIFComponentHolder = ComponentRegistry.getComponent(paramDomObject.getType());
      Object localObject = localIFComponentHolder;
      if (localIFComponentHolder == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ComponentFactory error type:[");
        ((StringBuilder)localObject).append(paramDomObject.getType());
        ((StringBuilder)localObject).append("] class not found");
        localObject = ((StringBuilder)localObject).toString();
        ViolaLogUtils.e(TAG, (String)localObject);
        localObject = ComponentRegistry.getComponent("container");
        if (localObject == null) {
          throw new Exception("Container component not found.");
        }
      }
      try
      {
        paramViolaInstance = ((IFComponentHolder)localObject).createInstance(paramViolaInstance, paramDomObject, paramVComponentContainer);
        return paramViolaInstance;
      }
      catch (Exception paramViolaInstance)
      {
        paramVComponentContainer = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("WXComponentFactory Exception type:[");
        ((StringBuilder)localObject).append(paramDomObject.getType());
        ((StringBuilder)localObject).append("] e ");
        ((StringBuilder)localObject).append(paramViolaInstance);
        ViolaLogUtils.e(paramVComponentContainer, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static void removeComponentTypesByInstanceId(String paramString)
  {
    sComponentTypes.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentFactory
 * JD-Core Version:    0.7.0.1
 */