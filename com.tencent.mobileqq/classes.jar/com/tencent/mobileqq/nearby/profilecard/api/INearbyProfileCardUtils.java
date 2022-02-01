package com.tencent.mobileqq.nearby.profilecard.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyProfileCardUtils
  extends QRouteApi
{
  public abstract int getEditRequestCode();
  
  public abstract boolean isFromTribe(int paramInt);
  
  public abstract void openProfileCard(Context paramContext, Object paramObject, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.INearbyProfileCardUtils
 * JD-Core Version:    0.7.0.1
 */