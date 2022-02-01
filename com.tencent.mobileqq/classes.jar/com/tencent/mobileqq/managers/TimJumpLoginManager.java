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
  public boolean b = false;
  public int c = 60;
  public JSONArray d = null;
  public JSONArray e = null;
  public int f = 72;
  public int g = 5;
  public int h = 24;
  private QQAppInterface i;
  private Handler j = null;
  private long k = -1L;
  private int l = 0;
  
  public TimJumpLoginManager(QQAppInterface paramQQAppInterface)
  {
    this.i = paramQQAppInterface;
    this.j = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void b()
  {
    if (!this.i.isLogin()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "showTimLoginDialog");
    }
    Object localObject1 = this.i.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tim_login_shared_pre_");
    ((StringBuilder)localObject2).append(this.i.getCurrentUin());
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    try
    {
      localObject2 = ((SharedPreferences)localObject1).getString("tim_login_sd", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.d = new JSONArray((String)localObject2);
      }
      localObject2 = ((SharedPreferences)localObject1).getString("tim_login_st", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.e = new JSONArray((String)localObject2);
      }
    }
    catch (Exception localException2)
    {
      label131:
      int m;
      String str1;
      String str4;
      String str5;
      break label131;
    }
    this.f = ((SharedPreferences)localObject1).getInt("tim_login_l", 72);
    this.g = ((SharedPreferences)localObject1).getInt("tim_login_tc", 5);
    this.h = ((SharedPreferences)localObject1).getInt("tim_login_sti", 24);
    this.k = ((SharedPreferences)localObject1).getLong("tim_login_lct", 0L);
    this.l = ((SharedPreferences)localObject1).getInt("tim_login_sc", 0);
    if (!c()) {
      return;
    }
    localObject2 = ((SharedPreferences)localObject1).edit();
    m = this.l + 1;
    this.l = m;
    ((SharedPreferences.Editor)localObject2).putInt("tim_login_sc", m);
    ((SharedPreferences.Editor)localObject2).putLong("tim_login_lct", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = HardCodeUtil.a(2131912289);
    str3 = "登录TIM";
    str1 = HardCodeUtil.a(2131898212);
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
    ReportController.b(this.i, "dc00898", "", "", "0X80085D9", "0X80085D9", 0, 0, "", "", "", "");
  }
  
  private boolean c()
  {
    if (!this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "switchKey false");
      }
      return false;
    }
    Object localObject2;
    if (this.l > this.g)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showCount = ");
        ((StringBuilder)localObject2).append(this.l);
        ((StringBuilder)localObject2).append(", showTipTotalCount = ");
        ((StringBuilder)localObject2).append(this.g);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    if (System.currentTimeMillis() - this.k < this.h * 60 * 60 * 1000)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lastShowTime = ");
        ((StringBuilder)localObject2).append(this.k);
        ((StringBuilder)localObject2).append(", showTipHourInterval = ");
        ((StringBuilder)localObject2).append(this.h);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    Object localObject1 = Calendar.getInstance();
    int n = ((Calendar)localObject1).get(7);
    if (this.d != null)
    {
      m = 0;
      while (m < this.d.length())
      {
        if (n - 1 == this.d.optInt(m))
        {
          m = 1;
          break label262;
        }
        m += 1;
      }
    }
    int m = 0;
    label262:
    if (m == 0) {
      return false;
    }
    m = ((Calendar)localObject1).get(11);
    localObject1 = this.e;
    if ((localObject1 != null) && (((JSONArray)localObject1).length() == 2))
    {
      n = this.e.optInt(0);
      int i1 = this.e.optInt(1);
      if (m >= n)
      {
        if (m >= i1) {
          return false;
        }
        if (!com.tencent.util.pm.PackageUtil.d(this.i.getApp(), "com.tencent.tim"))
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "tim not installed");
          }
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject1).append("/tencent/msflogs/com/tencent/tim");
        localObject1 = new File(((StringBuilder)localObject1).toString());
        if ((((File)localObject1).exists()) && (System.currentTimeMillis() - ((File)localObject1).lastModified() < this.f * 60 * 60 * 1000))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("timLogFile.lastModified() = ");
            localStringBuilder.append(((File)localObject1).lastModified());
            localStringBuilder.append(", androidLimit = ");
            localStringBuilder.append(this.f);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          return false;
        }
        if ((BaseActivity.sTopActivity instanceof SplashActivity))
        {
          localObject1 = (SplashActivity)BaseActivity.sTopActivity;
          if (SplashActivity.currentFragment == 1)
          {
            m = 1;
            break label543;
          }
        }
        m = 0;
        label543:
        if (m == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "is not in main tab");
          }
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    if (this.j.hasMessages(10011)) {
      this.j.removeMessages(10011);
    }
    Object localObject = this.i.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_login_shared_pre_");
    localStringBuilder.append(this.i.getCurrentUin());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    this.b = ((SharedPreferences)localObject).getBoolean("tim_login_s", false);
    this.c = ((SharedPreferences)localObject).getInt("tim_login_tal", 60);
    if (QLog.isColorLevel())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchKey = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", showTipTimeIntervalAfterLogined = ");
      localStringBuilder.append(this.c);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.b)
    {
      int m = this.c;
      if (m >= 0) {
        this.j.sendEmptyMessageDelayed(10011, m * 1000);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (!com.tencent.mobileqq.utils.PackageUtil.b(this.i.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
    {
      QQToast.makeText(this.i.getApp(), 1, 2131917226, 0).show();
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "jumpTimLogin tim not install ");
      }
      return;
    }
    Object localObject1 = com.tencent.mobileqq.utils.PackageUtil.b(this.i.getApp(), "com.tencent.tim");
    int m = TencentDocConvertConfigProcessor.a().h();
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpTimLogin tim timVersion=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("tim limit version = ");
      localStringBuilder.append(m);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    try
    {
      int n = Integer.parseInt(((String)localObject1).replace(".", ""));
      if (n == 0)
      {
        QQToast.makeText(this.i.getApp(), 1, 2131917226, 0).show();
        return;
      }
      if (n < m)
      {
        QQToast.makeText(this.i.getApp(), 1, 2131917227, 0).show();
        return;
      }
    }
    catch (Exception localException)
    {
      label204:
      break label204;
    }
    localObject1 = new QQProgressDialog(BaseActivity.sTopActivity, this.i.getApplication().getResources().getDimensionPixelOffset(2131299920));
    ((QQProgressDialog)localObject1).a(HardCodeUtil.a(2131912288));
    ((QQProgressDialog)localObject1).show();
    Object localObject2 = new WtloginHelper(this.i.getApplication().getApplicationContext());
    ((WtloginHelper)localObject2).SetTimeOut(20);
    ((WtloginHelper)localObject2).SetMsfTransportFlag(1);
    ((WtloginHelper)localObject2).SetListener(new TimJumpLoginManager.3(this, (QQProgressDialog)localObject1, (WtloginHelper)localObject2, paramBundle));
    paramBundle = util.getPkgSigFromApkName(this.i.getApp(), "com.tencent.tim");
    m = ((WtloginHelper)localObject2).GetA1WithA1(this.i.getAccount(), 16L, 16L, "com.tencent.tim".getBytes(), 1L, 16L, 16L, "8.8.17".getBytes(), paramBundle, new WUserSigInfo(), new WFastLoginInfo());
    if (m != -1001)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("jumpTimLogin GetA1WithA1, retCode = ");
        ((StringBuilder)localObject2).append(m);
        QLog.d(paramBundle, 2, ((StringBuilder)localObject2).toString());
      }
      if (((QQProgressDialog)localObject1).isShowing()) {
        ((QQProgressDialog)localObject1).dismiss();
      }
      QQToast.makeText(this.i.getApp(), 1, 2131917225, 0).show();
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