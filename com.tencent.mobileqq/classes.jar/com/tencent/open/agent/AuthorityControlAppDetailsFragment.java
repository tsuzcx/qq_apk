package com.tencent.open.agent;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import awqx;
import babr;
import bafb;
import bbuk;
import bbul;
import bbum;
import bcix;
import bciy;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.open.model.AppInfo;

public class AuthorityControlAppDetailsFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bcix jdField_a_of_type_Bcix;
  private bciy jdField_a_of_type_Bciy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AppInfo jdField_a_of_type_ComTencentOpenModelAppInfo;
  
  private void a()
  {
    this.jdField_a_of_type_Bciy = new bbuk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bciy);
  }
  
  public static void a(Activity paramActivity, AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(paramActivity, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_APP_INFO", paramAppInfo);
    PublicFragmentActivity.a(paramActivity, localIntent, AuthorityControlAppDetailsFragment.class, 996);
  }
  
  private void a(View paramView)
  {
    paramView = new bbul(this);
    bbum localbbum = new bbum(this);
    String str = ajjy.a(2131635013) + this.jdField_a_of_type_ComTencentOpenModelAppInfo.b() + ajjy.a(2131635004);
    paramView = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, str, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131652877), 2131625035, 2131629116, paramView, localbbum);
    try
    {
      paramView.show();
      label89:
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.a()), "");
      return;
    }
    catch (Throwable paramView)
    {
      break label89;
    }
  }
  
  private void b()
  {
    this.mContentView.findViewById(2131309365).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenModelAppInfo = ((AppInfo)getActivity().getIntent().getParcelableExtra("KEY_APP_INFO"));
    setTitle(this.jdField_a_of_type_ComTencentOpenModelAppInfo.b());
    this.jdField_a_of_type_Bcix = ((bcix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(151));
  }
  
  public int getContentLayoutId()
  {
    return 2131492903;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bciy);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    a();
    b();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */