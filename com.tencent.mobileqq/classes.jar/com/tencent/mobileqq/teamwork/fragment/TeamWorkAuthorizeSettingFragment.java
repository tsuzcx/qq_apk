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
import anvi;
import anvx;
import bdla;
import beav;
import beaw;
import beax;
import becb;
import beci;
import bedi;
import bedj;
import bedk;
import bedl;
import bedm;
import bedp;
import bedq;
import bhdj;
import bkzi;
import bkzz;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  anvi jdField_a_of_type_Anvi = new bedi(this);
  public beav a;
  private becb jdField_a_of_type_Becb;
  beci jdField_a_of_type_Beci = new bedj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public List<beax> a;
  Map<Integer, List<beax>> jdField_a_of_type_JavaUtilMap;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365777));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131367211));
    this.c = ((TextView)this.mContentView.findViewById(2131367703));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131380643));
    this.d = ((TextView)this.mContentView.findViewById(2131366012));
    setLeftViewName(2131690499);
    setRightButton(2131694399, this);
    setTitle(getActivity().getResources().getString(2131719228));
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.d.setText(2131719221);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + paramInt);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719225);
      this.c.setText(2131719223);
      this.d.setText(2131719222);
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
      if (this.jdField_a_of_type_Beav == null) {
        break;
      }
      this.jdField_a_of_type_Beav.a(this.jdField_b_of_type_Int);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719225);
      this.c.setText(2131719224);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719226);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719227);
    }
  }
  
  private void a(beaw parambeaw)
  {
    int i = 2;
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    if (this.jdField_b_of_type_Int != 2)
    {
      localbkzi.a(getString(2131719223), 5);
      localSparseArray.put(0, Integer.valueOf(2131719223));
      localbkzi.a(getString(2131719224), 5);
      localSparseArray.put(1, Integer.valueOf(2131719224));
    }
    for (;;)
    {
      localbkzi.a(getString(2131690756), 3);
      localSparseArray.put(i, Integer.valueOf(2131690756));
      localbkzi.a(new bedm(this, parambeaw, localSparseArray, localbkzi));
      localbkzi.c(2131690697);
      localbkzi.show();
      return;
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    ViewGroup localViewGroup1 = (ViewGroup)this.mContentView.findViewById(2131367212);
    ViewGroup localViewGroup2 = (ViewGroup)this.mContentView.findViewById(2131367704);
    ViewGroup localViewGroup3 = (ViewGroup)this.mContentView.findViewById(2131362136);
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
    View localView1 = this.mContentView.findViewById(2131365364);
    View localView2 = this.mContentView.findViewById(2131367704);
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
    this.jdField_a_of_type_Beav = new beav(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Beav);
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(String.valueOf(((beax)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
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
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localbkzi.a(getString(2131719225), 5);
    localSparseArray.put(0, Integer.valueOf(2131719225));
    localbkzi.a(getString(2131719226), 5);
    localSparseArray.put(1, Integer.valueOf(2131719226));
    localbkzi.a(getString(2131719227), 5);
    localSparseArray.put(2, Integer.valueOf(2131719227));
    localbkzi.a(new bedk(this, localSparseArray, localbkzi));
    localbkzi.a(anvx.a(2131714147));
    localbkzi.c(2131690697);
    localbkzi.show();
  }
  
  private void f()
  {
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localbkzi.a(getString(2131719223), 5);
    localSparseArray.put(0, Integer.valueOf(2131719223));
    localbkzi.a(getString(2131719224), 5);
    localSparseArray.put(1, Integer.valueOf(2131719224));
    localbkzi.a(new bedl(this, localSparseArray, localbkzi));
    localbkzi.a(anvx.a(2131714192));
    localbkzi.c(2131690697);
    localbkzi.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Beci);
    a();
    c();
    this.jdField_a_of_type_Becb = ((becb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER));
    this.jdField_a_of_type_Becb.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  public int getContentLayoutId()
  {
    return 2131562935;
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
          beax localbeax = new beax();
          localbeax.jdField_a_of_type_JavaLangString = localResultRecord.uin;
          localbeax.c = localResultRecord.name;
          localbeax.b = localResultRecord.groupUin;
          localbeax.jdField_a_of_type_Int = localResultRecord.type;
          localbeax.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localUinRightInfo;
          this.jdField_a_of_type_Beav.a(localbeax);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_Beav.notifyDataSetChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      bhdj.a(getActivity(), 230, getString(2131719217), "", 2131719216, 2131719218, new bedp(this), new bedq(this)).show();
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      e();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      f();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      a((beaw)paramView.getTag());
      if (this.jdField_b_of_type_Int == 1)
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        continue;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          beax localbeax = (beax)localIterator.next();
          if (this.jdField_b_of_type_Int == 2) {
            localbeax.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.set(2);
          }
          localArrayList.add(localbeax.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo);
        }
        this.jdField_a_of_type_Becb.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localArrayList);
        a(false);
        getRightTextView().setEnabled(false);
        startTitleProgress();
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Beci);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */