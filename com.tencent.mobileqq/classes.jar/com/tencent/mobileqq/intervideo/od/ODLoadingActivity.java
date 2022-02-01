package com.tencent.mobileqq.intervideo.od;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

public class ODLoadingActivity
  extends Activity
{
  private QQProgressDialog a;
  private FrameLayout b;
  private boolean c;
  private View d;
  private IVPluginDataReporter e = new IVPluginDataReporter();
  private Handler f;
  private boolean g;
  private final ODLoadingActivity.ODEnterCallback h = new ODLoadingActivity.ODEnterCallback(this);
  
  private void c()
  {
    if (this.a == null)
    {
      this.a = new QQProgressDialog(this, 40);
      this.a.a(HardCodeUtil.a(2131905642));
    }
    this.a.show();
  }
  
  private void d()
  {
    this.g = true;
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  void a()
  {
    d();
    finish();
    this.e.opType("onCloseLoadingView").report();
    Monitor.b("33669909");
  }
  
  void a(View paramView)
  {
    this.d = paramView;
    runOnUiThread(new ODLoadingActivity.4(this));
    this.e.opType("onShowLoadingView").report();
    Monitor.b("33669908");
  }
  
  void b()
  {
    this.e.opType("onEnterComplete").report();
    Monitor.b("33669911");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    IVCommonInterfaceImpl.getInstance().onHostActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    finish();
    if (!this.c)
    {
      this.e.opType("onBackPressed").report();
      Monitor.b("33669910");
      IVCommonInterfaceImpl.getInstance().onHostActivityBackPress();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (getIntent().getBooleanExtra("show_status_bar", false)) {
      setTheme(16973840);
    }
    super.onCreate(paramBundle);
    paramBundle = new Bundle(getIntent().getExtras());
    String str = paramBundle.getString("fromId");
    long l1 = 0L;
    if (str != null) {}
    try
    {
      long l2 = Long.parseLong(str);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ExecutorService localExecutorService;
      break label78;
    }
    QLog.e("ODLoadingActivity", 2, "not have fromId");
    break label86;
    label78:
    QLog.e("ODLoadingActivity", 2, "fromId not long");
    label86:
    str = paramBundle.getString("bizType");
    paramBundle.putString("qqVersion", "8.8.17");
    paramBundle.putBoolean("isGooglePlayVersion", false);
    this.e.opDepartment("shadow").opName(str).d1(String.valueOf(l1));
    this.e.opType("enterLoading").report();
    Monitor.b("33669907");
    this.b = new FrameLayout(this);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setContentView(this.b);
    findViewById(16908290).setVisibility(8);
    this.f = new Handler(Looper.getMainLooper());
    this.f.postDelayed(new ODLoadingActivity.1(this), 1000L);
    localExecutorService = ThreadManagerExecutor.getExecutorService(192);
    localExecutorService.submit(new ODLoadingActivity.3(this, localExecutorService.submit(new ODLoadingActivity.2(this, str)), l1, paramBundle));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.d != null) {}
    try
    {
      Field localField = View.class.getDeclaredField("mParent");
      localField.setAccessible(true);
      localField.set(this.d, null);
      label34:
      d();
      IVCommonInterfaceImpl.getInstance().onHostActivityDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    IVCommonInterfaceImpl.getInstance().onHostActivityNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    IVCommonInterfaceImpl.getInstance().onHostActivityPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    IVCommonInterfaceImpl.getInstance().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    IVCommonInterfaceImpl.getInstance().onHostActivityResume();
  }
  
  protected void onStop()
  {
    super.onStop();
    IVCommonInterfaceImpl.getInstance().onHostActivityStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity
 * JD-Core Version:    0.7.0.1
 */