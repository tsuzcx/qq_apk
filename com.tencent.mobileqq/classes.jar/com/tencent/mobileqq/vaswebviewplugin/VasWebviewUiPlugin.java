package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import anzj;
import asjw;
import awgi;
import bhsq;
import bioy;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class VasWebviewUiPlugin
  extends VasBasePlugin
{
  private static final String TAG = "VasWebviewUiPlugin";
  protected QQBrowserActivity activity;
  protected boolean isHomePageWatingBind;
  
  public VasWebviewUiPlugin()
  {
    this.mPluginNameSpace = String.valueOf(getPluginBusiness());
  }
  
  protected void OnActivityCreate() {}
  
  void OnActivityDestroy()
  {
    if (awgi.jdField_a_of_type_Boolean) {
      awgi.a(false, null, false);
    }
    if (awgi.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
      awgi.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
  }
  
  protected void OnActivityPause()
  {
    if (awgi.jdField_a_of_type_Boolean) {
      awgi.a(false, null, true);
    }
  }
  
  void OnActivityResume()
  {
    if (awgi.jdField_a_of_type_Boolean) {
      awgi.a(true, this.mRuntime.a(), true);
    }
  }
  
  protected String decodeUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewUiPlugin", 2, "decodeUrl:" + paramString);
    }
    String str1 = paramString.replace("[uin]", this.activity.getAppRuntime().getAccount()).replace("[client]", "androidQQ").replace("[version]", "8.4.5.4745").replace("[sid]", "").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
    Intent localIntent = this.activity.getIntent();
    String str2 = localIntent.getStringExtra("updateTime");
    paramString = str1;
    if (str2 != null)
    {
      paramString = str1;
      if (str2.length() > 0) {
        paramString = str1.replace("[updateTime]", str2);
      }
    }
    String str3 = localIntent.getStringExtra("adTag");
    str1 = paramString;
    if (str2 != null)
    {
      str1 = paramString;
      if (str2.length() > 0) {
        str1 = paramString.replace("[adTag]", str3);
      }
    }
    return str1.replace("[updateFlag]", Boolean.valueOf(localIntent.getBooleanExtra("updateFlag", false)).toString()).replace("[updateId]", "" + localIntent.getIntExtra("updateId", 0)).replace("[density]", ThemeUtil.getThemeDensity(this.activity));
  }
  
  void doAfterFinish() {}
  
  void doBeforeFinish() {}
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.activity == null) || ((this.business & getPluginBusiness()) == 0L)) {
      return false;
    }
    String str = "Web_uiplugin_step_" + paramLong;
    bhsq.a(null, str);
    if (paramLong == 1L) {}
    for (;;)
    {
      boolean bool;
      try
      {
        OnActivityCreate();
        bool = excuteEvent(paramString, paramLong, paramMap);
        return bool;
        if (paramLong == 8589934596L)
        {
          OnActivityDestroy();
          continue;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
        if (paramLong == 2L)
        {
          OnActivityResume();
          continue;
        }
      }
      finally
      {
        bhsq.a(str, null);
      }
      if (paramLong == 8589934597L)
      {
        OnActivityPause();
      }
      else if (paramLong != 8589934595L)
      {
        if (paramLong == 8589934600L)
        {
          bool = onActivityResult(((Integer)paramMap.get("requestCode")).intValue(), ((Integer)paramMap.get("resultCode")).intValue(), (Intent)paramMap.get("data"));
          bhsq.a(str, null);
          return bool;
        }
        if (paramLong == 8589934598L) {
          doBeforeFinish();
        } else if (paramLong == 8589934599L) {
          doAfterFinish();
        }
      }
    }
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() instanceof QQBrowserActivity)) {
      this.activity = ((QQBrowserActivity)this.mRuntime.a());
    }
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.business != 0L) && ((getPluginBusiness() & this.business) == 0L)) {}
    do
    {
      return;
      if (asjw.a().a()) {
        break;
      }
    } while (!paramBoolean2);
    Toast.makeText(BaseApplication.getContext(), anzj.a(2131714832), 0).show();
    return;
    if (paramBoolean1)
    {
      asjw.a().b(paramBundle);
      return;
    }
    asjw.a().a(paramBundle);
  }
  
  protected void webviewLoadUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewUiPlugin", 2, "now try open url: " + paramString);
    }
    if (this.mRuntime.a() != null)
    {
      this.mRuntime.a().loadUrl(paramString);
      return;
    }
    ThreadManager.getUIHandler().post(new VasWebviewUiPlugin.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
 * JD-Core Version:    0.7.0.1
 */