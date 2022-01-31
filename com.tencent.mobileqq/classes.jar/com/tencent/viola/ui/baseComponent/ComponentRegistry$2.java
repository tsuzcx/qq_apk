package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

final class ComponentRegistry$2
  implements Runnable
{
  public void run()
  {
    try
    {
      Iterator localIterator = ComponentRegistry.access$200().iterator();
      while (localIterator.hasNext()) {
        ComponentRegistry.access$100((Map)localIterator.next());
      }
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e(ComponentRegistry.TAG, "reload exception : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentRegistry.2
 * JD-Core Version:    0.7.0.1
 */