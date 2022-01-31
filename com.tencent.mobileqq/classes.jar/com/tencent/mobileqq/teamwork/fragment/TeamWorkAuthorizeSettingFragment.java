package com.tencent.mobileqq.teamwork.fragment;

import aimr;
import aims;
import aimt;
import aimu;
import aimv;
import aimy;
import aimz;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.Holder;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.ItemData;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TeamWorkAuthorizeSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public int a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new aimr(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TeamWorkAuthorizeUinListAdapter a;
  private TeamWorkHandler jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler;
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new aims(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public List a;
  Map jdField_a_of_type_JavaUtilMap;
  public boolean a;
  public int b = -1;
  TextView g;
  TextView h;
  TextView i;
  
  public TeamWorkAuthorizeSettingFragment()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.i.setText(2131439170);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + paramInt);
      return;
    case 2: 
      this.g.setText(2131439160);
      this.h.setText(2131439164);
      this.i.setText(2131439169);
    }
    for (;;)
    {
      if (this.b != paramInt)
      {
        this.jdField_a_of_type_Boolean = true;
        if ((this.b == 2) || (this.b == 1))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.b), localArrayList);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      this.b = paramInt;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.a(this.b);
      return;
      this.g.setText(2131439160);
      this.h.setText(2131439165);
      continue;
      this.g.setText(2131439161);
      continue;
      this.g.setText(2131439163);
    }
  }
  
  private void a(TeamWorkAuthorizeUinListAdapter.Holder paramHolder)
  {
    int j = 2;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    if (this.b != 2)
    {
      localActionSheet.a(getString(2131439164), 5);
      localSparseArray.put(0, Integer.valueOf(2131439164));
      localActionSheet.a(getString(2131439165), 5);
      localSparseArray.put(1, Integer.valueOf(2131439165));
    }
    for (;;)
    {
      localActionSheet.a(getString(2131433638), 3);
      localSparseArray.put(j, Integer.valueOf(2131433638));
      localActionSheet.a(new aimv(this, paramHolder, localSparseArray, localActionSheet));
      localActionSheet.c(2131433015);
      localActionSheet.show();
      return;
      j = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 0;
    ViewGroup localViewGroup1 = (ViewGroup)this.e.findViewById(2131375222);
    ViewGroup localViewGroup2 = (ViewGroup)this.e.findViewById(2131375224);
    ViewGroup localViewGroup3 = (ViewGroup)this.e.findViewById(2131366465);
    int j = 0;
    while (j < localViewGroup1.getChildCount())
    {
      localViewGroup1.getChildAt(j).setEnabled(paramBoolean);
      j += 1;
    }
    j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= localViewGroup2.getChildCount()) {
        break;
      }
      localViewGroup2.getChildAt(j).setEnabled(paramBoolean);
      j += 1;
    }
    while (k < localViewGroup3.getChildCount())
    {
      localViewGroup3.getChildAt(k).setEnabled(paramBoolean);
      k += 1;
    }
    localViewGroup1.setEnabled(paramBoolean);
    localViewGroup2.setEnabled(paramBoolean);
    localViewGroup3.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      a(this.b);
      c();
      localViewGroup1.setOnClickListener(this);
      localViewGroup2.setOnClickListener(this);
      localViewGroup3.setOnClickListener(this);
      return;
    }
    localViewGroup1.setOnClickListener(null);
    localViewGroup2.setOnClickListener(null);
    localViewGroup3.setOnClickListener(null);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.a(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.e.findViewById(2131375221));
    this.g = ((TextView)this.e.findViewById(2131375223));
    this.h = ((TextView)this.e.findViewById(2131375225));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.e.findViewById(2131375228));
    this.i = ((TextView)this.e.findViewById(2131375227));
    b(2131432414);
    b(2131433016, this);
    a(getActivity().getResources().getString(2131439162));
  }
  
  private void c()
  {
    View localView1 = this.e.findViewById(2131375226);
    View localView2 = this.e.findViewById(2131375224);
    if (this.b == 2)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(0);
      return;
    }
    if (this.b == 3)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(8);
      return;
    }
    if (this.b == 1)
    {
      localView2.setVisibility(8);
      localView1.setVisibility(0);
      return;
    }
    localView1.setVisibility(8);
    localView2.setVisibility(8);
  }
  
  private void d()
  {
    Intent localIntent = getActivity().getIntent();
    String str = localIntent.getStringExtra("team_work_name");
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("对\"" + str + "\"进行设置");
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("team_work_pad_url");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.b = localIntent.getIntExtra("team_work_public_tag", -1);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter = new TeamWorkAuthorizeUinListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter);
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(String.valueOf(((TeamWorkAuthorizeUinListAdapter.ItemData)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString));
      j += 1;
    }
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_type", 9504);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_entrance", 31);
    localIntent.putExtra("param_min", 0);
    localIntent.putExtra("param_max", 2000);
    localIntent.putExtra("param_enable_all_select", true);
    localIntent.putExtra("param_overload_tips_include_default_count", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    startActivityForResult(localIntent, 1001);
  }
  
  private void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localActionSheet.a(getString(2131439160), 5);
    localSparseArray.put(0, Integer.valueOf(2131439160));
    localActionSheet.a(getString(2131439161), 5);
    localSparseArray.put(1, Integer.valueOf(2131439161));
    localActionSheet.a(getString(2131439163), 5);
    localSparseArray.put(2, Integer.valueOf(2131439163));
    localActionSheet.a(new aimt(this, localSparseArray, localActionSheet));
    localActionSheet.a("对谁公开");
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  private void g()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localActionSheet.a(getString(2131439164), 5);
    localSparseArray.put(0, Integer.valueOf(2131439164));
    localActionSheet.a(getString(2131439165), 5);
    localSparseArray.put(1, Integer.valueOf(2131439165));
    localActionSheet.a(new aimu(this, localSparseArray, localActionSheet));
    localActionSheet.a("获得文档的人");
    localActionSheet.c(2131433015);
    localActionSheet.show();
  }
  
  protected int a()
  {
    return 2130971634;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    g();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    b();
    d();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler = ((TeamWorkHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public boolean d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      DialogUtil.b(getActivity(), 230, getString(2131439166), "", 2131439168, 2131439167, new aimy(this), new aimz(this)).show();
      return false;
    }
    return super.d();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (-1 == paramInt2))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)paramIntent.next();
          TimDocSSOMsg.UinRightInfo localUinRightInfo = new TimDocSSOMsg.UinRightInfo();
          localUinRightInfo.uint64_uin.set(Long.parseLong(localResultRecord.jdField_a_of_type_JavaLangString));
          localUinRightInfo.uint32_right.set(2);
          localUinRightInfo.uint32_uin_type.set(0);
          TeamWorkAuthorizeUinListAdapter.ItemData localItemData = new TeamWorkAuthorizeUinListAdapter.ItemData();
          localItemData.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString;
          localItemData.c = localResultRecord.b;
          localItemData.b = localResultRecord.c;
          localItemData.jdField_a_of_type_Int = localResultRecord.jdField_a_of_type_Int;
          localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localUinRightInfo;
          this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.a(localItemData);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131366465: 
    case 2131375222: 
    case 2131375224: 
    case 2131375219: 
      do
      {
        return;
        e();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        f();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        g();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        a((TeamWorkAuthorizeUinListAdapter.Holder)paramView.getTag());
      } while (this.b != 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
    paramView = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TeamWorkAuthorizeUinListAdapter.ItemData localItemData = (TeamWorkAuthorizeUinListAdapter.ItemData)localIterator.next();
      if (this.b == 2) {
        localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.set(2);
      }
      paramView.add(localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler.a(this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramView);
    a(false);
    b().setEnabled(false);
    g();
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */