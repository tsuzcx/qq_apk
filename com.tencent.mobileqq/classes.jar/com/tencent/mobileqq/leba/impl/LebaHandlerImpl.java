package com.tencent.mobileqq.leba.impl;

import com.tencent.mobileqq.leba.ILebaHandler;
import com.tencent.mobileqq.leba.core.CommPluginHandlerApi;
import com.tencent.mobileqq.leba.core.LebaSettingHandlerApi;

public class LebaHandlerImpl
  implements ILebaHandler
{
  public String getCommPluginHandlerClassName()
  {
    return CommPluginHandlerApi.a;
  }
  
  public String getLebaSettingHandlerClassName()
  {
    return LebaSettingHandlerApi.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.impl.LebaHandlerImpl
 * JD-Core Version:    0.7.0.1
 */