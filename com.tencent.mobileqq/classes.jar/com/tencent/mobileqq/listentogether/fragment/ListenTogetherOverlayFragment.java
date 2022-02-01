package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import awfq;
import awfx;
import awfy;
import awfz;
import awga;
import awgb;
import awgc;
import awgd;
import awge;
import awgf;
import awgg;
import awgh;
import awgi;
import awgx;
import bdla;
import bhdj;
import bkzi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private bkzi jdField_a_of_type_Bkzi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bkzi != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    awgx localawgx = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Bkzi = bkzi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = awfq.a();
    if (bool) {
      this.jdField_a_of_type_Bkzi.b(2131693562);
    }
    this.jdField_a_of_type_Bkzi.b(2131693537);
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.a(new awfx(this, localawgx));
    this.jdField_a_of_type_Bkzi.setOnCancelListener(new awgb(this, localawgx));
    this.jdField_a_of_type_Bkzi.a(new awgc(this, bool, localawgx));
    this.jdField_a_of_type_Bkzi.show();
    localawgx.b(true);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131695611).setNegativeButton(2131690697, new awge(this)).setPositiveButton(2131695615, new awgd(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131695613);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bkzi != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bkzi = bkzi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bkzi.b(2131716591);
    this.jdField_a_of_type_Bkzi.a(2131693575, 3);
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.a(new awgf(this, localListenTogetherManager));
    this.jdField_a_of_type_Bkzi.setOnDismissListener(new awgg(this));
    this.jdField_a_of_type_Bkzi.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    awgx localawgx = localListenTogetherManager.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690697, new awgi(this, localListenTogetherManager, localawgx)).setPositiveButton(2131693574, new awgh(this, localListenTogetherManager, localawgx));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131693539);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new awfy(this, localListenTogetherManager, localawgx));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    localawgx.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    awgx localawgx;
    QQCustomDialog localQQCustomDialog;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localawgx = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693541;
      label62:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog.setMessage(j).setNegativeButton(2131719875, new awfz(this));
      localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693543;; i = 2131693542)
    {
      localQQCustomDialog.setTitle(i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new awga(this, localawgx));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      localawgx.b(true);
      return;
      i = 0;
      break;
      j = 2131693540;
      break label62;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("type", 0);
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("uinType", -1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onDestroy");
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onResume mType: " + this.jdField_a_of_type_Int + " mHasGotoSetting:" + this.jdField_a_of_type_Boolean + " mUinType:" + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        return;
      }
      b();
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      c();
      return;
    }
    if (this.jdField_a_of_type_Int == 4)
    {
      e();
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment
 * JD-Core Version:    0.7.0.1
 */