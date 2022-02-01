package com.tencent.mobileqq.nearby.profilecard.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.nearby.profilecard.RealNearbyProfileCardUtils;
import com.tencent.mobileqq.nearby.profilecard.api.INearbyProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;

public class NearbyProfileCardUtilsImpl
  implements INearbyProfileCardUtils
{
  public int getEditRequestCode()
  {
    return NearbyProfileEditPanel.d;
  }
  
  public boolean isFromTribe(int paramInt)
  {
    return RealNearbyProfileCardUtils.a(paramInt);
  }
  
  public void openProfileCard(Context paramContext, Object paramObject, Bundle paramBundle, int paramInt)
  {
    RealNearbyProfileCardUtils.a(paramContext, (AllInOne)paramObject, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.impl.NearbyProfileCardUtilsImpl
 * JD-Core Version:    0.7.0.1
 */