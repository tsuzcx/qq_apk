package com.tencent.mobileqq.nearby.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.nearby.NearbyFakeActivityUtilsReal;
import com.tencent.mobileqq.nearby.api.INearbyFakeActivityUtils;

public class NearbyFakeActivityUtilsImpl
  implements INearbyFakeActivityUtils
{
  public boolean isNearbyProcessExist()
  {
    return NearbyFakeActivityUtilsReal.a();
  }
  
  public void openNearbyActWithPreLoad(Context paramContext, Intent paramIntent)
  {
    NearbyFakeActivityUtilsReal.a(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyFakeActivityUtilsImpl
 * JD-Core Version:    0.7.0.1
 */