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
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ISelectPermissionContract.Presenter jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$Presenter;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  
  private boolean a()
  {
    if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ))
    {
      AuthUIUtil.a(getQBaseActivity(), HardCodeUtil.a(2131694647), new OpenSelectPermissionFragment.1(this));
      return false;
    }
    return true;
  }
  
  public void a()
  {
    SSOLog.a("OpenSelectPermissionFragment", new Object[] { "showLoading" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = AuthUIUtil.a(getQBaseActivity(), null, 2131561398);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  public void a(ISelectPermissionContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$Presenter = paramPresenter;
  }
  
  public void b()
  {
    AuthUIUtil.a(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      if (getQBaseActivity() != null) {
        getQBaseActivity().finish();
      }
    }
    else if (paramView == this.c)
    {
      if (a())
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$Presenter.a();
        AuthorityUtil.a("0X800BA7E");
      }
    }
    else if (paramView == this.b)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_cancel_auth", 1);
      getQBaseActivity().setResult(102, localIntent);
      getQBaseActivity().finish();
      AuthorityUtil.a("0X800BA7F");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559676, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363340);
    this.b = paramLayoutInflater.findViewById(2131364265);
    paramLayoutInflater.findViewById(2131378881).setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362847));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.c = paramLayoutInflater.findViewById(2131365086);
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramViewGroup = new OpenSelectPermissionFragment.PermissionAdapter(this, null);
    paramBundle = getQBaseActivity().getIntent();
    ContractBuilder.a(this, getContext());
    this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$Presenter.a(paramBundle);
    ((ListView)paramLayoutInflater.findViewById(2131372451)).setAdapter(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$Presenter.a());
    this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$Presenter.a(paramBundle.getBooleanExtra("hasIcon", false));
    paramViewGroup = paramBundle.getStringExtra("appName");
    SSOLog.a("OpenSelectPermissionFragment", new Object[] { "onCreateView appName=", paramViewGroup });
    if (!TextUtils.isEmpty(paramViewGroup)) {
      ((TextView)paramLayoutInflater.findViewById(2131362849)).setText(paramViewGroup);
    }
    AuthorityUtil.a(null, "0X800B935", new String[] { "", "", paramViewGroup, this.jdField_a_of_type_ComTencentOpenAgentAuthISelectPermissionContract$Presenter.a() });
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    SSOLog.a("OpenSelectPermissionFragment", new Object[] { "onResume--isSetStatusColor=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    super.onResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      AuthorityUtil.a(getQBaseActivity());
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment
 * JD-Core Version:    0.7.0.1
 */