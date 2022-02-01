package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
  protected int a;
  protected DialogInterface.OnClickListener a;
  protected Bundle a;
  protected Handler a;
  private OpenIdObserver jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new TroopAbilityPreVerificationFragment.2(this);
  protected BaseActivity a;
  protected QQAppInterface a;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  protected String a;
  protected String b;
  protected String c = "";
  protected String d = "";
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
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBundleExtra("key_params");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject == null)
    {
      QLog.i("TroopAbility.PreVerification", 1, "doOnCreate params is null.");
      return false;
    }
    this.c = ((Bundle)localObject).getString("appid");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    this.g = this.jdField_a_of_type_AndroidOsBundle.getString("organization_id");
    this.d = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    this.e = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_sig");
    this.f = this.jdField_a_of_type_AndroidOsBundle.getString("sdk_version");
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    try
    {
      Integer.valueOf(this.c);
      Integer.valueOf(this.g);
      return true;
    }
    catch (Exception localException) {}
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", openId: ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", return.");
    QLog.d("TroopAbility.PreVerification", 1, ((StringBuilder)localObject).toString());
    return false;
    return false;
  }
  
  private void e()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getBaseActivity(), 230);
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new TroopAbilityPreVerificationFragment.1(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695206);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131714919), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131714915), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void f()
  {
    OpenID localOpenID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(this.c);
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
    {
      if (!this.jdField_b_of_type_JavaLangString.equals(localOpenID.openID))
      {
        QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
        e();
        return;
      }
      c();
      QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, mOpenId.equals(openId.openID)");
      return;
    }
    b(HardCodeUtil.a(2131714914));
    GetOpenID.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler(), this.c);
    QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, get openId from server.");
  }
  
  private void g()
  {
    if ((NetConnInfoCenter.getServerTime() - jdField_a_of_type_Long < jdField_b_of_type_Long) && (jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("use case receive api_groups:");
      ((StringBuilder)localObject1).append(jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody.get_privilege_rsp.api_groups.get());
      ((StringBuilder)localObject1).append(", api_names:");
      ((StringBuilder)localObject1).append(jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody.get_privilege_rsp.api_names.get());
      QLog.d("TroopAbility.PreVerification", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new HashSet();
      localObject2 = jdField_a_of_type_TencentImOidbOidb_0xb60$RspBody.get_privilege_rsp.api_groups.get().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Set)localObject1).add((Integer)((Iterator)localObject2).next());
      }
      boolean bool = a((Set)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("use cache check permission result:");
      ((StringBuilder)localObject1).append(bool);
      QLog.i("TroopAbility.PreVerification", 1, ((StringBuilder)localObject1).toString());
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
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("send type=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append(", appid=");
    ((StringBuilder)localObject2).append(this.c);
    QLog.i("TroopAbility.PreVerification", 1, ((StringBuilder)localObject2).toString());
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new TroopAbilityPreVerificationFragment.4(this), ((oidb_0xb60.ReqBody)localObject1).toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(getBaseActivity(), 1, paramString, 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract boolean a(Set<Integer> paramSet);
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
  }
  
  protected void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
    }
    d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    if (getBaseActivity().isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  protected void c()
  {
    b(HardCodeUtil.a(2131714917));
    g();
  }
  
  protected void c(String paramString)
  {
    d();
    a(paramString);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopAbilityPreVerificationFragment.3(this), 2000L);
  }
  
  protected void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (getBaseActivity().isResume())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    a();
    if (!a())
    {
      a(HardCodeUtil.a(2131714909));
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
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */