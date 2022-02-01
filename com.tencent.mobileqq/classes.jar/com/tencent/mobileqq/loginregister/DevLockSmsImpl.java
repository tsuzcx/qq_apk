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
    QLog.i("DevLockSmsImpl", 1, "gateway_login_new_dev sendSms mVerifySeq=" + this.b + ",isGateWayFlow=" + bool);
    HashMap localHashMap = null;
    if (bool)
    {
      localHashMap = new HashMap();
      localHashMap.put("key_business_seq", Integer.valueOf(this.b));
      localHashMap.put("businessType", Integer.valueOf(2));
    }
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqLoginregisterDevLockSmsImpl$DevLockSmsObserver, localHashMap);
    if (i == 0) {
      paramICommonSmsView.showLoadingDialog();
    }
    for (;;)
    {
      return true;
      QLog.i("DevLockSmsImpl", 1, "gateway_login_new_devsendSms failed ret=" + i);
    }
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    boolean bool = GatewayLoginNewDevHelper.a();
    QLog.i("DevLockSmsImpl", 1, "gateway_login_new_dev submitSms smsCode=" + paramString + ",mVerifySeq=" + this.b + ",isGateWayFlow=" + bool);
    HashMap localHashMap = null;
    if (bool)
    {
      localHashMap = new HashMap();
      localHashMap.put("key_business_seq", Integer.valueOf(this.b));
      localHashMap.put("businessType", Integer.valueOf(2));
      localHashMap.put("phoneToken", GatewayLoginNewDevHelper.a());
    }
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqLoginregisterDevLockSmsImpl$DevLockSmsObserver, paramString, localHashMap);
    if (i == 0) {
      paramICommonSmsView.showLoadingDialog();
    }
    for (;;)
    {
      return true;
      QLog.i("DevLockSmsImpl", 1, "gateway_login_new_dev submitSms failed ret=" + i);
      QQToast.a(paramQBaseActivity, 1, 2131716998, 0).a();
    }
  }
  
  public void b() {}
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    return a(paramQBaseActivity, paramICommonSmsView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DevLockSmsImpl
 * JD-Core Version:    0.7.0.1
 */