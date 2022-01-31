package com.tencent.mobileqq.fragment;

import akge;
import alpo;
import alzf;
import amab;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import asdm;
import azmj;
import bckv;
import bckw;
import bckx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopRobotFragment
  extends IphoneTitleBarFragment
{
  akge jdField_a_of_type_Akge;
  amab jdField_a_of_type_Amab = new asdm(this);
  private AddedRobotView jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  private void a(long paramLong)
  {
    if (getActivity() == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getActivity().app;
      } while (localObject == null);
      localObject = ((bckx)((QQAppInterface)localObject).getManager(203)).a(paramLong);
    } while (getActivity() == null);
    getActivity().runOnUiThread(new TroopRobotFragment.2(this, (bckv)localObject));
  }
  
  public void a()
  {
    QLog.d("TroopRobotFragment", 2, "getRobotLisFromServer");
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      ((alzf)getActivity().app.a(20)).h(l);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopRobotFragment", 2, "parseLong err", localException);
        }
        long l = 0L;
      }
    }
  }
  
  public void a(ArrayList<bckw> paramArrayList1, ArrayList<bckw> paramArrayList2, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Akge != null) {
      this.jdField_a_of_type_Akge.a(paramArrayList2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView.setAddList(paramArrayList1, paramInt, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_JavaLangString = a(getActivity()).getStringExtra("uin");
    this.jdField_a_of_type_Boolean = a(getActivity()).getBooleanExtra("be_admin_in_the_troop", false);
    paramLayoutInflater = getActivity().getResources().getString(2131721103);
    setTitle(paramLayoutInflater, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131375994));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView = new AddedRobotView(getActivity());
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(getResources().getDrawable(2130849754));
    this.jdField_a_of_type_Akge = new akge(getActivity().app, getActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akge);
    getActivity().addObserver(this.jdField_a_of_type_Amab);
    if ((AppSetting.c) && (this.leftView != null)) {
      this.leftView.setContentDescription(alpo.a(2131716130));
    }
    azmj.b(getActivity().app, "dc00898", "", "", "", "0X8009F9D", 0, 0, "", "", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131560501;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Akge != null)
    {
      this.jdField_a_of_type_Akge.a();
      this.jdField_a_of_type_Akge = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView = null;
    }
    getActivity().removeObserver(this.jdField_a_of_type_Amab);
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("TroopRobotFragment", 2, "onResume");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TroopRobotFragment
 * JD-Core Version:    0.7.0.1
 */