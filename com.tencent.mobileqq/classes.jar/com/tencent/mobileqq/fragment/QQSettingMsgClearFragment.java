package com.tencent.mobileqq.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.DeepCleanConfigProcessor;
import com.tencent.mobileqq.config.DeepCleanConfigReporter;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.VersionUtils;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;

public class QQSettingMsgClearFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static final String b = HardCodeUtil.a(2131892262);
  private static long n;
  QQProgressDialog a;
  Handler c = new QQSettingMsgClearFragment.8(this);
  private DownloadListener d;
  private QQAppInterface e;
  private BounceScrollView f;
  private FormSimpleItem g;
  private View h;
  private View i;
  private TextView j;
  private boolean k;
  private boolean l = false;
  private long m = 0L;
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq installSucceed appid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", packageName = ");
      localStringBuilder.append(paramString2);
      QLog.e("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
    if ((TextUtils.equals(paramString1, "5848")) && (TextUtils.equals(paramString2, "com.tencent.android.qqdownloader")))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("这是统一的DownloadListener，installSucceed, appId:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",packName:");
        localStringBuilder.append(paramString2);
        QLog.e("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
      }
      DownloadManagerV2.a().b(this.d);
      this.d = null;
    }
  }
  
  private void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString1 = DialogUtil.a(getBaseActivity(), 230).setTitle(null).setMessage(paramString1);
    paramString1.setMessageTextSize(17.0F);
    paramString1.setPositiveButton(paramString2, paramOnClickListener1);
    paramString1.setNegativeButton(getString(2131887648), new QQSettingMsgClearFragment.7(this, paramOnClickListener2, paramString1));
    try
    {
      paramString1.show();
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingMsgClearFragment", 2, "setTroopAdmins:", paramString1);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null)
    {
      if ((paramBoolean) && (!localQQProgressDialog.isShowing()))
      {
        this.a.show();
        return;
      }
      if ((!paramBoolean) && (this.a.isShowing())) {
        this.a.dismiss();
      }
    }
  }
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - n <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingMsgClearFragment", 2, "click too fast");
      }
      n = l1;
      return true;
    }
    n = l1;
    return false;
  }
  
  private void b()
  {
    this.f = ((BounceScrollView)this.mContentView.findViewById(2131445362));
    this.h = this.mContentView.findViewById(2131442476);
    this.h.setOnClickListener(this);
    this.mContentView.findViewById(2131431685).setOnClickListener(this);
    this.mContentView.findViewById(2131449218).setOnClickListener(this);
    this.g = ((FormSimpleItem)this.mContentView.findViewById(2131431682));
    this.g.setOnClickListener(this);
    this.g.setContentDescription(getString(2131888421));
    this.g.setLeftTextColor(4);
    this.i = this.mContentView.findViewById(2131431699);
    this.i.setOnClickListener(this);
    this.j = ((TextView)this.mContentView.findViewById(2131431700));
    g();
    if (VersionUtils.c()) {
      this.f.setOverScrollMode(0);
    }
    if (this.a == null)
    {
      this.a = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      this.a.a(getString(2131887798));
      this.a.setCanceledOnTouchOutside(true);
      this.a.c(true);
      this.a.a(false);
      this.a.b(true);
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" onDownloadFinish info = ");
      localStringBuilder.append(paramDownloadInfo);
      QLog.d("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
  }
  
  private void c()
  {
    try
    {
      if (getBaseActivity() == null) {
        return;
      }
      ClipboardManager localClipboardManager = (ClipboardManager)getBaseActivity().getApplicationContext().getSystemService("clipboard");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tmast://spaceclean?via=ANDROIDQQ.NEWYYB.AZQQAPK&targetTabType=1&clipboard_start_time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      localObject = ClipData.newPlainText("Label", ((StringBuilder)localObject).toString());
      ClipboardMonitor.setPrimaryClip(localClipboardManager, (ClipData)localObject);
      localClipboardManager.setPrimaryClip((ClipData)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    e();
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.b, "5848");
    localBundle.putString(DownloadConstants.l, b);
    localBundle.putString(DownloadConstants.f, "com.tencent.android.qqdownloader");
    localBundle.putString(DownloadConstants.j, "https://a.app.qq.com/o/myapp-down?g_f=1118400");
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putBoolean(DownloadConstants.h, true);
    DownloadProxy.a().a(getBaseActivity(), localBundle, "biz_src_qq_setting_msg_clean", null, 0);
  }
  
  private void e()
  {
    if (this.d == null)
    {
      this.d = new QQSettingMsgClearFragment.6(this);
      DownloadManagerV2.a().a(this.d);
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://spaceclean?via=ANDROIDQQ.YYB.AZQQAPK&targetTabType=1"));
    localIntent.setFlags(268435456);
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void g()
  {
    if (this.i != null)
    {
      if (DeepCleanConfigProcessor.a())
      {
        this.i.setVisibility(0);
        this.k = PackageUtil.d(BaseApplication.getContext(), "com.tencent.android.qqdownloader");
        this.j.setText(DeepCleanConfigProcessor.a(BaseApplication.getContext(), this.k));
        return;
      }
      this.i.setVisibility(8);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.e = ((QQAppInterface)getBaseActivity().getAppRuntime());
      if (this.e != null) {
        b();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627816;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431685)
    {
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileClear(getActivity(), 1);
      FileManagerReporter.a("0x80087C4");
      ReportController.b(null, "dc00898", "", "", "0X800A0C2", "0X800A0C2", 0, 0, "", "", "", "");
      QQSettingMsgHistoryActivity.a();
    }
    else
    {
      Object localObject1;
      if (paramView.getId() == 2131449218)
      {
        localObject1 = new Intent(getBaseActivity(), QQSettingMsgHistoryActivity.class);
        ((Intent)localObject1).putExtra("set_display_type", 1);
        getBaseActivity().startActivity((Intent)localObject1);
        ReportController.b(null, "CliOper", "", "", "0X800A2D1", "0X800A2D1", 0, 0, "", "", "", "");
      }
      else
      {
        Object localObject2;
        if (paramView.getId() == 2131442476)
        {
          if (!a())
          {
            localObject1 = new Intent();
            localObject2 = AIOImageProviderService.a(this.e.getCurrentUin(), "", 0, null, false);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject2).asBinder()));
            localBundle.putInt("jump", 1);
            ((Intent)localObject1).putExtras(localBundle);
            ((Intent)localObject1).setFlags(805306368);
            ReportController.b(null, "dc00898", "", "", "0X800A0C1", "0X800A0C1", 0, 0, "", "", "", "");
            PublicFragmentActivity.Launcher.a(this, (Intent)localObject1, PublicFragmentActivityForPeak.class, SessionClearFragment.class, 1);
            QQSettingMsgHistoryActivity.a();
          }
        }
        else if (paramView.getId() == 2131431682)
        {
          long l1 = System.currentTimeMillis();
          long l2 = this.m;
          if ((!getBaseActivity().isFinishing()) && (l1 - l2 >= 500L))
          {
            this.m = l1;
            localObject1 = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
            localObject2 = new QQSettingMsgClearFragment.1(this, (ActionSheet)localObject1);
            ((ActionSheet)localObject1).addButton(2131888420, 3);
            ((ActionSheet)localObject1).addCancelButton(getString(2131887648));
            ((ActionSheet)localObject1).setOnButtonClickListener((ActionSheet.OnButtonClickListener)localObject2);
            ((ActionSheet)localObject1).setMainTitle(2131897252);
            ((ActionSheet)localObject1).show();
          }
        }
        else if (paramView.getId() == 2131431699)
        {
          if (this.k)
          {
            DeepCleanConfigReporter.d();
            a(getString(2131888574), getString(2131888575), new QQSettingMsgClearFragment.2(this), new QQSettingMsgClearFragment.3(this));
          }
          else
          {
            DeepCleanConfigReporter.c();
            a(getString(2131888570), getString(2131888571), new QQSettingMsgClearFragment.4(this), new QQSettingMsgClearFragment.5(this));
          }
          DeepCleanConfigReporter.b();
          this.l = true;
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131897255));
    return localView;
  }
  
  public void onDestroy()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      a(false);
    }
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    QRUtils.a(getBaseActivity());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.d != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingMsgClearFragment", 2, "手动注销注册时事件mQQListener");
      }
      DownloadManagerV2.a().b(this.d);
      this.d = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.l) {
      DeepCleanConfigProcessor.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.k = PackageUtil.d(BaseApplication.getContext(), "com.tencent.android.qqdownloader");
    View localView = this.i;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      DeepCleanConfigReporter.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment
 * JD-Core Version:    0.7.0.1
 */