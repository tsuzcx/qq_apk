package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BindGroupFragment
  extends PublicBaseFragment
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private ListView e;
  private Bundle f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private QQProgressDialog m;
  private BindGroupAdapter n;
  private QQAppInterface o;
  private BaseActivity p;
  private View q;
  private List<TroopInfo> r = new ArrayList();
  private TroopObserver s = new BindGroupFragment.5(this);
  private int t = -1;
  
  private int a()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  private void a(String paramString)
  {
    QQToast.makeText(this.p, 1, paramString, 0).show(a());
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterAIO, troopUin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" action: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject).toString());
    localObject = AIOUtils.a(new Intent(this.p, SplashActivity.class), new int[] { 2 });
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", 1);
    ((Intent)localObject).putExtra("fromThirdAppByOpenSDK", true);
    ((Intent)localObject).putExtra("action", paramInt);
    ((Intent)localObject).putExtra("appid", this.j);
    ((Intent)localObject).putExtra("app_name", this.g);
    ((Intent)localObject).putExtra("pkg_name", this.k);
    startActivity((Intent)localObject);
  }
  
  private void a(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.p, 230);
    paramString2 = new BindGroupFragment.4(this, paramString2);
    localQQCustomDialog.setMessage(paramString1);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131899350), paramString2);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131899340), paramString2);
    localQQCustomDialog.show();
  }
  
  private void b()
  {
    QQProgressDialog localQQProgressDialog = this.m;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (this.p.isResume())) {
      this.m.dismiss();
    }
  }
  
  private void b(String paramString)
  {
    QQToast.makeText(this.p, 2, paramString, 0).show(a());
  }
  
  private void c(String paramString)
  {
    if (this.m == null) {
      this.m = new QQProgressDialog(this.p, a());
    }
    b();
    this.m.a(paramString);
    if (this.p.isResume()) {
      this.m.show();
    }
  }
  
  private boolean c()
  {
    this.f = this.p.getIntent().getBundleExtra("key_params");
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.i("TroopAbility.BindGroup.Fragment", 1, "doOnCreate params is null.");
      return false;
    }
    this.j = ((Bundle)localObject).getString("appid");
    this.i = this.f.getString("openid");
    this.g = this.f.getString("app_name");
    this.h = this.f.getString("organization_name");
    this.l = this.f.getString("organization_id");
    this.k = this.f.getString("pkg_name");
    if ((!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.i))) {}
    try
    {
      Integer.valueOf(this.j);
      return true;
    }
    catch (Exception localException) {}
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId: ");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append(", openId: ");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(", return.");
    QLog.d("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject).toString());
    return false;
    return false;
  }
  
  private void d()
  {
    this.a = ((TextView)this.q.findViewById(2131436180));
    this.b = ((TextView)this.q.findViewById(2131436182));
    this.c = ((TextView)this.q.findViewById(2131436211));
    this.d = ((TextView)this.q.findViewById(2131436227));
    this.e = ((ListView)this.q.findViewById(2131437788));
    this.a.setVisibility(0);
    this.a.setText(this.g);
    this.a.setOnClickListener(new BindGroupFragment.1(this));
    this.b.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setText(getResources().getString(2131887563));
    Object localObject = new TextView(this.p);
    ((TextView)localObject).setText(HardCodeUtil.a(2131899344));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setTextColor(getResources().getColor(2131168122));
    ((TextView)localObject).setPadding(AIOUtils.b(16.0F, getResources()), AIOUtils.b(16.0F, getResources()), 0, AIOUtils.b(8.0F, getResources()));
    this.e.addHeaderView((View)localObject);
    localObject = LayoutInflater.from(this.p).inflate(2131625994, null);
    this.e.addHeaderView((View)localObject);
    this.n = new BindGroupAdapter(this.p, this.o, this.e, 4, true);
    this.e.setAdapter(this.n);
    this.r.addAll(g());
    this.n.a(this.r);
    ((View)localObject).setOnClickListener(new BindGroupFragment.2(this));
    this.e.setOnItemClickListener(new BindGroupFragment.3(this));
  }
  
  private void e()
  {
    this.o.addObserver(this.s);
  }
  
  private void f()
  {
    this.o.removeObserver(this.s);
  }
  
  private List<TroopInfo> g()
  {
    Object localObject2 = new ArrayList(((TroopManager)this.o.getManager(QQManagerFactory.TROOP_MANAGER)).h());
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.o.getCurrentUin();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
      if (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) || ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(localObject1)))) {
        localArrayList.add(localTroopInfo);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getCreateTroopList list size: ");
    ((StringBuilder)localObject1).append(localArrayList.size());
    QLog.i("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject1).toString());
    return localArrayList;
  }
  
  private void h()
  {
    int i2 = this.r.size();
    Object localObject = new ArrayList();
    boolean bool = false;
    int i1 = 0;
    for (;;)
    {
      int i3 = this.t + 1;
      this.t = i3;
      if ((i3 >= i2) || (i1 > 100)) {
        break;
      }
      ((List)localObject).add(this.r.get(this.t));
      i1 += 1;
    }
    if (this.t == i2) {
      bool = true;
    }
    ((ITroopTokenHandler)this.o.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).a((List)localObject, bool);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTroopProfilePageByPage isLastPage: ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, ((StringBuilder)localObject).toString());
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("TroopAbility.BindGroup.Fragment", 1, "onCreateView.");
    this.o = getBaseActivity().app;
    this.p = getBaseActivity();
    this.q = paramLayoutInflater.inflate(2131625992, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.q.setFitsSystemWindows(true);
      this.q.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    if (!c())
    {
      this.p.finish();
      paramLayoutInflater = this.q;
    }
    else
    {
      d();
      e();
      c(HardCodeUtil.a(2131899347));
      h();
      paramLayoutInflater = this.q;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    f();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnNewIntent intent is null: ");
    boolean bool;
    if (paramIntent == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.i("TroopAbility.BindGroup.Fragment", 1, localStringBuilder.toString());
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      int i1 = paramIntent.getIntExtra("action", 0);
      paramIntent = paramIntent.getStringExtra("troop_uin");
      if (i1 == 2)
      {
        a(paramIntent, 2);
        this.p.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment
 * JD-Core Version:    0.7.0.1
 */