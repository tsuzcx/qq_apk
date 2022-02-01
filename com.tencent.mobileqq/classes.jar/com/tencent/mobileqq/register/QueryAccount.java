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
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
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
  protected HashMap<String, QueryAccount.UserRegTimeInfo> a = new HashMap();
  public String b;
  public String c;
  public int d;
  public String e;
  protected AccountObserver f = new QueryAccount.2(this);
  private String i = null;
  private Intent j = null;
  private RegisterWithNick k = null;
  private HashMap<String, Boolean> l = new HashMap();
  private BroadcastReceiver m;
  private boolean n = false;
  private boolean o = false;
  
  public QueryAccount(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    this.g.registObserver(this.f);
  }
  
  private void a(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this.h, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.h.phoneNum);
    localIntent.putExtra("invite_code", this.h.inviteCode);
    localIntent.putExtra("key", this.h.countryCode);
    localIntent.putExtra("key_register_is_phone_num_registered", this.h.mIsPhoneNumRegistered);
    localIntent.putExtra("key_register_has_pwd", this.h.mHasPwd);
    localIntent.putExtra("key_register_binded_qq", this.i);
    localIntent.putExtra("key_register_left_time", paramInt);
    localIntent.putExtra("key_register_exit_time", paramLong);
    localIntent.putExtra("register_verify_code_start_time", System.currentTimeMillis());
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("key_register_from", 7);
    Object localObject = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h.countryCode);
    localStringBuilder.append(this.h.phoneNum);
    localIntent.putExtra("key_register_from_friend_verify", (Serializable)((HashMap)localObject).get(localStringBuilder.toString()));
    boolean bool;
    if ((!this.o) && (!this.n)) {
      bool = false;
    } else {
      bool = true;
    }
    localIntent.putExtra("key_register_from_face_verify", bool);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("go2next countryCode=");
      ((StringBuilder)localObject).append(this.h.countryCode);
      ((StringBuilder)localObject).append(", phoneNum=");
      ((StringBuilder)localObject).append(PhoneCodeUtils.a(this.h.phoneNum));
      ((StringBuilder)localObject).append(", leftTime=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", exitTime=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("QueryAccount", 2, ((StringBuilder)localObject).toString());
    }
    b(localIntent);
    this.h.startActivityForResult(localIntent, 2);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return TextUtils.isEmpty(paramString2);
    }
    return paramString1.equals(paramString2);
  }
  
  private Bundle c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("wifi_mac", this.b);
    localBundle.putString("os_language", this.c);
    localBundle.putInt("qq_language", this.d);
    localBundle.putString("gps_location", this.e);
    return localBundle;
  }
  
  private void c(String paramString)
  {
    Intent localIntent = new Intent(this.h, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.h.phoneNum);
    localIntent.putExtra("invite_code", this.h.inviteCode);
    localIntent.putExtra("key", this.h.countryCode);
    localIntent.putExtra("key_register_prompt_info", paramString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.h.mIsPhoneNumRegistered);
    localIntent.putExtra("key_register_has_pwd", this.h.mHasPwd);
    localIntent.putExtra("key_register_binded_qq", this.i);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("key_register_from", 7);
    b(localIntent);
    this.h.startActivity(localIntent);
  }
  
  private void d()
  {
    Intent localIntent = this.j;
    if ((localIntent != null) && (localIntent.getBooleanExtra("key_register_from_fail_pay_lh", false)))
    {
      if (this.k == null) {
        this.k = new RegisterWithNick(this.h);
      }
      this.k.a(this.h.getIntent());
      return;
    }
    this.h.closeDialog();
    RegisterPersonalInfoActivity.a(this.g, this.h, this.h.phoneNum, this.h.countryCode, "", this.h.mIsPhoneNumRegistered, false, null, 7);
    this.h.finish();
  }
  
  private void d(String paramString)
  {
    try
    {
      this.h.handler.post(new QueryAccount.1(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    if (this.m == null)
    {
      this.m = new QueryAccount.4(this);
      IntentFilter localIntentFilter = new IntentFilter("action_qq_register_face_recognize_assist");
      this.h.registerReceiver(this.m, localIntentFilter);
    }
  }
  
  private void e(String paramString)
  {
    QLog.i("QueryAccount", 1, "gotoFaceRecognize");
    this.n = false;
    this.o = false;
    e();
    paramString = String.format("https://graph.qq.com/safe/face/identification?authType=regist&regsig=%s&uin=1854000000", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    LoginUtils.a(this.h, localIntent, "/base/browser", 2020);
    RegisterManager.b().a(5);
    RegisterManager.b().a(null);
  }
  
  public void a()
  {
    this.h.closeDialog();
    this.g.unRegistObserver(this.f);
    RegisterWithNick localRegisterWithNick = this.k;
    if (localRegisterWithNick != null) {
      localRegisterWithNick.a();
    }
    if (this.m != null) {
      this.h.unregisterReceiver(this.m);
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
      if (this.a.containsKey(localObject)) {
        this.a.remove(localObject);
      }
      paramInt1 = paramIntent.getIntExtra("key_register_left_time", 0);
      long l1 = paramIntent.getLongExtra("key_register_exit_time", 0L);
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
        localStringBuilder.append(l1);
        localStringBuilder.append(", inviteCode=");
        if (str1 == null) {
          paramIntent = "";
        } else {
          paramIntent = str1;
        }
        localStringBuilder.append(paramIntent);
        QLog.d("QueryAccount", 2, localStringBuilder.toString());
      }
      if ((paramInt1 > 0) && (l1 > 0L))
      {
        paramIntent = new QueryAccount.UserRegTimeInfo(this);
        paramIntent.a = paramInt1;
        paramIntent.b = l1;
        paramIntent.c = str1;
        this.a.put(localObject, paramIntent);
      }
    }
    else if (paramInt1 == 2020)
    {
      this.n = true;
      if (this.o)
      {
        paramIntent = RegisterManager.b().c();
        if (paramIntent != null)
        {
          a(null, paramIntent.a());
          return;
        }
        this.h.closeDialog();
        return;
      }
      this.h.closeDialog();
    }
  }
  
  public void a(Context paramContext)
  {
    String str4 = Locale.getDefault().getLanguage();
    String str1 = PropertiesUtils.b(BaseApplication.getContext(), "key_local_cache", "0");
    if ("0".equals(str1))
    {
      QLog.e("QueryAccount", 1, "addLocaleIdCookie, localeIdStr = 0");
      return;
    }
    int i1;
    try
    {
      i1 = Integer.parseInt(str1);
    }
    catch (Exception localException)
    {
      QLog.e("QueryAccount", 1, localException.toString());
      i1 = 0;
    }
    String str2 = "02:00:00:00:00:00";
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      paramContext = str2;
      if (localWifiManager != null)
      {
        paramContext = str2;
        if (NetworkMonitor.getConnectionInfo(localWifiManager) != null) {
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
    this.b = paramContext;
    this.c = str4;
    this.d = i1;
    this.e = str3;
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, new Object[] { "regMacAddr:", this.b, " regOS:", this.c, " regQQLang:", Integer.valueOf(this.d), " regLocation:", this.e });
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.j = paramIntent;
    if (QLog.isDevelopLevel()) {
      QLog.i("QueryAccount", 4, "setExtraInfo");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      localObject = c();
      if (!TextUtils.isEmpty(this.h.mCountryEnglishName))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("country_english_name", this.h.mCountryEnglishName.getBytes());
        ((Bundle)localObject).putSerializable("mapSt", localHashMap);
      }
      ((AccountManager)this.g.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.h.countryCode, this.h.phoneNum, this.h.inviteCode, Long.valueOf(AppSetting.d()), "8.8.17", (Bundle)localObject, null);
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
    Bundle localBundle = c();
    localBundle.putSerializable("mapSt", paramHashMap);
    ((AccountManager)this.g.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.h.countryCode, this.h.phoneNum, this.h.inviteCode, Long.valueOf(AppSetting.d()), "8.8.17", localBundle, null);
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.h.countryCode);
    ((StringBuilder)localObject).append(this.h.phoneNum);
    String str = ((StringBuilder)localObject).toString();
    if (!this.l.containsKey(str)) {
      this.l.put(str, Boolean.valueOf(false));
    }
    if (this.a.containsKey(str))
    {
      localObject = this.a.get(str);
      if ((localObject != null) && ((localObject instanceof QueryAccount.UserRegTimeInfo)))
      {
        QueryAccount.UserRegTimeInfo localUserRegTimeInfo = (QueryAccount.UserRegTimeInfo)localObject;
        if ((localUserRegTimeInfo.a > 0) && (localUserRegTimeInfo.b > 0L) && (a(this.h.inviteCode, localUserRegTimeInfo.c)))
        {
          long l1 = System.currentTimeMillis() - localUserRegTimeInfo.b;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startQueryAccount countryCode=");
            localStringBuilder.append(this.h.countryCode);
            localStringBuilder.append(", phoneNum=");
            localStringBuilder.append(PhoneCodeUtils.a(this.h.phoneNum));
            localStringBuilder.append(", leftTime=");
            localStringBuilder.append(localUserRegTimeInfo.a);
            localStringBuilder.append(", exitTime=");
            localStringBuilder.append(localUserRegTimeInfo.b);
            localStringBuilder.append(", interval=");
            localStringBuilder.append(l1);
            localStringBuilder.append(", inviteCode=");
            if (this.h.inviteCode == null) {
              localObject = "";
            } else {
              localObject = this.h.inviteCode;
            }
            localStringBuilder.append((String)localObject);
            QLog.d("QueryAccount", 2, localStringBuilder.toString());
          }
          if ((l1 > 0L) && (l1 < localUserRegTimeInfo.a * 1000L))
          {
            a(localUserRegTimeInfo.a, localUserRegTimeInfo.b);
            return;
          }
        }
      }
      this.a.remove(str);
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.h.notifyToast(2131889169, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startQueryAccount countryCode=");
        ((StringBuilder)localObject).append(this.h.countryCode);
        ((StringBuilder)localObject).append(" phoneNum=");
        ((StringBuilder)localObject).append(PhoneCodeUtils.a(this.h.phoneNum));
        QLog.d("queryMobile", 2, ((StringBuilder)localObject).toString());
      }
      ((AccountManager)this.g.getManager(0)).sendRegisterQueryMobile(this.h.countryCode, this.h.phoneNum, null);
      this.h.createWaitingDialog(2131914075);
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
      Intent localIntent = this.j;
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
      this.h.runOnUiThread(new QueryAccount.3(this));
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    ((Intent)localObject).putExtra("url", paramString);
    LoginUtils.a(this.h, (Intent)localObject, "/base/browser");
    RegisterManager.b().a(4);
    paramString = this.l;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.h.countryCode);
    ((StringBuilder)localObject).append(this.h.phoneNum);
    paramString.put(((StringBuilder)localObject).toString(), Boolean.valueOf(true));
    ReportController.b(this.g, "dc00898", "", "", "0X8009C5D", "0X8009C5D", 0, 0, "", "", this.h.phoneNum, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount
 * JD-Core Version:    0.7.0.1
 */