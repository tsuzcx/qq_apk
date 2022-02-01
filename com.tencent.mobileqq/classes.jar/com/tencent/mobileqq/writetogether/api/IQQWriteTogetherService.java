package com.tencent.mobileqq.writetogether.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.websocket.msg.IWriteTogetherMsg;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQWriteTogetherService
  extends IRuntimeService
{
  public abstract void addObservers(IWriteTogetherObserver paramIWriteTogetherObserver);
  
  public abstract void init(String paramString1, String paramString2, int paramInt);
  
  public abstract void notify(IWriteTogetherMsg paramIWriteTogetherMsg);
  
  public abstract void removeObserver(IWriteTogetherObserver paramIWriteTogetherObserver);
  
  public abstract void sendData(IWriteTogetherMsg paramIWriteTogetherMsg);
  
  public abstract void stop();
  
  public abstract void updateRev(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService
 * JD-Core Version:    0.7.0.1
 */