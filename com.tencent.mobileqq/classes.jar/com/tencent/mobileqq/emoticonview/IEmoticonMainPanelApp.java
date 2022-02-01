package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

public abstract interface IEmoticonMainPanelApp
{
  public abstract String getAccount();
  
  public abstract <T extends AppRuntime> T getAppRuntime();
  
  public abstract <T extends Context> T getApplication();
  
  public abstract Object getBusinessHandler(String paramString);
  
  public abstract String getCurrentAccountUin();
  
  public abstract String getCurrentUin();
  
  public abstract <T extends IMqqHandlerProxy> T getHandler(Class paramClass);
  
  public abstract Object getManager(int paramInt);
  
  public abstract <T extends IQQMessageFacadeProxy> T getMessageFacade();
  
  public abstract <T extends AppRuntime> T getQQAppInterface();
  
  public abstract IRuntimeService getService(Class paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp
 * JD-Core Version:    0.7.0.1
 */