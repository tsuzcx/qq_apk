package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SelectTroopMemberFragment
  extends IphoneTitleBarFragment
  implements SelectTroopMemberAdapter.AdapterCallBack, TroopMemberDataProvider.DataNotifyCallBack
{
  protected QQAppInterface a;
  protected Context b;
  protected int c;
  protected String d;
  protected XExpandableListView e;
  protected RelativeLayout f;
  protected ProgressBar g;
  protected TextView h;
  protected SelectTroopMemberAdapter i;
  protected TroopMemberDataProvider j;
  protected Dialog k;
  protected boolean l = false;
  protected TroopObserver m = new SelectTroopMemberFragment.1(this);
  
  protected static Intent a(Bundle paramBundle, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hide_title_left_arrow", true);
    localBundle.putString("troopUin", paramString);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, @Nullable String paramString)
  {
    PublicFragmentActivity.a(paramActivity, a(paramBundle, paramString), SelectTroopMemberFragment.class);
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, @Nullable String paramString, int paramInt)
  {
    PublicFragmentActivity.a(paramActivity, a(paramBundle, paramString), SelectTroopMemberFragment.class, paramInt);
  }
  
  private void a(View paramView)
  {
    new ReportTask(this.a).a("dc00899").b("Grp_mber").c("del_mber").d("del_confirm").a(this.c).a(new String[] { this.d }).a();
    f();
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.rightViewText.setText(String.format(getResources().getString(2131897536), new Object[] { String.valueOf(paramInt) }));
      this.rightViewText.setEnabled(true);
      return;
    }
    this.rightViewText.setText(2131897535);
    this.rightViewText.setEnabled(false);
  }
  
  private int g()
  {
    SparseArray localSparseArray = this.i.d();
    int n = 0;
    int i1 = 0;
    if (localSparseArray != null)
    {
      int i2;
      for (n = 0; i1 < localSparseArray.size(); n = i2)
      {
        List localList = (List)localSparseArray.get(localSparseArray.keyAt(i1));
        i2 = n;
        if (localList != null) {
          i2 = n + localList.size();
        }
        i1 += 1;
      }
    }
    return n;
  }
  
  private ArrayList<Long> h()
  {
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = this.i.d();
    int n;
    if (localSparseArray != null) {
      n = 0;
    }
    try
    {
      while (n < localSparseArray.size())
      {
        Object localObject = (List)localSparseArray.get(localSparseArray.keyAt(n));
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(Long.valueOf(Long.parseLong((String)((Iterator)localObject).next())));
          }
        }
        n += 1;
      }
      return localArrayList;
    }
    catch (Exception localException) {}
    return localArrayList;
  }
  
  private void i()
  {
    Object localObject1 = this.i;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((SelectTroopMemberAdapter)localObject1).d();
    localObject1 = new StringBuffer();
    int n = 0;
    int i2;
    for (int i1 = 0; n < ((SparseArray)localObject2).size(); i1 = i2)
    {
      int i3 = ((SparseArray)localObject2).keyAt(n);
      List localList = (List)((SparseArray)localObject2).get(i3);
      i2 = i1;
      if (localList != null)
      {
        i2 = i1;
        if (((SparseArray)localObject2).size() > 0)
        {
          i2 = i1 + localList.size();
          if (((StringBuffer)localObject1).length() == 0)
          {
            ((StringBuffer)localObject1).append(i3);
          }
          else
          {
            ((StringBuffer)localObject1).append("-");
            ((StringBuffer)localObject1).append(i3);
          }
        }
      }
      n += 1;
    }
    localObject2 = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.d);
    if (localObject2 != null)
    {
      if (((TroopInfo)localObject2).isTroopAdmin(this.a.getCurrentUin()))
      {
        n = 1;
        break label201;
      }
      if (((TroopInfo)localObject2).isTroopOwner(this.a.getCurrentUin()))
      {
        n = 2;
        break label201;
      }
    }
    n = 3;
    label201:
    new ReportTask(this.a).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_ver").a(this.c).a(new String[] { this.d, String.valueOf(i1), ((StringBuffer)localObject1).toString(), String.valueOf(n) }).a();
  }
  
  public <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public void a()
  {
    b(g());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.f.getVisibility() == 8) {
      this.f.setVisibility(0);
    }
    this.g.setProgress(paramInt);
    this.h.setText(paramString);
  }
  
  public void a(HashMap<String, Long> paramHashMap)
  {
    if (this.i != null)
    {
      if ((paramHashMap != null) && (paramHashMap.size() > 0)) {
        this.i.a(this.j.b(), paramHashMap);
      }
      this.i.a();
    }
  }
  
  protected boolean b()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return false;
    }
    this.d = localBundle.getString("troopUin", "");
    if (TextUtils.isEmpty(this.d)) {
      return false;
    }
    this.l = localBundle.getBoolean("onlyloadLocalData", false);
    this.c = localBundle.getInt("from", -1);
    return true;
  }
  
  protected void c()
  {
    setLeftButton(2131887648, new SelectTroopMemberFragment.2(this));
    setTitle(getResources().getString(2131897544));
    this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130844990));
    this.rightViewText.setTextColor(Color.parseColor("#FFFFFF"));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
    localLayoutParams.setMargins(0, 0, AIOUtils.b(14.0F, getResources()), 0);
    localLayoutParams.height = AIOUtils.b(29.0F, getResources());
    this.rightViewText.setLayoutParams(localLayoutParams);
    setRightButtonText("", new SelectTroopMemberFragment.3(this));
    this.rightViewText.setVisibility(0);
    b(0);
    this.f = ((RelativeLayout)a(2131448021));
    this.g = ((ProgressBar)a(2131435131));
    this.h = ((TextView)a(2131437663));
    this.e = ((XExpandableListView)a(2131437335));
    this.e.setGroupIndicator(null);
    this.e.setDivider(null);
    this.e.setChildDivider(null);
  }
  
  public void d() {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    try
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        getBaseActivity().getWindow().setFlags(16777216, 16777216);
        if (QLog.isColorLevel()) {
          QLog.d("SelectTroopMemberFragment", 2, "FLAG_HARDWARE_ACCELERATED");
        }
      }
      label47:
      this.a = ((QQAppInterface)getBaseActivity().getAppInterface());
      this.b = getBaseActivity();
      if (!b())
      {
        getBaseActivity().doOnBackPressed();
        return;
      }
      this.j = new TroopMemberDataProvider(this.a, this.b, this.d, this.l, this);
      c();
      this.j.a();
      this.a.addObserver(this.m);
      new ReportTask(this.a).a("dc00899").b("Grp_mber").c("del_mber").d("exp").a(this.c).a(new String[] { this.d }).a();
      return;
    }
    catch (Exception paramLayoutInflater)
    {
      break label47;
    }
  }
  
  public void e()
  {
    this.f.setVisibility(8);
    if (this.i == null)
    {
      this.i = new SelectTroopMemberAdapter(this.b, this.a, this.d, this.c, this.e, this);
      this.e.setAdapter(this.i);
    }
    this.i.a(this.j.b(), null);
  }
  
  protected void f()
  {
    ReportDialog localReportDialog = new ReportDialog(getBaseActivity(), 2131953338);
    localReportDialog.setContentView(2131624755);
    ((TextView)localReportDialog.findViewById(2131431880)).setText(getString(2131888462));
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431876);
    CheckBox localCheckBox = (CheckBox)localReportDialog.findViewById(2131430666);
    if ((localTextView1.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.d);
    if (localObject == null)
    {
      getBaseActivity().doOnBackPressed();
      return;
    }
    boolean bool;
    if ((!((TroopInfo)localObject).isTroopAdmin(this.a.getCurrentUin())) && (((TroopInfo)localObject).allowMemberKick == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = h();
    if (((ArrayList)localObject).size() == 1)
    {
      localTextView1.setText(getString(2131891097));
      localCheckBox.setText(getString(2131915655));
    }
    else
    {
      localTextView1.setText(getString(2131892022));
      localCheckBox.setText(getString(2131892025));
    }
    if (bool) {
      localCheckBox.setVisibility(8);
    }
    localCheckBox.setOnClickListener(new SelectTroopMemberFragment.4(this, localCheckBox));
    localTextView1 = (TextView)localReportDialog.findViewById(2131431864);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431870);
    localTextView1.setText(17039360);
    localTextView2.setText(17039370);
    localTextView1.setOnClickListener(new SelectTroopMemberFragment.5(this, localReportDialog));
    localTextView2.setOnClickListener(new SelectTroopMemberFragment.6(this, (ArrayList)localObject, localCheckBox, bool, localReportDialog));
    localReportDialog.show();
    new ReportTask(this.a).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_exp").a(this.c).a(new String[] { this.d }).a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131626509;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.i;
    if (localObject != null) {
      ((SelectTroopMemberAdapter)localObject).c();
    }
    localObject = this.j;
    if (localObject != null) {
      ((TroopMemberDataProvider)localObject).c();
    }
    localObject = this.a;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.m);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment
 * JD-Core Version:    0.7.0.1
 */