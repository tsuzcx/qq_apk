package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import anzj;
import axfy;
import axgj;
import axif;
import axig;
import axih;
import axjn;
import bhlq;
import bhpc;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
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
    if ((getActivity() != null) && (this.jdField_a_of_type_Axfz != null)) {
      getActivity().addObserver(this.jdField_a_of_type_Axfz);
    }
  }
  
  private void o()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_Axfz != null)) {
      getActivity().removeObserver(this.jdField_a_of_type_Axfz);
    }
  }
  
  protected void a()
  {
    super.a();
    n();
  }
  
  public void aG_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = anzj.a(2131705819);
      String str1 = anzj.a(2131705805);
      this.jdField_b_of_type_Int = axfy.a().a();
      if (this.jdField_b_of_type_Int == 2) {
        localObject = anzj.a(2131705801);
      }
      if (this.jdField_b_of_type_Int == 2) {
        str1 = anzj.a(2131705807);
      }
      String str2 = anzj.a(2131705815);
      if (this.jdField_b_of_type_Int == 1) {
        str2 = anzj.a(2131705802);
      }
      localObject = bhlq.a(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131690398), str1, new axig(this), new axih(this));
    } while (localFragmentActivity.isFinishing());
    ((bhpc)localObject).show();
  }
  
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131690388));
    if (axfy.a().a() == 2) {
      setTitle(getActivity().getString(2131690385));
    }
  }
  
  protected void c()
  {
    super.c();
    axjn.a("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.e) });
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
        if (!axgj.c) {
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
    String str2 = anzj.a(2131705800);
    this.jdField_b_of_type_Int = axfy.a().a();
    String str1 = anzj.a(2131705816);
    if (this.jdField_b_of_type_Int == 1) {
      str1 = anzj.a(2131705806);
    }
    bhlq.a(localFragmentActivity, 0, null, str1, null, str2, new axif(this), null).show();
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
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "onDestroyView topage = " + this.jdField_a_of_type_Int + ", bizType = " + axfy.a().a() + ", sIsShouQiBtnClick = " + axgj.a);
    }
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */