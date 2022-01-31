package com.tencent.open.agent;

import alpo;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import bdcd;
import bdfq;
import bepp;
import bfcy;
import bfcz;
import bfda;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mzy;
import ndm;
import tencent.im.oidb.oidb_0xb60.ClientInfo;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeReq;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp;
import tencent.im.oidb.oidb_0xb60.ReqBody;
import tencent.im.oidb.oidb_0xb60.RspBody;

public abstract class TroopAbilityPreVerificationFragment
  extends PublicBaseFragment
{
  private static long jdField_a_of_type_Long;
  private static oidb_0xb60.RspBody jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody;
  private static long b;
  public int a;
  protected DialogInterface.OnClickListener a;
  public Bundle a;
  protected Handler a;
  public FragmentActivity a;
  public bdfq a;
  protected bepp a;
  protected QQAppInterface a;
  public String a;
  private ndm jdField_a_of_type_Ndm = new bfcz(this);
  public String b;
  public String c = "";
  public String d = "";
  protected String e = "";
  protected String f = "";
  protected String g = "";
  
  public TroopAbilityPreVerificationFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      QLog.i("TroopAbility.PreVerification", 1, "doOnCreate params is null.");
      return false;
    }
    this.c = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    this.g = this.jdField_a_of_type_AndroidOsBundle.getString("organization_id");
    this.d = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    this.e = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_sig");
    this.f = this.jdField_a_of_type_AndroidOsBundle.getString("sdk_version");
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      QLog.d("TroopAbility.PreVerification", 1, "appId: " + this.c + ", openId: " + this.jdField_b_of_type_JavaLangString + ", return.");
      return false;
    }
    try
    {
      Integer.valueOf(this.c);
      Integer.valueOf(this.g);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (!this.jdField_a_of_type_Bdfq.isShowing()))
    {
      this.jdField_a_of_type_Bdfq.show();
      return;
    }
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = bdcd.a(getActivity(), 230);
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new bfcy(this);
    }
    this.jdField_a_of_type_Bdfq.setMessage(2131695720);
    this.jdField_a_of_type_Bdfq.setTitle(2131692310);
    this.jdField_a_of_type_Bdfq.setNegativeButton(alpo.a(2131715520), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_Bdfq.setPositiveButton(alpo.a(2131715516), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_Bdfq.show();
  }
  
  private void f()
  {
    OpenID localOpenID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.c);
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
    {
      b(alpo.a(2131715515));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.c);
      QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, get openId from server.");
      return;
    }
    if (!this.jdField_b_of_type_JavaLangString.equals(localOpenID.openID))
    {
      QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
      e();
      return;
    }
    c();
    QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, mOpenId.equals(openId.openID)");
  }
  
  private void g()
  {
    if ((NetConnInfoCenter.getServerTime() - jdField_a_of_type_Long < jdField_b_of_type_Long) && (jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody != null))
    {
      QLog.d("TroopAbility.PreVerification", 1, "use case receive api_groups:" + jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody.get_privilege_rsp.api_groups.get() + ", api_names:" + jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody.get_privilege_rsp.api_names.get());
      localObject1 = new HashSet();
      localObject2 = jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody.get_privilege_rsp.api_groups.get().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Set)localObject1).add((Integer)((Iterator)localObject2).next());
      }
      boolean bool = a((Set)localObject1);
      QLog.i("TroopAbility.PreVerification", 1, "use cache check permission result:" + bool);
      a(bool);
      return;
    }
    QLog.i("TroopAbility.PreVerification", 1, "getThirdAppPermissions.");
    Object localObject1 = new oidb_0xb60.ReqBody();
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.setHasFlag(true);
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.appid.set(Integer.valueOf(this.c).intValue());
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.app_type.set(this.jdField_a_of_type_Int);
    Object localObject2 = new oidb_0xb60.ClientInfo();
    ((oidb_0xb60.ClientInfo)localObject2).android_package_name.set(this.d);
    ((oidb_0xb60.ClientInfo)localObject2).android_signature.set(this.e);
    ((oidb_0xb60.ClientInfo)localObject2).sdk_version.set(this.f);
    ((oidb_0xb60.ClientInfo)localObject2).platform.set(1);
    QLog.i("TroopAbility.PreVerification", 1, "send type=" + this.jdField_a_of_type_Int + ", appid=" + this.c);
    mzy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bfda(this), ((oidb_0xb60.ReqBody)localObject1).toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ndm);
  }
  
  public void a(String paramString)
  {
    QQToast.a(getActivity(), 1, paramString, 0).b(getActivity().getTitleBarHeight());
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(Set<Integer> paramSet);
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ndm);
  }
  
  protected void b(String paramString)
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(getActivity(), getActivity().getTitleBarHeight());
    }
    d();
    this.jdField_a_of_type_Bepp.a(paramString);
    if (getActivity().isResume()) {
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  public void c()
  {
    b(alpo.a(2131715518));
    g();
  }
  
  public void c(String paramString)
  {
    d();
    a(paramString);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopAbilityPreVerificationFragment.3(this), 2000L);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing()) && (getActivity().isResume())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
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
    a();
    if (!a())
    {
      a(alpo.a(2131715510));
      return;
    }
    f();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */