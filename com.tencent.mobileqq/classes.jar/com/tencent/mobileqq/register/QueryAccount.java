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
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131711195));
    localIntent.putExtra("key_register_from", 7);
    localIntent.putExtra("key_register_from_friend_verify", (Serializable)this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum));
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, "go2next countryCode=" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + ", phoneNum=" + PhoneCodeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum) + ", leftTime=" + paramInt + ", exitTime=" + paramLong);
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
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_register_from_fail_pay_lh", false)))
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
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131711195));
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
  
  public String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode)) {
          break label191;
        }
        if ("853".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode))
        {
          break label191;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode)) {
            i = 0;
          }
        }
        if (!"86".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode)) {
          break label183;
        }
        j = paramString.length();
        if (j == 11) {
          break label183;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label166;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode);
      if (bool)
      {
        i = 9;
        continue;
        label166:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label183:
        continue;
        label191:
        i = 6;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick != null) {
      this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick.a();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("phonenum");
      str3 = paramIntent.getStringExtra("key");
      str1 = paramIntent.getStringExtra("invite_code");
      str2 = str3 + (String)localObject;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str2);
      }
      paramInt1 = paramIntent.getIntExtra("key_register_left_time", 0);
      l = paramIntent.getLongExtra("key_register_exit_time", 0L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doOnActivityResult countryCode=").append(str3).append(", phoneNum=").append(PhoneCodeUtils.a((String)localObject)).append(", leftTime=").append(paramInt1).append(", exitTime=").append(l).append(", inviteCode=");
        if (str1 == null)
        {
          paramIntent = "";
          QLog.d("QueryAccount", 2, paramIntent);
        }
      }
      else if ((paramInt1 > 0) && (l > 0L))
      {
        paramIntent = new QueryAccount.UserRegTimeInfo(this);
        paramIntent.jdField_a_of_type_Int = paramInt1;
        paramIntent.jdField_a_of_type_Long = l;
        paramIntent.jdField_a_of_type_JavaLangString = str1;
        this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramIntent);
      }
    }
    while (paramInt1 != 2020) {
      for (;;)
      {
        Object localObject;
        String str3;
        String str1;
        String str2;
        long l;
        return;
        paramIntent = str1;
      }
    }
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
  
  public void a(Context paramContext)
  {
    String str3 = Locale.getDefault().getLanguage();
    String str1 = PropertiesUtils.a(BaseApplication.getContext(), "key_local_cache", "0");
    if ("0".equals(str1)) {
      QLog.e("QueryAccount", 1, "addLocaleIdCookie, localeIdStr = 0");
    }
    for (;;)
    {
      return;
      try
      {
        i = Integer.parseInt(str1);
        str1 = "02:00:00:00:00:00";
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
          if ((paramContext != null) && (paramContext.getConnectionInfo() != null)) {
            paramContext = QQDeviceInfo.getMAC("641d5d");
          }
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            try
            {
              str1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getCityCode();
              this.jdField_a_of_type_JavaLangString = paramContext;
              this.jdField_b_of_type_JavaLangString = str3;
              this.jdField_a_of_type_Int = i;
              this.c = str1;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QueryAccount", 2, new Object[] { "regMacAddr:", this.jdField_a_of_type_JavaLangString, " regOS:", this.jdField_b_of_type_JavaLangString, " regQQLang:", Integer.valueOf(this.jdField_a_of_type_Int), " regLocation:", this.c });
              return;
              localException = localException;
              QLog.e("QueryAccount", 1, localException.toString());
              int i = 0;
              continue;
              paramContext = paramContext;
              QLog.e("QueryAccount", 1, paramContext, new Object[0]);
              paramContext = localException;
              continue;
            }
            catch (Throwable localThrowable)
            {
              QLog.e("QueryAccount", 1, localThrowable, new Object[0]);
              String str2 = "";
              continue;
            }
            paramContext = "02:00:00:00:00:00";
          }
        }
      }
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
    if (!a()) {
      return;
    }
    try
    {
      Bundle localBundle = a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mCountryEnglishName))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("country_english_name", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.mCountryEnglishName.getBytes());
        localBundle.putSerializable("mapSt", localHashMap);
      }
      ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode, Long.valueOf(AppSetting.a()), "8.5.5", localBundle, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QueryAccount", 1, "sendRegistByPhone exception: " + paramString);
    }
  }
  
  public void a(String paramString, HashMap<String, Object> paramHashMap)
  {
    if ((!a()) || (paramHashMap == null))
    {
      QLog.e("QueryAccount", 1, "sendRegistByPhone error: params wrong");
      return;
    }
    Bundle localBundle = a();
    localBundle.putSerializable("mapSt", paramHashMap);
    ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode, Long.valueOf(AppSetting.a()), "8.5.5", localBundle, null);
  }
  
  public boolean a()
  {
    boolean bool = true;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getEditPhoneNum();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum = a(str);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716940, 1);
      bool = false;
    }
    return bool;
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum;
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(str)) {
      this.jdField_b_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(false));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if ((localObject != null) && ((localObject instanceof QueryAccount.UserRegTimeInfo)))
      {
        QueryAccount.UserRegTimeInfo localUserRegTimeInfo = (QueryAccount.UserRegTimeInfo)localObject;
        if ((localUserRegTimeInfo.jdField_a_of_type_Int > 0) && (localUserRegTimeInfo.jdField_a_of_type_Long > 0L) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode, localUserRegTimeInfo.jdField_a_of_type_JavaLangString)))
        {
          long l = System.currentTimeMillis() - localUserRegTimeInfo.jdField_a_of_type_Long;
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("startQueryAccount countryCode=").append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode).append(", phoneNum=").append(PhoneCodeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum)).append(", leftTime=").append(localUserRegTimeInfo.jdField_a_of_type_Int).append(", exitTime=").append(localUserRegTimeInfo.jdField_a_of_type_Long).append(", interval=").append(l).append(", inviteCode=");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode != null) {
              break label308;
            }
          }
          label308:
          for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.inviteCode)
          {
            QLog.d("QueryAccount", 2, (String)localObject);
            if ((l <= 0L) || (l >= localUserRegTimeInfo.jdField_a_of_type_Int * 1000L)) {
              break;
            }
            a(localUserRegTimeInfo.jdField_a_of_type_Int, localUserRegTimeInfo.jdField_a_of_type_Long);
            return;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131692257, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "startQueryAccount countryCode=" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + " phoneNum=" + PhoneCodeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum));
      }
      ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).sendRegisterQueryMobile(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.createWaitingDialog(2131716959);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_AndroidContentIntent != null)) {
      paramIntent.putExtras(this.jdField_a_of_type_AndroidContentIntent);
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
    Intent localIntent = new Intent();
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131711195));
    localIntent.putExtra("url", paramString);
    LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, localIntent, "/base/browser");
    RegisterManager.a().a(4);
    this.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.countryCode + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, Boolean.valueOf(true));
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8009C5D", "0X8009C5D", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.phoneNum, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount
 * JD-Core Version:    0.7.0.1
 */