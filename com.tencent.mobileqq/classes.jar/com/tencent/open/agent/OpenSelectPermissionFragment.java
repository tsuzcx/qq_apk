package com.tencent.open.agent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.auth.ContractBuilder;
import com.tencent.open.agent.auth.ISelectPermissionContract.Presenter;
import com.tencent.open.agent.auth.ISelectPermissionContract.View;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import mqq.app.MobileQQ;

public class OpenSelectPermissionFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, ISelectPermissionContract.View
{
  private View a;
  private View b;
  private View c;
  private ImageView d;
  private QQProgressDialog e;
  private ISelectPermissionContract.Presenter f;
  private boolean g;
  
  private boolean d()
  {
    if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ))
    {
      AuthUIUtil.a(getQBaseActivity(), HardCodeUtil.a(2131892333), new OpenSelectPermissionFragment.1(this));
      return false;
    }
    return true;
  }
  
  public void a()
  {
    SSOLog.a("OpenSelectPermissionFragment", new Object[] { "showLoading" });
    this.e = AuthUIUtil.a(getQBaseActivity(), null, 2131627754);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.d.setImageBitmap(paramBitmap);
  }
  
  public void a(ISelectPermissionContract.Presenter paramPresenter)
  {
    this.f = paramPresenter;
  }
  
  public void b()
  {
    AuthUIUtil.a(getQBaseActivity(), this.e);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a)
    {
      if (getQBaseActivity() != null) {
        getQBaseActivity().finish();
      }
    }
    else if (paramView == this.c)
    {
      if (d())
      {
        this.f.c();
        AuthorityUtil.e("0X800BA7E");
      }
    }
    else if (paramView == this.b)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_cancel_auth", 1);
      getQBaseActivity().setResult(102, localIntent);
      getQBaseActivity().finish();
      AuthorityUtil.e("0X800BA7F");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625707, paramViewGroup, false);
    this.a = paramLayoutInflater.findViewById(2131429218);
    this.b = paramLayoutInflater.findViewById(2131430281);
    paramLayoutInflater.findViewById(2131447582).setBackgroundColor(0);
    this.d = ((ImageView)paramLayoutInflater.findViewById(2131428628));
    this.a.setOnClickListener(this);
    this.c = paramLayoutInflater.findViewById(2131431227);
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramViewGroup = new OpenSelectPermissionFragment.PermissionAdapter(this, null);
    paramBundle = getQBaseActivity().getIntent();
    ContractBuilder.a(this, getContext());
    this.f.a(paramBundle);
    ((ListView)paramLayoutInflater.findViewById(2131439973)).setAdapter(paramViewGroup);
    paramViewGroup.a(this.f.a());
    this.f.a(paramBundle.getBooleanExtra("hasIcon", false));
    paramViewGroup = paramBundle.getStringExtra("appName");
    SSOLog.a("OpenSelectPermissionFragment", new Object[] { "onCreateView appName=", paramViewGroup });
    if (!TextUtils.isEmpty(paramViewGroup)) {
      ((TextView)paramLayoutInflater.findViewById(2131428630)).setText(paramViewGroup);
    }
    AuthorityUtil.a(null, "0X800B935", new String[] { "", "", paramViewGroup, this.f.b() });
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    SSOLog.a("OpenSelectPermissionFragment", new Object[] { "onResume--isSetStatusColor=", Boolean.valueOf(this.g) });
    super.onResume();
    if (!this.g)
    {
      AuthorityUtil.b(getQBaseActivity());
      this.g = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment
 * JD-Core Version:    0.7.0.1
 */