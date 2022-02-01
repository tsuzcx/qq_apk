package com.tencent.mobileqq.guild.open;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.AppInfo;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class GuildOpenVerifyFragment
  extends QPublicBaseFragment
  implements IGuildFeatureConstants
{
  protected QQAppInterface a;
  protected QBaseActivity b;
  protected QQProgressDialog c;
  protected QQCustomDialog d;
  protected DialogInterface.OnClickListener e;
  private boolean f = false;
  private boolean g = true;
  private Bundle h;
  private QQGuildOpenData i;
  private AppInfo j;
  
  private void a(AppInfo paramAppInfo, boolean paramBoolean)
  {
    QLog.d("QQGuildOpenVerifyFragment", 1, new Object[] { "checkAccount isSame:", Boolean.valueOf(paramBoolean) });
    this.j = paramAppInfo;
    if (paramBoolean)
    {
      c();
      return;
    }
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.d("QQGuildOpenVerifyFragment", 1, new Object[] { "checkOpenIdAndScheme isCreate:", Boolean.valueOf(paramBoolean) });
    a(HardCodeUtil.a(2131899050));
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getMsgHandler().a(true, this.i.openId, false, 0L, this.i.appId, 1, 2005, this.i.packageId, true, ForwardShareByServerHelper.d(), this.i.rawUrl, new GuildOpenVerifyFragment.1(this));
  }
  
  private boolean b()
  {
    this.h = this.b.getIntent().getBundleExtra("key_params");
    Object localObject = this.h;
    if (localObject == null)
    {
      QLog.i("QQGuildOpenVerifyFragment", 1, "doOnCreate params is null.");
      return false;
    }
    this.f = "create".equals(((Bundle)localObject).getString("extra_action"));
    localObject = this.h.getString("force_account_equal");
    boolean bool;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"1".equals(localObject))) {
      bool = false;
    } else {
      bool = true;
    }
    this.g = bool;
    this.i = new QQGuildOpenData();
    this.i.rawUrl = this.h.getString("extra_raw_url");
    this.i.appId = ForwardUtils.a(this.h.getString("appid"));
    this.i.appName = this.h.getString("app_name");
    this.i.openId = this.h.getString("openid");
    this.i.packageId = this.h.getString("package_id");
    this.i.guildOpenId = this.h.getString("guild_openid");
    this.i.orgId = this.h.getString("guild_id");
    this.i.worldId = this.h.getString("zone_id");
    this.i.isFromSDK = "1".equals(this.h.getString("from_open_sdk"));
    if ((this.i.appId > 0L) && (!TextUtils.isEmpty(this.i.openId))) {
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId: ");
    ((StringBuilder)localObject).append(this.i.appId);
    ((StringBuilder)localObject).append(", openId: ");
    ((StringBuilder)localObject).append(this.i.openId);
    ((StringBuilder)localObject).append(", return.");
    QLog.d("QQGuildOpenVerifyFragment", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private void c()
  {
    if (this.f)
    {
      ((IGuildOpenApi)this.a.getRuntimeService(IGuildOpenApi.class, "")).gotoGuildOpenCreateAction(getQBaseActivity(), this.j.e(), this.j.i(), this.i);
      return;
    }
    ((IGuildOpenApi)this.a.getRuntimeService(IGuildOpenApi.class, "")).gotoGuildOpenAddAction(getQBaseActivity(), this.j.e(), this.j.i(), this.i);
  }
  
  private void d()
  {
    QQCustomDialog localQQCustomDialog = this.d;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()))
    {
      this.d.show();
      return;
    }
    if (this.d == null)
    {
      this.d = DialogUtil.a(getQBaseActivity(), 230);
      this.e = new GuildOpenVerifyFragment.2(this);
    }
    int k;
    if (this.g) {
      k = 2131892940;
    } else {
      k = 2131892939;
    }
    this.d.setMessage(k);
    this.d.setTitle(2131889094);
    this.d.setNegativeButton(getString(2131887648), this.e);
    if (this.g) {
      k = 2131887702;
    } else {
      k = 2131888568;
    }
    this.d.setPositiveButton(getString(k), this.e);
    this.d.show();
  }
  
  protected void a()
  {
    QQProgressDialog localQQProgressDialog = this.c;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.c.dismiss();
    }
  }
  
  protected void a(String paramString)
  {
    if (this.c == null)
    {
      this.c = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
      this.c.a(new GuildOpenVerifyFragment.3(this));
    }
    a();
    this.c.a(paramString);
    this.c.show();
  }
  
  protected void b(String paramString)
  {
    QQToast.makeText(getQBaseActivity(), 1, paramString, 0).show(getQBaseActivity().getTitleBarHeight());
    this.b.finish();
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
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = ((QQAppInterface)getQBaseActivity().getAppRuntime());
    this.b = getQBaseActivity();
    if (!b())
    {
      b("参数错误。");
      return;
    }
    a(this.f);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    localQBaseActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.open.GuildOpenVerifyFragment
 * JD-Core Version:    0.7.0.1
 */