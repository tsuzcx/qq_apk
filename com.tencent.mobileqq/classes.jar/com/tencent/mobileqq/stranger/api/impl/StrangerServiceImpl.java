package com.tencent.mobileqq.stranger.api.impl;

import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.stranger.handler.StrangerHandler;
import java.util.List;
import mqq.app.AppRuntime;

public class StrangerServiceImpl
  implements IStrangerService
{
  private AppRuntime appRuntime;
  
  public void deleteStrangers(List<Long> paramList)
  {
    StrangerHandler.a(this.appRuntime).a(paramList);
  }
  
  public void getLocalList()
  {
    StrangerHandler.a(this.appRuntime).a();
  }
  
  public void getRemoteList(boolean paramBoolean)
  {
    StrangerHandler.a(this.appRuntime).a(paramBoolean);
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    StrangerHandler.a(this.appRuntime).notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stranger.api.impl.StrangerServiceImpl
 * JD-Core Version:    0.7.0.1
 */