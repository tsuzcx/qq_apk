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
  private View a;
  private View b;
  private int c;
  private Activity d;
  private QQAppInterface e;
  private AppInfo f;
  private OpenAgentHandler g;
  private OpenAgentObserver h;
  private QQProgressDialog i;
  private int j;
  private AuthoritySdkJumpInfo k;
  private long l;
  private long m;
  private BroadcastReceiver n;
  private boolean o = false;
  private Runnable p = new AuthorityControlAppDetailsFragment.8(this);
  private Runnable q = new AuthorityControlAppDetailsFragment.9(this);
  
  private View a(AuthorityControlAppDetailsFragment.AuthPermission paramAuthPermission, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.d.getLayoutInflater().inflate(2131624262, paramViewGroup, false);
    if (!TextUtils.isEmpty(paramAuthPermission.c))
    {
      localObject = (TextView)paramViewGroup.findViewById(2131428891);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramAuthPermission.c);
    }
    Object localObject = (FormSwitchItem)paramViewGroup.findViewById(2131428896);
    ((FormSwitchItem)localObject).setText(paramAuthPermission.b);
    ((FormSwitchItem)localObject).setContentDescription(paramAuthPermission.b);
    ((FormSwitchItem)localObject).setChecked(paramAuthPermission.d);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new AuthorityControlAppDetailsFragment.11(this, paramAuthPermission));
    return paramViewGroup;
  }
  
  private void a()
  {
    this.a = this.mContentView.findViewById(2131444615);
    this.a.setOnClickListener(this);
    this.b = this.mContentView.findViewById(2131428913);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "operateAuthItem type=", Integer.valueOf(paramInt1), ", id=", Integer.valueOf(paramInt2), ", mStatus=", Integer.valueOf(this.c) });
    if (!NetworkUtil.isNetworkAvailable(this.d))
    {
      QQToast.makeText(this.d, HardCodeUtil.a(2131892333), 0).show();
      return;
    }
    if (this.c != 0) {
      return;
    }
    this.c = 1;
    if (this.j == 2)
    {
      BasicSdkJumpInfo localBasicSdkJumpInfo = this.k.a();
      this.g.a(this.f.a(), paramInt1, Collections.singletonList(Integer.valueOf(paramInt2)), localBasicSdkJumpInfo.b(), localBasicSdkJumpInfo.d(), this.h);
    }
    else
    {
      this.g.a(this.f.a(), paramInt1, Collections.singletonList(Integer.valueOf(paramInt2)), this.h);
    }
    f();
  }
  
  private void a(int paramInt, String paramString)
  {
    AuthorityUtil.a(this.e, "0X800BADE", 0, j(), new String[] { String.valueOf(paramInt), "", paramString, "" });
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
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131899049));
    ((StringBuilder)localObject).append(this.f.c());
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131899040));
    localObject = ((StringBuilder)localObject).toString();
    Activity localActivity = this.d;
    paramView = DialogUtil.a(localActivity, 230, (String)localObject, localActivity.getResources().getString(2131915674), 2131887648, 2131892267, paramView, local7);
    try
    {
      paramView.show();
      label104:
      ReportController.b(this.e, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.f.a()), "");
      AuthorityUtil.a(this.e, "0X800B931", 0, j(), new String[] { String.valueOf(this.f.a()), "", this.f.c(), "" });
      return;
    }
    catch (Throwable paramView)
    {
      break label104;
    }
  }
  
  private void a(AppInfo paramAppInfo)
  {
    this.f = paramAppInfo;
    setTitle(this.f.c());
    this.g = ((OpenAgentHandler)this.e.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER));
    a(1, 0);
  }
  
  private void a(AuthoritySdkJumpInfo paramAuthoritySdkJumpInfo)
  {
    this.b.setVisibility(8);
    setTitle("");
    this.k = paramAuthoritySdkJumpInfo;
    paramAuthoritySdkJumpInfo = paramAuthoritySdkJumpInfo.a();
    f();
    a(paramAuthoritySdkJumpInfo, new AuthorityControlAppDetailsFragment.2(this, paramAuthoritySdkJumpInfo));
  }
  
  private void a(BasicSdkJumpInfo paramBasicSdkJumpInfo, AuthorityControlAppDetailsFragment.IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    String str = paramBasicSdkJumpInfo.c();
    Object localObject1;
    if (TextUtils.isEmpty(str))
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = this.d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("");
      localObject1 = AuthorityUtil.a((Context)localObject1, str, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.e;
    Share.a((AppInterface)localObject2, this.d, ((QQAppInterface)localObject2).getCurrentAccountUin(), paramBasicSdkJumpInfo.a(), (String)localObject1, 0L, l1, new AuthorityControlAppDetailsFragment.3(this, paramIGetAppInfoCallback), str, 15000L, false);
  }
  
  private void a(List<AppInfo> paramList)
  {
    if ((this.j == 2) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      MqqHandler localMqqHandler = this.e.getHandler(AuthorityControlFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1, paramList));
      }
    }
  }
  
  private void b()
  {
    Object localObject = this.d.getIntent();
    this.j = ((Intent)localObject).getIntExtra("from", 1);
    int i1 = this.j;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      localObject = (AuthoritySdkJumpInfo)((Intent)localObject).getParcelableExtra("KEY_SDK_INFO");
      this.m = ((AuthoritySdkJumpInfo)localObject).a().a();
      a((AuthoritySdkJumpInfo)localObject);
      return;
    }
    localObject = (AppInfo)((Intent)localObject).getParcelableExtra("KEY_APP_INFO");
    a((AppInfo)localObject);
    this.m = ((AppInfo)localObject).a();
    a(((AppInfo)localObject).a(), ((AppInfo)localObject).c());
  }
  
  private void b(AppInfo paramAppInfo)
  {
    AccountChecker localAccountChecker = new AccountChecker(this.e);
    f();
    localAccountChecker.a(this.k.a().a(), this.k.a().b(), new AuthorityControlAppDetailsFragment.4(this, paramAppInfo));
  }
  
  private void b(List<oidb_0xf26.AuthItem> paramList)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "showAuthItems size=", Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject = (LinearLayout)this.mContentView.findViewById(2131428900);
    ((LinearLayout)localObject).setVisibility(0);
    ((LinearLayout)localObject).removeAllViews();
    int i2 = Math.min(paramList.size(), 20);
    int i1 = 0;
    boolean bool1 = false;
    while (i1 < i2)
    {
      oidb_0xf26.AuthItem localAuthItem = (oidb_0xf26.AuthItem)paramList.get(i1);
      AuthorityControlAppDetailsFragment.AuthPermission localAuthPermission = new AuthorityControlAppDetailsFragment.AuthPermission(null);
      localAuthPermission.a = localAuthItem.auth_group_id.get();
      localAuthPermission.b = localAuthItem.auth_group_name.get().toStringUtf8();
      localAuthPermission.c = localAuthItem.auth_group_desc.get().toStringUtf8();
      boolean bool2;
      if (localAuthItem.auth_result.get() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localAuthPermission.d = bool2;
      QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "showAuthItems ", localAuthPermission });
      ((LinearLayout)localObject).addView(a(localAuthPermission, (ViewGroup)localObject), new LinearLayout.LayoutParams(-1, -2));
      bool1 = TextUtils.isEmpty(localAuthPermission.c) ^ true;
      i1 += 1;
    }
    if (bool1)
    {
      paramList = this.mContentView.findViewById(2131444615);
      localObject = (LinearLayout.LayoutParams)paramList.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      paramList.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void c()
  {
    this.n = new AuthorityControlAppDetailsFragment.1(this);
    this.d.registerReceiver(this.n, new IntentFilter("action_opensdk_app_detail_open"));
  }
  
  private void d()
  {
    Intent localIntent = new Intent("action_opensdk_app_detail_open");
    localIntent.setPackage(this.d.getPackageName());
    localIntent.putExtra("appId", this.m);
    localIntent.putExtra("launchTime", this.l);
    this.d.sendBroadcast(localIntent);
  }
  
  private void e()
  {
    this.h = new AuthorityControlAppDetailsFragment.5(this);
  }
  
  private void f()
  {
    this.c = 1;
    ThreadManager.getUIHandler().postDelayed(this.p, 400L);
    ThreadManager.getUIHandler().postDelayed(this.q, 15000L);
  }
  
  private boolean g()
  {
    boolean bool;
    if (this.c == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = 0;
    ThreadManager.getUIHandler().removeCallbacks(this.p);
    ThreadManager.getUIHandler().removeCallbacks(this.q);
    i();
    return bool;
  }
  
  private void h()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "showLoadingDialog");
    if (this.i == null)
    {
      Activity localActivity = this.d;
      this.i = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299920));
      this.i.a(HardCodeUtil.a(2131899050));
      this.i.a(new AuthorityControlAppDetailsFragment.10(this));
    }
    if (this.i.isShowing()) {
      return;
    }
    this.i.show();
  }
  
  private void i()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "dismissLoadingDialog");
    QQProgressDialog localQQProgressDialog = this.i;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.i.dismiss();
    }
  }
  
  private int j()
  {
    int i1 = this.j;
    if (i1 == 1) {
      return 1;
    }
    if (i1 == 2) {
      return 2;
    }
    return 0;
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    if ((this.j == 2) && (!this.o) && ((SplashActivity.sWeakInstance == null) || (SplashActivity.sWeakInstance.get() == null)))
    {
      localObject = new Intent();
      RouteUtils.a(this.d, (Intent)localObject, "/base/start/splash");
    }
    Object localObject = this.n;
    if (localObject != null)
    {
      this.d.unregisterReceiver((BroadcastReceiver)localObject);
      this.n = null;
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131624016;
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
    if (paramView.getId() == 2131444615) {
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
    this.c = 0;
    ThreadManager.getUIHandler().removeCallbacks(this.p);
    ThreadManager.getUIHandler().removeCallbacks(this.q);
    i();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.d = getBaseActivity();
    paramView = this.d;
    if (paramView == null)
    {
      QLog.e("AuthorityControlAppDetailsActivity", 1, "onViewCreated: mActivity is null");
      return;
    }
    if (paramView.getIntent() == null)
    {
      QLog.e("AuthorityControlAppDetailsActivity", 1, "onViewCreated: intent is null");
      this.d.finish();
    }
    this.e = getBaseActivity().app;
    this.l = System.currentTimeMillis();
    e();
    a();
    b();
    d();
    c();
    ReportController.b(this.e, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */