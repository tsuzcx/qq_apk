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
      Map localMap = this.val$componentInfo;
      Object localObject = localMap;
      if (localMap == null) {
        localObject = new HashMap();
      }
      ((Map)localObject).put("type", this.val$type);
      ((Map)localObject).put("methods", this.val$holder.getMethods());
      ComponentRegistry.access$000(this.val$type, this.val$holder);
      ComponentRegistry.access$100((Map)localObject);
      ComponentRegistry.access$200().add(localObject);
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e(ComponentRegistry.TAG, "register component error:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentRegistry.1
 * JD-Core Version:    0.7.0.1
 */