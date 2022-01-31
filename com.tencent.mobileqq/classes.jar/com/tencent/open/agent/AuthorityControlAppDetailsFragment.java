package com.tencent.open.agent;

import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import axqw;
import bbcv;
import bbgg;
import bcyk;
import bcyl;
import bcym;
import bdmy;
import bdmz;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.open.model.AppInfo;

public class AuthorityControlAppDetailsFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bdmy jdField_a_of_type_Bdmy;
  private bdmz jdField_a_of_type_Bdmz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AppInfo jdField_a_of_type_ComTencentOpenModelAppInfo;
  
  private void a()
  {
    this.jdField_a_of_type_Bdmz = new bcyk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdmz);
  }
  
  public static void a(Activity paramActivity, AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(paramActivity, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_APP_INFO", paramAppInfo);
    PublicFragmentActivity.a(paramActivity, localIntent, AuthorityControlAppDetailsFragment.class, 996);
  }
  
  private void a(View paramView)
  {
    paramView = new bcyl(this);
    bcym localbcym = new bcym(this);
    String str = ajyc.a(2131700797) + this.jdField_a_of_type_ComTencentOpenModelAppInfo.b() + ajyc.a(2131700788);
    paramView = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, str, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718702), 2131690596, 2131694793, paramView, localbcym);
    try
    {
      paramView.show();
      label89:
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a()), "");
      return;
    }
    catch (Throwable paramView)
    {
      break label89;
    }
  }
  
  private void b()
  {
    this.mContentView.findViewById(2131375111).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenModelAppInfo = ((AppInfo)getActivity().getIntent().getParcelableExtra("KEY_APP_INFO"));
    setTitle(this.jdField_a_of_type_ComTencentOpenModelAppInfo.b());
    this.jdField_a_of_type_Bdmy = ((bdmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(151));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdmz);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    b();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */