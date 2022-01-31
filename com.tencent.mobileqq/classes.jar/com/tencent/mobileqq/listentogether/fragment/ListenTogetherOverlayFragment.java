package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import atmr;
import atmw;
import atmx;
import atmy;
import atmz;
import atna;
import atnb;
import atnc;
import atnd;
import atne;
import atnf;
import atng;
import atnh;
import atnw;
import azqs;
import bdgm;
import bdjz;
import bhuf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bdjz jdField_a_of_type_Bdjz;
  private bhuf jdField_a_of_type_Bhuf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bhuf != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    atnw localatnw = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Bhuf = bhuf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = atmr.a();
    if (bool) {
      this.jdField_a_of_type_Bhuf.b(2131693971);
    }
    this.jdField_a_of_type_Bhuf.b(2131693941);
    this.jdField_a_of_type_Bhuf.c(2131690648);
    this.jdField_a_of_type_Bhuf.a(new atmw(this, localatnw));
    this.jdField_a_of_type_Bhuf.setOnCancelListener(new atna(this, localatnw));
    this.jdField_a_of_type_Bhuf.a(new atnb(this, bool, localatnw));
    this.jdField_a_of_type_Bhuf.show();
    localatnw.b(true);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131696330).setNegativeButton(2131690648, new atnd(this)).setPositiveButton(2131696334, new atnc(this));
    this.jdField_a_of_type_Bdjz.setTitle(2131696332);
    this.jdField_a_of_type_Bdjz.setCancelable(false);
    this.jdField_a_of_type_Bdjz.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bdjz.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bhuf != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bhuf = bhuf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bhuf.b(2131717662);
    this.jdField_a_of_type_Bhuf.a(2131693988, 3);
    this.jdField_a_of_type_Bhuf.c(2131690648);
    this.jdField_a_of_type_Bhuf.a(new atne(this, localListenTogetherManager));
    this.jdField_a_of_type_Bhuf.setOnDismissListener(new atnf(this));
    this.jdField_a_of_type_Bhuf.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    atnw localatnw = localListenTogetherManager.a();
    this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690648, new atnh(this, localListenTogetherManager, localatnw)).setPositiveButton(2131693987, new atng(this, localListenTogetherManager, localatnw));
    this.jdField_a_of_type_Bdjz.setTitle(2131693945);
    this.jdField_a_of_type_Bdjz.setOnDismissListener(new atmx(this, localListenTogetherManager, localatnw));
    this.jdField_a_of_type_Bdjz.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bdjz.show();
    localatnw.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    atnw localatnw;
    bdjz localbdjz;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localatnw = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localbdjz = bdgm.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693947;
      label62:
      this.jdField_a_of_type_Bdjz = localbdjz.setMessage(j).setNegativeButton(2131721268, new atmy(this));
      localbdjz = this.jdField_a_of_type_Bdjz;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693949;; i = 2131693948)
    {
      localbdjz.setTitle(i);
      this.jdField_a_of_type_Bdjz.setOnDismissListener(new atmz(this, localatnw));
      this.jdField_a_of_type_Bdjz.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bdjz.show();
      localatnw.b(true);
      return;
      i = 0;
      break;
      j = 2131693946;
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