package com.tencent.mobileqq.newnearby;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyVersionControl
  extends QRouteApi
{
  public static final int VERSION_NEW = 2;
  public static final int VERSION_OLD = 1;
  
  public abstract int getVersion();
  
  public abstract void updateVersion(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.INearbyVersionControl
 * JD-Core Version:    0.7.0.1
 */