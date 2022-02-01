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
import anyu;
import anzj;
import bdll;
import beaf;
import beag;
import beah;
import bebl;
import bebs;
import becs;
import bect;
import becu;
import becv;
import becw;
import becz;
import beda;
import bhlq;
import bhpc;
import blir;
import blji;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  anyu jdField_a_of_type_Anyu = new becs(this);
  public beaf a;
  private bebl jdField_a_of_type_Bebl;
  bebs jdField_a_of_type_Bebs = new bect(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public List<beah> a;
  Map<Integer, List<beah>> jdField_a_of_type_JavaUtilMap;
  public boolean a;
  public int b;
  TextView b;
  TextView c;
  TextView d;
  
  public TeamWorkAuthorizeSettingFragment()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a()
  {
    this.vg.changeBg(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365650));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131367075));
    this.c = ((TextView)this.mContentView.findViewById(2131367542));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131380583));
    this.d = ((TextView)this.mContentView.findViewById(2131365882));
    setLeftViewName(2131690384);
    setRightButton(2131694098, this);
    setTitle(getActivity().getResources().getString(2131718587));
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.d.setText(2131718580);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + paramInt);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718584);
      this.c.setText(2131718582);
      this.d.setText(2131718581);
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
      if (this.jdField_a_of_type_Beaf == null) {
        break;
      }
      this.jdField_a_of_type_Beaf.a(this.jdField_b_of_type_Int);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718584);
      this.c.setText(2131718583);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718585);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718586);
    }
  }
  
  private void a(beag parambeag)
  {
    int i = 2;
    blir localblir = (blir)blji.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    if (this.jdField_b_of_type_Int != 2)
    {
      localblir.a(getString(2131718582), 5);
      localSparseArray.put(0, Integer.valueOf(2131718582));
      localblir.a(getString(2131718583), 5);
      localSparseArray.put(1, Integer.valueOf(2131718583));
    }
    for (;;)
    {
      localblir.a(getString(2131690639), 3);
      localSparseArray.put(i, Integer.valueOf(2131690639));
      localblir.a(new becw(this, parambeag, localSparseArray, localblir));
      localblir.c(2131690580);
      localblir.show();
      return;
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    ViewGroup localViewGroup1 = (ViewGroup)this.mContentView.findViewById(2131367076);
    ViewGroup localViewGroup2 = (ViewGroup)this.mContentView.findViewById(2131367543);
    ViewGroup localViewGroup3 = (ViewGroup)this.mContentView.findViewById(2131362132);
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
    View localView1 = this.mContentView.findViewById(2131365246);
    View localView2 = this.mContentView.findViewById(2131367543);
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
    this.jdField_a_of_type_Beaf = new beaf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Beaf);
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(String.valueOf(((beah)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
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
    blir localblir = (blir)blji.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localblir.a(getString(2131718584), 5);
    localSparseArray.put(0, Integer.valueOf(2131718584));
    localblir.a(getString(2131718585), 5);
    localSparseArray.put(1, Integer.valueOf(2131718585));
    localblir.a(getString(2131718586), 5);
    localSparseArray.put(2, Integer.valueOf(2131718586));
    localblir.a(new becu(this, localSparseArray, localblir));
    localblir.a(anzj.a(2131713568));
    localblir.c(2131690580);
    localblir.show();
  }
  
  private void f()
  {
    blir localblir = (blir)blji.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localblir.a(getString(2131718582), 5);
    localSparseArray.put(0, Integer.valueOf(2131718582));
    localblir.a(getString(2131718583), 5);
    localSparseArray.put(1, Integer.valueOf(2131718583));
    localblir.a(new becv(this, localSparseArray, localblir));
    localblir.a(anzj.a(2131713613));
    localblir.c(2131690580);
    localblir.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bebs);
    a();
    c();
    this.jdField_a_of_type_Bebl = ((bebl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122));
    this.jdField_a_of_type_Bebl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  public int getContentLayoutId()
  {
    return 2131562985;
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
          beah localbeah = new beah();
          localbeah.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString;
          localbeah.c = localResultRecord.b;
          localbeah.b = localResultRecord.c;
          localbeah.jdField_a_of_type_Int = localResultRecord.jdField_a_of_type_Int;
          localbeah.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localUinRightInfo;
          this.jdField_a_of_type_Beaf.a(localbeah);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_Beaf.notifyDataSetChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      bhlq.a(getActivity(), 230, getString(2131718576), "", 2131718575, 2131718577, new becz(this), new beda(this)).show();
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      e();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      f();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      a((beag)paramView.getTag());
      if (this.jdField_b_of_type_Int == 1)
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        continue;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          beah localbeah = (beah)localIterator.next();
          if (this.jdField_b_of_type_Int == 2) {
            localbeah.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.set(2);
          }
          localArrayList.add(localbeah.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo);
        }
        this.jdField_a_of_type_Bebl.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localArrayList);
        a(false);
        getRightTextView().setEnabled(false);
        startTitleProgress();
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bebs);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */