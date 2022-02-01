package com.tencent.qzonehub.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.sim.SimInfo;

@QAPI(process={"all"})
public abstract interface ISimManagerApi
  extends QRouteApi
{
  public abstract ISimManagerApi createProduct(String paramString, int paramInt);
  
  public abstract SimInfo getDataSimInfo();
  
  public abstract void initAllInfo(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.ISimManagerApi
 * JD-Core Version:    0.7.0.1
 */