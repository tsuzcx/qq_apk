package com.tencent.mobileqq.qqsec.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.security.ModifyPwdTopBarHelper;
import com.tencent.qphone.base.util.QLog;

public class SafeBlockApiImpl
  implements ISafeBlockApi
{
  private static final String TAG = "SafeBlockApiImpl";
  
  public void cancelVerifyRiskDialog(String paramString)
  {
    ModifyPwdTopBarHelper.a().a(paramString);
  }
  
  public void doAfterPushRiskDialog(String paramString, long paramLong)
  {
    ModifyPwdTopBarHelper.a().a(paramString, paramLong);
  }
  
  public void enableJumpLoginFromFund(QBaseActivity paramQBaseActivity)
  {
    if ((paramQBaseActivity != null) && ((paramQBaseActivity instanceof NotificationActivity)))
    {
      ((NotificationActivity)paramQBaseActivity).enableJumpLoginFromFund();
      return;
    }
    QLog.e("SafeBlockApiImpl", 1, "enableJumpLoginFromFund error: baseActivity param error");
  }
  
  public void exitApp(Activity paramActivity)
  {
    if ((paramActivity != null) && ((paramActivity instanceof NotificationActivity)))
    {
      ((NotificationActivity)paramActivity).exitApp();
      return;
    }
    QLog.e("SafeBlockApiImpl", 1, "exitApp error: activity param error");
  }
  
  public boolean finishNotifyActivityByKicked(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.e("SafeBlockApiImpl", 1, "finishNotifyActivityByKicked error: context == null");
      return false;
    }
    if ((NotificationActivity.instance != null) && (!NotificationActivity.instance.isFinishing()))
    {
      QLog.d("SafeBlockApiImpl", 1, "needFinish, notification activity exists");
      Intent localIntent = NotificationActivity.instance.getIntent();
      NotificationActivity.instance.finish();
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public String getAppendMsgWithSceneId(int paramInt)
  {
    return FrozenNotifyDlgHelper.a().a(paramInt);
  }
  
  public int getForbidScene(byte[] paramArrayOfByte)
  {
    return FrozenNotifyDlgHelper.a().a(paramArrayOfByte);
  }
  
  public String getJumpAQH5Url(String paramString1, String paramString2, boolean paramBoolean)
  {
    return FrozenNotifyDlgHelper.a().a(paramString1, paramString2, paramBoolean);
  }
  
  public int getLinkTypeForReport(String paramString, int paramInt1, int paramInt2)
  {
    return FrozenNotifyDlgHelper.a().a(paramString, paramInt1, paramInt2);
  }
  
  public Class<?> getNotifyActivityClass()
  {
    return NotificationActivity.class;
  }
  
  public int getTipResIdWithSceneId(int paramInt)
  {
    return FrozenNotifyDlgHelper.a().a(paramInt);
  }
  
  public CharSequence handleNotifyMsg(String paramString, QBaseActivity paramQBaseActivity, int paramInt)
  {
    return FrozenNotifyDlgHelper.a().a(paramString, paramQBaseActivity, paramInt);
  }
  
  public TipsBar initModifyPwdBanner(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    return ModifyPwdTopBarHelper.a().a(paramBaseQQAppInterface, paramContext);
  }
  
  public boolean isBlockNotifyActivity(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("SafeBlockApiImpl", 1, "isBlockNotifyActivity error: activity == null");
      return false;
    }
    return paramObject instanceof NotificationActivity;
  }
  
  public void reportFrozenDlg(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    FrozenNotifyDlgHelper.a().a(paramBaseQQAppInterface, paramInt1, paramInt2, paramString);
  }
  
  public boolean shouldHandleByDlgHelper(byte[] paramArrayOfByte)
  {
    return FrozenNotifyDlgHelper.a().a(paramArrayOfByte);
  }
  
  public boolean unBlockWithMiniAppFromCnt(QBaseActivity paramQBaseActivity, String paramString)
  {
    return FrozenNotifyDlgHelper.a().a(paramQBaseActivity, paramString);
  }
  
  public void updateBarDisplayStatus(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    ModifyPwdTopBarHelper.a().a(paramBaseQQAppInterface, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqsec.api.impl.SafeBlockApiImpl
 * JD-Core Version:    0.7.0.1
 */