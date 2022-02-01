package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import avtq;
import avtv;
import avtw;
import avtx;
import avty;
import avtz;
import avua;
import avub;
import avuc;
import avud;
import avue;
import avuf;
import avug;
import avuv;
import bcst;
import bglp;
import bgpa;
import bkho;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bgpa jdField_a_of_type_Bgpa;
  private bkho jdField_a_of_type_Bkho;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bkho != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    avuv localavuv = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Bkho = bkho.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = avtq.a();
    if (bool) {
      this.jdField_a_of_type_Bkho.b(2131693274);
    }
    this.jdField_a_of_type_Bkho.b(2131693253);
    this.jdField_a_of_type_Bkho.c(2131690582);
    this.jdField_a_of_type_Bkho.a(new avtv(this, localavuv));
    this.jdField_a_of_type_Bkho.setOnCancelListener(new avtz(this, localavuv));
    this.jdField_a_of_type_Bkho.a(new avua(this, bool, localavuv));
    this.jdField_a_of_type_Bkho.show();
    localavuv.b(true);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131695212).setNegativeButton(2131690582, new avuc(this)).setPositiveButton(2131695216, new avub(this));
    this.jdField_a_of_type_Bgpa.setTitle(2131695214);
    this.jdField_a_of_type_Bgpa.setCancelable(false);
    this.jdField_a_of_type_Bgpa.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bgpa.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bkho != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bkho = bkho.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Bkho.b(2131715887);
    this.jdField_a_of_type_Bkho.a(2131693287, 3);
    this.jdField_a_of_type_Bkho.c(2131690582);
    this.jdField_a_of_type_Bkho.a(new avud(this, localListenTogetherManager));
    this.jdField_a_of_type_Bkho.setOnDismissListener(new avue(this));
    this.jdField_a_of_type_Bkho.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    avuv localavuv = localListenTogetherManager.a();
    this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131690582, new avug(this, localListenTogetherManager, localavuv)).setPositiveButton(2131693286, new avuf(this, localListenTogetherManager, localavuv));
    this.jdField_a_of_type_Bgpa.setTitle(2131693255);
    this.jdField_a_of_type_Bgpa.setOnDismissListener(new avtw(this, localListenTogetherManager, localavuv));
    this.jdField_a_of_type_Bgpa.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bgpa.show();
    localavuv.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    avuv localavuv;
    bgpa localbgpa;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localavuv = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localbgpa = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131693257;
      label62:
      this.jdField_a_of_type_Bgpa = localbgpa.setMessage(j).setNegativeButton(2131718987, new avtx(this));
      localbgpa = this.jdField_a_of_type_Bgpa;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131693259;; i = 2131693258)
    {
      localbgpa.setTitle(i);
      this.jdField_a_of_type_Bgpa.setOnDismissListener(new avty(this, localavuv));
      this.jdField_a_of_type_Bgpa.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bgpa.show();
      localavuv.b(true);
      return;
      i = 0;
      break;
      j = 2131693256;
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