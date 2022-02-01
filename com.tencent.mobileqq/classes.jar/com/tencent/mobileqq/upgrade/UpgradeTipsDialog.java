package com.tencent.mobileqq.upgrade;

import agej;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Message;
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
import anvl;
import awfu;
import bdll;
import bhdt;
import bhdu;
import bhec;
import bhed;
import bhhx;
import bmtd;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeTipsDialog
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private awfu jdField_a_of_type_Awfu;
  private bhed jdField_a_of_type_Bhed;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  public WebView a;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  
  public UpgradeTipsDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, UpgradeDetailWrapper paramUpgradeDetailWrapper, bhed parambhed)
  {
    super(paramActivity, 2131755824);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = paramUpgradeDetailWrapper;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b(parambhed);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)paramView.findViewById(2131380465));
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
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new bhec(this));
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + bmtd.a());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    this.jdField_a_of_type_Awfu = new awfu();
    this.jdField_a_of_type_Awfu.a(new UpgradeTipsDialog.JsCover(this), "qqupgrade");
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131380461));
    boolean bool = anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131380462));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131380463));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (bhdu.a().a() == 4) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693065);
    }
  }
  
  private void b(bhed parambhed)
  {
    requestWindowFeature(1);
    this.jdField_a_of_type_Bhed = parambhed;
    parambhed = getLayoutInflater().inflate(2131561666, null);
    a(parambhed);
    parambhed.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(parambhed);
    parambhed = getWindow();
    WindowManager.LayoutParams localLayoutParams = parambhed.getAttributes();
    parambhed.setGravity(17);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    localLayoutParams.width = agej.a(260.0F, getContext().getResources());
    if (i <= j) {}
    for (localLayoutParams.height = agej.a(368.0F, getContext().getResources());; localLayoutParams.height = agej.a(300.0F, getContext().getResources()))
    {
      parambhed.setAttributes(localLayoutParams);
      setCancelable(false);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(bhdu.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL));
      return;
    }
  }
  
  public void a(bhed parambhed)
  {
    this.jdField_a_of_type_Bhed = parambhed;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void dismiss()
  {
    bhhx.b(this.jdField_a_of_type_AndroidAppActivity);
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
        anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
        if (bool) {
          anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
        }
        if (this.jdField_b_of_type_Boolean) {
          ((anvl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(bool);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str1 = bhdt.b();
        String str2 = bhdu.a();
        if (bool) {}
        for (Object localObject = "1";; localObject = "0")
        {
          bdll.b(localQQAppInterface, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, str1, String.valueOf(1), str2, (String)localObject);
          if (bhdu.a().a() != 4) {
            break label200;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (localObject == null) {
            break;
          }
          ((MqqHandler)localObject).obtainMessage(1134018).sendToTarget();
          break;
        }
        label200:
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_hold", 0, 0, "", "", "", "");
        if (bool)
        {
          bhdu.a().a();
          continue;
        }
        bhdu.a().b();
      }
      catch (Exception localException1)
      {
        try
        {
          dismiss();
          label262:
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, bhdt.b(), String.valueOf(1), bhdu.a(), "");
          anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
          if (bhdu.a().a() == 4)
          {
            bhdu.a().a(getContext());
            continue;
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Clk_upd_now", 0, 0, "", "", "", "");
          anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.strNewTipsDescURL, -1);
          UpgradeDetailActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper, true, true, true);
          continue;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          break label262;
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Awfu.a("qqupgrade");
    this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    bhhx.a(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTipsDialog
 * JD-Core Version:    0.7.0.1
 */