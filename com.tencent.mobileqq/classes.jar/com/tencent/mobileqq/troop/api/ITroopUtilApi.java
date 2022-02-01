package com.tencent.mobileqq.troop.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopUtilApi
  extends QRouteApi
{
  public static final int TYPE_GUEST_VISTOR = 2;
  
  public abstract boolean hasSetTroopHead(String paramString);
  
  public abstract void openTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopUtilApi
 * JD-Core Version:    0.7.0.1
 */