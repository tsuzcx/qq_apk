package com.tencent.open.agent;

import alpo;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import azmj;
import bdcd;
import bdfq;
import beyb;
import beyc;
import beyd;
import bfmk;
import bfml;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.open.model.AppInfo;

public class AuthorityControlAppDetailsFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bfmk jdField_a_of_type_Bfmk;
  private bfml jdField_a_of_type_Bfml;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AppInfo jdField_a_of_type_ComTencentOpenModelAppInfo;
  
  private void a()
  {
    this.jdField_a_of_type_Bfml = new beyb(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfml);
  }
  
  public static void a(Activity paramActivity, AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(paramActivity, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_APP_INFO", paramAppInfo);
    PublicFragmentActivity.a(paramActivity, localIntent, AuthorityControlAppDetailsFragment.class, 996);
  }
  
  private void a(View paramView)
  {
    paramView = new beyc(this);
    beyd localbeyd = new beyd(this);
    String str = alpo.a(2131701177) + this.jdField_a_of_type_ComTencentOpenModelAppInfo.b() + alpo.a(2131701168);
    paramView = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, str, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131719186), 2131690648, 2131694951, paramView, localbeyd);
    try
    {
      paramView.show();
      label89:
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a()), "");
      return;
    }
    catch (Throwable paramView)
    {
      break label89;
    }
  }
  
  private void b()
  {
    this.mContentView.findViewById(2131375593).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenModelAppInfo = ((AppInfo)getActivity().getIntent().getParcelableExtra("KEY_APP_INFO"));
    setTitle(this.jdField_a_of_type_ComTencentOpenModelAppInfo.b());
    this.jdField_a_of_type_Bfmk = ((bfmk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(151));
  }
  
  public int getContentLayoutId()
  {
    return 2131558440;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bfml);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    b();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */