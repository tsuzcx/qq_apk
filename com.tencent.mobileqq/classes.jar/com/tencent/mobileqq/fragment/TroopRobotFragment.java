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
  RobotAdapter a;
  TroopRobotObserver b = new TroopRobotFragment.1(this);
  private XListView c;
  private String d;
  private AddedRobotView e;
  private boolean f = false;
  
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
      l = Long.parseLong(this.d);
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
    Object localObject = this.c;
    if ((localObject != null) && (((XListView)localObject).getVisibility() != 0)) {
      this.c.setVisibility(0);
    }
    localObject = this.a;
    if (localObject != null) {
      ((RobotAdapter)localObject).a(paramArrayList2);
    }
    paramArrayList2 = this.e;
    if (paramArrayList2 != null) {
      paramArrayList2.setAddList(paramArrayList1, paramInt, this.d);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.d = a(getActivity()).getStringExtra("uin");
    this.f = a(getActivity()).getBooleanExtra("be_admin_in_the_troop", false);
    paramLayoutInflater = getActivity().getResources().getString(2131917610);
    setTitle(paramLayoutInflater, paramLayoutInflater);
    this.c = ((XListView)this.mContentView.findViewById(2131445151));
    this.e = new AddedRobotView(getActivity());
    this.c.setVerticalScrollBarEnabled(false);
    this.c.addHeaderView(this.e);
    this.c.setDivider(getResources().getDrawable(2130852616));
    this.a = new RobotAdapter(getBaseActivity().app, getBaseActivity(), this.c, this.d, this.f);
    this.c.setAdapter(this.a);
    getBaseActivity().addObserver(this.b);
    if ((AppSetting.e) && (this.leftView != null)) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131901576));
    }
    ReportController.b(getBaseActivity().app, "dc00898", "", "", "", "0X8009F9D", 0, 0, "", "", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131626740;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.a;
    if (localObject != null)
    {
      ((RobotAdapter)localObject).a();
      this.a = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((AddedRobotView)localObject).a();
      this.e = null;
    }
    getQBaseActivity().removeObserver(this.b);
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("TroopRobotFragment", 2, "onResume");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TroopRobotFragment
 * JD-Core Version:    0.7.0.1
 */