package com.tencent.mobileqq.leba.observer;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class ResourcePluginListener$CallbackRunner
  implements Runnable
{
  private SoftReference<ResourcePluginListener> a;
  private byte b;
  private int c;
  
  public ResourcePluginListener$CallbackRunner(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    this.a = new SoftReference(paramResourcePluginListener);
    this.b = paramByte;
    this.c = paramInt;
  }
  
  public void run()
  {
    ResourcePluginListener localResourcePluginListener = (ResourcePluginListener)this.a.get();
    if ((localResourcePluginListener == null) && (QLog.isColorLevel())) {
      QLog.d("ResourcePluginListener", 1, "ResourcePluginListener is null");
    }
    if (localResourcePluginListener != null)
    {
      int i = this.c;
      if (i == 2)
      {
        localResourcePluginListener.b(this.b);
        return;
      }
      if (i == 1) {
        localResourcePluginListener.a(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.observer.ResourcePluginListener.CallbackRunner
 * JD-Core Version:    0.7.0.1
 */