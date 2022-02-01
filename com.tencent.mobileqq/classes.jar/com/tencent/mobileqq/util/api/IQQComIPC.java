package com.tencent.mobileqq.util.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IQQComIPC
  extends QRouteApi
{
  public static final String KEY_REQ_PARAM = "req_param";
  
  public abstract void cancelAlarmNotifaction(Bundle paramBundle);
  
  public abstract void removeMessageRecord(Bundle paramBundle);
  
  public abstract void setAlarmNotifaction(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.api.IQQComIPC
 * JD-Core Version:    0.7.0.1
 */