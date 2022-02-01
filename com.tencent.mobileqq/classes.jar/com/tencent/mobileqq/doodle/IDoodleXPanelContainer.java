package com.tencent.mobileqq.doodle;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDoodleXPanelContainer
  extends QRouteApi
{
  public abstract int getExternalPanelheight();
  
  public abstract int getXPanelContainerNONE();
  
  public abstract void setExternalPanelheight(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doodle.IDoodleXPanelContainer
 * JD-Core Version:    0.7.0.1
 */