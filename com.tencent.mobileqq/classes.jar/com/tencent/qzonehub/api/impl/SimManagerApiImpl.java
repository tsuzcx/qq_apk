package com.tencent.qzonehub.api.impl;

import android.content.Context;
import com.tencent.qzonehub.api.ISimManagerApi;
import cooperation.qzone.sim.SimInfo;
import cooperation.qzone.sim.SimManager;
import cooperation.qzone.sim.SimManagerFectory;

public class SimManagerApiImpl
  implements ISimManagerApi
{
  private SimManager simManager;
  
  public ISimManagerApi createProduct(String paramString, int paramInt)
  {
    this.simManager = SimManagerFectory.createProduct(paramString, paramInt);
    return this;
  }
  
  public SimInfo getDataSimInfo()
  {
    SimManager localSimManager = this.simManager;
    if (localSimManager == null) {
      return null;
    }
    return localSimManager.getDataSimInfo();
  }
  
  public void initAllInfo(Context paramContext)
  {
    SimManager localSimManager = this.simManager;
    if (localSimManager != null) {
      localSimManager.initAllInfo(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.SimManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */