package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.api.utils.TroopNameHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopNameHelperServiceImpl
  implements ITroopNameHelperService
{
  public static final String TAG = "TroopNameHelperApiImpl";
  AppRuntime mApp;
  protected TroopNameHelper troopNameHelper;
  
  private TroopNameHelper getTroopNameHelper()
  {
    if (this.troopNameHelper == null) {
      this.troopNameHelper = new TroopNameHelper(this.mApp);
    }
    return this.troopNameHelper;
  }
  
  public String getNewName(ArrayList<String> paramArrayList)
  {
    return getTroopNameHelper().a(paramArrayList);
  }
  
  public boolean isInReturnTaskList(String paramString)
  {
    return getTroopNameHelper().c(paramString);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    TroopNameHelper localTroopNameHelper = this.troopNameHelper;
    if (localTroopNameHelper != null) {
      localTroopNameHelper.a();
    }
  }
  
  public void onFriendNameChaned(String paramString)
  {
    getTroopNameHelper().b(paramString);
  }
  
  public void reExecuteReturnTask(String paramString, boolean paramBoolean)
  {
    getTroopNameHelper().a(paramString, paramBoolean);
  }
  
  public void updateTroopName(String paramString)
  {
    getTroopNameHelper().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopNameHelperServiceImpl
 * JD-Core Version:    0.7.0.1
 */