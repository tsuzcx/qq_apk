package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.reflect.Constructor;

public class ComponentSimpleHolder$ClazzComponentCreator
  implements ComponentCreator
{
  private final Class<? extends VComponent> mCompClz;
  private Constructor<? extends VComponent> mConstructor;
  
  public ComponentSimpleHolder$ClazzComponentCreator(Class<? extends VComponent> paramClass)
  {
    this.mCompClz = paramClass;
  }
  
  private void loadConstructor()
  {
    Class localClass = this.mCompClz;
    try
    {
      localConstructor = localClass.getConstructor(new Class[] { ViolaInstance.class, DomObject.class, VComponentContainer.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Constructor localConstructor;
      label32:
      break label32;
    }
    ViolaLogUtils.d("ClazzComponentCreator", "Use deprecated component constructor");
    try
    {
      localConstructor = localClass.getConstructor(new Class[] { ViolaInstance.class, DomObject.class, VComponentContainer.class, Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      label72:
      label113:
      break label72;
    }
    try
    {
      localConstructor = localClass.getConstructor(new Class[] { ViolaInstance.class, DomObject.class, VComponentContainer.class, String.class, Boolean.TYPE });
      this.mConstructor = localConstructor;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      break label113;
    }
    throw new Exception("Can't find constructor of component.");
  }
  
  public VComponent createInstance(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    if (this.mConstructor == null) {
      try
      {
        loadConstructor();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    int i = this.mConstructor.getParameterTypes().length;
    if (i == 3) {
      return (VComponent)this.mConstructor.newInstance(new Object[] { paramViolaInstance, paramDomObject, paramVComponentContainer });
    }
    if (i == 4) {
      return (VComponent)this.mConstructor.newInstance(new Object[] { paramViolaInstance, paramDomObject, paramVComponentContainer, Boolean.valueOf(false) });
    }
    return (VComponent)this.mConstructor.newInstance(new Object[] { paramViolaInstance, paramDomObject, paramVComponentContainer, paramViolaInstance.getInstanceId(), Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentSimpleHolder.ClazzComponentCreator
 * JD-Core Version:    0.7.0.1
 */