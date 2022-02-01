package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.utils.ViolaLogUtils;

final class ComponentRegistry$3
  implements Runnable
{
  ComponentRegistry$3(String paramString, IFComponentHolder paramIFComponentHolder) {}
  
  public void run()
  {
    try
    {
      ComponentRegistry.access$000(this.val$type, this.val$holder);
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e(ComponentRegistry.TAG, "register component error:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentRegistry.3
 * JD-Core Version:    0.7.0.1
 */