package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final class ComponentRegistry$1
  implements Runnable
{
  ComponentRegistry$1(Map paramMap, String paramString, IFComponentHolder paramIFComponentHolder) {}
  
  public void run()
  {
    try
    {
      localObject2 = this.val$componentInfo;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashMap();
      }
      ((Map)localObject1).put("type", this.val$type);
      ((Map)localObject1).put("methods", this.val$holder.getMethods());
      ComponentRegistry.access$000(this.val$type, this.val$holder);
      ComponentRegistry.access$100((Map)localObject1);
      ComponentRegistry.access$200().add(localObject1);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = ComponentRegistry.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("register component error:");
      localStringBuilder.append(localException);
      ViolaLogUtils.e((String)localObject2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentRegistry.1
 * JD-Core Version:    0.7.0.1
 */