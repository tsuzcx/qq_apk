package com.tencent.mobileqq.weiyun.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWeiyunResponseHandler
  extends QRouteApi
{
  public static final int ERROR_DISK_SERVER_CODE_FLOW_LIMIT = 1127;
  public static final int ERROR_DISK_SERVER_CODE_FLOW_LIMIT_VIP = 22000;
  public static final int ERROR_DISK_SERVER_CODE_FLOW_LIMIT_VIP_SUPER = 22121;
  public static final int ERR_DISK_OFFLINE_2_WEIYUN_CAPACITY = -20001;
  public static final int ERR_DISK_SERVER_LIMIT_EXCEED_MAX_CAPACITY = 1053;
  public static final int ERR_DISK_SERVER_LIMIT_EXCEED_MAX_CAPACITY_VIP = 22081;
  public static final int ERR_DISK_SERVER_LIMIT_EXCEED_MAX_CAPACITY_VIP_SUPER = 22121;
  
  public abstract boolean endSave2Weiyun(int paramInt);
  
  public abstract String getErrorMsg(Context paramContext);
  
  public abstract boolean isAllRequestFinished();
  
  public abstract boolean isFlowOverErrorCode(int paramInt);
  
  public abstract boolean isSpaceOverErrorCode(int paramInt);
  
  public abstract boolean needShowGrayTips();
  
  public abstract boolean needShowGrayTips(int paramInt);
  
  public abstract void setRequestData(String paramString1, String paramString2, int paramInt);
  
  public abstract void showGrayTips(AppInterface paramAppInterface);
  
  public abstract void startSave2Weiyun();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler
 * JD-Core Version:    0.7.0.1
 */