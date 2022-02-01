package com.tencent.mobileqq.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class QueryAccount
  extends RegisterStepBase
{
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private RegisterWithNick jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
  public String a;
  private HashMap<String, QueryAccount.UserRegTimeInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new QueryAccount.2(this);
  private boolean jdField_a_of_type_Boolean = false;
  public String b;
  private HashMap<String, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  public String c;
  private String d = null;
  
  public QueryAccount(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
  }
  
  private Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("wifi_mac", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("os_language", this.jdField_b_of_type_JavaLangString);
    localBundle.putInt("qq_language", this.jdField_a_of_type_Int);
    localBundle.putString("gps_location", this.c);
    return localBundle;
  }
  
  private void a(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd);
    localIntent.putExtra("key_register_binded_qq", this.d);
    localIntent.putExtra("key_register_left_time", paramInt);
    localIntent.putExtra("key_register_exit_time", paramLong);
    localIntent.putExtra("register_verify_code_start_time", System.currentTimeMillis());
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131711171));
    localIntent.putExtra("key_register_from", 7);
    Object localObject = this.jdField_b_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    localIntent.putExtra("key_register_from_friend_verify", (Serializable)((HashMap)localObject).get(localStringBuilder.toString()));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("go2next countryCode=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
      ((StringBuilder)localObject).append(", phoneNum=");
      ((StringBuilder)localObject).append(PhoneCodeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum));
      ((StringBuilder)localObject).append(", leftTime=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", exitTime=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("QueryAccount", 2, ((StringBuilder)localObject).toString());
    }
    b(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivityForResult(localIntent, 2);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return TextUtils.isEmpty(paramString2);
    }
    return paramString1.equals(paramString2);
  }
  
  private void c()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if ((localIntent != null) && (localIntent.getBooleanExtra("key_register_from_fail_pay_lh", false)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick == null) {
        this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = new RegisterWithNick(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    RegisterPersonalInfoActivity.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, "", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered, false, null, 7);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    localIntent.putExtra("key_register_prompt_info", paramString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mIsPhoneNumRegistered);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mHasPwd);
    localIntent.putExtra("key_register_binded_qq", this.d);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131711171));
    localIntent.putExtra("key_register_from", 7);
    b(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(localIntent);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QueryAccount.4(this);
      IntentFilter localIntentFilter = new IntentFilter("action_qq_register_face_recognize_assist");
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new QueryAccount.1(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e(String paramString)
  {
    QLog.i("QueryAccount", 1, "gotoFaceRecognize");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    d();
    paramString = String.format("https://graph.qq.com/safe/face/identification?authType=regist&regsig=%s&uin=1854000000", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, localIntent, "/base/browser", 2020);
    RegisterManager.a().a(5);
    RegisterManager.a().a(null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    RegisterWithNick localRegisterWithNick = this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick;
    if (localRegisterWithNick != null) {
      localRegisterWithNick.a();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      String str2 = paramIntent.getStringExtra("phonenum");
      String str3 = paramIntent.getStringExtra("key");
      String str1 = paramIntent.getStringExtra("invite_code");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(str2);
      localObject = ((StringBuilder)localObject).toString();
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
      }
      paramInt1 = paramIntent.getIntExtra("key_register_left_time", 0);
      long l = paramIntent.getLongExtra("key_register_exit_time", 0L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnActivityResult countryCode=");
        localStringBuilder.append(str3);
        localStringBuilder.append(", phoneNum=");
        localStringBuilder.append(PhoneCodeUtils.a(str2));
        localStringBuilder.append(", leftTime=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", exitTime=");
        localStringBuilder.append(l);
        localStringBuilder.append(", inviteCode=");
        if (str1 == null) {
          paramIntent = "";
        } else {
          paramIntent = str1;
        }
        localStringBuilder.append(paramIntent);
        QLog.d("QueryAccount", 2, localStringBuilder.toString());
      }
      if ((paramInt1 > 0) && (l > 0L))
      {
        paramIntent = new QueryAccount.UserRegTimeInfo(this);
        paramIntent.jdField_a_of_type_Int = paramInt1;
        paramIntent.jdField_a_of_type_Long = l;
        paramIntent.jdField_a_of_type_JavaLangString = str1;
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramIntent);
      }
    }
    else if (paramInt1 == 2020)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Boolean)
      {
        paramIntent = RegisterManager.a().a();
        if (paramIntent != null)
        {
          a(null, paramIntent.a());
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    }
  }
  
  public void a(Context paramContext)
  {
    String str4 = Locale.getDefault().getLanguage();
    String str1 = PropertiesUtils.a(BaseApplication.getContext(), "key_local_cache", "0");
    if ("0".equals(str1))
    {
      QLog.e("QueryAccount", 1, "addLocaleIdCookie, localeIdStr = 0");
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(str1);
    }
    catch (Exception localException)
    {
      QLog.e("QueryAccount", 1, localException.toString());
      i = 0;
    }
    String str2 = "02:00:00:00:00:00";
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      paramContext = str2;
      if (localWifiManager != null)
      {
        paramContext = str2;
        if (localWifiManager.getConnectionInfo() != null) {
          paramContext = QQDeviceInfo.getMAC("641d5d");
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("QueryAccount", 1, paramContext, new Object[0]);
      paramContext = str2;
    }
    String str3;
    try
    {
      str2 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getCityCode();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QueryAccount", 1, localThrowable, new Object[0]);
      str3 = "";
    }
    this.jdField_a_of_type_JavaLangString = paramContext;
    this.jdField_b_of_type_JavaLangString = str4;
    this.jdField_a_of_type_Int = i;
    this.c = str3;
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, new Object[] { "regMacAddr:", this.jdField_a_of_type_JavaLangString, " regOS:", this.jdField_b_of_type_JavaLangString, " regQQLang:", Integer.valueOf(this.jdField_a_of_type_Int), " regLocation:", this.c });
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (QLog.isDevelopLevel()) {
      QLog.i("QueryAccount", 4, "setExtraInfo");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      localObject = a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mCountryEnglishName))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("country_english_name", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mCountryEnglishName.getBytes());
        ((Bundle)localObject).putSerializable("mapSt", localHashMap);
      }
      ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode, Long.valueOf(AppSetting.a()), "8.7.0", (Bundle)localObject, null);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendRegistByPhone exception: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("QueryAccount", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null)
    {
      QLog.e("QueryAccount", 1, "sendRegistByPhone error: extrasMap is null");
      return;
    }
    Bundle localBundle = a();
    localBundle.putSerializable("mapSt", paramHashMap);
    ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode, Long.valueOf(AppSetting.a()), "8.7.0", localBundle, null);
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    String str = ((StringBuilder)localObject).toString();
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(str)) {
      this.jdField_b_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(false));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      localObject = this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if ((localObject != null) && ((localObject instanceof QueryAccount.UserRegTimeInfo)))
      {
        QueryAccount.UserRegTimeInfo localUserRegTimeInfo = (QueryAccount.UserRegTimeInfo)localObject;
        if ((localUserRegTimeInfo.jdField_a_of_type_Int > 0) && (localUserRegTimeInfo.jdField_a_of_type_Long > 0L) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode, localUserRegTimeInfo.jdField_a_of_type_JavaLangString)))
        {
          long l = System.currentTimeMillis() - localUserRegTimeInfo.jdField_a_of_type_Long;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startQueryAccount countryCode=");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
            localStringBuilder.append(", phoneNum=");
            localStringBuilder.append(PhoneCodeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum));
            localStringBuilder.append(", leftTime=");
            localStringBuilder.append(localUserRegTimeInfo.jdField_a_of_type_Int);
            localStringBuilder.append(", exitTime=");
            localStringBuilder.append(localUserRegTimeInfo.jdField_a_of_type_Long);
            localStringBuilder.append(", interval=");
            localStringBuilder.append(l);
            localStringBuilder.append(", inviteCode=");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode == null) {
              localObject = "";
            } else {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode;
            }
            localStringBuilder.append((String)localObject);
            QLog.d("QueryAccount", 2, localStringBuilder.toString());
          }
          if ((l > 0L) && (l < localUserRegTimeInfo.jdField_a_of_type_Int * 1000L))
          {
            a(localUserRegTimeInfo.jdField_a_of_type_Int, localUserRegTimeInfo.jdField_a_of_type_Long);
            return;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131692183, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startQueryAccount countryCode=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
        ((StringBuilder)localObject).append(" phoneNum=");
        ((StringBuilder)localObject).append(PhoneCodeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum));
        QLog.d("queryMobile", 2, ((StringBuilder)localObject).toString());
      }
      ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).sendRegisterQueryMobile(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.createWaitingDialog(2131716612);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
      if (localIntent != null) {
        paramIntent.putExtras(localIntent);
      }
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QueryAccount", 1, "onRegisterCommitMobileResp, url is empty");
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.runOnUiThread(new QueryAccount.3(this));
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131711171));
    ((Intent)localObject).putExtra("url", paramString);
    LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, (Intent)localObject, "/base/browser");
    RegisterManager.a().a(4);
    paramString = this.jdField_b_of_type_JavaUtilHashMap;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum);
    paramString.put(((StringBuilder)localObject).toString(), Boolean.valueOf(true));
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8009C5D", "0X8009C5D", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount
 * JD-Core Version:    0.7.0.1
 */