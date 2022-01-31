package com.tencent.mobileqq.intervideo.od;

import adll;
import adlm;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Map;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;

public class ODLoadingActivity
  extends Activity
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, IVPluginEvtListener, LoadingUI.Event
{
  long jdField_a_of_type_Long;
  AlertDialog jdField_a_of_type_AndroidAppAlertDialog = null;
  protected BroadcastReceiver a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public IVPluginInfo a;
  public LoadingUI a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c;
  boolean d;
  
  public ODLoadingActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI = new LoadingUI();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adlm(this);
  }
  
  private void b()
  {
    Object localObject = new IntentFilter(HuayangJsPlugin.a("com.tencent.huayang"));
    ((IntentFilter)localObject).addAction(HuayangJsPlugin.b("com.tencent.huayang"));
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    localObject = IVPluginInfo.a();
    IVPluginInfo localIVPluginInfo = (IVPluginInfo)((Map)localObject).get("com.tencent.huayang");
    localIVPluginInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Long;
    localIVPluginInfo.e = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.e;
    HuayangDowanloadHelper.a(this, "com.tencent.huayang", "hy_sixgod").a("hy_sixgod", this.jdField_a_of_type_JavaLangString, "huayang://openpage/mainpage?tab=od", "download", (Map)localObject);
  }
  
  private void c()
  {
    if (!NetworkUtil.g(this)) {
      a("Live", -10002, "网络连接错误，请稍候再试!");
    }
    do
    {
      return;
      if (NetworkUtil.a(this)) {
        break;
      }
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("提示");
      localBuilder.setMessage("当前处于移动网络环境下,是否继续？");
      this.jdField_a_of_type_Boolean = false;
      localBuilder.setPositiveButton("取消", this);
      localBuilder.setNegativeButton("继续", this);
      this.jdField_a_of_type_AndroidAppAlertDialog = localBuilder.create();
      this.jdField_a_of_type_AndroidAppAlertDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppAlertDialog.setOnDismissListener(this);
    } while (isFinishing());
    try
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.show();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    b();
  }
  
  public void a()
  {
    this.b = false;
    b();
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(String paramString)
  {
    this.b = true;
    finish();
    if (this.c) {
      Monitor.a("2694149");
    }
    for (;;)
    {
      StoryReportor.a("huayang", "ODLoad", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), 0, new String[] { "", "", "", "7.6.0" });
      return;
      Monitor.a("2694146");
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("首次进入需要初始化资源...", false);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a(paramInt);
    if (paramInt == 100) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("正在努力加载...", true);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("加载失败，请重试!");
    if (this.c)
    {
      Monitor.a("2694150");
      return;
    }
    Monitor.a("2694147");
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void b(String paramString) {}
  
  public void c(String paramString) {}
  
  public void d(String paramString) {}
  
  public void onBackPressed()
  {
    finish();
    if (this.d)
    {
      Monitor.a("2694154");
      return;
    }
    if (this.c)
    {
      Monitor.a("2694156");
      return;
    }
    Monitor.a("2694155");
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = false;
        ((ODProxy)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime((BaseActivity)null)).getManager(107)).a("od_nowificancel");
      } while (isFinishing());
      try
      {
        this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
        return;
      }
      catch (IllegalArgumentException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (isFinishing());
    try
    {
      this.jdField_a_of_type_AndroidAppAlertDialog.dismiss();
      return;
    }
    catch (IllegalArgumentException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    paramBundle.setClassLoader(getClass().getClassLoader());
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = ((IVPluginInfo)paramBundle.getParcelable("plugininfo"));
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.c = TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.g, "launcher");
    if ((!this.c) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.g)))
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.g;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a(this, paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a(this);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBundle = getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4);
      boolean bool = paramBundle.getBoolean("huayang_plugin_start_flag" + this.jdField_a_of_type_JavaLangString + "com.tencent.od", false);
      this.d = (paramBundle.getBoolean("huayang_plugin_new_start_mode" + this.jdField_a_of_type_JavaLangString, false) & bool);
      if (!this.d) {
        break label257;
      }
      Monitor.a("2694151");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new adll(this), 50L);
      return;
      paramBundle = getString(2131430827);
      break;
      label257:
      if (this.c) {
        Monitor.a("2694148");
      } else {
        Monitor.a("2694145");
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b();
      return;
    }
    super.finish();
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.b) {
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity
 * JD-Core Version:    0.7.0.1
 */