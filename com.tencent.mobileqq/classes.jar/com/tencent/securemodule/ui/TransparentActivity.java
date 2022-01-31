package com.tencent.securemodule.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.service.IControlService;
import sm.ai;
import sm.ak;
import sm.al;
import sm.am;
import sm.an;
import sm.ao;
import sm.ap;
import sm.aq;
import sm.ar;
import sm.as;
import sm.az;
import sm.e;
import sm.u;

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
  
  public class a
    extends Thread
    implements Runnable
  {
    private int b;
    
    public a(int paramInt)
    {
      this.b = paramInt;
    }
    
    private void a()
    {
      for (;;)
      {
        try
        {
          int i = this.b;
          if (i < 5) {
            try
            {
              Thread.sleep(2000L);
              Message localMessage1 = TransparentActivity.c(TransparentActivity.this).obtainMessage(4);
              localMessage1.arg1 = (this.b + 1);
              TransparentActivity.c(TransparentActivity.this).sendMessage(localMessage1);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              continue;
            }
          }
          localMessage2 = TransparentActivity.c(TransparentActivity.this).obtainMessage(2);
        }
        finally {}
        Message localMessage2;
        localMessage2.arg1 = 0;
        TransparentActivity.c(TransparentActivity.this).sendMessage(localMessage2);
      }
    }
    
    public void run()
    {
      j = 0;
      i = j;
      try
      {
        if (TransparentActivity.d(TransparentActivity.this) != null)
        {
          Object localObject = new UniAttribute();
          ((UniAttribute)localObject).setEncodeName("UTF-8");
          ((UniAttribute)localObject).put("data", TransparentActivity.e(TransparentActivity.this));
          localObject = ((UniAttribute)localObject).encode();
          if (localObject != null) {
            TransparentActivity.d(TransparentActivity.this).doRemoteTask(az.a((byte[])localObject), new ar(this));
          }
          i = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          i = j;
        }
      }
      if (i == 0) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.securemodule.ui.TransparentActivity
 * JD-Core Version:    0.7.0.1
 */