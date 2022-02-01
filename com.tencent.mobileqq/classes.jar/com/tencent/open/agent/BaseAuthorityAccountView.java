package com.tencent.open.agent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.StringAddition;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppActivity;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public abstract class BaseAuthorityAccountView
  extends LinearLayout
{
  protected SharedPreferences a;
  protected SharedPreferences.Editor b;
  protected Context c;
  protected WtloginManager d = null;
  protected AbstractOpenSdkAppInterface e;
  protected ArrayList<String> f;
  protected LinearLayout g;
  protected QQCustomDialog h = null;
  protected float i;
  protected float j;
  protected View k;
  protected View l;
  protected RelativeLayout m;
  protected LinearLayout n;
  protected ActionSheet o;
  protected BounceScrollView p;
  protected boolean q = false;
  
  public BaseAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    a();
  }
  
  private void a()
  {
    this.e = ((AbstractOpenSdkAppInterface)((AppActivity)this.c).getAppRuntime());
    this.d = ((WtloginManager)this.e.getManager(1));
    this.a = this.c.getSharedPreferences("accountList", 0);
    this.b = this.a.edit();
    if (!TextUtils.isEmpty(this.e.getAccount())) {
      SharedPrefs.b(this.e.getAccount());
    }
    Object localObject = SharedPrefs.c();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      SharedPrefs.b((String)localObject);
    }
    localObject = this.c.getResources().getDisplayMetrics();
    this.i = ((DisplayMetrics)localObject).widthPixels;
    this.j = ((DisplayMetrics)localObject).heightPixels;
  }
  
  private void c(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-->deleteAccount--account to delete is ");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { ((StringBuilder)localObject1).toString() });
    SharedPrefs.d(paramString);
    localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = AuthorityUtil.a((SharedPreferences)localObject1);
    Object localObject2 = new ArrayList();
    if (localObject1 != null)
    {
      int i2 = localObject1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        ((ArrayList)localObject2).add(localObject1[i1]);
        i1 += 1;
      }
    }
    while (((ArrayList)localObject2).contains("")) {
      ((ArrayList)localObject2).remove("");
    }
    if (((ArrayList)localObject2).contains(paramString))
    {
      ((ArrayList)localObject2).remove(paramString);
      localObject2 = ((ArrayList)localObject2).iterator();
      StringBuilder localStringBuilder;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = localStringBuilder.toString())
      {
        String str = (String)((Iterator)localObject2).next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(",");
        localStringBuilder.append(str);
      }
      this.b.putString("accList", (String)localObject1);
      this.b.commit();
    }
    if (paramString.equals(this.a.getString("last_account", "")))
    {
      SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->deleteAccount--account to delete equals last account, clear last account" });
      this.b.remove("last_account").commit();
    }
    paramString = new File(OpenSdkVirtualUtil.b(OpenSdkVirtualUtil.a(this.d, paramString)));
    if (!paramString.exists()) {
      paramString.delete();
    }
  }
  
  private int getMaxListHeight()
  {
    float f1 = DisplayUtil.a(this.c, 72.0F);
    double d1 = this.j;
    Double.isNaN(d1);
    d1 = d1 * 2.0D / 3.0D;
    double d2 = f1;
    Double.isNaN(d2);
    f1 = ((int)(d1 / d2) - 2) * f1 + f1 / 2.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->getMaxListHeight maxHeight = ");
    localStringBuilder.append(f1);
    SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
    return (int)f1;
  }
  
  protected void a(String paramString)
  {
    Object localObject1 = new WloginSimpleInfo();
    this.d.getBasicUserInfo(paramString, (WloginSimpleInfo)localObject1);
    Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    localObject2 = this.k;
    if (localObject2 != null)
    {
      localObject2 = (ImageView)((View)localObject2).findViewById(2131428883);
      ((TextView)this.k.findViewById(2131428884)).setText(StringAddition.a((String)localObject1, 12, true));
      a(paramString, (ImageView)localObject2);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("当前帐号：");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { ((StringBuilder)localObject1).toString() });
  }
  
  protected void a(String paramString, ImageView paramImageView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->updateAccountFace uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
    ThreadManager.executeOnSubThread(new BaseAuthorityAccountView.5(this, paramString, paramImageView));
  }
  
  abstract boolean a(String paramString, boolean paramBoolean);
  
  protected void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->showAccountConfirm uin = ");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { ((StringBuilder)localObject).toString() });
    this.h = DialogUtil.a(this.c, 230);
    this.h.setContentView(2131624587);
    this.h.setTitle(getResources().getString(2131896587));
    this.h.setMessageTextSize(18.0F);
    localObject = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("?");
    ((QQCustomDialog)localObject).setMessage(localStringBuilder.toString());
    paramString = new BaseAuthorityAccountView.6(this, paramString);
    this.h.setNegativeButton(2131897864, paramString);
    this.h.setPositiveButton(2131897865, paramString);
    this.h.show();
  }
  
  abstract boolean b();
  
  protected void c()
  {
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->initBaseUI" });
    this.l = LayoutInflater.from(this.c).inflate(getAccountListContainerLayoutId(), null);
    this.m = ((RelativeLayout)this.l.findViewById(2131428886));
    this.n = ((LinearLayout)this.l.findViewById(2131427421));
    this.g = new LinearLayout(this.c);
    this.g.setOrientation(1);
    this.n.addView(this.g);
    h();
    i();
  }
  
  protected void d()
  {
    this.o = AuthUIUtil.a(getContext(), null);
    this.o.setActionContentView(this.l, null);
    Object localObject = this.o.getRootView();
    if ((localObject instanceof DispatchActionMoveScrollView)) {
      ((DispatchActionMoveScrollView)localObject).a = true;
    }
    localObject = this.o.getActionContentView();
    ((RelativeLayout)localObject).addOnLayoutChangeListener(new BaseAuthorityAccountView.1(this, (RelativeLayout)localObject));
    this.p = ((BounceScrollView)this.l.findViewById(2131427459));
    this.p.setMaxHeight(getMaxListHeight());
  }
  
  public void e()
  {
    if (this.o == null) {
      d();
    }
    if (!this.o.isShowing()) {
      this.o.show();
    }
  }
  
  public void f()
  {
    ActionSheet localActionSheet = this.o;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      this.o.dismiss();
    }
  }
  
  public void g()
  {
    ThreadManager.postImmediately(new BaseAuthorityAccountView.2(this), null, true);
  }
  
  protected int getAccountListContainerLayoutId()
  {
    return 2131625689;
  }
  
  protected int getAccountListItemLayoutId()
  {
    return 2131625686;
  }
  
  public void h()
  {
    this.f = SharedPrefs.b();
    if (this.f != null)
    {
      SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->initOrUpdateAccountList" });
      int i1 = 0;
      while (i1 < this.f.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" 第");
        localStringBuilder.append(i1);
        localStringBuilder.append("帐号: ");
        localStringBuilder.append((String)this.f.get(i1));
        SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
        i1 += 1;
      }
    }
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->initOrUpdateAccountList account list = null" });
  }
  
  protected void i()
  {
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->updateDropDownViews" });
    this.g.removeAllViews();
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((ArrayList)localObject1).size() == 0) {
        return;
      }
      int i1 = 0;
      while (i1 < this.f.size())
      {
        ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.c).inflate(getAccountListItemLayoutId(), this.g, false);
        localViewGroup.setBackgroundResource(2130842886);
        String str = (String)this.f.get(i1);
        ((TextView)localViewGroup.findViewById(2131427488)).setText(str);
        TextView localTextView = (TextView)localViewGroup.findViewById(2131427463);
        localTextView.setMaxWidth((int)(this.i * 3.0F / 5.0F));
        localObject1 = new WloginSimpleInfo();
        this.d.getBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView.setText((CharSequence)localObject1);
        localObject1 = (ImageView)localViewGroup.findViewById(2131427454);
        ((ImageView)localViewGroup.findViewById(2131436081)).setVisibility(8);
        localObject2 = (ImageView)localViewGroup.findViewById(2131435975);
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130846997);
        ((ImageView)localObject2).setTag(str);
        ((ImageView)localObject2).setOnClickListener(new BaseAuthorityAccountView.3(this));
        a(str, (ImageView)localObject1);
        localViewGroup.setOnClickListener(new BaseAuthorityAccountView.4(this, str));
        this.g.addView(localViewGroup);
        i1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */