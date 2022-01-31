package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import atii;
import atin;
import atio;
import atip;
import atiq;
import atir;
import atis;
import atit;
import atiu;
import ativ;
import atiw;
import atix;
import atiy;
import atjn;
import azmj;
import bdcd;
import bdfq;
import bhpy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bdfq jdField_a_of_type_Bdfq;
  private bhpy jdField_a_of_type_Bhpy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bhpy != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    atjn localatjn = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Bhpy = bhpy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = atii.a();
    if (bool) {
      this.jdField_a_of_type_Bhpy.b(2131693969);
    }
    this.jdField_a_of_type_Bhpy.b(2131693939);
    this.jdField_a_of_type_Bhpy.c(2131690648);
    this.jdField_a_of_type_Bhpy.a(new atin(this, localatjn));
    this.jdField_a_of_type_Bhpy.setOnCancelListener(new atir(this, localatjn));
    this.jdField_a_of_type_Bhpy.a(new atis(this, bool, localatjn));
    this.jdField_a_of_type_Bhpy.show();
    localatjn.b(true);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bdfq != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131696328).setNegativeButton(2131690648, new atiu(this)).setPositiveButton(2131696332, new atit(this));
    this.jdField_a_of_type_Bdfq.setTitle(2131696330);
    this.jdField_a_of_type_Bdfq.setCancelable(false);
    this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bdfq.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bhpy != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bhpy = bhpy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bhpy.b(2131717650);
    this.jdField_a_of_type_Bhpy.a(2131693986, 3);
    this.jdField_a_of_type_Bhpy.c(2131690648);
    this.jdField_a_of_type_Bhpy.a(new ativ(this, localListenTogetherManager));
    this.jdField_a_of_type_Bhpy.setOnDismissListener(new atiw(this));
    this.jdField_a_of_type_Bhpy.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bdfq != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    atjn localatjn = localListenTogetherManager.a();
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690648, new atiy(this, localListenTogetherManager, localatjn)).setPositiveButton(2131693985, new atix(this, localListenTogetherManager, localatjn));
    this.jdField_a_of_type_Bdfq.setTitle(2131693943);
    this.jdField_a_of_type_Bdfq.setOnDismissListener(new atio(this, localListenTogetherManager, localatjn));
    this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bdfq.show();
    localatjn.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bdfq != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    atjn localatjn;
    bdfq localbdfq;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localatjn = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localbdfq = bdcd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693945;
      label62:
      this.jdField_a_of_type_Bdfq = localbdfq.setMessage(j).setNegativeButton(2131721255, new atip(this));
      localbdfq = this.jdField_a_of_type_Bdfq;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693947;; i = 2131693946)
    {
      localbdfq.setTitle(i);
      this.jdField_a_of_type_Bdfq.setOnDismissListener(new atiq(this, localatjn));
      this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bdfq.show();
      localatjn.b(true);
      return;
      i = 0;
      break;
      j = 2131693944;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment
 * JD-Core Version:    0.7.0.1
 */