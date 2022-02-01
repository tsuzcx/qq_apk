package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.GatewayLoginNewDevHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DevLockSmsImpl
  implements IAuthDevVerifyApi
{
  private boolean a;
  private int b;
  private DevLockSmsImpl.DevLockSmsObserver c;
  private int d;
  
  public void a() {}
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    Intent localIntent = paramQBaseActivity.getIntent();
    if (localIntent == null)
    {
      QLog.d("DevLockSmsImpl", 1, "sendSms, intent is null");
      return;
    }
    this.a = localIntent.getBooleanExtra("from_login", false);
    this.b = localIntent.getIntExtra("mobile_type", -1);
    this.d = localIntent.getIntExtra("seq", 0);
    this.c = new DevLockSmsImpl.DevLockSmsObserver(paramQBaseActivity, paramICommonSmsView);
    this.c.setSeq(this.d);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    if (!this.a) {
      return false;
    }
    boolean bool = GatewayLoginNewDevHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gateway_login_new_dev submitSms smsCode=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",mVerifySeq=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(",isGateWayFlow=");
    ((StringBuilder)localObject).append(bool);
    QLog.i("DevLockSmsImpl", 1, ((StringBuilder)localObject).toString());
    localObject = null;
    if (bool)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("key_business_seq", Integer.valueOf(this.d));
      ((HashMap)localObject).put("businessType", Integer.valueOf(2));
      ((HashMap)localObject).put("phoneToken", GatewayLoginNewDevHelper.c());
    }
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.c, paramString, (HashMap)localObject);
    if (i == 0)
    {
      paramICommonSmsView.showLoadingDialog();
      return true;
    }
    paramICommonSmsView = new StringBuilder();
    paramICommonSmsView.append("gateway_login_new_dev submitSms failed ret=");
    paramICommonSmsView.append(i);
    QLog.i("DevLockSmsImpl", 1, paramICommonSmsView.toString());
    QQToast.makeText(paramQBaseActivity, 1, 2131914114, 0).show();
    return true;
  }
  
  public void b() {}
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (!this.a) {
      return false;
    }
    if (this.b != -1) {
      EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.b);
    }
    boolean bool = GatewayLoginNewDevHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gateway_login_new_dev sendSms mVerifySeq=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(",isGateWayFlow=");
    ((StringBuilder)localObject).append(bool);
    QLog.i("DevLockSmsImpl", 1, ((StringBuilder)localObject).toString());
    localObject = null;
    if (bool)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("key_business_seq", Integer.valueOf(this.d));
      ((HashMap)localObject).put("businessType", Integer.valueOf(2));
    }
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.c, (HashMap)localObject);
    if (i == 0)
    {
      paramICommonSmsView.showLoadingDialog();
      return true;
    }
    paramQBaseActivity = new StringBuilder();
    paramQBaseActivity.append("gateway_login_new_devsendSms failed ret=");
    paramQBaseActivity.append(i);
    QLog.i("DevLockSmsImpl", 1, paramQBaseActivity.toString());
    return true;
  }
  
  public boolean c(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    return b(paramQBaseActivity, paramICommonSmsView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DevLockSmsImpl
 * JD-Core Version:    0.7.0.1
 */