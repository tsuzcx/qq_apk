package com.tencent.mobileqq.hotchat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHotChatSCHelper
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract String getActID();
  
  public abstract boolean getCurShowingNote();
  
  public abstract IHotChatSCMng getHotChatSCMng();
  
  public abstract void setCurShowingNote(boolean paramBoolean);
  
  public abstract void startCheck(long paramLong);
  
  public abstract void startCheckDelay(long paramLong);
  
  public abstract void stopCheck();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IHotChatSCHelper
 * JD-Core Version:    0.7.0.1
 */