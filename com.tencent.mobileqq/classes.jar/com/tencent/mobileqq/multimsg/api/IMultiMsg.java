package com.tencent.mobileqq.multimsg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMultiMsg
  extends QRouteApi
{
  public abstract MultiMsgBean getMultiMsgValue();
  
  public abstract String getPicDefaultPath();
  
  public abstract long getPicDefaultSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.api.IMultiMsg
 * JD-Core Version:    0.7.0.1
 */