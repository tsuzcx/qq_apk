package com.tencent.mobileqq.msgbackup.fragment;

import ajya;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import askv;
import aslg;
import asnc;
import asnd;
import asne;
import asoi;
import bbdj;
import bbgu;
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
    if ((getActivity() != null) && (this.jdField_a_of_type_Askw != null)) {
      getActivity().addObserver(this.jdField_a_of_type_Askw);
    }
  }
  
  private void o()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_Askw != null)) {
      getActivity().removeObserver(this.jdField_a_of_type_Askw);
    }
  }
  
  protected void a()
  {
    super.a();
    n();
  }
  
  public void aK_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = ajya.a(2131706937);
      String str1 = ajya.a(2131706923);
      this.jdField_b_of_type_Int = askv.a().a();
      if (this.jdField_b_of_type_Int == 2) {
        localObject = ajya.a(2131706919);
      }
      if (this.jdField_b_of_type_Int == 2) {
        str1 = ajya.a(2131706925);
      }
      String str2 = ajya.a(2131706933);
      if (this.jdField_b_of_type_Int == 1) {
        str2 = ajya.a(2131706920);
      }
      localObject = bbdj.a(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131690347), str1, new asnd(this), new asne(this));
    } while (localFragmentActivity.isFinishing());
    ((bbgu)localObject).show();
  }
  
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131690337));
    if (askv.a().a() == 2) {
      setTitle(getActivity().getString(2131690334));
    }
  }
  
  protected void c()
  {
    super.c();
    asoi.a("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.e) });
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
        if (!aslg.c) {
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
    String str2 = ajya.a(2131706918);
    this.jdField_b_of_type_Int = askv.a().a();
    String str1 = ajya.a(2131706934);
    if (this.jdField_b_of_type_Int == 1) {
      str1 = ajya.a(2131706924);
    }
    bbdj.a(localFragmentActivity, 0, null, str1, null, str2, new asnc(this), null).show();
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
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "onDestroyView topage = " + this.jdField_a_of_type_Int + ", bizType = " + askv.a().a() + ", sIsShouQiBtnClick = " + aslg.a);
    }
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */