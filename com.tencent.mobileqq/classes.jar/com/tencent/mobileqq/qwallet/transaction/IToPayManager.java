package com.tencent.mobileqq.qwallet.transaction;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IToPayManager
  extends QRouteApi
{
  public static final String BROADCAST_PAYER_NOTIFY = "com.tencent.qwallet.payer.notify";
  public static final String KEY_RECOMMEND = "recommend";
  public static final String KEY_TIPS = "tips";
  
  public abstract HashMap<String, Object> getTopayList(IToPayManager.TopayListener paramTopayListener, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void onReceivePayerNotify(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong);
  
  public abstract void removeObserver(AppRuntime paramAppRuntime);
  
  public abstract void topay(AppActivity paramAppActivity, ArrayList<ResultRecord> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.IToPayManager
 * JD-Core Version:    0.7.0.1
 */