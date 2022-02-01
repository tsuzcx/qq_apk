package com.tencent.mobileqq.nearby;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.nearby.api.INearbyFakeActivityUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class NearbyFakeActivityUtils
{
  @TargetApi(11)
  public static void a(Context paramContext, Intent paramIntent)
  {
    ((INearbyFakeActivityUtils)QRoute.api(INearbyFakeActivityUtils.class)).openNearbyActWithPreLoad(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivityUtils
 * JD-Core Version:    0.7.0.1
 */