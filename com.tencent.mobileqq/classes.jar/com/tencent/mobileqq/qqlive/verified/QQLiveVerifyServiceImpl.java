package com.tencent.mobileqq.qqlive.verified;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qqlive.callback.verified.QQLiveVerifyCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigBean;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigProcessor;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQLiveVerifyServiceImpl
  implements IQQLiveVerifyService
{
  private IQQLiveSDK a;
  private ConcurrentHashMap<Integer, QQLiveVerifyCallback> b = new ConcurrentHashMap();
  private QQCustomDialog c;
  private FaceVerifyBroadcastReceiver d;
  
  private void a(Activity paramActivity, QQLiveVerifyCallback paramQQLiveVerifyCallback)
  {
    if (paramActivity == null)
    {
      paramQQLiveVerifyCallback.a(-1, "activitiy is null");
      return;
    }
    if (this.c == null) {
      this.c = DialogUtil.a(paramActivity, 230, null, "完成实名认证之后才可以进行直播", "取消", "去认证", new QQLiveVerifyServiceImpl.1(this, paramQQLiveVerifyCallback), new QQLiveVerifyServiceImpl.2(this, paramQQLiveVerifyCallback));
    }
    if (!this.c.isShowing()) {
      this.c.show();
    }
  }
  
  private void a(QQLiveVerifyCallback paramQQLiveVerifyCallback)
  {
    Object localObject = this.a.getAppRuntime().getApplicationContext();
    Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
    String str = QQLiveConfigProcessor.a().e;
    localIntent.putExtra("url", str);
    localIntent.putExtra("fragmentStyle", 7);
    localIntent.putExtra("extra_web_verify_app_id", this.a.getAppId());
    localIntent.putExtra("extra_web_verify_client_type", this.a.getConfigModule().getConfigData().getLiveClientType());
    int i = paramQQLiveVerifyCallback.hashCode();
    localIntent.putExtra("extra_web_verify_callback_key", i);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onToVerified url:");
      localStringBuilder.append(str);
      QLog.e("QQLiveVerifyServiceImpl", 1, localStringBuilder.toString());
    }
    ((Context)localObject).startActivity(localIntent);
    localObject = this.b;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).put(Integer.valueOf(i), paramQQLiveVerifyCallback);
    }
  }
  
  public void destroy()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLiveVerifyServiceImpl", 4, "destroy");
    }
    this.b.clear();
    if (this.d != null)
    {
      try
      {
        MobileQQ.sMobileQQ.unregisterReceiver(this.d);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQLiveVerifyServiceImpl", 1, localThrowable, new Object[0]);
      }
      this.d = null;
    }
  }
  
  public void goToVerified(Activity paramActivity, QQLiveVerifyCallback paramQQLiveVerifyCallback)
  {
    IQQLiveSDK localIQQLiveSDK = this.a;
    if ((localIQQLiveSDK != null) && (!localIQQLiveSDK.isDestroyed()))
    {
      a(paramActivity, paramQQLiveVerifyCallback);
      return;
    }
    paramQQLiveVerifyCallback.a(-1, "qqLiveSdk还没初始化!");
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.a = paramIQQLiveSDK;
    this.d = new FaceVerifyBroadcastReceiver();
    paramIQQLiveSDK = new IntentFilter();
    paramIQQLiveSDK.addAction("qqlive.faceverify");
    MobileQQ.sMobileQQ.registerReceiver(this.d, paramIQQLiveSDK);
  }
  
  public void notifyVerifyResult(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (QQLiveVerifyCallback)((ConcurrentHashMap)localObject).remove(Integer.valueOf(paramInt1));
      if (localObject != null) {
        ((QQLiveVerifyCallback)localObject).a(paramInt2, paramString);
      }
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.QQLiveVerifyServiceImpl
 * JD-Core Version:    0.7.0.1
 */