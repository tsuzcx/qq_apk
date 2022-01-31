package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import arrn;
import arrs;
import arrt;
import arru;
import arrv;
import arrw;
import arrx;
import arry;
import arrz;
import arsa;
import arsb;
import arsc;
import arsd;
import arss;
import axqy;
import bbdj;
import bbgu;
import bfpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bbgu jdField_a_of_type_Bbgu;
  private bfpc jdField_a_of_type_Bfpc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bfpc != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    arss localarss = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Bfpc = bfpc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = arrn.a();
    if (bool) {
      this.jdField_a_of_type_Bfpc.b(2131693853);
    }
    this.jdField_a_of_type_Bfpc.b(2131693823);
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.a(new arrs(this, localarss));
    this.jdField_a_of_type_Bfpc.setOnCancelListener(new arrw(this, localarss));
    this.jdField_a_of_type_Bfpc.a(new arrx(this, bool, localarss));
    this.jdField_a_of_type_Bfpc.show();
    localarss.b(true);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bbgu != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131696161).setNegativeButton(2131690596, new arrz(this)).setPositiveButton(2131696165, new arry(this));
    this.jdField_a_of_type_Bbgu.setTitle(2131696163);
    this.jdField_a_of_type_Bbgu.setCancelable(false);
    this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbgu.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bfpc != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bfpc = bfpc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bfpc.b(2131717278);
    this.jdField_a_of_type_Bfpc.a(2131693870, 3);
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.a(new arsa(this, localListenTogetherManager));
    this.jdField_a_of_type_Bfpc.setOnDismissListener(new arsb(this));
    this.jdField_a_of_type_Bfpc.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bbgu != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    arss localarss = localListenTogetherManager.a();
    this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690596, new arsd(this, localListenTogetherManager, localarss)).setPositiveButton(2131693869, new arsc(this, localListenTogetherManager, localarss));
    this.jdField_a_of_type_Bbgu.setTitle(2131693827);
    this.jdField_a_of_type_Bbgu.setOnDismissListener(new arrt(this, localListenTogetherManager, localarss));
    this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbgu.show();
    localarss.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bbgu != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    arss localarss;
    bbgu localbbgu;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localarss = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localbbgu = bbdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693829;
      label62:
      this.jdField_a_of_type_Bbgu = localbbgu.setMessage(j).setNegativeButton(2131720715, new arru(this));
      localbbgu = this.jdField_a_of_type_Bbgu;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693831;; i = 2131693830)
    {
      localbbgu.setTitle(i);
      this.jdField_a_of_type_Bbgu.setOnDismissListener(new arrv(this, localarss));
      this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bbgu.show();
      localarss.b(true);
      return;
      i = 0;
      break;
      j = 2131693828;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment
 * JD-Core Version:    0.7.0.1
 */