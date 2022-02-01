package com.tencent.mobileqq.troop.homework.api;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHWTroopUIApi
  extends QRouteApi
{
  public abstract void startEntryDebugFragment(Activity paramActivity, Bundle paramBundle);
  
  public abstract void startPublishHomeWorkFragment(Activity paramActivity, @Nullable Bundle paramBundle, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi
 * JD-Core Version:    0.7.0.1
 */