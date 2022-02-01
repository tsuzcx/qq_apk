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
  private long a = 0L;
  private Button b;
  private QQProgressDialog c;
  private OpenCardContainer d;
  private TextView e;
  private TextView f;
  private TextView g;
  private INewAuthorityContract.Presenter h;
  private Runnable i = new OpenAuthorityFragment.3(this);
  private Handler j = new Handler(Looper.getMainLooper());
  
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
    this.b = ((Button)paramView.findViewById(2131439600));
    this.g = ((TextView)paramView.findViewById(2131430467));
    this.g.setOnClickListener(this);
    this.d = ((OpenCardContainer)paramView.findViewById(2131430379));
    this.d.setOnUpdateStatusBarListener(new OpenAuthorityFragment.1(this));
    e();
    if (AuthParamUtil.a(getQBaseActivity().getIntent(), "internal_authority", false))
    {
      this.d.setTag(Boolean.valueOf(true));
      this.d.findViewById(2131439299).setVisibility(8);
      this.d.setVisibility(4);
    }
    this.b.setOnClickListener(this);
    a(false);
    paramView = AuthMemoryCache.a().c(a(paramBundle));
    if (paramView != null)
    {
      Object localObject = paramView.c;
      long l = paramView.b;
      if (localObject != null)
      {
        paramView = new LinkedList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          VirtualInfo localVirtualInfo = (VirtualInfo)((Iterator)localObject).next();
          VirtualAccountInfo localVirtualAccountInfo = new VirtualAccountInfo(localVirtualInfo);
          if (localVirtualInfo.a == l) {
            localVirtualAccountInfo.d = true;
          }
          paramView.add(localVirtualAccountInfo);
        }
        b(paramView, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
      }
    }
    this.d.setPresenter(this.h);
    this.d.setCurrentAppId(a(paramBundle));
    if (AuthParamUtil.a(paramBundle, "key_login_by_qr_scan", false)) {
      this.g.setVisibility(4);
    }
    if (AuthParamUtil.a(getQBaseActivity().getIntent()))
    {
      this.c = new QQProgressDialog(getQBaseActivity(), 0, 2131627755, 17);
      this.c.a(-1);
    }
    else
    {
      if (getQBaseActivity().isChild()) {
        paramView = getQBaseActivity().getParent();
      } else {
        paramView = getQBaseActivity();
      }
      this.c = new QQProgressDialog(paramView, getQBaseActivity().getTitleBarHeight());
    }
    paramView = AuthParamUtil.a(paramBundle, "oauth_app_name");
    if (paramView != null) {
      this.d.a(paramView, null);
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString == null) || (!paramString.equals(this.d.l.b))) {
      b(new ArrayList(), paramString);
    }
  }
  
  private void e()
  {
    ((ImmersiveTitleBar2)this.d.findViewById(2131447582)).resetBkColor(0);
    this.d.findViewById(2131436180).setOnClickListener(this);
    this.e = ((TextView)this.d.findViewById(2131436227));
    this.f = ((TextView)this.d.findViewById(2131436211));
    this.f.setText(2131887648);
    this.f.setOnClickListener(this);
  }
  
  private void f()
  {
    if (getQBaseActivity() == null)
    {
      SSOLog.b("OpenAuthorityFragment", new Object[] { "updateTitleColor activity is null" });
      return;
    }
    int k = getResources().getColor(2131166684);
    ColorStateList localColorStateList = getResources().getColorStateList(2131166684);
    TextView localTextView = this.e;
    if (localTextView != null)
    {
      localTextView.setTextColor(k);
      this.e.setText("");
    }
    localTextView = this.f;
    if (localTextView != null) {
      localTextView.setTextColor(localColorStateList);
    }
  }
  
  private boolean g()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    return (localQBaseActivity == null) || (localQBaseActivity.isFinishing());
  }
  
  public void a()
  {
    this.d.a(1);
  }
  
  public void a(int paramInt)
  {
    this.c.a(getResources().getString(paramInt));
    AuthUIUtil.a(getQBaseActivity(), this.c, 0);
  }
  
  public void a(int paramInt, List<VirtualAccountInfo> paramList, long paramLong)
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    if (paramInt != 0)
    {
      paramList = getQBaseActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131905665));
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
    b(paramList, str);
    if (paramLong != 0L) {
      this.d.l.a(paramLong);
    }
  }
  
  public void a(long paramLong)
  {
    this.j.removeCallbacks(this.i);
    this.j.postDelayed(this.i, paramLong);
  }
  
  public void a(INewAuthorityContract.Presenter paramPresenter)
  {
    this.h = paramPresenter;
  }
  
  public void a(String paramString)
  {
    this.d.c(paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.d.a(paramString, paramBitmap);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    AuthUIUtil.a(getQBaseActivity(), paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
  }
  
  public boolean a(List<Permission> paramList, String paramString)
  {
    return this.d.a(paramList, paramString);
  }
  
  public Object b(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5) {
        return null;
      }
      return Integer.valueOf(this.d.l.getCount());
    }
    return getQBaseActivity();
  }
  
  public void b()
  {
    AuthUIUtil.a(getQBaseActivity(), this.c);
  }
  
  public void b(List<VirtualAccountInfo> paramList, String paramString)
  {
    this.d.l.a(paramList, paramString);
  }
  
  public void c()
  {
    SSOLog.a("OpenAuthorityFragment", new Object[] { "onBackPressed" });
    this.h.c();
  }
  
  public long d()
  {
    return this.d.getSelectVid();
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
      this.h.a(paramIntent);
    }
    else
    {
      if ((paramInt1 == 102) && (paramIntent != null))
      {
        this.h.b(paramIntent);
        return;
      }
      if (paramInt1 == 100)
      {
        this.h.b(paramInt2, paramIntent);
        return;
      }
    }
    b();
    if (paramInt2 == 0)
    {
      this.h.a(paramInt2, paramIntent);
      return;
    }
    if (-1 == paramInt2)
    {
      if (AuthorityUtil.a(getActivity(), paramIntent)) {
        return;
      }
      this.j.post(new OpenAuthorityFragment.2(this));
      this.h.a(paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.f)
    {
      SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick cancel" });
      this.h.c();
    }
    else if (paramView == this.b)
    {
      SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick authorize btn" });
      long l = System.currentTimeMillis();
      try
      {
        if (l - this.a < 500L)
        {
          SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick btn repeat click" });
        }
        else
        {
          this.a = l;
          this.h.g();
        }
      }
      finally {}
    }
    else if (paramView == this.g)
    {
      SSOLog.a("OpenAuthorityFragment", new Object[] { "onClick showAccountSheet" });
      this.d.k.e();
      AuthorityUtil.e("0X800BA78");
      AuthorityUtil.e("0X800BA7B");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    SSOLog.a("OpenAuthorityFragment", new Object[] { "onCreateView" });
    paramLayoutInflater = paramLayoutInflater.inflate(2131625696, paramViewGroup, false);
    if ((getQBaseActivity().getAppRuntime() instanceof AbstractOpenSdkAppInterface))
    {
      ContractBuilder.a(this, getContext());
      paramViewGroup = AuthParamUtil.a(getQBaseActivity().getIntent(), "key_params");
      a(paramLayoutInflater, paramViewGroup);
      this.h.a(paramViewGroup);
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
    this.h.a();
  }
  
  public void onResume()
  {
    super.onResume();
    ImmersiveUtils.setStatusTextColor(true, getQBaseActivity().getWindow());
    this.d.c();
    this.h.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment
 * JD-Core Version:    0.7.0.1
 */