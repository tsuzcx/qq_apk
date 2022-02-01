package com.tencent.mobileqq.stranger.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IStrangerService
  extends IRuntimeService
{
  public abstract void deleteStrangers(List<Long> paramList);
  
  public abstract void getLocalList();
  
  public abstract void getRemoteList(boolean paramBoolean);
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stranger.api.IStrangerService
 * JD-Core Version:    0.7.0.1
 */