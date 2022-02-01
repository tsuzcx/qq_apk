package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQFileAppStorePromoteConfigBean
  extends QRouteApi
{
  public abstract String getActionHint();
  
  public abstract boolean getActionSwitch();
  
  public abstract void setActionSwitch(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQFileAppStorePromoteConfigBean
 * JD-Core Version:    0.7.0.1
 */