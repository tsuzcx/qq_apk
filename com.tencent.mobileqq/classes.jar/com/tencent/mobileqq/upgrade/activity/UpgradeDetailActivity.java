package com.tencent.mobileqq.upgrade.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeController.OnStateChangedListener;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ProtectedWebView;
import cooperation.qzone.QZoneHelper;
import protocol.KQQConfig.UpgradeInfo;

@SuppressLint({"SetJavaScriptEnabled"})
public class UpgradeDetailActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, UpgradeController.OnStateChangedListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private JsBridge jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  private int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 0;
    int i = j;
    int k;
    if (!bool)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("supportGoMarketPhoneID,jumpMarketSupportPhone,");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",manufacture:");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        QLog.i("UpgradeDetailActivity", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        localObject = getPackageManager();
        bool = paramString.contains("vivo");
        if ((bool) && (Build.MANUFACTURER.equalsIgnoreCase("vivo")))
        {
          k = ((PackageManager)localObject).getPackageInfo("com.bbk.appstore", 0).versionCode;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("supportGoMarketPhoneID versioncode:");
            paramString.append(k);
            QLog.i("UpgradeDetailActivity", 2, paramString.toString());
          }
        }
        else if ((paramString.contains("xiaomi")) && (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")))
        {
          i = j;
          if (((PackageManager)localObject).getPackageInfo("com.xiaomi.market", 0) != null) {
            i = 2;
          }
        }
        else
        {
          if (paramString.contains("oppo"))
          {
            bool = Build.MANUFACTURER.equalsIgnoreCase("oppo");
            if (bool)
            {
              k = 3;
              try
              {
                paramString = ((PackageManager)localObject).getPackageInfo("com.oppo.market", 0);
                i = j;
                if (paramString == null) {
                  break label601;
                }
                i = j;
                if (paramString.applicationInfo == null) {
                  break label601;
                }
                i = j;
                if (!paramString.applicationInfo.enabled) {
                  break label601;
                }
                int m = paramString.versionCode;
                if (QLog.isColorLevel())
                {
                  paramString = new StringBuilder();
                  paramString.append("supportGoMarketPhoneID oppo market versioncode:");
                  paramString.append(m);
                  QLog.i("UpgradeDetailActivity", 2, paramString.toString());
                }
                i = j;
                if (m <= 6300) {
                  break label601;
                }
                i = 3;
              }
              catch (Throwable paramString)
              {
                try
                {
                  localObject = ((PackageManager)localObject).getPackageInfo("com.heytap.market", 0);
                  if (QLog.isColorLevel())
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("oppo.market exception:");
                    localStringBuilder.append(paramString.getMessage());
                    QLog.i("UpgradeDetailActivity", 2, localStringBuilder.toString());
                  }
                  if ((localObject != null) && (((PackageInfo)localObject).applicationInfo != null))
                  {
                    bool = ((PackageInfo)localObject).applicationInfo.enabled;
                    if (bool)
                    {
                      i = k;
                      break label408;
                    }
                  }
                  i = 0;
                }
                catch (Throwable paramString)
                {
                  label408:
                  i = j;
                  if (!QLog.isColorLevel()) {
                    break label601;
                  }
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("heytap.market exception:");
                ((StringBuilder)localObject).append(paramString.getMessage());
                QLog.i("UpgradeDetailActivity", 2, ((StringBuilder)localObject).toString());
                i = j;
              }
            }
          }
          i = j;
          if (paramString.contains("huawei"))
          {
            i = j;
            if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
            {
              k = ((PackageManager)localObject).getPackageInfo("com.huawei.appmarket", 0).versionCode;
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder();
                paramString.append("supportGoMarketPhoneID versioncode:");
                paramString.append(k);
                QLog.i("UpgradeDetailActivity", 2, paramString.toString());
              }
              i = j;
              if (k >= 80003300) {
                i = 4;
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("supportGoMarketPhoneID exception:");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.i("UpgradeDetailActivity", 2, ((StringBuilder)localObject).toString());
          i = j;
        }
      }
    }
    for (;;)
    {
      label601:
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("supportGoMarketPhoneID returnid:");
        paramString.append(i);
        QLog.i("UpgradeDetailActivity", 2, paramString.toString());
      }
      return i;
      i = j;
      if (k >= 3100) {
        i = 1;
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379354);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((ProtectedWebView)findViewById(2131379356));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localWebSettings.getUserAgentString());
    localStringBuilder.append(" ");
    localStringBuilder.append(QZoneHelper.getQUA());
    localWebSettings.setUserAgentString(localStringBuilder.toString());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new UpgradeDetailActivity.TroopSeedWebViewClient(this, null));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(new UpgradeDetailActivity.TroopSeedWebChromeClient(this, null));
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge = new JsBridge();
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a(new UpgradeDetailActivity.JsCover(this), "qqupgrade");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131379357));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            return;
          }
          if (paramInt2 == 1)
          {
            ReportController.b(null, "dc00898", "", "", "0X800AB96", "0X800AB96", 0, 0, "", "", "", "");
            return;
          }
          if (paramInt2 == 2)
          {
            ReportController.b(null, "dc00898", "", "", "0X800AB97", "0X800AB97", 0, 0, "", "", "", "");
            return;
          }
          if (paramInt2 == 3) {
            ReportController.b(null, "dc00898", "", "", "0X800AB98", "0X800AB98", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (paramInt2 == 1)
          {
            ReportController.b(null, "dc00898", "", "", "0X800AB99", "0X800AB99", 0, 0, "", "", "", "");
            return;
          }
          if (paramInt2 == 2)
          {
            ReportController.b(null, "dc00898", "", "", "0X800AB9A", "0X800AB9A", 0, 0, "", "", "", "");
            return;
          }
          if (paramInt2 == 3) {
            ReportController.b(null, "dc00898", "", "", "0X800AB9B", "0X800AB9B", 0, 0, "", "", "", "");
          }
        }
      }
      else
      {
        if (paramInt2 == 1)
        {
          ReportController.b(null, "dc00898", "", "", "0X800AB9F", "0X800AB9F", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt2 == 2)
        {
          ReportController.b(null, "dc00898", "", "", "0X800ABA0", "0X800ABA0", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt2 == 3) {
          ReportController.b(null, "dc00898", "", "", "0X800ABA1", "0X800ABA1", 0, 0, "", "", "", "");
        }
      }
    }
    else
    {
      if (paramInt2 == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800AB9C", "0X800AB9C", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt2 == 2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800AB9D", "0X800AB9D", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt2 == 3) {
        ReportController.b(null, "dc00898", "", "", "0X800AB9E", "0X800AB9E", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(Activity paramActivity, UpgradeDetailWrapper paramUpgradeDetailWrapper, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, UpgradeDetailActivity.class);
    localIntent.putExtra("detail_wrapper", paramUpgradeDetailWrapper);
    localIntent.putExtra("is_anim", paramBoolean1);
    localIntent.putExtra("download_right_now", paramBoolean2);
    localIntent.putExtra("need_left_back", paramBoolean3);
    paramActivity.startActivity(localIntent);
    if (paramBoolean1) {
      paramActivity.overridePendingTransition(2130771993, 2130771994);
    }
  }
  
  private void a(Context paramContext, int paramInt)
  {
    Object localObject1;
    Intent localIntent;
    Object localObject4;
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("hiapplink://com.huawei.appmarket?appId=C9319&accessID=%2F687abcc2447f49059f0c8873390a1686&caller=");
          ((StringBuilder)localObject1).append("com.tencent.mobileqq");
          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject1).toString()));
          ((Intent)localObject1).setPackage("com.huawei.appmarket");
          ((Intent)localObject1).setFlags(335544320);
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_appstore");
          paramContext.startActivity((Intent)localObject1);
          if (!QLog.isColorLevel()) {
            break label615;
          }
          QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate huawei");
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("market://details?id=");
        ((StringBuilder)localObject1).append("com.tencent.mobileqq");
        ((StringBuilder)localObject1).append("&caller=");
        ((StringBuilder)localObject1).append("com.tencent.mobileqq");
        ((StringBuilder)localObject1).append("&token=273b98f0a5b2c20d&atd=true&style=0");
        localIntent = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject1).toString()));
        localObject4 = paramContext.getPackageManager();
        localObject3 = "";
      }
    }
    try
    {
      PackageInfo localPackageInfo = ((PackageManager)localObject4).getPackageInfo("com.oppo.market", 0);
      localObject1 = localObject3;
      if (localPackageInfo != null)
      {
        localObject1 = localObject3;
        if (localPackageInfo.applicationInfo != null)
        {
          bool = localPackageInfo.applicationInfo.enabled;
          localObject1 = localObject3;
          if (bool) {
            localObject1 = "com.oppo.market";
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      boolean bool;
      label258:
      label313:
      label615:
      break label258;
    }
    try
    {
      localObject4 = ((PackageManager)localObject4).getPackageInfo("com.heytap.market", 0);
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject3;
        if (((PackageInfo)localObject4).applicationInfo != null)
        {
          bool = ((PackageInfo)localObject4).applicationInfo.enabled;
          localObject1 = localObject3;
          if (bool) {
            localObject1 = "com.heytap.market";
          }
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      Object localObject2 = localObject3;
      break label313;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localIntent.setPackage((String)localObject1);
      localIntent.setFlags(270532608);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
      paramContext.startActivity(localIntent);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("jumpToPhoneMarketDetailUpdate oppo,oppopkg:");
      paramContext.append((String)localObject1);
      QLog.i("UpgradeDetailActivity", 2, paramContext.toString());
      return;
      localObject1 = new Intent();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mimarket://details?id=");
      ((StringBuilder)localObject3).append("com.tencent.mobileqq");
      ((StringBuilder)localObject3).append("&ref=com.tencent.mobileqq_selfupdate&startDownload=true");
      ((Intent)localObject1).setData(Uri.parse(((StringBuilder)localObject3).toString()));
      ((Intent)localObject1).setPackage("com.xiaomi.market");
      ((Intent)localObject1).setFlags(335544320);
      ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_appstore");
      paramContext.startActivity((Intent)localObject1);
      if (QLog.isColorLevel())
      {
        QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate xiaomi");
        return;
        localObject1 = new Intent();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("vivomarket://details?id=");
        ((StringBuilder)localObject3).append("com.tencent.mobileqq");
        ((StringBuilder)localObject3).append("&th_name=self_update");
        ((Intent)localObject1).setData(Uri.parse(((StringBuilder)localObject3).toString()));
        ((Intent)localObject1).setPackage("com.bbk.appstore");
        ((Intent)localObject1).setFlags(335544320);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_appstore");
        paramContext.startActivity((Intent)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("UpgradeDetailActivity", 2, "jumpToPhoneMarketDetailUpdate vivo");
        }
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack()) {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
      label36:
      this.jdField_a_of_type_ComTencentSmttSdkWebView.goBack();
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  private void b(String paramString)
  {
    if ((!getIntent().getBooleanExtra("need_left_back", true)) && (this.leftView != null)) {
      this.leftView.setVisibility(4);
    }
    setTitle(paramString);
    removeWebViewLayerType();
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade != 1))
    {
      int i = a(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkAndStartdownload market supportMarketID:");
        ((StringBuilder)localObject1).append(i);
        QLog.d("UpgradeDetailActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (i != 0)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(100, 0, 0).sendToTarget();
        }
        localObject2 = DialogUtil.a(this, 230);
        UpgradeDetailActivity.1 local1 = new UpgradeDetailActivity.1(this, i);
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                localObject1 = "";
              } else {
                localObject1 = getString(2131691623);
              }
            }
            else {
              localObject1 = getString(2131691625);
            }
          }
          else {
            localObject1 = getString(2131691628);
          }
        }
        else {
          localObject1 = getString(2131691627);
        }
        String str = getString(2131691624, new Object[] { localObject1 });
        localObject1 = getString(2131691622, new Object[] { localObject1 });
        ((QQCustomDialog)localObject2).setMessage(str);
        ((QQCustomDialog)localObject2).setTitle(2131691626);
        ((QQCustomDialog)localObject2).setNegativeButton(2131691621, local1);
        ((QQCustomDialog)localObject2).setPositiveButton((String)localObject1, getResources().getColor(2131165349), local1);
        ((QQCustomDialog)localObject2).show();
        a(i, 1);
        return;
      }
      UpgradeController.a().b(false);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkAndStartdownload");
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) {
        localObject1 = "null";
      } else {
        localObject1 = "iIncrementUpgrade==1";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("UpgradeDetailActivity", 2, ((StringBuilder)localObject2).toString());
    }
    UpgradeController.a().b(false);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invokeDownloadStateToWebView: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("UpgradeDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:onDownloadStateChanged(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    ((WebView)localObject).loadUrl(localStringBuilder.toString());
  }
  
  public void a(int paramInt, UpgradeController paramUpgradeController)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(100, paramInt, 0).sendToTarget();
    }
  }
  
  void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
      label7:
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadUrl: ");
        localStringBuilder.append(paramString);
        QLog.d("UpgradeDetailActivity", 2, localStringBuilder.toString());
      }
      return;
    }
    catch (Exception localException)
    {
      break label7;
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearView();
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  boolean a(String paramString)
  {
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish start");
    }
    super.finish();
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
      if (localObject != null)
      {
        ((MqqWeakReferenceHandler)localObject).removeMessages(100);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(101);
      }
      localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView;
      if (localObject == null) {}
    }
    try
    {
      ((WebView)localObject).loadUrl("javascript:onDestroy()");
    }
    catch (Exception localException)
    {
      label75:
      break label75;
    }
    if (this.jdField_b_of_type_Boolean) {
      overridePendingTransition(2130771991, 2130771992);
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "UpgradeDetailActivity.finish stop");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      a(paramMessage.arg1);
    } else if (paramMessage.what == 101) {
      b(false);
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (a()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = UpgradeController.a().a();
    if ((paramBundle != null) && (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (paramBundle.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType > 0))
    {
      super.setContentView(2131562999);
      removeWebViewLayerType();
      Intent localIntent = getIntent();
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = ((UpgradeDetailWrapper)localIntent.getParcelableExtra("detail_wrapper"));
      this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("is_anim", true);
      UpgradeController.a().a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null)
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_b_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Long;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4)) {
        this.jdField_a_of_type_Long = Math.min(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.patchsize);
      }
      String str = HardCodeUtil.a(2131715690);
      paramBundle = null;
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewUpgradeDescURL;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fontSetting=");
        ((StringBuilder)localObject).append(FontSettingManager.getFontLevel());
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder;
        if (paramBundle.endsWith("?"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramBundle);
          localStringBuilder.append((String)localObject);
          paramBundle = localStringBuilder.toString();
        }
        else if (paramBundle.contains("?"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramBundle);
          localStringBuilder.append("&");
          localStringBuilder.append((String)localObject);
          paramBundle = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramBundle);
          localStringBuilder.append("?");
          localStringBuilder.append((String)localObject);
          paramBundle = localStringBuilder.toString();
        }
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
      if (localIntent.getBooleanExtra("download_right_now", false)) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageAtTime(101, 1500L);
      }
      b(str);
      a();
      if (paramBundle != null) {
        a(paramBundle);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    finish();
  }
  
  public void onDestroy()
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
      if (localObject != null)
      {
        ((MqqWeakReferenceHandler)localObject).removeMessages(100);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(101);
      }
      localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView;
      if (localObject == null) {}
    }
    try
    {
      ((WebView)localObject).loadUrl("javascript:onDestroy()");
      label52:
      UpgradeController.a().b(this);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a("qqupgrade");
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearView();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (a())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    MyAppApi.a().a(this);
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        a(UpgradeController.a().a());
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity
 * JD-Core Version:    0.7.0.1
 */