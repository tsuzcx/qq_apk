package com.tencent.mobileqq.troop.troopcreate.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.InviteMemberInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopCreateService
  extends IRuntimeService
{
  public abstract void createTroop(Activity paramActivity, ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback);
  
  public abstract void createTroop(ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback, Activity paramActivity, List<TroopCreateInfo.InviteMemberInfo> paramList);
  
  public abstract void onReuseTroop(String paramString);
  
  public abstract void releaseCreateCallback(ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback);
  
  public abstract void startCreateTroop(ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback, Activity paramActivity, ArrayList<ResultRecord> paramArrayList);
  
  public abstract void startCreateTroopSession(Activity paramActivity, int paramInt);
  
  public abstract void startCreateTroopSession(Activity paramActivity, int paramInt, String paramString);
  
  public abstract void terminateLogic();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
 * JD-Core Version:    0.7.0.1
 */