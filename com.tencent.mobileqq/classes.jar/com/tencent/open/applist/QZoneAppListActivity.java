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
  
  private void a()
  {
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qappcenter_plugin.apk");
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
          this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qappcenter_plugin.apk", new QZoneAppListActivity.1(this));
        }
        i = 0;
      }
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
        return;
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(5, 0L);
    }
  }
  
  private void b()
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "qappcenter_plugin.apk";
    localPluginParams.e = HardCodeUtil.a(2131711552);
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localPluginParams.f = a();
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      if (localIntent.getIntExtra("process_id", -1) == 2) {
        localPluginParams.jdField_a_of_type_JavaLangClass = QAppCenterPluginProxyActivityQzone.class;
      } else {
        localPluginParams.jdField_a_of_type_JavaLangClass = QAppCenterPluginProxyActivityTools.class;
      }
    }
    else {
      localPluginParams.jdField_a_of_type_JavaLangClass = QAppCenterPluginProxyActivityTools.class;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[launchPlugin] class:");
    ((StringBuilder)localObject).append(localPluginParams.jdField_a_of_type_JavaLangClass);
    LogUtility.b("GHOST", ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).putExtra("userQqResources", 2);
    if ((localIntent != null) && (localIntent.getExtras() != null)) {
      ((Intent)localObject).putExtras(localIntent.getExtras());
    }
    localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
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
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
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
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
              return;
            }
            a(100);
            b();
            return;
          }
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(3);
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
          return;
        }
        i = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(2, i, 0).sendToTarget();
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 400L);
        return;
      }
      this.jdField_a_of_type_CooperationPluginIPluginManager.d("qappcenter_plugin.apk");
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
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
    getWindow().setBackgroundDrawableResource(2131167333);
    setContentView(2131559650);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373123));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371767);
    setTitle(2131695331);
    updateAppRuntime();
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    int i;
    if (DownloadSDKConfigManager.canGotoNewAppListPage()) {
      i = 6;
    } else {
      i = 1;
    }
    DownloadSDKConfigManager.refreshNewAppCenterConfig();
    this.jdField_a_of_type_Int = getIntent().getIntExtra("goto_type", i);
    paramBundle = new StringBuilder();
    paramBundle.append("[doOnCreate] mGotoType:");
    paramBundle.append(this.jdField_a_of_type_Int);
    LogUtility.b("GHOST", paramBundle.toString());
    a();
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
            b();
            return true;
          }
        }
        else
        {
          int j = 0;
          try
          {
            i = Integer.valueOf(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).intValue();
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
      a("qappcenter_plugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qappcenter_plugin.apk"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.applist.QZoneAppListActivity
 * JD-Core Version:    0.7.0.1
 */