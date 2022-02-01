package com.tencent.open.agent;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.auth.ContractBuilder;
import com.tencent.open.agent.auth.IOldAuthorityContract.Presenter;
import com.tencent.open.agent.auth.IOldAuthorityContract.View;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;

public class AuthorityActivity
  extends QBaseActivity
  implements View.OnClickListener, IOldAuthorityContract.View
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private CardContainer jdField_a_of_type_ComTencentOpenAgentCardContainer;
  private IOldAuthorityContract.Presenter jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AuthorityActivity.3(this);
  private TextView b;
  
  private void a(Bundle paramBundle)
  {
    if (!AuthParamUtil.a(paramBundle, "key_login_by_qr_scan", false)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a;
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.b();
    localObject = (TextView)((AuthorityAccountView)localObject).findViewById(2131361869);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(AuthUIUtil.a(paramBundle));
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131372129));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131364351));
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setDeleteLastAccountListener(new AuthorityActivity.1(this));
    d();
    if (AuthParamUtil.a(getIntent(), "internal_authority", false))
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131371858).setVisibility(8);
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(false);
    AuthUIUtil.a((MaxHeightScrollView)findViewById(2131364352), this);
    if (AuthParamUtil.a(getIntent()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, 0, 2131561399, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    }
    else
    {
      Object localObject;
      if (isChild()) {
        localObject = getParent();
      } else {
        localObject = this;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, getTitleBarHeight());
    }
    paramBundle = AuthParamUtil.a(paramBundle, "oauth_app_name");
    if (!TextUtils.isEmpty(paramBundle)) {
      a(paramBundle, null);
    }
  }
  
  private void d()
  {
    ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131378881)).resetBkColor(0);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369202).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694629);
    this.b = ((TextView)this.jdField_a_of_type_ComTencentOpenAgentCardContainer.findViewById(2131369233));
    this.b.setText(2131690728);
    this.b.setOnClickListener(this);
  }
  
  public Object a(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return null;
      }
      return this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
    }
    return this;
  }
  
  public void a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setTextColor(getResources().getColor(2131165963));
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    localTextView = this.b;
    if (localTextView != null) {
      localTextView.setTextColor(getResources().getColorStateList(2131165963));
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(paramInt));
    AuthUIUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, 0);
  }
  
  public void a(long paramLong)
  {
    c();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void a(IOldAuthorityContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter = paramPresenter;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1, paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString1, paramString2, paramBitmap);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.a(paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, String paramString)
  {
    return this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramGetAuthApiListResponse, paramString);
  }
  
  public void b()
  {
    AuthUIUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--onActivityResult, requestCode: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | resultCode:");
    localStringBuilder.append(paramInt2);
    SSOLog.a("AuthorityActivity", new Object[] { localStringBuilder.toString() });
    if (paramInt1 == 100)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.b(paramInt2, paramIntent);
      return;
    }
    b();
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.a(paramInt2, paramIntent);
      return;
    }
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      if (AuthorityUtil.a(this, paramIntent)) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new AuthorityActivity.2(this));
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.a(paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    SSOLog.a("AuthorityActivity", new Object[] { "doOnBackPressed" });
    super.doOnBackPressed();
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    SSOLog.a("AuthorityActivity", new Object[] { "doOnCreate" });
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    SSOLog.a("AuthorityActivity", new Object[] { "doOnDestroy" });
    super.doOnDestroy();
    b();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    SSOLog.a("AuthorityActivity", new Object[] { "doOnResume manu=", localObject });
    if ((!((String)localObject).equals("MeizuPRO 7-S")) && (!((String)localObject).equalsIgnoreCase("MeizuM711C"))) {
      ImmersiveUtils.trySetImmersiveStatusBar(getWindow());
    } else {
      ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    }
    ImmersiveUtils.setStatusTextColor(true, getWindow());
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.c();
    }
    else if (paramView.getId() == 2131363053)
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.f();
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.c();
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      long l = System.currentTimeMillis();
      try
      {
        if (l - this.jdField_a_of_type_Long < 500L) {
          break label156;
        }
        this.jdField_a_of_type_Long = l;
        if (!NetworkUtil.isNetworkAvailable(this))
        {
          SSOLog.a("AuthorityActivity", new Object[] { "mAuthorizeBtn click, network not available " });
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        }
        else
        {
          this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.g();
        }
      }
      finally {}
    }
    label156:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SSOLog.a("AuthorityActivity", new Object[] { "-->onCreate--" });
    if (!(super.getAppRuntime() instanceof AbstractOpenSdkAppInterface)) {
      return;
    }
    super.setContentView(2131559665);
    paramBundle = AuthParamUtil.a(getIntent(), "key_params");
    b(paramBundle);
    ContractBuilder.a(this, this);
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthIOldAuthorityContract$Presenter.a(paramBundle)) {
      return;
    }
    a(AuthParamUtil.a(paramBundle, "client_id"));
    a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */