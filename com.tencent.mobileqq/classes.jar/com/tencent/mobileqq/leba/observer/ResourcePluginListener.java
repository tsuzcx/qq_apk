package com.tencent.mobileqq.leba.observer;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class ResourcePluginListener
{
  public static void a(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ResourcePluginListener.CallbackRunner(paramResourcePluginListener, paramByte, paramInt));
  }
  
  public void a(byte paramByte) {}
  
  public void b(byte paramByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.observer.ResourcePluginListener
 * JD-Core Version:    0.7.0.1
 */