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
  private long a;
  private Button b;
  private QQProgressDialog c;
  private CardContainer d;
  private TextView e;
  private TextView f;
  private IOldAuthorityContract.Presenter g;
  private Handler h = new Handler(Looper.getMainLooper());
  private Runnable i = new AuthorityActivity.3(this);
  
  private void a(Bundle paramBundle)
  {
    if (!AuthParamUtil.a(paramBundle, "key_login_by_qr_scan", false)) {
      return;
    }
    Object localObject = this.d.k;
    if (localObject == null) {
      return;
    }
    this.d.b();
    localObject = (TextView)((AuthorityAccountView)localObject).findViewById(2131427423);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(AuthUIUtil.a(paramBundle));
  }
  
  private void b(Bundle paramBundle)
  {
    this.b = ((Button)super.findViewById(2131439600));
    this.d = ((CardContainer)super.findViewById(2131430379));
    this.d.setDeleteLastAccountListener(new AuthorityActivity.1(this));
    d();
    if (AuthParamUtil.a(getIntent(), "internal_authority", false))
    {
      this.d.setTag(Boolean.valueOf(true));
      this.d.findViewById(2131439299).setVisibility(8);
      this.d.setVisibility(4);
    }
    this.b.setOnClickListener(this);
    a(false);
    AuthUIUtil.a((MaxHeightScrollView)findViewById(2131430380), this);
    if (AuthParamUtil.a(getIntent()))
    {
      this.c = new QQProgressDialog(this, 0, 2131627755, 17);
      this.c.a(-1);
    }
    else
    {
      Object localObject;
      if (isChild()) {
        localObject = getParent();
      } else {
        localObject = this;
      }
      this.c = new QQProgressDialog((Context)localObject, getTitleBarHeight());
    }
    paramBundle = AuthParamUtil.a(paramBundle, "oauth_app_name");
    if (!TextUtils.isEmpty(paramBundle)) {
      a(paramBundle, null);
    }
  }
  
  private void d()
  {
    ((ImmersiveTitleBar2)this.d.findViewById(2131447582)).resetBkColor(0);
    this.d.findViewById(2131436180).setOnClickListener(this);
    this.e = ((TextView)this.d.findViewById(2131436227));
    this.e.setText(2131892313);
    this.f = ((TextView)this.d.findViewById(2131436211));
    this.f.setText(2131887648);
    this.f.setOnClickListener(this);
  }
  
  public void a()
  {
    TextView localTextView = this.e;
    if (localTextView != null)
    {
      localTextView.setTextColor(getResources().getColor(2131166684));
      this.e.setText("");
    }
    localTextView = this.f;
    if (localTextView != null) {
      localTextView.setTextColor(getResources().getColorStateList(2131166684));
    }
  }
  
  public void a(int paramInt)
  {
    this.c.a(getResources().getString(paramInt));
    AuthUIUtil.a(this, this.c, 0);
  }
  
  public void a(long paramLong)
  {
    c();
    this.h.postDelayed(this.i, paramLong);
  }
  
  public void a(IOldAuthorityContract.Presenter paramPresenter)
  {
    this.g = paramPresenter;
  }
  
  public void a(String paramString)
  {
    this.d.a(1, paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.d.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.d.a(paramString1, paramString2, paramBitmap);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.g.a(paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, String paramString)
  {
    return this.d.a(paramGetAuthApiListResponse, paramString);
  }
  
  public Object b(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return null;
      }
      return this.d.getAuthList();
    }
    return this;
  }
  
  public void b()
  {
    AuthUIUtil.a(this, this.c);
  }
  
  public void c()
  {
    this.h.removeCallbacks(this.i);
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
      this.g.b(paramInt2, paramIntent);
      return;
    }
    b();
    if (paramInt2 == 0)
    {
      this.g.a(paramInt2, paramIntent);
      return;
    }
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      if (AuthorityUtil.a(this, paramIntent)) {
        return;
      }
      this.h.post(new AuthorityActivity.2(this));
      this.g.a(paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    SSOLog.a("AuthorityActivity", new Object[] { "doOnBackPressed" });
    super.doOnBackPressed();
    this.g.c();
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
    this.g.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.g.b();
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
    if (paramView == this.f)
    {
      this.g.c();
    }
    else if (paramView.getId() == 2131428886)
    {
      this.g.f();
      this.d.c();
    }
    else if (paramView == this.b)
    {
      long l = System.currentTimeMillis();
      try
      {
        if (l - this.a < 500L) {
          break label156;
        }
        this.a = l;
        if (!NetworkUtil.isNetworkAvailable(this))
        {
          SSOLog.a("AuthorityActivity", new Object[] { "mAuthorizeBtn click, network not available " });
          this.h.removeCallbacks(this.i);
          this.h.post(this.i);
        }
        else
        {
          this.g.g();
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
    super.setContentView(2131625695);
    paramBundle = AuthParamUtil.a(getIntent(), "key_params");
    b(paramBundle);
    ContractBuilder.a(this, this);
    if (this.g.a(paramBundle)) {
      return;
    }
    a(AuthParamUtil.a(paramBundle, "client_id"));
    a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */