package com.tencent.mobileqq.msgbackup.fragment;

import alpo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import aubu;
import aucf;
import aueb;
import auec;
import aued;
import aufh;
import bdcd;
import bdfq;
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
    if ((getActivity() != null) && (this.jdField_a_of_type_Aubv != null)) {
      getActivity().addObserver(this.jdField_a_of_type_Aubv);
    }
  }
  
  private void o()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_Aubv != null)) {
      getActivity().removeObserver(this.jdField_a_of_type_Aubv);
    }
  }
  
  protected void a()
  {
    super.a();
    n();
  }
  
  public void aL_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = alpo.a(2131707309);
      String str1 = alpo.a(2131707295);
      this.jdField_b_of_type_Int = aubu.a().a();
      if (this.jdField_b_of_type_Int == 2) {
        localObject = alpo.a(2131707291);
      }
      if (this.jdField_b_of_type_Int == 2) {
        str1 = alpo.a(2131707297);
      }
      String str2 = alpo.a(2131707305);
      if (this.jdField_b_of_type_Int == 1) {
        str2 = alpo.a(2131707292);
      }
      localObject = bdcd.a(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131690398), str1, new auec(this), new aued(this));
    } while (localFragmentActivity.isFinishing());
    ((bdfq)localObject).show();
  }
  
  protected void b()
  {
    super.b();
    setTitle(getActivity().getString(2131690388));
    if (aubu.a().a() == 2) {
      setTitle(getActivity().getString(2131690385));
    }
  }
  
  protected void c()
  {
    super.c();
    aufh.a("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.e) });
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
        if (!aucf.c) {
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
    String str2 = alpo.a(2131707290);
    this.jdField_b_of_type_Int = aubu.a().a();
    String str1 = alpo.a(2131707306);
    if (this.jdField_b_of_type_Int == 1) {
      str1 = alpo.a(2131707296);
    }
    bdcd.a(localFragmentActivity, 0, null, str1, null, str2, new aueb(this), null).show();
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
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "onDestroyView topage = " + this.jdField_a_of_type_Int + ", bizType = " + aubu.a().a() + ", sIsShouQiBtnClick = " + aucf.a);
    }
    o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */