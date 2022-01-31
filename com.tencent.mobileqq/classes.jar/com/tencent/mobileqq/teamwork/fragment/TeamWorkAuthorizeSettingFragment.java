package com.tencent.mobileqq.teamwork.fragment;

import ajxl;
import ajyc;
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
import axqw;
import aydy;
import aydz;
import ayea;
import ayfe;
import ayfl;
import aygm;
import aygn;
import aygo;
import aygp;
import aygq;
import aygt;
import aygu;
import bbcv;
import bbgg;
import bfol;
import bfoy;
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
  ajxl jdField_a_of_type_Ajxl = new aygm(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public aydy a;
  private ayfe jdField_a_of_type_Ayfe;
  ayfl jdField_a_of_type_Ayfl = new aygn(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public List<ayea> a;
  Map<Integer, List<ayea>> jdField_a_of_type_JavaUtilMap;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365284));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131366630));
    this.c = ((TextView)this.mContentView.findViewById(2131367051));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131378790));
    this.d = ((TextView)this.mContentView.findViewById(2131365519));
    setLeftViewName(2131690331);
    setRightButton(2131694793, this);
    setTitle(getActivity().getResources().getString(2131720095));
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.d.setText(2131720088);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + paramInt);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720092);
      this.c.setText(2131720090);
      this.d.setText(2131720089);
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
      if (this.jdField_a_of_type_Aydy == null) {
        break;
      }
      this.jdField_a_of_type_Aydy.a(this.jdField_b_of_type_Int);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720092);
      this.c.setText(2131720091);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720093);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720094);
    }
  }
  
  private void a(aydz paramaydz)
  {
    int i = 2;
    bfol localbfol = (bfol)bfoy.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    if (this.jdField_b_of_type_Int != 2)
    {
      localbfol.a(getString(2131720090), 5);
      localSparseArray.put(0, Integer.valueOf(2131720090));
      localbfol.a(getString(2131720091), 5);
      localSparseArray.put(1, Integer.valueOf(2131720091));
    }
    for (;;)
    {
      localbfol.a(getString(2131690708), 3);
      localSparseArray.put(i, Integer.valueOf(2131690708));
      localbfol.a(new aygq(this, paramaydz, localSparseArray, localbfol));
      localbfol.c(2131690596);
      localbfol.show();
      return;
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    ViewGroup localViewGroup1 = (ViewGroup)this.mContentView.findViewById(2131366631);
    ViewGroup localViewGroup2 = (ViewGroup)this.mContentView.findViewById(2131367052);
    ViewGroup localViewGroup3 = (ViewGroup)this.mContentView.findViewById(2131362064);
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
    View localView1 = this.mContentView.findViewById(2131364878);
    View localView2 = this.mContentView.findViewById(2131367052);
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
    this.jdField_a_of_type_Aydy = new aydy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aydy);
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(String.valueOf(((ayea)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString));
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
    bfol localbfol = (bfol)bfoy.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localbfol.a(getString(2131720092), 5);
    localSparseArray.put(0, Integer.valueOf(2131720092));
    localbfol.a(getString(2131720093), 5);
    localSparseArray.put(1, Integer.valueOf(2131720093));
    localbfol.a(getString(2131720094), 5);
    localSparseArray.put(2, Integer.valueOf(2131720094));
    localbfol.a(new aygo(this, localSparseArray, localbfol));
    localbfol.a(ajyc.a(2131714764));
    localbfol.c(2131690596);
    localbfol.show();
  }
  
  private void f()
  {
    bfol localbfol = (bfol)bfoy.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localbfol.a(getString(2131720090), 5);
    localSparseArray.put(0, Integer.valueOf(2131720090));
    localbfol.a(getString(2131720091), 5);
    localSparseArray.put(1, Integer.valueOf(2131720091));
    localbfol.a(new aygp(this, localSparseArray, localbfol));
    localbfol.a(ajyc.a(2131714809));
    localbfol.c(2131690596);
    localbfol.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayfl);
    a();
    c();
    this.jdField_a_of_type_Ayfe = ((ayfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(122));
    this.jdField_a_of_type_Ayfe.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
  }
  
  public int getContentLayoutId()
  {
    return 2131562491;
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
          ayea localayea = new ayea();
          localayea.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString;
          localayea.c = localResultRecord.b;
          localayea.b = localResultRecord.c;
          localayea.jdField_a_of_type_Int = localResultRecord.jdField_a_of_type_Int;
          localayea.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = localUinRightInfo;
          this.jdField_a_of_type_Aydy.a(localayea);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_Aydy.notifyDataSetChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean)
    {
      bbcv.a(getActivity(), 230, getString(2131720084), "", 2131720083, 2131720085, new aygt(this), new aygu(this)).show();
      return false;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131362064: 
    case 2131366631: 
    case 2131367052: 
    case 2131376900: 
      do
      {
        return;
        d();
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        e();
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        f();
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        return;
        a((aydz)paramView.getTag());
      } while (this.jdField_b_of_type_Int != 1);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      return;
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
    paramView = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ayea localayea = (ayea)localIterator.next();
      if (this.jdField_b_of_type_Int == 2) {
        localayea.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.set(2);
      }
      paramView.add(localayea.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo);
    }
    this.jdField_a_of_type_Ayfe.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramView);
    a(false);
    getRightTextView().setEnabled(false);
    startTitleProgress();
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayfl);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */