package com.tencent.mobileqq.troop.api.troopcreate;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process={""})
public abstract interface ICreateTroopShare
  extends IRuntimeService
{
  public abstract void ShareToQQ(JSONObject paramJSONObject, Activity paramActivity);
  
  public abstract void miniAppShareQQDirectly(Intent paramIntent, Activity paramActivity);
  
  public abstract void miniAppShareQQDirectlyWithOutDialog(Intent paramIntent, Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.ICreateTroopShare
 * JD-Core Version:    0.7.0.1
 */