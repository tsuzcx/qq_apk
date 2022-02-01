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
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  
  private String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      return "com.tencent.plugin.qappcenter.QZoneAppListActivity";
    case 2: 
      return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
    case 3: 
      return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
    case 4: 
      return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
    case 5: 
      return "com.tencent.plugin.qappcenter.WebAppActivity";
    case 6: 
      return "com.tencent.plugin.qappcenter.AppCenterMainActivity";
    case 7: 
      return "com.tencent.plugin.qappcenter.AppCenterAppDetailActivity";
    case 8: 
      return "com.tencent.plugin.qappcenter.AppCenterSearchActivity";
    }
    return "com.tencent.plugin.qappcenter.AppCenterBrowserActivity";
  }
  
  private void a()
  {
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qappcenter_plugin.apk");
    int j = 0;
    int i;
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState != 4) {
        break label43;
      }
      i = 1;
    }
    while (i == 0)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
      return;
      label43:
      i = j;
      if (localPluginInfo.mState != 1)
      {
        this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qappcenter_plugin.apk", new QZoneAppListActivity.1(this));
        i = j;
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(5, 0L);
  }
  
  private void b()
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "qappcenter_plugin.apk";
    localPluginParams.e = HardCodeUtil.a(2131711577);
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localPluginParams.f = a();
    Intent localIntent1 = getIntent();
    if (localIntent1 != null) {
      if (localIntent1.getIntExtra("process_id", -1) == 2) {
        localPluginParams.jdField_a_of_type_JavaLangClass = QAppCenterPluginProxyActivityQzone.class;
      }
    }
    for (;;)
    {
      LogUtility.b("GHOST", "[launchPlugin] class:" + localPluginParams.jdField_a_of_type_JavaLangClass);
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("userQqResources", 2);
      if ((localIntent1 != null) && (localIntent1.getExtras() != null)) {
        localIntent2.putExtras(localIntent1.getExtras());
      }
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent2;
      IPluginManager.a(this, localPluginParams);
      finish();
      return;
      localPluginParams.jdField_a_of_type_JavaLangClass = QAppCenterPluginProxyActivityTools.class;
      continue;
      localPluginParams.jdField_a_of_type_JavaLangClass = QAppCenterPluginProxyActivityTools.class;
    }
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new QZoneAppListActivity.2(this, paramInt));
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "handlePluginInfo:" + paramPluginBaseInfo.mState);
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
      return;
    case 0: 
      this.jdField_a_of_type_CooperationPluginIPluginManager.d("qappcenter_plugin.apk");
      return;
    case 1: 
    case 2: 
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(2, i, 0).sendToTarget();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
      return;
    }
    a(100);
    b();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167305);
    setContentView(2131559773);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373545));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372185);
    setTitle(2131695321);
    updateAppRuntime();
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    if (DownloadSDKConfigManager.canGotoNewAppListPage()) {}
    for (int i = 6;; i = 1)
    {
      DownloadSDKConfigManager.refreshNewAppCenterConfig();
      this.jdField_a_of_type_Int = getIntent().getIntExtra("goto_type", i);
      LogUtility.b("GHOST", "[doOnCreate] mGotoType:" + this.jdField_a_of_type_Int);
      a();
      return true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = 99;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        a("qappcenter_plugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qappcenter_plugin.apk"));
        continue;
        a(paramMessage.arg1);
        continue;
        try
        {
          i = Integer.valueOf(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).intValue();
          if (i < 99)
          {
            i = j;
            a(i);
          }
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("IphoneTitleBarActivity", 2, "handleMessage Exception:", paramMessage);
            }
            int i = 0;
            continue;
            i += 1;
          }
        }
        b();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.applist.QZoneAppListActivity
 * JD-Core Version:    0.7.0.1
 */