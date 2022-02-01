package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import anvx;
import bdla;
import bhdj;
import bjay;
import bjaz;
import bjba;
import bjpj;
import bjpk;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.model.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AuthorityControlAppDetailsFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bjpj jdField_a_of_type_Bjpj;
  private bjpk jdField_a_of_type_Bjpk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AppInfo jdField_a_of_type_ComTencentOpenModelAppInfo;
  
  private void a()
  {
    this.jdField_a_of_type_Bjpk = new bjay(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bjpk);
  }
  
  public static void a(Activity paramActivity, AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(paramActivity, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_APP_INFO", paramAppInfo);
    PublicFragmentActivity.a(paramActivity, localIntent, AuthorityControlAppDetailsFragment.class, 996);
  }
  
  private void a(View paramView)
  {
    paramView = new bjaz(this);
    bjba localbjba = new bjba(this);
    String str = anvx.a(2131700307) + this.jdField_a_of_type_ComTencentOpenModelAppInfo.b() + anvx.a(2131700298);
    paramView = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, str, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718037), 2131690697, 2131694399, paramView, localbjba);
    try
    {
      paramView.show();
      label89:
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a()), "");
      return;
    }
    catch (Throwable paramView)
    {
      break label89;
    }
  }
  
  private void b()
  {
    this.mContentView.findViewById(2131376517).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenModelAppInfo = ((AppInfo)getActivity().getIntent().getParcelableExtra("KEY_APP_INFO"));
    setTitle(this.jdField_a_of_type_ComTencentOpenModelAppInfo.b());
    this.jdField_a_of_type_Bjpj = ((bjpj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER));
  }
  
  public int getContentLayoutId()
  {
    return 2131558446;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bjpk);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    b();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */