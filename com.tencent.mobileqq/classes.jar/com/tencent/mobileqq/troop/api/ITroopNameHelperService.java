package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopNameHelperService
  extends IRuntimeService
{
  public abstract String getNewName(ArrayList<String> paramArrayList);
  
  public abstract boolean isInReturnTaskList(String paramString);
  
  public abstract void onFriendNameChaned(String paramString);
  
  public abstract void reExecuteReturnTask(String paramString, boolean paramBoolean);
  
  public abstract void updateTroopName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopNameHelperService
 * JD-Core Version:    0.7.0.1
 */