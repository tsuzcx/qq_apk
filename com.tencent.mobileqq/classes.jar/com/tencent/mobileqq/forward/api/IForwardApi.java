package com.tencent.mobileqq.forward.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IForwardApi
  extends QRouteApi
{
  public abstract String KEY_DIRECT_SHOW_UIN();
  
  public abstract String KEY_DIRECT_SHOW_UIN_TYPE();
  
  public abstract String KEY_REQ();
  
  public abstract int REQ_DIRECT_SHOW_DIALOG();
  
  public abstract String SELECTION_MODE();
  
  public abstract int SELECTION_MODE_MULTI();
  
  public abstract int SEND_ASK_ANONYMOUSLY_ARK_MSG();
  
  public abstract Class getForwardRecentActivityClass();
  
  public abstract Class getForwardRecentTranslucentActivityClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.api.IForwardApi
 * JD-Core Version:    0.7.0.1
 */