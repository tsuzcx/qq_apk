package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IExpandClassManager
  extends QRouteApi
{
  public abstract String getExpandHandlerClassName();
  
  public abstract Class getExpandLimitChatManagerClass();
  
  public abstract Class getExpandManagerClass();
  
  public abstract Class getLimitChatOnPlusConfClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.IExpandClassManager
 * JD-Core Version:    0.7.0.1
 */