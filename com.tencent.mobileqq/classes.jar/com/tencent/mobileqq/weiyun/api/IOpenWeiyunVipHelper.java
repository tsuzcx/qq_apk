package com.tencent.mobileqq.weiyun.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IOpenWeiyunVipHelper
  extends QRouteApi
{
  public static final int REQUEST_CODE_OPEN_VIP = 2000;
  
  public abstract void closeLimitDialog();
  
  public abstract boolean isNonVipFlowOverErrorCode(int paramInt);
  
  public abstract boolean isNonVipSpaceOverErrorCode(int paramInt);
  
  public abstract boolean needShowLimitDialog(int paramInt);
  
  public abstract void showLimitDialog(Activity paramActivity, int paramInt);
  
  public abstract void showWeiYunSpaceOrFlowLimitDialog(Activity paramActivity, int paramInt);
  
  public abstract void startOpenQQVipH5(Activity paramActivity, String paramString, boolean paramBoolean);
  
  public abstract void startOpenWeiyunVipCompareH5(Activity paramActivity, String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
 * JD-Core Version:    0.7.0.1
 */