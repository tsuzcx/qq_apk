package com.tencent.mobileqq.fragment;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.adapter.AppletsListAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AppletsSettingFragment
  extends IphoneTitleBarFragment
{
  AppletsFolderManager a;
  protected QQCustomDialog b = null;
  private XListView c;
  private AppletsListAdapter d;
  private QQAppInterface e;
  private RelativeLayout f;
  private TextView g;
  private Switch h;
  private TextView i;
  private TextView j;
  private AppletItem k;
  private HashMap<String, AppletItem> l = new HashMap();
  private QQProgressDialog m;
  private boolean n;
  private CustomHandler o;
  private View.OnClickListener p = new AppletsSettingFragment.1(this);
  private Runnable q = new AppletsSettingFragment.2(this);
  private AppletsObserver r = new AppletsSettingFragment.3(this);
  private AppletsSettingFragment.OnChangeSwitchListener s = new AppletsSettingFragment.4(this);
  
  private String a(AppletItem paramAppletItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppletItem.a());
    localStringBuilder.append("&");
    localStringBuilder.append(paramAppletItem.d());
    return localStringBuilder.toString();
  }
  
  private void a(List<AppletItem> paramList)
  {
    AppletsListAdapter localAppletsListAdapter = this.d;
    if (localAppletsListAdapter != null) {
      localAppletsListAdapter.a(paramList);
    }
    if (this.j != null)
    {
      if ((paramList != null) && (paramList.size() >= 1))
      {
        this.j.setVisibility(0);
        return;
      }
      this.j.setVisibility(8);
    }
  }
  
  private void b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c()
  {
    this.o = new CustomHandler(Looper.getMainLooper(), null);
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.c = ((XListView)this.mContentView.findViewById(2131428672));
    this.c.setDivider(null);
    this.c.setVerticalScrollBarEnabled(false);
    this.f = ((RelativeLayout)this.mContentView.findViewById(2131428671));
    this.f.setBackgroundResource(2130839622);
    this.g = ((TextView)this.mContentView.findViewById(2131428666));
    this.h = ((Switch)this.mContentView.findViewById(2131428665));
    this.i = ((TextView)this.mContentView.findViewById(2131428664));
    this.j = ((TextView)this.mContentView.findViewById(2131428663));
    this.j.setVisibility(8);
    this.h.setOnClickListener(this.p);
    if (this.d == null)
    {
      this.d = new AppletsListAdapter(this.e, getBaseActivity(), this.s);
      this.c.setAdapter(this.d);
    }
    if (this.m == null)
    {
      this.m = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      this.m.c(2131886997);
      this.m.setCanceledOnTouchOutside(true);
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.l.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AppletItem localAppletItem = (AppletItem)((Map.Entry)localIterator.next()).getValue();
      if ((localAppletItem != null) && (localAppletItem.e() == 1)) {
        localIterator.remove();
      }
    }
  }
  
  protected void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.b.show();
      }
      return;
    }
    this.b = DialogUtil.a(getBaseActivity(), 230);
    localObject = this.a.e();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.b.setMessage((CharSequence)localObject);
    } else {
      this.b.setMessage(2131887002);
    }
    localObject = new AppletsSettingFragment.5(this);
    this.b.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    this.b.setPositiveButton(2131888010, (DialogInterface.OnClickListener)localObject);
    this.b.show();
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getBaseActivity().getApplicationContext(), paramInt, 0).show();
  }
  
  public void a(boolean paramBoolean)
  {
    QQProgressDialog localQQProgressDialog = this.m;
    if (localQQProgressDialog != null)
    {
      if ((paramBoolean) && (!localQQProgressDialog.isShowing()))
      {
        this.m.show();
        this.o.postDelayed(this.q, 500L);
        return;
      }
      if ((!paramBoolean) && (this.m.isShowing())) {
        this.m.dismiss();
      }
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.e = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    this.e.addObserver(this.r);
    this.a = ((AppletsFolderManager)this.e.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER));
    c();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131627788;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131887001));
    return localView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.o;
    if (localObject != null) {
      ((CustomHandler)localObject).removeCallbacks(this.q);
    }
    localObject = this.e;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.r);
    }
    this.e = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment
 * JD-Core Version:    0.7.0.1
 */