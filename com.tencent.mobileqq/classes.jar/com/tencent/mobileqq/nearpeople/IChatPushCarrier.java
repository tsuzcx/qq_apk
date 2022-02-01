package com.tencent.mobileqq.nearpeople;

import EncounterSvc.RespEncounterInfo;
import android.view.View;
import java.util.List;

public abstract interface IChatPushCarrier
{
  public abstract void a();
  
  public abstract void a(View paramView, RespEncounterInfo paramRespEncounterInfo);
  
  public abstract void a(List<RespEncounterInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.IChatPushCarrier
 * JD-Core Version:    0.7.0.1
 */