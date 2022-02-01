package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.wstt.SSCM.SSCM;

@QAPI(process={"all"})
public abstract interface IPttSSCMPool
  extends QRouteApi
{
  public abstract void clear();
  
  public abstract SSCM getSSCM();
  
  public abstract void returnObject(SSCM paramSSCM);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.IPttSSCMPool
 * JD-Core Version:    0.7.0.1
 */