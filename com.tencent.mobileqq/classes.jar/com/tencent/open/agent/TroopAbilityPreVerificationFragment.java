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
  private static long p;
  private static long q;
  private static oidb_0xb60.RspBody r;
  protected QQAppInterface a;
  protected BaseActivity b;
  protected QQProgressDialog c;
  protected Handler d = new Handler();
  protected Bundle e;
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  protected String l = "";
  protected int m = 1;
  protected QQCustomDialog n;
  protected DialogInterface.OnClickListener o;
  private OpenIdObserver s = new TroopAbilityPreVerificationFragment.2(this);
  
  private boolean e()
  {
    this.e = this.b.getIntent().getBundleExtra("key_params");
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.i("TroopAbility.PreVerification", 1, "doOnCreate params is null.");
      return false;
    }
    this.h = ((Bundle)localObject).getString("appid");
    this.g = this.e.getString("openid");
    this.f = this.e.getString("app_name");
    this.l = this.e.getString("organization_id");
    this.i = this.e.getString("pkg_name");
    this.j = this.e.getString("pkg_sig");
    this.k = this.e.getString("sdk_version");
    if ((!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.g))) {}
    try
    {
      Integer.valueOf(this.h);
      Integer.valueOf(this.l);
      return true;
    }
    catch (Exception localException) {}
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId: ");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(", openId: ");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(", return.");
    QLog.d("TroopAbility.PreVerification", 1, ((StringBuilder)localObject).toString());
    return false;
    return false;
  }
  
  private void f()
  {
    QQCustomDialog localQQCustomDialog = this.n;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()))
    {
      this.n.show();
      return;
    }
    if (this.n == null)
    {
      this.n = DialogUtil.a(getBaseActivity(), 230);
      this.o = new TroopAbilityPreVerificationFragment.1(this);
    }
    this.n.setMessage(2131892939);
    this.n.setTitle(2131889094);
    this.n.setNegativeButton(HardCodeUtil.a(2131898212), this.o);
    this.n.setPositiveButton(HardCodeUtil.a(2131912413), this.o);
    this.n.show();
  }
  
  private void g()
  {
    OpenID localOpenID = this.a.getMsgHandler().e(this.h);
    this.e.putString("uin", this.a.getCurrentAccountUin());
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
    {
      if (!this.g.equals(localOpenID.openID))
      {
        QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
        f();
        return;
      }
      c();
      QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, mOpenId.equals(openId.openID)");
      return;
    }
    b(HardCodeUtil.a(2131912412));
    GetOpenID.a(this.a.getMsgHandler(), this.h);
    QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, get openId from server.");
  }
  
  private void h()
  {
    if ((NetConnInfoCenter.getServerTime() - p < q) && (r != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("use case receive api_groups:");
      ((StringBuilder)localObject1).append(r.get_privilege_rsp.api_groups.get());
      ((StringBuilder)localObject1).append(", api_names:");
      ((StringBuilder)localObject1).append(r.get_privilege_rsp.api_names.get());
      QLog.d("TroopAbility.PreVerification", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new HashSet();
      localObject2 = r.get_privilege_rsp.api_groups.get().iterator();
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
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.appid.set(Integer.valueOf(this.h).intValue());
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.app_type.set(this.m);
    Object localObject2 = new oidb_0xb60.ClientInfo();
    ((oidb_0xb60.ClientInfo)localObject2).android_package_name.set(this.i);
    ((oidb_0xb60.ClientInfo)localObject2).android_signature.set(this.j);
    ((oidb_0xb60.ClientInfo)localObject2).sdk_version.set(this.k);
    ((oidb_0xb60.ClientInfo)localObject2).platform.set(1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("send type=");
    ((StringBuilder)localObject2).append(this.m);
    ((StringBuilder)localObject2).append(", appid=");
    ((StringBuilder)localObject2).append(this.h);
    QLog.i("TroopAbility.PreVerification", 1, ((StringBuilder)localObject2).toString());
    ProtoUtils.a(this.a, new TroopAbilityPreVerificationFragment.4(this), ((oidb_0xb60.ReqBody)localObject1).toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
  }
  
  protected void a()
  {
    this.a.addObserver(this.s);
  }
  
  protected void a(String paramString)
  {
    QQToast.makeText(getBaseActivity(), 1, paramString, 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract boolean a(Set<Integer> paramSet);
  
  protected void b()
  {
    this.a.removeObserver(this.s);
  }
  
  protected void b(String paramString)
  {
    if (this.c == null) {
      this.c = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
    }
    d();
    this.c.a(paramString);
    if (getBaseActivity().isResume()) {
      this.c.show();
    }
  }
  
  protected void c()
  {
    b(HardCodeUtil.a(2131912415));
    h();
  }
  
  protected void c(String paramString)
  {
    d();
    a(paramString);
    this.d.postDelayed(new TroopAbilityPreVerificationFragment.3(this), 2000L);
  }
  
  protected void d()
  {
    QQProgressDialog localQQProgressDialog = this.c;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (getBaseActivity().isResume())) {
      this.c.dismiss();
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
    this.a = getBaseActivity().app;
    this.b = getBaseActivity();
    a();
    if (!e())
    {
      a(HardCodeUtil.a(2131912407));
      return;
    }
    g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */