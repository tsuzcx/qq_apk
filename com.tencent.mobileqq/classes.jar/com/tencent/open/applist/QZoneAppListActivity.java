package com.tencent.open.applist;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import com.tencent.util.WeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import cooperation.qappcenter.QAppCenterPluginProxyActivityQzone;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;

public class QZoneAppListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private int a = 0;
  private IPluginManager b;
  private WeakReferenceHandler c;
  private TextView d;
  private View e;
  
  private String a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 9: 
      return "com.tencent.plugin.qappcenter.AppCenterBrowserActivity";
    case 8: 
      return "com.tencent.plugin.qappcenter.AppCenterSearchActivity";
    case 7: 
      return "com.tencent.plugin.qappcenter.AppCenterAppDetailActivity";
    case 6: 
      return "com.tencent.plugin.qappcenter.AppCenterMainActivity";
    case 5: 
      return "com.tencent.plugin.qappcenter.WebAppActivity";
    case 2: 
    case 3: 
    case 4: 
      return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
    }
    return "com.tencent.plugin.qappcenter.QZoneAppListActivity";
  }
  
  private void b()
  {
    PluginInfo localPluginInfo = this.b.d("qappcenter_plugin.apk");
    if (localPluginInfo != null)
    {
      int i;
      if (localPluginInfo.mState == 4)
      {
        i = 1;
      }
      else
      {
        if (localPluginInfo.mState != 1) {
          this.b.installPlugin("qappcenter_plugin.apk", new QZoneAppListActivity.1(this));
        }
        i = 0;
      }
      if (i == 0)
      {
        this.c.sendEmptyMessageDelayed(1, 400L);
        return;
      }
      this.c.sendEmptyMessageDelayed(5, 0L);
    }
  }
  
  private void c()
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.d = "qappcenter_plugin.apk";
    localPluginParams.g = HardCodeUtil.a(2131909199);
    localPluginParams.c = this.app.getCurrentAccountUin();
    localPluginParams.h = a();
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      if (localIntent.getIntExtra("process_id", -1) == 2) {
        localPluginParams.i = QAppCenterPluginProxyActivityQzone.class;
      } else {
        localPluginParams.i = QAppCenterPluginProxyActivityTools.class;
      }
    }
    else {
      localPluginParams.i = QAppCenterPluginProxyActivityTools.class;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[launchPlugin] class:");
    ((StringBuilder)localObject).append(localPluginParams.i);
    LogUtility.b("GHOST", ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).putExtra("userQqResources", 2);
    if ((localIntent != null) && (localIntent.getExtras() != null)) {
      ((Intent)localObject).putExtras(localIntent.getExtras());
    }
    localPluginParams.j = ((Intent)localObject);
    IPluginManager.a(this, localPluginParams);
    finish();
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new QZoneAppListActivity.2(this, paramInt));
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.b.isReady()) {
        this.c.sendEmptyMessageDelayed(1, 400L);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("handlePluginInfo:");
      paramString.append(paramPluginBaseInfo.mState);
      QLog.d("IphoneTitleBarActivity", 2, paramString.toString());
    }
    int i = paramPluginBaseInfo.mState;
    if (i != -2)
    {
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              this.c.sendEmptyMessageDelayed(1, 400L);
              return;
            }
            a(100);
            c();
            return;
          }
          this.c.sendEmptyMessage(3);
          this.c.sendEmptyMessageDelayed(1, 400L);
          return;
        }
        i = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
        this.c.obtainMessage(2, i, 0).sendToTarget();
        this.c.sendEmptyMessageDelayed(1, 400L);
        return;
      }
      this.b.e("qappcenter_plugin.apk");
      return;
    }
    this.c.sendEmptyMessage(4);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131168376);
    setContentView(2131625679);
    this.d = ((TextView)findViewById(2131440726));
    this.d.setText("0%");
    this.e = findViewById(2131439201);
    setTitle(2131893070);
    updateAppRuntime();
    this.b = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    this.c = new WeakReferenceHandler(this);
    int i;
    if (DownloadSDKConfigManager.canGotoNewAppListPage()) {
      i = 6;
    } else {
      i = 1;
    }
    DownloadSDKConfigManager.refreshNewAppCenterConfig();
    this.a = getIntent().getIntExtra("goto_type", i);
    paramBundle = new StringBuilder();
    paramBundle.append("[doOnCreate] mGotoType:");
    paramBundle.append(this.a);
    LogUtility.b("GHOST", paramBundle.toString());
    b();
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return true;
            }
            c();
            return true;
          }
        }
        else
        {
          int j = 0;
          try
          {
            i = Integer.valueOf(this.d.getText().toString()).intValue();
          }
          catch (Exception paramMessage)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.w("IphoneTitleBarActivity", 2, "handleMessage Exception:", paramMessage);
              i = j;
            }
          }
          j = 99;
          if (i < 99) {
            i = j;
          } else {
            i += 1;
          }
          a(i);
          return true;
        }
      }
      else
      {
        a(paramMessage.arg1);
        return true;
      }
    }
    else if (!isFinishing()) {
      a("qappcenter_plugin.apk", this.b.d("qappcenter_plugin.apk"));
    }
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.applist.QZoneAppListActivity
 * JD-Core Version:    0.7.0.1
 */