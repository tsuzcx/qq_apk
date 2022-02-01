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
  protected int a;
  protected Dialog a;
  protected Context a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  protected QQAppInterface a;
  protected TroopObserver a;
  protected SelectTroopMemberAdapter a;
  protected TroopMemberDataProvider a;
  protected XExpandableListView a;
  protected String a;
  protected boolean a;
  
  public SelectTroopMemberFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new SelectTroopMemberFragment.1(this);
  }
  
  private int a()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.a();
    int i = 0;
    int j = 0;
    if (localSparseArray != null)
    {
      int k;
      for (i = 0; j < localSparseArray.size(); i = k)
      {
        List localList = (List)localSparseArray.get(localSparseArray.keyAt(j));
        k = i;
        if (localList != null) {
          k = i + localList.size();
        }
        j += 1;
      }
    }
    return i;
  }
  
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
  
  private ArrayList<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.a();
    int i;
    if (localSparseArray != null) {
      i = 0;
    }
    try
    {
      while (i < localSparseArray.size())
      {
        Object localObject = (List)localSparseArray.get(localSparseArray.keyAt(i));
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(Long.valueOf(Long.parseLong((String)((Iterator)localObject).next())));
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException) {}
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.rightViewText.setText(String.format(getResources().getString(2131699505), new Object[] { String.valueOf(paramInt) }));
      this.rightViewText.setEnabled(true);
      return;
    }
    this.rightViewText.setText(2131699504);
    this.rightViewText.setEnabled(false);
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
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("del_confirm").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    e();
  }
  
  private void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((SelectTroopMemberAdapter)localObject1).a();
    localObject1 = new StringBuffer();
    int i = 0;
    int k;
    for (int j = 0; i < ((SparseArray)localObject2).size(); j = k)
    {
      int m = ((SparseArray)localObject2).keyAt(i);
      List localList = (List)((SparseArray)localObject2).get(m);
      k = j;
      if (localList != null)
      {
        k = j;
        if (((SparseArray)localObject2).size() > 0)
        {
          k = j + localList.size();
          if (((StringBuffer)localObject1).length() == 0)
          {
            ((StringBuffer)localObject1).append(m);
          }
          else
          {
            ((StringBuffer)localObject1).append("-");
            ((StringBuffer)localObject1).append(m);
          }
        }
      }
      i += 1;
    }
    localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if (localObject2 != null)
    {
      if (((TroopInfo)localObject2).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
      {
        i = 1;
        break label201;
      }
      if (((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
      {
        i = 2;
        break label201;
      }
    }
    i = 3;
    label201:
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_ver").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(j), ((StringBuffer)localObject1).toString(), String.valueOf(i) }).a();
  }
  
  public <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public void a()
  {
    a(a());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(HashMap<String, Long> paramHashMap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter != null)
    {
      if ((paramHashMap != null) && (paramHashMap.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider.a(), paramHashMap);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.a();
    }
  }
  
  protected boolean a()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = localBundle.getString("troopUin", "");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("onlyloadLocalData", false);
    this.jdField_a_of_type_Int = localBundle.getInt("from", -1);
    return true;
  }
  
  protected void b()
  {
    setLeftButton(2131690728, new SelectTroopMemberFragment.2(this));
    setTitle(getResources().getString(2131699513));
    this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130844035));
    this.rightViewText.setTextColor(Color.parseColor("#FFFFFF"));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
    localLayoutParams.setMargins(0, 0, AIOUtils.b(14.0F, getResources()), 0);
    localLayoutParams.height = AIOUtils.b(29.0F, getResources());
    this.rightViewText.setLayoutParams(localLayoutParams);
    setRightButtonText("", new SelectTroopMemberFragment.3(this));
    this.rightViewText.setVisibility(0);
    a(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131379284));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131368260));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370395));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)a(2131370169));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setChildDivider(null);
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter = new SelectTroopMemberAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetXExpandableListView, this);
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider.a(), null);
  }
  
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppInterface());
      this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
      if (!a())
      {
        getBaseActivity().doOnBackPressed();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider = new TroopMemberDataProvider(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this);
      b();
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("exp").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
      return;
    }
    catch (Exception paramLayoutInflater)
    {
      break label47;
    }
  }
  
  protected void e()
  {
    ReportDialog localReportDialog = new ReportDialog(getBaseActivity(), 2131756189);
    localReportDialog.setContentView(2131559094);
    ((TextView)localReportDialog.findViewById(2131365648)).setText(getString(2131691503));
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365644);
    CheckBox localCheckBox = (CheckBox)localReportDialog.findViewById(2131364597);
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
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      getBaseActivity().doOnBackPressed();
      return;
    }
    boolean bool;
    if ((!((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (((TroopInfo)localObject).allowMemberKick == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = a();
    if (((ArrayList)localObject).size() == 1)
    {
      localTextView1.setText(getString(2131693533));
      localCheckBox.setText(getString(2131718176));
    }
    else
    {
      localTextView1.setText(getString(2131694348));
      localCheckBox.setText(getString(2131694351));
    }
    if (bool) {
      localCheckBox.setVisibility(8);
    }
    localCheckBox.setOnClickListener(new SelectTroopMemberFragment.4(this, localCheckBox));
    localTextView1 = (TextView)localReportDialog.findViewById(2131365633);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365639);
    localTextView1.setText(17039360);
    localTextView2.setText(17039370);
    localTextView1.setOnClickListener(new SelectTroopMemberFragment.5(this, localReportDialog));
    localTextView2.setOnClickListener(new SelectTroopMemberFragment.6(this, (ArrayList)localObject, localCheckBox, bool, localReportDialog));
    localReportDialog.show();
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_exp").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131560464;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter;
    if (localObject != null) {
      ((SelectTroopMemberAdapter)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider;
    if (localObject != null) {
      ((TroopMemberDataProvider)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment
 * JD-Core Version:    0.7.0.1
 */