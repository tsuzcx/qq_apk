package com.tencent.securemodule.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.securemodule.ai;
import com.tencent.securemodule.ak;
import com.tencent.securemodule.al;
import com.tencent.securemodule.am;
import com.tencent.securemodule.an;
import com.tencent.securemodule.ao;
import com.tencent.securemodule.ap;
import com.tencent.securemodule.aq;
import com.tencent.securemodule.as;
import com.tencent.securemodule.e;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.service.IControlService;
import com.tencent.securemodule.u;

public class TransparentActivity
  extends Activity
{
  private final int a = 1;
  private final int b = 2;
  private final int c = 3;
  private final int d = 4;
  private final int e = 1;
  private final int f = 0;
  private final int g = 5;
  private Context h;
  private e i;
  private AppInfo j;
  private ProgressDialog k = null;
  private Handler l = new ai(this);
  private IControlService m;
  private ServiceConnection n = new ak(this);
  
  private void a()
  {
    this.i = ((e)getIntent().getSerializableExtra("data"));
    if (this.i != null)
    {
      c();
      return;
    }
    finish();
  }
  
  private void a(boolean paramBoolean)
  {
    String str = "发现“" + this.j.getSoftName() + "应用”被病毒感染，";
    StringBuilder localStringBuilder = new StringBuilder().append(str);
    if (paramBoolean) {}
    for (str = "建议立即启动腾讯手机管家查杀";; str = "建议立即安装最新版腾讯手机管家查杀")
    {
      str = str;
      new AlertDialog.Builder(this).setTitle("QQ安全登录扫描").setMessage(str).setPositiveButton("确定", new aq(this, paramBoolean)).setNegativeButton("取消", new ap(this)).setOnCancelListener(new ao(this)).show();
      return;
    }
  }
  
  private void b()
  {
    this.j = ((AppInfo)getIntent().getSerializableExtra("data"));
    if (this.j != null)
    {
      AppInfo localAppInfo = as.a(this.h, "com.tencent.qqpimsecure");
      if ((localAppInfo != null) && ("00B1208638DE0FCD3E920886D658DAF6".equals(localAppInfo.getCertMd5())) && (localAppInfo.getVersionCode() >= 77))
      {
        a(true);
        return;
      }
      a(false);
      return;
    }
    finish();
  }
  
  private void c()
  {
    u localu = this.i.b();
    if (localu != null)
    {
      Object localObject = localu.a();
      String str = localu.b();
      localObject = new AlertDialog.Builder(this).setTitle((CharSequence)localObject).setMessage(str).setPositiveButton("确定", new am(this)).setOnCancelListener(new al(this));
      if (localu.d() != 1) {
        ((AlertDialog.Builder)localObject).setNegativeButton("取消", new an(this));
      }
      ((AlertDialog.Builder)localObject).show();
      return;
    }
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getResources().getDrawable(17170445);
    getWindow().setBackgroundDrawable(paramBundle);
    this.h = this;
    paramBundle = new Intent();
    paramBundle.setClass(this.h, SecureService.class);
    bindService(paramBundle, this.n, 1);
    paramBundle = getIntent().getAction();
    if ("1000040".equals(paramBundle))
    {
      a();
      return;
    }
    if ("1000041".equals(paramBundle))
    {
      b();
      return;
    }
    finish();
  }
  
  public void onDestroy()
  {
    if (this.n != null) {
      unbindService(this.n);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.ui.TransparentActivity
 * JD-Core Version:    0.7.0.1
 */