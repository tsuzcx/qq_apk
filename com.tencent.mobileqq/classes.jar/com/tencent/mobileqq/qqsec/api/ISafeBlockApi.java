package com.tencent.mobileqq.qqsec.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISafeBlockApi
  extends QRouteApi
{
  public abstract void cancelVerifyRiskDialog(String paramString);
  
  public abstract void doAfterPushRiskDialog(String paramString, long paramLong);
  
  public abstract void enableJumpLoginFromFund(QBaseActivity paramQBaseActivity);
  
  public abstract void exitApp(Activity paramActivity);
  
  public abstract boolean finishNotifyActivityByKicked(Context paramContext);
  
  public abstract String getAppendMsgWithSceneId(int paramInt);
  
  public abstract int getForbidScene(byte[] paramArrayOfByte);
  
  public abstract String getJumpAQH5Url(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract int getLinkTypeForReport(String paramString, int paramInt1, int paramInt2);
  
  public abstract Class<?> getNotifyActivityClass();
  
  public abstract int getTipResIdWithSceneId(int paramInt);
  
  public abstract CharSequence handleNotifyMsg(String paramString, QBaseActivity paramQBaseActivity, int paramInt);
  
  public abstract TipsBar initModifyPwdBanner(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext);
  
  public abstract boolean isBlockNotifyActivity(Object paramObject);
  
  public abstract void reportFrozenDlg(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, int paramInt2, String paramString);
  
  public abstract boolean shouldHandleByDlgHelper(byte[] paramArrayOfByte);
  
  public abstract boolean unBlockWithMiniAppFromCnt(QBaseActivity paramQBaseActivity, String paramString);
  
  public abstract void updateBarDisplayStatus(BaseQQAppInterface paramBaseQQAppInterface, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqsec.api.ISafeBlockApi
 * JD-Core Version:    0.7.0.1
 */