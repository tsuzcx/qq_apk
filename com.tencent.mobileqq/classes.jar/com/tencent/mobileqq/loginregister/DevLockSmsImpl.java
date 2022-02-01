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
  private int jdField_a_of_type_Int;
  private DevLockSmsImpl.DevLockSmsObserver jdField_a_of_type_ComTencentMobileqqLoginregisterDevLockSmsImpl$DevLockSmsObserver;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
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
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("from_login", false);
    this.jdField_a_of_type_Int = localIntent.getIntExtra("mobile_type", -1);
    this.b = localIntent.getIntExtra("seq", 0);
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterDevLockSmsImpl$DevLockSmsObserver = new DevLockSmsImpl.DevLockSmsObserver(paramQBaseActivity, paramICommonSmsView);
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterDevLockSmsImpl$DevLockSmsObserver.setSeq(this.b);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_Int != -1) {
      EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.jdField_a_of_type_Int);
    }
    boolean bool = GatewayLoginNewDevHelper.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gateway_login_new_dev sendSms mVerifySeq=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",isGateWayFlow=");
    ((StringBuilder)localObject).append(bool);
    QLog.i("DevLockSmsImpl", 1, ((StringBuilder)localObject).toString());
    localObject = null;
    if (bool)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("key_business_seq", Integer.valueOf(this.b));
      ((HashMap)localObject).put("businessType", Integer.valueOf(2));
    }
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqLoginregisterDevLockSmsImpl$DevLockSmsObserver, (HashMap)localObject);
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
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    boolean bool = GatewayLoginNewDevHelper.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gateway_login_new_dev submitSms smsCode=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",mVerifySeq=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",isGateWayFlow=");
    ((StringBuilder)localObject).append(bool);
    QLog.i("DevLockSmsImpl", 1, ((StringBuilder)localObject).toString());
    localObject = null;
    if (bool)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("key_business_seq", Integer.valueOf(this.b));
      ((HashMap)localObject).put("businessType", Integer.valueOf(2));
      ((HashMap)localObject).put("phoneToken", GatewayLoginNewDevHelper.a());
    }
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqLoginregisterDevLockSmsImpl$DevLockSmsObserver, paramString, (HashMap)localObject);
    if (i == 0)
    {
      paramICommonSmsView.showLoadingDialog();
      return true;
    }
    paramICommonSmsView = new StringBuilder();
    paramICommonSmsView.append("gateway_login_new_dev submitSms failed ret=");
    paramICommonSmsView.append(i);
    QLog.i("DevLockSmsImpl", 1, paramICommonSmsView.toString());
    QQToast.a(paramQBaseActivity, 1, 2131716651, 0).a();
    return true;
  }
  
  public void b() {}
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    return a(paramQBaseActivity, paramICommonSmsView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DevLockSmsImpl
 * JD-Core Version:    0.7.0.1
 */