package com.tencent.mobileqq.fragment;

import aeow;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import anvx;
import aqwq;
import aqws;
import audy;
import auxr;
import auxs;
import auxt;
import auxu;
import auxv;
import auxw;
import auxx;
import auxy;
import bdla;
import bhdj;
import bisl;
import bjjq;
import bjju;
import bjmy;
import bkyz;
import bkzi;
import bkzq;
import bkzz;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.VersionUtils;
import vbp;
import zmk;

public class QQSettingMsgClearFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static final String a;
  private static long jdField_b_of_type_Long;
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bisl a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private vbp jdField_a_of_type_Vbp;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131694394);
  }
  
  public QQSettingMsgClearFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new auxy(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377134));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131374430);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.mContentView.findViewById(2131365465).setOnClickListener(this);
    this.mContentView.findViewById(2131380587).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131365462));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691432));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(4);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365480);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365481));
    f();
    if (VersionUtils.isGingerBread()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bisl.a(getString(2131690828));
      this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Bisl.c(true);
      this.jdField_a_of_type_Bisl.a(false);
      this.jdField_a_of_type_Bisl.b(true);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingMsgClearFragment", 2, "qq installSucceed appid = " + paramString1 + ", packageName = " + paramString2);
    }
    if ((TextUtils.equals(paramString1, "5848")) && (TextUtils.equals(paramString2, "com.tencent.android.qqdownloader")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingMsgClearFragment", 2, "这是统一的DownloadListener，installSucceed, appId:" + paramString1 + ",packName:" + paramString2);
      }
      bjjq.a().b(this.jdField_a_of_type_Vbp);
      this.jdField_a_of_type_Vbp = null;
    }
  }
  
  private void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString1 = bhdj.a(getActivity(), 230).setTitle(null).setMessage(paramString1);
    paramString1.setMessageTextSize(17.0F);
    paramString1.setPositiveButton(paramString2, paramOnClickListener1);
    paramString1.setNegativeButton(getString(2131690697), new auxx(this, paramOnClickListener2, paramString1));
    try
    {
      paramString1.show();
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQSettingMsgClearFragment", 2, "setTroopAdmins:", paramString1);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bisl != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bisl.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bisl.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bisl.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bisl.dismiss();
  }
  
  public static boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_b_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingMsgClearFragment", 2, "click too fast");
      }
      jdField_b_of_type_Long = l;
      return true;
    }
    jdField_b_of_type_Long = l;
    return false;
  }
  
  private void b()
  {
    try
    {
      if (getActivity() == null) {
        return;
      }
      ((ClipboardManager)getActivity().getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", "tmast://spaceclean?via=ANDROIDQQ.NEWYYB.AZQQAPK&targetTabType=1&clipboard_start_time=" + System.currentTimeMillis()));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingMsgClearFragment", 2, paramString + " onDownloadFinish info = " + paramDownloadInfo);
    }
  }
  
  private void c()
  {
    d();
    Bundle localBundle = new Bundle();
    localBundle.putString(bjmy.b, "5848");
    localBundle.putString(bjmy.l, jdField_a_of_type_JavaLangString);
    localBundle.putString(bjmy.f, "com.tencent.android.qqdownloader");
    localBundle.putString(bjmy.j, "http://a.app.qq.com/o/myapp-down?g_f=1118400");
    localBundle.putInt(bjmy.k, 2);
    localBundle.putBoolean(bjmy.h, true);
    bjju.a().a(getActivity(), localBundle, "biz_src_qq_setting_msg_clean", null, 0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Vbp == null)
    {
      this.jdField_a_of_type_Vbp = new auxw(this);
      bjjq.a().a(this.jdField_a_of_type_Vbp);
    }
  }
  
  private void e()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://spaceclean?via=ANDROIDQQ.YYB.AZQQAPK&targetTabType=1"));
    localIntent.setFlags(268435456);
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (aqwq.a())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Boolean = bkyz.a(BaseApplication.getContext(), "com.tencent.android.qqdownloader");
        this.jdField_a_of_type_AndroidWidgetTextView.setText(aqwq.a(BaseApplication.getContext(), this.jdField_a_of_type_Boolean));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        a();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561506;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView.getId() == 2131365465)
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), FMActivity.class);
      ((Intent)localObject1).putExtra("selectMode", true);
      ((Intent)localObject1).putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      ((Intent)localObject1).putExtra("tab_tab_type", 8);
      ((Intent)localObject1).putExtra("only_show_local_tab", true);
      ((Intent)localObject1).putExtra("max_select_count", 999999);
      bdla.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 0, 0, "", "", "", "");
      startActivityForResult((Intent)localObject1, 1);
      audy.a("0x80087C4");
      bdla.b(null, "dc00898", "", "", "0X800A0C2", "0X800A0C2", 0, 0, "", "", "", "");
      QQSettingMsgHistoryActivity.a();
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() == 2131380587)
        {
          localObject1 = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
          ((Intent)localObject1).putExtra("set_display_type", 1);
          getActivity().startActivity((Intent)localObject1);
          bdla.b(null, "CliOper", "", "", "0X800A2D1", "0X800A2D1", 0, 0, "", "", "", "");
        }
        else
        {
          Object localObject2;
          if (paramView.getId() == 2131374430)
          {
            if (!a())
            {
              localObject1 = new Intent();
              localObject2 = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "", 0, null, false);
              Bundle localBundle = new Bundle();
              localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(((AIOImageProviderService)localObject2).asBinder()));
              localBundle.putInt("jump", 1);
              ((Intent)localObject1).putExtras(localBundle);
              ((Intent)localObject1).setFlags(805306368);
              bdla.b(null, "dc00898", "", "", "0X800A0C1", "0X800A0C1", 0, 0, "", "", "", "");
              aeow.a(this, (Intent)localObject1, PublicFragmentActivityForPeak.class, SessionClearFragment.class, 1);
              QQSettingMsgHistoryActivity.a();
            }
          }
          else
          {
            if (paramView.getId() != 2131365462) {
              break;
            }
            long l1 = System.currentTimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            if ((!getActivity().isFinishing()) && (l1 - l2 >= 500L))
            {
              this.jdField_a_of_type_Long = l1;
              localObject1 = (bkzi)bkzz.a(getActivity(), null);
              localObject2 = new auxr(this, (bkzi)localObject1);
              ((bkzi)localObject1).a(2131691431, 3);
              ((bkzi)localObject1).d(getString(2131690697));
              ((bkzi)localObject1).a((bkzq)localObject2);
              ((bkzi)localObject1).a(2131698819);
              ((bkzi)localObject1).show();
            }
          }
        }
      }
    } while (paramView.getId() != 2131365480);
    if (this.jdField_a_of_type_Boolean)
    {
      aqws.d();
      a(getString(2131691574), getString(2131691575), new auxs(this), new auxt(this));
    }
    for (;;)
    {
      aqws.b();
      this.jdField_b_of_type_Boolean = true;
      break;
      aqws.c();
      a(getString(2131691570), getString(2131691571), new auxu(this), new auxv(this));
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131698822));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      a(false);
    }
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    zmk.a(getActivity());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Vbp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingMsgClearFragment", 2, "手动注销注册时事件mQQListener");
      }
      bjjq.a().b(this.jdField_a_of_type_Vbp);
      this.jdField_a_of_type_Vbp = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_b_of_type_Boolean) {
      aqwq.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = bkyz.a(BaseApplication.getContext(), "com.tencent.android.qqdownloader");
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
      aqws.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment
 * JD-Core Version:    0.7.0.1
 */