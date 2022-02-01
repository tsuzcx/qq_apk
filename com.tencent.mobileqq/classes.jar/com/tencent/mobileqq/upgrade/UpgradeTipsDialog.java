package com.tencent.mobileqq.upgrade;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.util.OrientationUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneHelper;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeTipsDialog
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private JsBridge jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  private UpgradeTipsDialog.OnPreparedListener jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog$OnPreparedListener;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean = false;
  
  public UpgradeTipsDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, UpgradeDetailWrapper paramUpgradeDetailWrapper, UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    super(paramActivity, 2131755842);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = paramUpgradeDetailWrapper;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b(paramOnPreparedListener);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)paramView.findViewById(2131380970));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setFadingEdgeLength(0);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalScrollBarEnabled(false);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibility");
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibilityTraversal");
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new UpgradeTipsDialog.1(this));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + QZoneHelper.getQUA());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge = new JsBridge();
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a(new UpgradeTipsDialog.JsCover(this), "qqupgrade");
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131380966));
    boolean bool = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131380967));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131380968));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (UpgradeController.a().a() == 4) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693442);
    }
  }
  
  private void b(UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog$OnPreparedListener = paramOnPreparedListener;
    paramOnPreparedListener = getLayoutInflater().inflate(2131561731, null);
    a(paramOnPreparedListener);
    paramOnPreparedListener.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramOnPreparedListener);
    paramOnPreparedListener = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramOnPreparedListener.getAttributes();
    paramOnPreparedListener.setGravity(17);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    localLayoutParams.width = AIOUtils.a(260.0F, getContext().getResources());
    if (i <= j) {}
    for (localLayoutParams.height = AIOUtils.a(368.0F, getContext().getResources());; localLayoutParams.height = AIOUtils.a(300.0F, getContext().getResources()))
    {
      paramOnPreparedListener.setAttributes(localLayoutParams);
      setCancelable(false);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL));
      return;
    }
  }
  
  public void a(UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog$OnPreparedListener = paramOnPreparedListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void dismiss()
  {
    OrientationUtil.b(this.jdField_a_of_type_AndroidAppActivity);
    super.dismiss();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        dismiss();
        boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
        ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
        if (bool) {
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
        }
        if (this.jdField_b_of_type_Boolean) {
          ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(bool);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str2 = UpgradeConstants.b();
        String str3 = UpgradeController.a();
        if (bool) {}
        for (String str1 = "1";; str1 = "0")
        {
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, str2, String.valueOf(1), str3, str1);
          if (UpgradeController.a().a() != 4) {
            break label188;
          }
          BannerManager.a().b(17, 3000);
          break;
        }
        label188:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_hold", 0, 0, "", "", "", "");
        if (bool)
        {
          UpgradeController.a().a();
          continue;
        }
        UpgradeController.a().b();
      }
      catch (Exception localException1)
      {
        try
        {
          dismiss();
          label250:
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, UpgradeConstants.b(), String.valueOf(1), UpgradeController.a(), "");
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
          if (UpgradeController.a().a() == 4)
          {
            UpgradeController.a().a(getContext());
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_now", 0, 0, "", "", "", "");
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
          UpgradeDetailActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper, true, true, true);
          continue;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          break label250;
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a("qqupgrade");
    this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    OrientationUtil.a(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTipsDialog
 * JD-Core Version:    0.7.0.1
 */