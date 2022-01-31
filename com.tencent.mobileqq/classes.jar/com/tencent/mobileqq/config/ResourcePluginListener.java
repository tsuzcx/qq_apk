package com.tencent.mobileqq.config;

import com.tencent.common.app.BaseApplicationImpl;
import mqq.os.MqqHandler;

public class ResourcePluginListener
{
  public static void a(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    BaseApplicationImpl.sUiHandler.post(new ResourcePluginListener.CallbackRunner(paramResourcePluginListener, paramByte, paramInt));
  }
  
  public void a(byte paramByte) {}
  
  public void b(byte paramByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ResourcePluginListener
 * JD-Core Version:    0.7.0.1
 */