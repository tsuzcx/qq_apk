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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportTask;
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
  protected TroopBusinessObserver a;
  protected SelectTroopMemberAdapter a;
  protected TroopMemberDataProvider a;
  protected XExpandableListView a;
  protected String a;
  protected boolean a;
  
  public SelectTroopMemberFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new SelectTroopMemberFragment.1(this);
  }
  
  private int a()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.a();
    if (localSparseArray != null)
    {
      int j = 0;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= localSparseArray.size()) {
          break;
        }
        List localList = (List)localSparseArray.get(localSparseArray.keyAt(j));
        k = i;
        if (localList != null) {
          k = i + localList.size();
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
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
    for (;;)
    {
      try
      {
        if (i < localSparseArray.size())
        {
          Object localObject = (List)localSparseArray.get(localSparseArray.keyAt(i));
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              localArrayList.add(Long.valueOf(Long.parseLong((String)((Iterator)localObject).next())));
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception localException) {}
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.rightViewText.setText(String.format(getResources().getString(2131699400), new Object[] { String.valueOf(paramInt) }));
      this.rightViewText.setEnabled(true);
      return;
    }
    this.rightViewText.setText(2131699399);
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.a();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = 0;
    if (i < ((SparseArray)localObject).size())
    {
      int m = ((SparseArray)localObject).keyAt(i);
      List localList = (List)((SparseArray)localObject).get(m);
      int k = j;
      if (localList != null)
      {
        k = j;
        if (((SparseArray)localObject).size() > 0)
        {
          k = j + localList.size();
          if (localStringBuffer.length() != 0) {
            break label111;
          }
          localStringBuffer.append(m);
        }
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        label111:
        localStringBuffer.append("-").append(m);
      }
    }
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        i = 1;
      }
    }
    for (;;)
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_ver").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(j), localStringBuffer.toString(), String.valueOf(i) }).a();
      return;
      if (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        i = 2;
      } else {
        i = 3;
      }
    }
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
    if (localBundle == null) {}
    do
    {
      return false;
      this.jdField_a_of_type_JavaLangString = localBundle.getString("troopUin", "");
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("onlyloadLocalData", false);
    this.jdField_a_of_type_Int = localBundle.getInt("from", -1);
    return true;
  }
  
  protected void b()
  {
    setLeftButton(2131690800, new SelectTroopMemberFragment.2(this));
    setTitle(getResources().getString(2131699408));
    this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130844132));
    this.rightViewText.setTextColor(Color.parseColor("#FFFFFF"));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
    localLayoutParams.setMargins(0, 0, AIOUtils.a(14.0F, getResources()), 0);
    localLayoutParams.height = AIOUtils.a(29.0F, getResources());
    this.rightViewText.setLayoutParams(localLayoutParams);
    setRightButtonText("", new SelectTroopMemberFragment.3(this));
    this.rightViewText.setVisibility(0);
    a(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131379955));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131368512));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370760));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)a(2131370509));
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
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    try
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        getActivity().getWindow().setFlags(16777216, 16777216);
        if (QLog.isColorLevel()) {
          QLog.d("SelectTroopMemberFragment", 2, "FLAG_HARDWARE_ACCELERATED");
        }
      }
      label47:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
      this.jdField_a_of_type_AndroidContentContext = getActivity();
      if (!a())
      {
        getActivity().doOnBackPressed();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider = new TroopMemberDataProvider(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this);
      b();
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
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
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755842);
    localReportDialog.setContentView(2131559216);
    ((TextView)localReportDialog.findViewById(2131365811)).setText(getString(2131691582));
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365807);
    CheckBox localCheckBox = (CheckBox)localReportDialog.findViewById(2131364710);
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
      getActivity().doOnBackPressed();
      return;
    }
    boolean bool;
    if ((!((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (((TroopInfo)localObject).allowMemberKick == 1))
    {
      bool = true;
      localObject = a();
      if (((ArrayList)localObject).size() != 1) {
        break label392;
      }
      localTextView1.setText(getString(2131693578));
      localCheckBox.setText(getString(2131718511));
    }
    for (;;)
    {
      if (bool) {
        localCheckBox.setVisibility(8);
      }
      localCheckBox.setOnClickListener(new SelectTroopMemberFragment.4(this, localCheckBox));
      localTextView1 = (TextView)localReportDialog.findViewById(2131365796);
      TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365802);
      localTextView1.setText(17039360);
      localTextView2.setText(17039370);
      localTextView1.setOnClickListener(new SelectTroopMemberFragment.5(this, localReportDialog));
      localTextView2.setOnClickListener(new SelectTroopMemberFragment.6(this, (ArrayList)localObject, localCheckBox, bool, localReportDialog));
      localReportDialog.show();
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("confirm_exp").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
      return;
      bool = false;
      break;
      label392:
      localTextView1.setText(getString(2131694383));
      localCheckBox.setText(getString(2131694386));
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560575;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment
 * JD-Core Version:    0.7.0.1
 */