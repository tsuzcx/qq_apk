package com.tencent.mobileqq.qwallet.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import java.util.Observer;

@QAPI(process={"all"})
public abstract interface IArkPubicEventWrap
  extends QRouteApi
{
  public abstract void addNotify(String paramString);
  
  public abstract void addObserver(Observer paramObserver);
  
  public abstract void callbackMuteStatus();
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract void registVolumnReceiver(List<String> paramList);
  
  public abstract void registVolumnReceiver(String... paramVarArgs);
  
  public abstract void removeNotify(String paramString);
  
  public abstract void unRegistVolumnReceiver(List<String> paramList);
  
  public abstract void unRegistVolumnReceiver(String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap
 * JD-Core Version:    0.7.0.1
 */