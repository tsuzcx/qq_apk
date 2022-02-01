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
import com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor;
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
  WebView a;
  private CheckBox b;
  private Button c;
  private Button d;
  private QQAppInterface e;
  private Activity f;
  private UpgradeDetailWrapper g;
  private UpgradeTipsDialog.OnPreparedListener h;
  private boolean i;
  private boolean j = false;
  private JsBridge k;
  
  public UpgradeTipsDialog(Activity paramActivity, QQAppInterface paramQQAppInterface, UpgradeDetailWrapper paramUpgradeDetailWrapper, UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    super(paramActivity, 2131953338);
    this.g = paramUpgradeDetailWrapper;
    this.f = paramActivity;
    this.e = paramQQAppInterface;
    b(paramOnPreparedListener);
  }
  
  private void a(View paramView)
  {
    this.a = ((WebView)paramView.findViewById(2131449153));
    this.a.setVerticalFadingEdgeEnabled(false);
    this.a.setFadingEdgeLength(0);
    this.a.setHorizontalFadingEdgeEnabled(false);
    this.a.setHorizontalScrollBarEnabled(false);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.a.removeJavascriptInterface("searchBoxJavaBridge_");
      this.a.removeJavascriptInterface("accessibility");
      this.a.removeJavascriptInterface("accessibilityTraversal");
    }
    this.a.setWebViewClient(new UpgradeTipsDialog.1(this));
    WebSettings localWebSettings = this.a.getSettings();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localWebSettings.getUserAgentString());
    localStringBuilder.append(" ");
    localStringBuilder.append(QZoneHelper.getQUA());
    localWebSettings.setUserAgentString(localStringBuilder.toString());
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(2);
    this.k = new JsBridge();
    this.k.a(new UpgradeTipsDialog.JsCover(this), "qqupgrade");
    this.b = ((CheckBox)paramView.findViewById(2131449149));
    boolean bool = ConfigHandler.a(this.e, true);
    this.b.setChecked(bool);
    this.b.setOnCheckedChangeListener(this);
    this.d = ((Button)paramView.findViewById(2131449150));
    this.d.setOnClickListener(this);
    this.c = ((Button)paramView.findViewById(2131449151));
    this.c.setOnClickListener(this);
    if (UpgradeController.a().b() == 4) {
      this.c.setText(2131890946);
    }
  }
  
  private void b(UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    requestWindowFeature(1);
    this.h = paramOnPreparedListener;
    paramOnPreparedListener = getLayoutInflater().inflate(2131627935, null);
    a(paramOnPreparedListener);
    paramOnPreparedListener.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramOnPreparedListener);
    paramOnPreparedListener = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramOnPreparedListener.getAttributes();
    paramOnPreparedListener.setGravity(17);
    int m = getContext().getResources().getDisplayMetrics().widthPixels;
    int n = getContext().getResources().getDisplayMetrics().heightPixels;
    localLayoutParams.width = AIOUtils.b(260.0F, getContext().getResources());
    if (m <= n) {
      localLayoutParams.height = AIOUtils.b(368.0F, getContext().getResources());
    } else {
      localLayoutParams.height = AIOUtils.b(300.0F, getContext().getResources());
    }
    paramOnPreparedListener.setAttributes(localLayoutParams);
    setCancelable(false);
    this.a.loadUrl(UpgradeController.c(this.g.b.strNewTipsDescURL));
  }
  
  public void a(UpgradeTipsDialog.OnPreparedListener paramOnPreparedListener)
  {
    this.h = paramOnPreparedListener;
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public void dismiss()
  {
    OrientationUtil.b(this.f);
    super.dismiss();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.j ^= true;
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    }
    try
    {
      dismiss();
      ReportController.b(this.e, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, UpgradeConstants.b(), String.valueOf(1), UpgradeController.k(), "");
      ConfigHandler.b(this.e, this.b.isChecked());
      if (UpgradeController.a().b() == 4)
      {
        UpgradeController.a().a(getContext());
      }
      else
      {
        ReportController.b(this.e, "CliOper", "", "", "Update_tips", "Clk_upd_now", 0, 0, "", "", "", "");
        ConfigHandler.a(this.e, this.g.b.strNewTipsDescURL, -1);
        UpgradeDetailActivity.a(this.f, this.g, true, true, true);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        dismiss();
        label184:
        boolean bool = this.b.isChecked();
        ConfigHandler.b(this.e, bool);
        if (bool) {
          ConfigHandler.a(this.e, this.g.b.strNewTipsDescURL, -1);
        }
        if (this.j) {
          ((ConfigHandler)this.e.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a(bool);
        }
        QQAppInterface localQQAppInterface = this.e;
        String str2 = UpgradeConstants.b();
        String str3 = UpgradeController.k();
        String str1;
        if (bool) {
          str1 = "1";
        } else {
          str1 = "0";
        }
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, str2, String.valueOf(1), str3, str1);
        if (UpgradeController.a().b() == 4)
        {
          BannerManager.a().b(InstallUpgradeBannerProcessor.a, 3000);
        }
        else
        {
          ReportController.b(this.e, "CliOper", "", "", "Update_tips", "Clk_upd_hold", 0, 0, "", "", "", "");
          if (bool) {
            UpgradeController.a().e();
          } else {
            UpgradeController.a().f();
          }
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label184;
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.k.a("qqupgrade");
    this.a.destroy();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    super.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    OrientationUtil.a(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTipsDialog
 * JD-Core Version:    0.7.0.1
 */