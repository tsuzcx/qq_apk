package com.tencent.mobileqq.teamwork.fragment;

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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TeamWorkAuthorizeSettingFragment.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TeamWorkAuthorizeUinListAdapter jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter;
  private TeamWorkHandler jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler;
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new TeamWorkAuthorizeSettingFragment.2(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  List<TeamWorkAuthorizeUinListAdapter.ItemData> jdField_a_of_type_JavaUtilList;
  Map<Integer, List<TeamWorkAuthorizeUinListAdapter.ItemData>> jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  TextView d;
  
  private void a()
  {
    this.vg.changeBg(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365940));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131367396));
    this.c = ((TextView)this.mContentView.findViewById(2131367910));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131381090));
    this.d = ((TextView)this.mContentView.findViewById(2131366177));
    setLeftViewName(2131690601);
    setRightButton(2131694615, this);
    setTitle(getActivity().getResources().getString(2131719783));
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.d.setText(2131719776);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + paramInt);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719780);
      this.c.setText(2131719778);
      this.d.setText(2131719777);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int != paramInt)
      {
        this.jdField_a_of_type_Boolean = true;
        if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 1))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), localArrayList);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      this.jdField_b_of_type_Int = paramInt;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.a(this.jdField_b_of_type_Int);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719780);
      this.c.setText(2131719779);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719781);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719782);
    }
  }
  
  private void a(TeamWorkAuthorizeUinListAdapter.Holder paramHolder)
  {
    int i = 2;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    if (this.jdField_b_of_type_Int != 2)
    {
      localActionSheet.addButton(getString(2131719778), 5);
      localSparseArray.put(0, Integer.valueOf(2131719778));
      localActionSheet.addButton(getString(2131719779), 5);
      localSparseArray.put(1, Integer.valueOf(2131719779));
    }
    for (;;)
    {
      localActionSheet.addButton(getString(2131690860), 3);
      localSparseArray.put(i, Integer.valueOf(2131690860));
      localActionSheet.setOnButtonClickListener(new TeamWorkAuthorizeSettingFragment.5(this, paramHolder, localSparseArray, localActionSheet));
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.show();
      return;
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    ViewGroup localViewGroup1 = (ViewGroup)this.mContentView.findViewById(2131367397);
    ViewGroup localViewGroup2 = (ViewGroup)this.mContentView.findViewById(2131367911);
    ViewGroup localViewGroup3 = (ViewGroup)this.mContentView.findViewById(2131362156);
    int i = 0;
    while (i < localViewGroup1.getChildCount())
    {
      localViewGroup1.getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= localViewGroup2.getChildCount()) {
        break;
      }
      localViewGroup2.getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
    while (j < localViewGroup3.getChildCount())
    {
      localViewGroup3.getChildAt(j).setEnabled(paramBoolean);
      j += 1;
    }
    localViewGroup1.setEnabled(paramBoolean);
    localViewGroup2.setEnabled(paramBoolean);
    localViewGroup3.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      a(this.jdField_b_of_type_Int);
      b();
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
    View localView1 = this.mContentView.findViewById(2131365514);
    View localView2 = this.mContentView.findViewById(2131367911);
    if (this.jdField_b_of_type_Int == 2)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(0);
      return;
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(8);
      return;
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      localView2.setVisibility(8);
      localView1.setVisibility(0);
      return;
    }
    localView1.setVisibility(8);
    localView2.setVisibility(8);
  }
  
  private void c()
  {
    Intent localIntent = getActivity().getIntent();
    String str = localIntent.getStringExtra("team_work_name");
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("对\"" + str + "\"进行设置");
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("team_work_pad_url");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("team_work_public_tag", -1);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter = new TeamWorkAuthorizeUinListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter);
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(String.valueOf(((TeamWorkAuthorizeUinListAdapter.ItemData)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
      i += 1;
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
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localActionSheet.addButton(getString(2131719780), 5);
    localSparseArray.put(0, Integer.valueOf(2131719780));
    localActionSheet.addButton(getString(2131719781), 5);
    localSparseArray.put(1, Integer.valueOf(2131719781));
    localActionSheet.addButton(getString(2131719782), 5);
    localSparseArray.put(2, Integer.valueOf(2131719782));
    localActionSheet.setOnButtonClickListener(new TeamWorkAuthorizeSettingFragment.3(this, localSparseArray, localActionSheet));
    localActionSheet.setMainTitle(HardCodeUtil.a(2131714643));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  private void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localActionSheet.addButton(getString(2131719778), 5);
    localSparseArray.put(0, Integer.valueOf(2131719778));
    localActionSheet.addButton(getString(2131719779), 5);
    localSparseArray.put(1, Integer.valueOf(2131719779));
    localActionSheet.setOnButtonClickListener(new TeamWorkAuthorizeSettingFragment.4(this, localSparseArray, localActionSheet));
    localActionSheet.setMainTitle(HardCodeUtil.a(2131714688));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    a();
    c();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler = ((TeamWorkHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public int getContentLayoutId()
  {
    return 2131563086;
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
          localUinRightInfo.uint64_uin.set(Long.parseLong(localResultRecord.uin));
          localUinRightInfo.uint32_right.set(2);
          localUinRightInfo.uint32_uin_type.set(0);
          TeamWorkAuthorizeUinListAdapter.ItemData localItemData = new TeamWorkAuthorizeUinListAdapter.ItemData();
          localItemData.jdField_a_of_type_JavaLangString = localResultRecord.uin;
          localItemData.c = localResultRecord.name;
          localItemData.b = localResultRecord.groupUin;
          localItemData.jdField_a_of_type_Int = localResultRecord.type;
          localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localUinRightInfo;
          this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.a(localItemData);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.notifyDataSetChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      DialogUtil.a(getActivity(), 230, getString(2131719772), "", 2131719771, 2131719773, new TeamWorkAuthorizeSettingFragment.6(this), new TeamWorkAuthorizeSettingFragment.7(this)).show();
      return false;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      d();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      e();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      f();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      a((TeamWorkAuthorizeUinListAdapter.Holder)paramView.getTag());
      if (this.jdField_b_of_type_Int == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          TeamWorkAuthorizeUinListAdapter.ItemData localItemData = (TeamWorkAuthorizeUinListAdapter.ItemData)localIterator.next();
          if (this.jdField_b_of_type_Int == 2) {
            localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.set(2);
          }
          localArrayList.add(localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkHandler.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localArrayList);
        a(false);
        getRightTextView().setEnabled(false);
        startTitleProgress();
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */