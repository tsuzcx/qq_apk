package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import awml;
import awmq;
import awmr;
import awms;
import awmt;
import awmu;
import awmv;
import awmw;
import awmx;
import awmy;
import awmz;
import awna;
import awnb;
import awnq;
import bdll;
import bhlq;
import bhpc;
import blir;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bhpc jdField_a_of_type_Bhpc;
  private blir jdField_a_of_type_Blir;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Blir != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    awnq localawnq = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Blir = blir.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = awml.a();
    if (bool) {
      this.jdField_a_of_type_Blir.b(2131693286);
    }
    this.jdField_a_of_type_Blir.b(2131693265);
    this.jdField_a_of_type_Blir.c(2131690580);
    this.jdField_a_of_type_Blir.a(new awmq(this, localawnq));
    this.jdField_a_of_type_Blir.setOnCancelListener(new awmu(this, localawnq));
    this.jdField_a_of_type_Blir.a(new awmv(this, bool, localawnq));
    this.jdField_a_of_type_Blir.show();
    localawnq.b(true);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131695255).setNegativeButton(2131690580, new awmx(this)).setPositiveButton(2131695259, new awmw(this));
    this.jdField_a_of_type_Bhpc.setTitle(2131695257);
    this.jdField_a_of_type_Bhpc.setCancelable(false);
    this.jdField_a_of_type_Bhpc.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bhpc.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Blir != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Blir = blir.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Blir.b(2131715996);
    this.jdField_a_of_type_Blir.a(2131693299, 3);
    this.jdField_a_of_type_Blir.c(2131690580);
    this.jdField_a_of_type_Blir.a(new awmy(this, localListenTogetherManager));
    this.jdField_a_of_type_Blir.setOnDismissListener(new awmz(this));
    this.jdField_a_of_type_Blir.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    awnq localawnq = localListenTogetherManager.a();
    this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690580, new awnb(this, localListenTogetherManager, localawnq)).setPositiveButton(2131693298, new awna(this, localListenTogetherManager, localawnq));
    this.jdField_a_of_type_Bhpc.setTitle(2131693267);
    this.jdField_a_of_type_Bhpc.setOnDismissListener(new awmr(this, localListenTogetherManager, localawnq));
    this.jdField_a_of_type_Bhpc.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bhpc.show();
    localawnq.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    awnq localawnq;
    bhpc localbhpc;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localawnq = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localbhpc = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693269;
      label62:
      this.jdField_a_of_type_Bhpc = localbhpc.setMessage(j).setNegativeButton(2131719137, new awms(this));
      localbhpc = this.jdField_a_of_type_Bhpc;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693271;; i = 2131693270)
    {
      localbhpc.setTitle(i);
      this.jdField_a_of_type_Bhpc.setOnDismissListener(new awmt(this, localawnq));
      this.jdField_a_of_type_Bhpc.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bhpc.show();
      localawnq.b(true);
      return;
      i = 0;
      break;
      j = 2131693268;
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