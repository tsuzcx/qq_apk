package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.RobotAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.TroopRobotData;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopRobotFragment
  extends IphoneTitleBarFragment
{
  RobotAdapter jdField_a_of_type_ComTencentMobileqqAdapterRobotAdapter;
  TroopRobotObserver jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver = new TroopRobotFragment.1(this);
  private AddedRobotView jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  private void a(long paramLong)
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject = getBaseActivity().app;
    if (localObject == null) {
      return;
    }
    localObject = ((ITroopRobotService)((QQAppInterface)localObject).getRuntimeService(ITroopRobotService.class, "all")).getTroopRobotData(paramLong);
    if (getActivity() != null) {
      getActivity().runOnUiThread(new TroopRobotFragment.2(this, (TroopRobotData)localObject));
    }
  }
  
  public void a()
  {
    QLog.d("TroopRobotFragment", 2, "getRobotLisFromServer");
    long l;
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotFragment", 2, "parseLong err", localException);
      }
      l = 0L;
    }
    ((ITroopRobotHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a(l);
  }
  
  public void a(ArrayList<TroopRobotInfo> paramArrayList1, ArrayList<TroopRobotInfo> paramArrayList2, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if ((localObject != null) && (((XListView)localObject).getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterRobotAdapter;
    if (localObject != null) {
      ((RobotAdapter)localObject).a(paramArrayList2);
    }
    paramArrayList2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView;
    if (paramArrayList2 != null) {
      paramArrayList2.setAddList(paramArrayList1, paramInt, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_JavaLangString = a(getActivity()).getStringExtra("uin");
    this.jdField_a_of_type_Boolean = a(getActivity()).getBooleanExtra("be_admin_in_the_troop", false);
    paramLayoutInflater = getActivity().getResources().getString(2131720005);
    setTitle(paramLayoutInflater, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131376821));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView = new AddedRobotView(getActivity());
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(getResources().getDrawable(2130850794));
    this.jdField_a_of_type_ComTencentMobileqqAdapterRobotAdapter = new RobotAdapter(getBaseActivity().app, getBaseActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterRobotAdapter);
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver);
    if ((AppSetting.d) && (this.leftView != null)) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131715530));
    }
    ReportController.b(getBaseActivity().app, "dc00898", "", "", "", "0X8009F9D", 0, 0, "", "", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131560695;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterRobotAdapter;
    if (localObject != null)
    {
      ((RobotAdapter)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqAdapterRobotAdapter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView;
    if (localObject != null)
    {
      ((AddedRobotView)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAddedRobotView = null;
    }
    getQBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("TroopRobotFragment", 2, "onResume");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TroopRobotFragment
 * JD-Core Version:    0.7.0.1
 */