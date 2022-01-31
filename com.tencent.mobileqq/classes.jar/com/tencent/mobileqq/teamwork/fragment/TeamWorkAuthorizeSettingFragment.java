package com.tencent.mobileqq.teamwork.fragment;

import ajjh;
import ajjy;
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
import awqx;
import axdw;
import axdx;
import axdy;
import axfb;
import axfi;
import axgi;
import axgj;
import axgk;
import axgl;
import axgm;
import axgp;
import axgq;
import babr;
import bafb;
import begr;
import behe;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
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
  ajjh jdField_a_of_type_Ajjh = new axgi(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public axdw a;
  private axfb jdField_a_of_type_Axfb;
  axfi jdField_a_of_type_Axfi = new axgj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public List<axdy> a;
  Map<Integer, List<axdy>> jdField_a_of_type_JavaUtilMap;
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
    this.vg.a(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131299716));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131301019));
    this.c = ((TextView)this.mContentView.findViewById(2131301441));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131312965));
    this.d = ((TextView)this.mContentView.findViewById(2131299939));
    setLeftViewName(2131624770);
    setRightButton(2131629116, this);
    setTitle(getActivity().getResources().getString(2131654205));
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.d.setText(2131654198);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + paramInt);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654202);
      this.c.setText(2131654200);
      this.d.setText(2131654199);
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
      if (this.jdField_a_of_type_Axdw == null) {
        break;
      }
      this.jdField_a_of_type_Axdw.a(this.jdField_b_of_type_Int);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654202);
      this.c.setText(2131654201);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654203);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654204);
    }
  }
  
  private void a(axdx paramaxdx)
  {
    int i = 2;
    begr localbegr = (begr)behe.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    if (this.jdField_b_of_type_Int != 2)
    {
      localbegr.a(getString(2131654200), 5);
      localSparseArray.put(0, Integer.valueOf(2131654200));
      localbegr.a(getString(2131654201), 5);
      localSparseArray.put(1, Integer.valueOf(2131654201));
    }
    for (;;)
    {
      localbegr.a(getString(2131625147), 3);
      localSparseArray.put(i, Integer.valueOf(2131625147));
      localbegr.a(new axgm(this, paramaxdx, localSparseArray, localbegr));
      localbegr.c(2131625035);
      localbegr.show();
      return;
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    ViewGroup localViewGroup1 = (ViewGroup)this.mContentView.findViewById(2131301020);
    ViewGroup localViewGroup2 = (ViewGroup)this.mContentView.findViewById(2131301442);
    ViewGroup localViewGroup3 = (ViewGroup)this.mContentView.findViewById(2131296523);
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
    View localView1 = this.mContentView.findViewById(2131299314);
    View localView2 = this.mContentView.findViewById(2131301442);
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
    this.jdField_a_of_type_Axdw = new axdw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Axdw);
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(String.valueOf(((axdy)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
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
    begr localbegr = (begr)behe.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localbegr.a(getString(2131654202), 5);
    localSparseArray.put(0, Integer.valueOf(2131654202));
    localbegr.a(getString(2131654203), 5);
    localSparseArray.put(1, Integer.valueOf(2131654203));
    localbegr.a(getString(2131654204), 5);
    localSparseArray.put(2, Integer.valueOf(2131654204));
    localbegr.a(new axgk(this, localSparseArray, localbegr));
    localbegr.a(ajjy.a(2131648975));
    localbegr.c(2131625035);
    localbegr.show();
  }
  
  private void f()
  {
    begr localbegr = (begr)behe.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localbegr.a(getString(2131654200), 5);
    localSparseArray.put(0, Integer.valueOf(2131654200));
    localbegr.a(getString(2131654201), 5);
    localSparseArray.put(1, Integer.valueOf(2131654201));
    localbegr.a(new axgl(this, localSparseArray, localbegr));
    localbegr.a(ajjy.a(2131649020));
    localbegr.c(2131625035);
    localbegr.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axfi);
    a();
    c();
    this.jdField_a_of_type_Axfb = ((axfb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122));
    this.jdField_a_of_type_Axfb.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public int getContentLayoutId()
  {
    return 2131496891;
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
          axdy localaxdy = new axdy();
          localaxdy.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString;
          localaxdy.c = localResultRecord.b;
          localaxdy.b = localResultRecord.c;
          localaxdy.jdField_a_of_type_Int = localResultRecord.jdField_a_of_type_Int;
          localaxdy.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localUinRightInfo;
          this.jdField_a_of_type_Axdw.a(localaxdy);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_Axdw.notifyDataSetChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      babr.a(getActivity(), 230, getString(2131654194), "", 2131654193, 2131654195, new axgp(this), new axgq(this)).show();
      return false;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131296523: 
    case 2131301020: 
    case 2131301442: 
    case 2131311092: 
      do
      {
        return;
        d();
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        e();
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        f();
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        a((axdx)paramView.getTag());
      } while (this.jdField_b_of_type_Int != 1);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      return;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
    paramView = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axdy localaxdy = (axdy)localIterator.next();
      if (this.jdField_b_of_type_Int == 2) {
        localaxdy.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.set(2);
      }
      paramView.add(localaxdy.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo);
    }
    this.jdField_a_of_type_Axfb.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramView);
    a(false);
    getRightTextView().setEnabled(false);
    startTitleProgress();
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axfi);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */