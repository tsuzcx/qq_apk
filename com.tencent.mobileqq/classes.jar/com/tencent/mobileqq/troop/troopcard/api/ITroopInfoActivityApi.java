package com.tencent.mobileqq.troop.troopcard.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopInfoActivityApi
  extends QRouteApi
{
  public abstract void openTroopProfile(Context paramContext, Bundle paramBundle);
  
  public abstract void openTroopProfileForResult(Activity paramActivity, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi
 * JD-Core Version:    0.7.0.1
 */