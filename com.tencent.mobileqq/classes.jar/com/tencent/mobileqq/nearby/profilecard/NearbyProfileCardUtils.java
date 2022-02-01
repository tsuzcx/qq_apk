package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.profilecard.api.INearbyProfileCardUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class NearbyProfileCardUtils
{
  public static int a()
  {
    return ((INearbyProfileCardUtils)QRoute.api(INearbyProfileCardUtils.class)).getEditRequestCode();
  }
  
  public static void a(Context paramContext, Object paramObject, Bundle paramBundle)
  {
    ((INearbyProfileCardUtils)QRoute.api(INearbyProfileCardUtils.class)).openProfileCard(paramContext, paramObject, paramBundle, 6);
  }
  
  public static boolean a(int paramInt)
  {
    return ((INearbyProfileCardUtils)QRoute.api(INearbyProfileCardUtils.class)).isFromTribe(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileCardUtils
 * JD-Core Version:    0.7.0.1
 */