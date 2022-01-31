package com.tencent.mobileqq.intervideo.now;

import adkw;
import adkx;
import adky;
import adkz;
import adla;
import adlb;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.XPlugin;

public class NowLoadingActivity
  extends Activity
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, IVPluginEvtListener
{
  static boolean c;
  AlertDialog jdField_a_of_type_AndroidAppAlertDialog = null;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public View a;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public TextView a;
  public RoundProgressBar a;
  IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  boolean jdField_a_of_type_Boolean;
  public TextView b;
  boolean b;
  public TextView c;
  public boolean d = false;
  boolean e = false;
  boolean f = false;
  
  public NowLoadingActivity()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowLoadingActivity", 2, "NowLoadingActivity  run ");
    }
    NowProxy localNowProxy = (NowProxy)((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getManager(181);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo != null)
    {
      localNowProxy.a.a(this);
      NowPerfUtil.e();
      if (!localNowProxy.a.a(this.f))
      {
        QLog.e("XProxy|NowLoadingActivity", 1, "NowLoadingActivity ,NowPlugin mPlugininfo为空，直接finish ");
        localNowProxy.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a("enter_exception", "1", "", "", "");
        finish();
      }
      return;
    }
    QLog.e("XProxy|NowLoadingActivity", 1, "NowLoadingActivity  intent获取到的mPlugininfo为空，直接finish ");
    localNowProxy.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowDataReporter.a("enter_exception", "2", "", "", "");
    finish();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    paramString = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (;;)
    {
      paramString.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  private void b()
  {
    if (jdField_c_of_type_Boolean) {
      a();
    }
    do
    {
      return;
      this.f = ((NowProxy)((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getManager(181)).a.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin();
      if (!NetworkUtil.g(this))
      {
        a("Live", -10002, "网络连接错误，请稍候再试!");
        return;
      }
      if (NetworkUtil.a(this)) {
        break label178;
      }
      if ((NetworkUtil.a(this) == 1) || (this.f)) {
        break;
      }
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("提示");
      localBuilder.setMessage("观看直播需先加载直播组件，当前处于非Wi-Fi网络环境下，将消耗少许流量，是否继续？");
      this.jdField_b_of_type_Boolean = false;
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
    a();
    return;
    label178:
    a();
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setProgress(100);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    new Handler().postDelayed(new adlb(this), 3000L);
  }
  
  public void a(String paramString, int paramInt)
  {
    runOnUiThread(new adla(this, paramInt));
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setProgress(0);
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.invalidate();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("直播插件加载失败");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d = true;
    QLog.i("XProxy|NowLoadingActivity", 1, "NowLoadingActivity 收到onError,code = " + paramInt + "desc = " + paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramString2.equals("action.now.showloading"))
    {
      QLog.i("XProxy|NowLoadingActivity", 1, "Now插件已显示，NowLoadingActivity 销毁");
      new Handler().postDelayed(new adky(this), 0L);
    }
    while (!paramString2.equals("action.now.removeoutloading")) {
      return;
    }
    QLog.i("XProxy|NowLoadingActivity", 1, "收到广播action.now.removeoutloading");
    new Handler().postDelayed(new adkz(this), 0L);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setProgress(99);
  }
  
  public void c(String paramString)
  {
    if (!isFinishing())
    {
      QLog.i("XProxy|NowLoadingActivity", 1, "onPluginDestroy，NowLoadingActivity 销毁");
      finish();
    }
  }
  
  public void d(String paramString) {}
  
  public void onBackPressed()
  {
    NowProxy localNowProxy = (NowProxy)((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getManager(181);
    if (!this.e)
    {
      localNowProxy.a.a("nowloadingback");
      this.e = true;
    }
    finish();
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
        this.jdField_b_of_type_Boolean = false;
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
      this.jdField_b_of_type_Boolean = true;
      jdField_c_of_type_Boolean = true;
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
    QLog.i("XProxy|NowLoadingActivity", 1, "NowLoadingActivity  onCreate ");
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130970743);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370090);
    this.jdField_a_of_type_ComTencentBizUiRoundProgressBar = ((RoundProgressBar)findViewById(2131371752));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131371753));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramBundle = getIntent().getExtras();
    paramBundle.setClassLoader(getClass().getClassLoader());
    this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = ((IVPluginInfo)paramBundle.getParcelable("plugininfo"));
    paramBundle = (ImageView)findViewById(2131371504);
    try
    {
      paramBundle.setImageDrawable(getResources().getDrawable(2130839540));
      findViewById(2131371504).setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371754));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370098));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371286));
      paramBundle = (NowProxy)((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getManager(181);
      if (paramBundle.a.a() == 3) {
        a("Live", 95);
      }
      findViewById(2131371504).setOnClickListener(new adkw(this, paramBundle));
      new Handler().postDelayed(new adkx(this, paramBundle), 10L);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        QLog.e("XProxy|NowLoadingActivity", 1, "NowLoadingActivity  bkg drawable error.");
      }
    }
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowLoadingActivity", 2, "NowLoadingActivity  destroy ");
    }
    super.onDestroy();
    ((NowProxy)((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getManager(181)).b(this);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      a();
      return;
    }
    ((NowProxy)((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getManager(181)).a.a("now_nowificancel");
    super.finish();
  }
  
  protected void onResume()
  {
    QLog.i("XProxy|NowLoadingActivity", 1, "NowLoadingActivity  onResume ");
    super.onResume();
  }
  
  protected void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowLoadingActivity", 2, "NowLoadingActivity  onStart ");
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowLoadingActivity", 2, "NowLoadingActivity  onStop ");
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowLoadingActivity
 * JD-Core Version:    0.7.0.1
 */