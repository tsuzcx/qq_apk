package com.tencent.open.agent;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.manager.OpenAgentHandler;
import com.tencent.open.manager.OpenAgentObserver;
import com.tencent.open.model.AppInfo;
import com.tencent.open.sdk.checker.AccountChecker;
import com.tencent.open.sdk.data.AuthoritySdkJumpInfo;
import com.tencent.open.sdk.data.BasicSdkJumpInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xf26.oidb_0xf26.AuthItem;

public class AuthorityControlAppDetailsFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private OpenAgentHandler jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler;
  private OpenAgentObserver jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver;
  private AppInfo jdField_a_of_type_ComTencentOpenModelAppInfo;
  private AuthoritySdkJumpInfo jdField_a_of_type_ComTencentOpenSdkDataAuthoritySdkJumpInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AuthorityControlAppDetailsFragment.8(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new AuthorityControlAppDetailsFragment.9(this);
  
  private int a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 1) {
      return 1;
    }
    if (i == 2) {
      return 2;
    }
    return 0;
  }
  
  private View a(AuthorityControlAppDetailsFragment.AuthPermission paramAuthPermission, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131558647, paramViewGroup, false);
    if (!TextUtils.isEmpty(paramAuthPermission.b))
    {
      localObject = (TextView)paramViewGroup.findViewById(2131363057);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramAuthPermission.b);
    }
    Object localObject = (FormSwitchItem)paramViewGroup.findViewById(2131363062);
    ((FormSwitchItem)localObject).setText(paramAuthPermission.jdField_a_of_type_JavaLangString);
    ((FormSwitchItem)localObject).setContentDescription(paramAuthPermission.jdField_a_of_type_JavaLangString);
    ((FormSwitchItem)localObject).setChecked(paramAuthPermission.jdField_a_of_type_Boolean);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new AuthorityControlAppDetailsFragment.11(this, paramAuthPermission));
    return paramViewGroup;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131376399);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131363077);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "operateAuthItem type=", Integer.valueOf(paramInt1), ", id=", Integer.valueOf(paramInt2), ", mStatus=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131694647), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_b_of_type_Int == 2)
    {
      BasicSdkJumpInfo localBasicSdkJumpInfo = this.jdField_a_of_type_ComTencentOpenSdkDataAuthoritySdkJumpInfo.a();
      this.jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler.a(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a(), paramInt1, Collections.singletonList(Integer.valueOf(paramInt2)), localBasicSdkJumpInfo.a(), localBasicSdkJumpInfo.c(), this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver);
    }
    else
    {
      this.jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler.a(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a(), paramInt1, Collections.singletonList(Integer.valueOf(paramInt2)), this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver);
    }
    f();
  }
  
  private void a(int paramInt, String paramString)
  {
    AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800BADE", 0, a(), new String[] { String.valueOf(paramInt), "", paramString, "" });
  }
  
  public static void a(Activity paramActivity, AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(paramActivity, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_APP_INFO", paramAppInfo);
    localIntent.putExtra("from", 1);
    PublicFragmentActivity.a(paramActivity, localIntent, AuthorityControlAppDetailsFragment.class, 996);
  }
  
  public static void a(Context paramContext, AuthoritySdkJumpInfo paramAuthoritySdkJumpInfo)
  {
    QLog.i("AuthorityControlAppDetailsActivity", 1, "launchFromSdk");
    Intent localIntent = new Intent(paramContext, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_SDK_INFO", paramAuthoritySdkJumpInfo);
    localIntent.putExtra("from", 2);
    PublicFragmentActivity.a(paramContext, localIntent, AuthorityControlAppDetailsFragment.class);
  }
  
  private void a(View paramView)
  {
    paramView = new AuthorityControlAppDetailsFragment.6(this);
    AuthorityControlAppDetailsFragment.7 local7 = new AuthorityControlAppDetailsFragment.7(this);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131701028));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentOpenModelAppInfo.b());
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131701019));
    localObject = ((StringBuilder)localObject).toString();
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    paramView = DialogUtil.a(localActivity, 230, (String)localObject, localActivity.getResources().getString(2131718194), 2131690728, 2131694583, paramView, local7);
    try
    {
      paramView.show();
      label104:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a()), "");
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B931", 0, a(), new String[] { String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a()), "", this.jdField_a_of_type_ComTencentOpenModelAppInfo.b(), "" });
      return;
    }
    catch (Throwable paramView)
    {
      break label104;
    }
  }
  
  private void a(AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentOpenModelAppInfo = paramAppInfo;
    setTitle(this.jdField_a_of_type_ComTencentOpenModelAppInfo.b());
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentHandler = ((OpenAgentHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER));
    a(1, 0);
  }
  
  private void a(AuthoritySdkJumpInfo paramAuthoritySdkJumpInfo)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    setTitle("");
    this.jdField_a_of_type_ComTencentOpenSdkDataAuthoritySdkJumpInfo = paramAuthoritySdkJumpInfo;
    paramAuthoritySdkJumpInfo = paramAuthoritySdkJumpInfo.a();
    f();
    a(paramAuthoritySdkJumpInfo, new AuthorityControlAppDetailsFragment.2(this, paramAuthoritySdkJumpInfo));
  }
  
  private void a(BasicSdkJumpInfo paramBasicSdkJumpInfo, AuthorityControlAppDetailsFragment.IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    long l = System.currentTimeMillis() / 1000L;
    String str = paramBasicSdkJumpInfo.b();
    Object localObject1;
    if (TextUtils.isEmpty(str))
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("");
      localObject1 = AuthorityUtil.a((Context)localObject1, str, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Share.a((AppInterface)localObject2, this.jdField_a_of_type_AndroidAppActivity, ((QQAppInterface)localObject2).getCurrentAccountUin(), paramBasicSdkJumpInfo.a(), (String)localObject1, 0L, l, new AuthorityControlAppDetailsFragment.3(this, paramIGetAppInfoCallback), str, 15000L, false);
  }
  
  private void a(List<AppInfo> paramList)
  {
    if ((this.jdField_b_of_type_Int == 2) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(AuthorityControlFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1, paramList));
      }
    }
  }
  
  private boolean a()
  {
    boolean bool;
    if (this.jdField_a_of_type_Int == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Int = 0;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    h();
    return bool;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("from", 1);
    int i = this.jdField_b_of_type_Int;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      localObject = (AuthoritySdkJumpInfo)((Intent)localObject).getParcelableExtra("KEY_SDK_INFO");
      this.jdField_b_of_type_Long = ((AuthoritySdkJumpInfo)localObject).a().a();
      a((AuthoritySdkJumpInfo)localObject);
      return;
    }
    localObject = (AppInfo)((Intent)localObject).getParcelableExtra("KEY_APP_INFO");
    a((AppInfo)localObject);
    this.jdField_b_of_type_Long = ((AppInfo)localObject).a();
    a(((AppInfo)localObject).a(), ((AppInfo)localObject).b());
  }
  
  private void b(AppInfo paramAppInfo)
  {
    AccountChecker localAccountChecker = new AccountChecker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    f();
    localAccountChecker.a(this.jdField_a_of_type_ComTencentOpenSdkDataAuthoritySdkJumpInfo.a().a(), this.jdField_a_of_type_ComTencentOpenSdkDataAuthoritySdkJumpInfo.a().a(), new AuthorityControlAppDetailsFragment.4(this, paramAppInfo));
  }
  
  private void b(List<oidb_0xf26.AuthItem> paramList)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "showAuthItems size=", Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject = (LinearLayout)this.mContentView.findViewById(2131363066);
    ((LinearLayout)localObject).setVisibility(0);
    ((LinearLayout)localObject).removeAllViews();
    int j = Math.min(paramList.size(), 20);
    int i = 0;
    boolean bool1 = false;
    while (i < j)
    {
      oidb_0xf26.AuthItem localAuthItem = (oidb_0xf26.AuthItem)paramList.get(i);
      AuthorityControlAppDetailsFragment.AuthPermission localAuthPermission = new AuthorityControlAppDetailsFragment.AuthPermission(null);
      localAuthPermission.jdField_a_of_type_Int = localAuthItem.auth_group_id.get();
      localAuthPermission.jdField_a_of_type_JavaLangString = localAuthItem.auth_group_name.get().toStringUtf8();
      localAuthPermission.b = localAuthItem.auth_group_desc.get().toStringUtf8();
      boolean bool2;
      if (localAuthItem.auth_result.get() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localAuthPermission.jdField_a_of_type_Boolean = bool2;
      QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "showAuthItems ", localAuthPermission });
      ((LinearLayout)localObject).addView(a(localAuthPermission, (ViewGroup)localObject), new LinearLayout.LayoutParams(-1, -2));
      bool1 = TextUtils.isEmpty(localAuthPermission.b) ^ true;
      i += 1;
    }
    if (bool1)
    {
      paramList = this.mContentView.findViewById(2131376399);
      localObject = (LinearLayout.LayoutParams)paramList.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      paramList.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AuthorityControlAppDetailsFragment.1(this);
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_opensdk_app_detail_open"));
  }
  
  private void d()
  {
    Intent localIntent = new Intent("action_opensdk_app_detail_open");
    localIntent.setPackage(this.jdField_a_of_type_AndroidAppActivity.getPackageName());
    localIntent.putExtra("appId", this.jdField_b_of_type_Long);
    localIntent.putExtra("launchTime", this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentOpenManagerOpenAgentObserver = new AuthorityControlAppDetailsFragment.5(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = 1;
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
    ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
  }
  
  private void g()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "showLoadingDialog");
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299168));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131701029));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new AuthorityControlAppDetailsFragment.10(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void h()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "dismissLoadingDialog");
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    if ((this.jdField_b_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean) && ((SplashActivity.sWeakInstance == null) || (SplashActivity.sWeakInstance.get() == null)))
    {
      localObject = new Intent();
      RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, "/base/start/splash");
    }
    Object localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver((BroadcastReceiver)localObject);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131558474;
  }
  
  public boolean onBackEvent()
  {
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376399) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    QLog.d("AuthorityControlAppDetailsActivity", 1, "onDestroyView");
    this.jdField_a_of_type_Int = 0;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    h();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidAppActivity = getBaseActivity();
    paramView = this.jdField_a_of_type_AndroidAppActivity;
    if (paramView == null)
    {
      QLog.e("AuthorityControlAppDetailsActivity", 1, "onViewCreated: mActivity is null");
      return;
    }
    if (paramView.getIntent() == null)
    {
      QLog.e("AuthorityControlAppDetailsActivity", 1, "onViewCreated: intent is null");
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    e();
    a();
    b();
    d();
    c();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */