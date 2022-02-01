package com.tencent.mobileqq.doutu.api.impl;

import android.content.Context;
import com.tencent.mobileqq.doutu.api.IDoutuSPUtil;
import com.tencent.mobileqq.doutu.api.IDoutuUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class DoutuUtilsImpl
  implements IDoutuUtils
{
  public void markResDamaged(Context paramContext)
  {
    if (!DoutuServiceImpl.isLoadingRes) {
      ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuResDamaged(paramContext, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuUtilsImpl
 * JD-Core Version:    0.7.0.1
 */