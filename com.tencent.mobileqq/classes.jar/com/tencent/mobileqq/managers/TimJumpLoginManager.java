package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;

public class TimJumpLoginManager
  implements Handler.Callback, Manager
{
  public static String a = "TimJumpLoginManager";
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public JSONArray a;
  public boolean a;
  public int b;
  public JSONArray b;
  public int c = 5;
  public int d = 24;
  private int e = 0;
  
  public TimJumpLoginManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 60;
    this.jdField_a_of_type_OrgJsonJSONArray = null;
    this.jdField_b_of_type_OrgJsonJSONArray = null;
    this.jdField_b_of_type_Int = 72;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "switchKey false");
      }
      return false;
    }
    Object localObject2;
    if (this.e > this.c)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showCount = ");
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append(", showTipTotalCount = ");
        ((StringBuilder)localObject2).append(this.c);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.d * 60 * 60 * 1000)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lastShowTime = ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject2).append(", showTipHourInterval = ");
        ((StringBuilder)localObject2).append(this.d);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    Object localObject1 = Calendar.getInstance();
    int j = ((Calendar)localObject1).get(7);
    if (this.jdField_a_of_type_OrgJsonJSONArray != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
      {
        if (j - 1 == this.jdField_a_of_type_OrgJsonJSONArray.optInt(i))
        {
          i = 1;
          break label261;
        }
        i += 1;
      }
    }
    int i = 0;
    label261:
    if (i == 0) {
      return false;
    }
    i = ((Calendar)localObject1).get(11);
    localObject1 = this.jdField_b_of_type_OrgJsonJSONArray;
    if ((localObject1 != null) && (((JSONArray)localObject1).length() == 2))
    {
      j = this.jdField_b_of_type_OrgJsonJSONArray.optInt(0);
      int k = this.jdField_b_of_type_OrgJsonJSONArray.optInt(1);
      if (i >= j)
      {
        if (i >= k) {
          return false;
        }
        if (!com.tencent.util.pm.PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim"))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "tim not installed");
          }
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject1).append("/tencent/msflogs/com/tencent/tim");
        localObject1 = new File(((StringBuilder)localObject1).toString());
        if ((((File)localObject1).exists()) && (System.currentTimeMillis() - ((File)localObject1).lastModified() < this.jdField_b_of_type_Int * 60 * 60 * 1000))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("timLogFile.lastModified() = ");
            localStringBuilder.append(((File)localObject1).lastModified());
            localStringBuilder.append(", androidLimit = ");
            localStringBuilder.append(this.jdField_b_of_type_Int);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          return false;
        }
        if ((BaseActivity.sTopActivity instanceof SplashActivity))
        {
          localObject1 = (SplashActivity)BaseActivity.sTopActivity;
          if (SplashActivity.currentFragment == 1)
          {
            i = 1;
            break label537;
          }
        }
        i = 0;
        label537:
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "is not in main tab");
          }
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showTimLoginDialog");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tim_login_shared_pre_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    try
    {
      localObject2 = ((SharedPreferences)localObject1).getString("tim_login_sd", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray((String)localObject2);
      }
      localObject2 = ((SharedPreferences)localObject1).getString("tim_login_st", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray((String)localObject2);
      }
    }
    catch (Exception localException2)
    {
      label131:
      int i;
      String str1;
      String str4;
      String str5;
      break label131;
    }
    this.jdField_b_of_type_Int = ((SharedPreferences)localObject1).getInt("tim_login_l", 72);
    this.c = ((SharedPreferences)localObject1).getInt("tim_login_tc", 5);
    this.d = ((SharedPreferences)localObject1).getInt("tim_login_sti", 24);
    this.jdField_a_of_type_Long = ((SharedPreferences)localObject1).getLong("tim_login_lct", 0L);
    this.e = ((SharedPreferences)localObject1).getInt("tim_login_sc", 0);
    if (!a()) {
      return;
    }
    localObject2 = ((SharedPreferences)localObject1).edit();
    i = this.e + 1;
    this.e = i;
    ((SharedPreferences.Editor)localObject2).putInt("tim_login_sc", i);
    ((SharedPreferences.Editor)localObject2).putLong("tim_login_lct", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = HardCodeUtil.a(2131714786);
    str3 = "登录TIM";
    str1 = HardCodeUtil.a(2131714785);
    str4 = ((SharedPreferences)localObject1).getString("tim_login_t", "QQ办公简洁版");
    str5 = ((SharedPreferences)localObject1).getString("tim_login_c", (String)localObject2);
    localObject2 = str1;
    try
    {
      localObject1 = ((SharedPreferences)localObject1).getString("tim_login_btns", "");
      str2 = str3;
      localObject3 = str1;
      localObject2 = str1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = str1;
        JSONArray localJSONArray = new JSONArray((String)localObject1);
        str2 = str3;
        localObject3 = str1;
        localObject2 = str1;
        if (localJSONArray.length() == 2)
        {
          localObject1 = str1;
          localObject2 = str1;
          if (!TextUtils.isEmpty(localJSONArray.optString(0)))
          {
            localObject2 = str1;
            localObject1 = localJSONArray.optString(0);
          }
          str2 = str3;
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(localJSONArray.optString(1)))
          {
            localObject2 = localObject1;
            str2 = localJSONArray.optString(1);
            localObject3 = localObject1;
          }
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str2 = str3;
        Object localObject3 = localException2;
      }
    }
    DialogUtil.a(BaseActivity.sTopActivity, 230, str4, str5, (String)localObject3, str2, new TimJumpLoginManager.1(this), new TimJumpLoginManager.2(this)).show();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80085D9", "0X80085D9", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10011)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10011);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_login_shared_pre_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("tim_login_s", false);
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("tim_login_tal", 60);
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchKey = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(", showTipTimeIntervalAfterLogined = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Int;
      if (i >= 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10011, i * 1000);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (!com.tencent.mobileqq.utils.PackageUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131719629, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "jumpTimLogin tim not install ");
      }
      return;
    }
    Object localObject1 = com.tencent.mobileqq.utils.PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim");
    int i = TencentDocConvertConfigProcessor.a().b();
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpTimLogin tim timVersion=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("tim limit version = ");
      localStringBuilder.append(i);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    try
    {
      int j = Integer.parseInt(((String)localObject1).replace(".", ""));
      if (j == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131719629, 0).a();
        return;
      }
      if (j < i)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131719630, 0).a();
        return;
      }
    }
    catch (Exception localException)
    {
      label202:
      break label202;
    }
    localObject1 = new QQProgressDialog(BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimensionPixelOffset(2131299168));
    ((QQProgressDialog)localObject1).a(HardCodeUtil.a(2131714784));
    ((QQProgressDialog)localObject1).show();
    Object localObject2 = new WtloginHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    ((WtloginHelper)localObject2).SetTimeOut(20);
    ((WtloginHelper)localObject2).SetMsfTransportFlag(1);
    ((WtloginHelper)localObject2).SetListener(new TimJumpLoginManager.3(this, (QQProgressDialog)localObject1, (WtloginHelper)localObject2, paramBundle));
    paramBundle = util.getPkgSigFromApkName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim");
    i = ((WtloginHelper)localObject2).GetA1WithA1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 16L, 16L, "com.tencent.tim".getBytes(), 1L, 16L, 16L, "8.7.0".getBytes(), paramBundle, new WUserSigInfo(), new WFastLoginInfo());
    if (i != -1001)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("jumpTimLogin GetA1WithA1, retCode = ");
        ((StringBuilder)localObject2).append(i);
        QLog.d(paramBundle, 2, ((StringBuilder)localObject2).toString());
      }
      if (((QQProgressDialog)localObject1).isShowing()) {
        ((QQProgressDialog)localObject1).dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131719628, 0).a();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10011) {
      b();
    }
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TimJumpLoginManager
 * JD-Core Version:    0.7.0.1
 */