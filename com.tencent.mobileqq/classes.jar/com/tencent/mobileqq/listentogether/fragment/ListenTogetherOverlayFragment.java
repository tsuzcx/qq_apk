package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import arrl;
import arrq;
import arrr;
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
import arsq;
import axqw;
import bbcv;
import bbgg;
import bfol;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bbgg jdField_a_of_type_Bbgg;
  private bfol jdField_a_of_type_Bfol;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bfol != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    arsq localarsq = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Bfol = bfol.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = arrl.a();
    if (bool) {
      this.jdField_a_of_type_Bfol.b(2131693852);
    }
    this.jdField_a_of_type_Bfol.b(2131693822);
    this.jdField_a_of_type_Bfol.c(2131690596);
    this.jdField_a_of_type_Bfol.a(new arrq(this, localarsq));
    this.jdField_a_of_type_Bfol.setOnCancelListener(new arru(this, localarsq));
    this.jdField_a_of_type_Bfol.a(new arrv(this, bool, localarsq));
    this.jdField_a_of_type_Bfol.show();
    localarsq.b(true);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bbgg != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131696160).setNegativeButton(2131690596, new arrx(this)).setPositiveButton(2131696164, new arrw(this));
    this.jdField_a_of_type_Bbgg.setTitle(2131696162);
    this.jdField_a_of_type_Bbgg.setCancelable(false);
    this.jdField_a_of_type_Bbgg.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbgg.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bfol != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bfol = bfol.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bfol.b(2131717267);
    this.jdField_a_of_type_Bfol.a(2131693869, 3);
    this.jdField_a_of_type_Bfol.c(2131690596);
    this.jdField_a_of_type_Bfol.a(new arry(this, localListenTogetherManager));
    this.jdField_a_of_type_Bfol.setOnDismissListener(new arrz(this));
    this.jdField_a_of_type_Bfol.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bbgg != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    arsq localarsq = localListenTogetherManager.a();
    this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690596, new arsb(this, localListenTogetherManager, localarsq)).setPositiveButton(2131693868, new arsa(this, localListenTogetherManager, localarsq));
    this.jdField_a_of_type_Bbgg.setTitle(2131693826);
    this.jdField_a_of_type_Bbgg.setOnDismissListener(new arrr(this, localListenTogetherManager, localarsq));
    this.jdField_a_of_type_Bbgg.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbgg.show();
    localarsq.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bbgg != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    arsq localarsq;
    bbgg localbbgg;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localarsq = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localbbgg = bbcv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693828;
      label62:
      this.jdField_a_of_type_Bbgg = localbbgg.setMessage(j).setNegativeButton(2131720704, new arrs(this));
      localbbgg = this.jdField_a_of_type_Bbgg;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693830;; i = 2131693829)
    {
      localbbgg.setTitle(i);
      this.jdField_a_of_type_Bbgg.setOnDismissListener(new arrt(this, localarsq));
      this.jdField_a_of_type_Bbgg.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bbgg.show();
      localarsq.b(true);
      return;
      i = 0;
      break;
      j = 2131693827;
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