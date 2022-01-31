package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import aqvv;
import aqwa;
import aqwb;
import aqwc;
import aqwd;
import aqwe;
import aqwf;
import aqwg;
import aqwh;
import aqwi;
import aqwj;
import aqwk;
import aqwl;
import aqxa;
import awqx;
import babr;
import bafb;
import begr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bafb jdField_a_of_type_Bafb;
  private begr jdField_a_of_type_Begr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_Begr != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    aqxa localaqxa = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    this.jdField_a_of_type_Begr = begr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    boolean bool = aqvv.a();
    if (bool) {
      this.jdField_a_of_type_Begr.b(2131628211);
    }
    this.jdField_a_of_type_Begr.b(2131628181);
    this.jdField_a_of_type_Begr.c(2131625035);
    this.jdField_a_of_type_Begr.a(new aqwa(this, localaqxa));
    this.jdField_a_of_type_Begr.setOnCancelListener(new aqwe(this, localaqxa));
    this.jdField_a_of_type_Begr.a(new aqwf(this, bool, localaqxa));
    this.jdField_a_of_type_Begr.show();
    localaqxa.b(true);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(2131630460).setNegativeButton(2131625035, new aqwh(this)).setPositiveButton(2131630464, new aqwg(this));
    this.jdField_a_of_type_Bafb.setTitle(2131630462);
    this.jdField_a_of_type_Bafb.setCancelable(false);
    this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bafb.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Begr != null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Begr = begr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Begr.b(2131651475);
    this.jdField_a_of_type_Begr.a(2131628228, 3);
    this.jdField_a_of_type_Begr.c(2131625035);
    this.jdField_a_of_type_Begr.a(new aqwi(this, localListenTogetherManager));
    this.jdField_a_of_type_Begr.setOnDismissListener(new aqwj(this));
    this.jdField_a_of_type_Begr.show();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    aqxa localaqxa = localListenTogetherManager.a();
    this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setNegativeButton(2131625035, new aqwl(this, localListenTogetherManager, localaqxa)).setPositiveButton(2131628227, new aqwk(this, localListenTogetherManager, localaqxa));
    this.jdField_a_of_type_Bafb.setTitle(2131628185);
    this.jdField_a_of_type_Bafb.setOnDismissListener(new aqwb(this, localListenTogetherManager, localaqxa));
    this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bafb.show();
    localaqxa.b(true);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    aqxa localaqxa;
    bafb localbafb;
    int j;
    if (this.jdField_b_of_type_Int == 1)
    {
      i = 1;
      localaqxa = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localbafb = babr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131628187;
      label62:
      this.jdField_a_of_type_Bafb = localbafb.setMessage(j).setNegativeButton(2131654806, new aqwc(this));
      localbafb = this.jdField_a_of_type_Bafb;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131628189;; i = 2131628188)
    {
      localbafb.setTitle(i);
      this.jdField_a_of_type_Bafb.setOnDismissListener(new aqwd(this, localaqxa));
      this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bafb.show();
      localaqxa.b(true);
      return;
      i = 0;
      break;
      j = 2131628186;
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