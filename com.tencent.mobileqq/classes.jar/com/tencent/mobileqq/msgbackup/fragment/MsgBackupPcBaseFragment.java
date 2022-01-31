package com.tencent.mobileqq.msgbackup.fragment;

import ajjy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import arop;
import arpa;
import arqw;
import arqx;
import arqy;
import arsc;
import babr;
import bafb;
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
    if ((getActivity() != null) && (this.jdField_a_of_type_Aroq != null)) {
      getActivity().addObserver(this.jdField_a_of_type_Aroq);
    }
  }
  
  private void o()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_Aroq != null)) {
      getActivity().removeObserver(this.jdField_a_of_type_Aroq);
    }
  }
  
  protected void a()
  {
    super.a();
    n();
  }
  
  public void aN_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = ajjy.a(2131641141);
      String str1 = ajjy.a(2131641127);
      this.jdField_b_of_type_Int = arop.a().a();
      if (this.jdField_b_of_type_Int == 2) {
        localObject = ajjy.a(2131641123);
      }
      if (this.jdField_b_of_type_Int == 2) {
        str1 = ajjy.a(2131641129);
      }
      String str2 = ajjy.a(2131641137);
      if (this.jdField_b_of_type_Int == 1) {
        str2 = ajjy.a(2131641124);
      }
      localObject = babr.a(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131624786), str1, new arqx(this), new arqy(this));
    } while (localFragmentActivity.isFinishing());
    ((bafb)localObject).show();
  }
  
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131624776));
    if (arop.a().a() == 2) {
      setTitle(getActivity().getString(2131624773));
    }
  }
  
  protected void c()
  {
    super.c();
    arsc.a("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.e) });
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
        if (!arpa.c) {
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
    String str2 = ajjy.a(2131641122);
    this.jdField_b_of_type_Int = arop.a().a();
    String str1 = ajjy.a(2131641138);
    if (this.jdField_b_of_type_Int == 1) {
      str1 = ajjy.a(2131641128);
    }
    babr.a(localFragmentActivity, 0, null, str1, null, str2, new arqw(this), null).show();
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
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "onDestroyView topage = " + this.jdField_a_of_type_Int + ", bizType = " + arop.a().a() + ", sIsShouQiBtnClick = " + arpa.a);
    }
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */