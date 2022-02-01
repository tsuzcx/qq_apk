package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.auth.ContractBuilder;
import com.tencent.open.agent.auth.INewAuthorityContract.Presenter;
import com.tencent.open.agent.auth.INewAuthorityContract.View;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OpenAuthorityFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, INewAuthorityContract.View
{
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private OpenCardContainer jdField_a_of_type_ComTencentOpenAgentOpenCardContainer;
  private INewAuthorityContract.Presenter jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter;
  private Runnable jdField_a_of_type_JavaLangRunnable = new OpenAuthorityFragment.3(this);
  private TextView b;
  private TextView c;
  
  private String a(Bundle paramBundle)
  {
    String str1 = AuthParamUtil.a(paramBundle, "client_id");
    String str2 = AuthParamUtil.a(paramBundle, "key_proxy_appid");
    paramBundle = str2;
    if (TextUtils.isEmpty(str2)) {
      paramBundle = str1;
    }
    return paramBundle;
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372129));
    this.c = ((TextView)paramView.findViewById(2131364433));
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer = ((OpenCardContainer)paramView.findViewById(2131364351));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setOnUpdateStatusBarListener(new OpenAuthorityFragment.1(this));
    d();
    if (AuthParamUtil.a(getQBaseActivity().getIntent(), "internal_authority", false))
    {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131371858).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(false);
    paramView = AuthMemoryCache.a().a(a(paramBundle));
    if (paramView != null)
    {
      Object localObject = paramView.jdField_a_of_type_JavaUtilArrayList;
      long l = paramView.jdField_a_of_type_Long;
      if (localObject != null)
      {
        paramView = new LinkedList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          VirtualInfo localVirtualInfo = (VirtualInfo)((Iterator)localObject).next();
          VirtualAccountInfo localVirtualAccountInfo = new VirtualAccountInfo(localVirtualInfo);
          if (localVirtualInfo.jdField_a_of_type_Long == l) {
            localVirtualAccountInfo.a = true;
          }
          paramView.add(localVirtualAccountInfo);
        }
        a(paramView, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
      }
    }
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setPresenter(this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.setCurrentAppId(a(paramBundle));
    if (AuthParamUtil.a(paramBundle, "key_login_by_qr_scan", false)) {
      this.c.setVisibility(4);
    }
    if (AuthParamUtil.a(getQBaseActivity().getIntent()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getQBaseActivity(), 0, 2131561399, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    }
    else
    {
      if (getQBaseActivity().isChild()) {
        paramView = getQBaseActivity().getParent();
      } else {
        paramView = getQBaseActivity();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramView, getQBaseActivity().getTitleBarHeight());
    }
    paramView = AuthParamUtil.a(paramBundle, "oauth_app_name");
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(paramView, null);
    }
  }
  
  private boolean a()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    return (localQBaseActivity == null) || (localQBaseActivity.isFinishing());
  }
  
  private void b(String paramString)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a))) {
      a(new ArrayList(), paramString);
    }
  }
  
  private void d()
  {
    ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131378881)).resetBkColor(0);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369202).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369249));
    this.b = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.findViewById(2131369233));
    this.b.setText(2131690728);
    this.b.setOnClickListener(this);
  }
  
  private void e()
  {
    if (getQBaseActivity() == null)
    {
      SSOLog.b("OpenAuthorityFragment", new Object[] { "updateTitleColor activity is null" });
      return;
    }
    int i = getResources().getColor(2131165963);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165963);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setTextColor(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    localTextView = this.b;
    if (localTextView != null) {
      localTextView.setTextColor(localColorStateList);
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a();
  }
  
  public Object a(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5) {
        return null;
      }
      return Integer.valueOf(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.getCount());
    }
    return getQBaseActivity();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(paramInt));
    AuthUIUtil.a(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, 0);
  }
  
  public void a(int paramInt, List<VirtualAccountInfo> paramList, long paramLong)
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    if (paramInt != 0)
    {
      paramList = getQBaseActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707851));
      localStringBuilder.append(paramInt);
      AuthUIUtil.a(paramList, localStringBuilder.toString(), false);
      b(str);
      return;
    }
    if (paramList == null)
    {
      b(str);
      return;
    }
    a(paramList, str);
    if (paramLong != 0L) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a(paramLong);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(INewAuthorityContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter = paramPresenter;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.b(paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(paramString, paramBitmap);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    AuthUIUtil.a(getQBaseActivity(), paramString, paramBoolean);
  }
  
  public void a(List<VirtualAccountInfo> paramList, String paramString)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a(paramList, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public boolean a(List<Permission> paramList, String paramString)
  {
    return this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a(paramList, paramString);
  }
  
  public void b()
  {
    AuthUIUtil.a(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
  }
  
  public void c()
  {
    SSOLog.a("OpenAuthorityFragment", new Object[] { "onBackPressed" });
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.c();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--onActivityResult, requestCode: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | resultCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" | data: ");
    localStringBuilder.append(paramIntent);
    SSOLog.a("OpenAuthorityFragment", new Object[] { localStringBuilder.toString() });
    if ((paramInt1 == 101) && (paramIntent != null))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.a(paramIntent);
    }
    else
    {
      if ((paramInt1 == 102) && (paramIntent != null))
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.b(paramIntent);
        return;
      }
      if (paramInt1 == 100)
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.b(paramInt2, paramIntent);
        return;
      }
    }
    b();
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.a(paramInt2, paramIntent);
      return;
    }
    if (-1 == paramInt2)
    {
      if (AuthorityUtil.a(getActivity(), paramIntent)) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new OpenAuthorityFragment.2(this));
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.a(paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick cancel" });
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.c();
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick authorize btn" });
      long l = System.currentTimeMillis();
      try
      {
        if (l - this.jdField_a_of_type_Long < 500L)
        {
          SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick btn repeat click" });
        }
        else
        {
          this.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.g();
        }
      }
      finally {}
    }
    else if (paramView == this.c)
    {
      SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick showAccountSheet" });
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.a();
      AuthorityUtil.a("0X800BA78");
      AuthorityUtil.a("0X800BA7B");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    SSOLog.a("OpenAuthorityFragment", new Object[] { "onCreateView" });
    paramLayoutInflater = paramLayoutInflater.inflate(2131559666, paramViewGroup, false);
    if ((getQBaseActivity().getAppRuntime() instanceof AbstractOpenSdkAppInterface))
    {
      ContractBuilder.a(this, getContext());
      paramViewGroup = AuthParamUtil.a(getQBaseActivity().getIntent(), "key_params");
      a(paramLayoutInflater, paramViewGroup);
      this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.a(paramViewGroup);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    SSOLog.a("OpenAuthorityFragment", new Object[] { "onDestroy" });
    super.onDestroy();
    b();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.a();
  }
  
  public void onResume()
  {
    super.onResume();
    ImmersiveUtils.setStatusTextColor(true, getQBaseActivity().getWindow());
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.c();
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment
 * JD-Core Version:    0.7.0.1
 */