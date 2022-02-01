package com.tencent.mobileqq.leba.core;

import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;

public class CommPluginHandlerApi
{
  public static final String a = CommPluginHandler.class.getName();
  
  public static void a(AppRuntime paramAppRuntime)
  {
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.CommPluginHandlerApi
 * JD-Core Version:    0.7.0.1
 */