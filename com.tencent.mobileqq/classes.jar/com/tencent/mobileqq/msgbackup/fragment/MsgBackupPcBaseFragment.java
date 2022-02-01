package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import anvx;
import awzh;
import awzs;
import axbo;
import axbp;
import axbq;
import axcw;
import bhdj;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupPcBaseFragment
  extends MsgBackupBaseFragment
{
  public String a;
  public boolean e;
  public boolean f;
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_start", 5);
    localIntent.putExtra("BIZ_TYPE", paramInt);
    PublicFragmentActivity.a(paramContext, localIntent, MsgBackupPCTransportFragment.class);
  }
  
  private void n()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_Awzi != null)) {
      getActivity().addObserver(this.jdField_a_of_type_Awzi);
    }
  }
  
  private void o()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_Awzi != null)) {
      getActivity().removeObserver(this.jdField_a_of_type_Awzi);
    }
  }
  
  protected void a()
  {
    super.a();
    n();
  }
  
  public void ax_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = anvx.a(2131706401);
      String str1 = anvx.a(2131706387);
      this.jdField_b_of_type_Int = awzh.a().a();
      if (this.jdField_b_of_type_Int == 2) {
        localObject = anvx.a(2131706383);
      }
      if (this.jdField_b_of_type_Int == 2) {
        str1 = anvx.a(2131706389);
      }
      String str2 = anvx.a(2131706397);
      if (this.jdField_b_of_type_Int == 1) {
        str2 = anvx.a(2131706384);
      }
      localObject = bhdj.a(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131690513), str1, new axbp(this), new axbq(this));
    } while (localFragmentActivity.isFinishing());
    ((QQCustomDialog)localObject).show();
  }
  
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131690503));
    if (awzh.a().a() == 2) {
      setTitle(getActivity().getString(2131690500));
    }
  }
  
  protected void c()
  {
    super.c();
    axcw.a("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.e) });
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    boolean bool2 = true;
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        this.jdField_a_of_type_Int = paramActivity.getIntExtra("param_start", -1);
        this.jdField_b_of_type_Int = paramActivity.getIntExtra("BIZ_TYPE", 1);
        this.jdField_a_of_type_JavaLangString = paramActivity.getStringExtra("0x11bpush_extra");
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "toPage = " + this.jdField_a_of_type_Int + "; mBizType = " + this.jdField_b_of_type_Int);
        }
      }
      bool1 = bool2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        if (!awzs.c) {
          break label124;
        }
      }
    }
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.e = bool1;
      return;
    }
  }
  
  public void l()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    String str2 = anvx.a(2131706382);
    this.jdField_b_of_type_Int = awzh.a().a();
    String str1 = anvx.a(2131706398);
    if (this.jdField_b_of_type_Int == 1) {
      str1 = anvx.a(2131706388);
    }
    bhdj.a(localFragmentActivity, 0, null, str1, null, str2, new axbo(this), null).show();
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_Int == 1) {
      MsgBackupCompleteFragment.a(getActivity(), this.c, this.d, this.e);
    }
    while (this.jdField_b_of_type_Int != 2) {
      return;
    }
    MsgBackupCompleteFragment.i(getActivity(), this.c, this.d);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "onDestroyView topage = " + this.jdField_a_of_type_Int + ", bizType = " + awzh.a().a() + ", sIsShouQiBtnClick = " + awzs.a);
    }
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */