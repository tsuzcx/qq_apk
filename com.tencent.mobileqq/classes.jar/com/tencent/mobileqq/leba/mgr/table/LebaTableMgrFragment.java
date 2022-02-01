package com.tencent.mobileqq.leba.mgr.table;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaTableMgrItemBizProxy;
import com.tencent.mobileqq.leba.business.LebaTableMgrTitleBizProxy;
import com.tencent.mobileqq.leba.config.LebaConfigApi;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaTableMgrFragment
  extends QIphoneTitleBarFragment
{
  LebaTableMgrItemBizProxy jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy = new LebaTableMgrItemBizProxy();
  LebaTableMgrTitleBizProxy jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrTitleBizProxy = new LebaTableMgrTitleBizProxy();
  LebaConfigApi jdField_a_of_type_ComTencentMobileqqLebaConfigLebaConfigApi = new LebaConfigApi();
  private LebaMgrDataLogic jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic;
  private LebaTableMgrAdpter jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
  private boolean jdField_a_of_type_Boolean;
  
  protected int a()
  {
    return 2131561147;
  }
  
  public AppRuntime a()
  {
    if (getQBaseActivity() == null) {
      return null;
    }
    return getQBaseActivity().getAppRuntime();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy.a();
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrTitleBizProxy.a();
  }
  
  @Nullable
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(null, false, null);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("doOnCreateView mIsNight=");
    paramLayoutInflater.append(this.jdField_a_of_type_Boolean);
    QLog.i("LebaTableMgrFragment", 1, paramLayoutInflater.toString());
    a(getString(2131693593));
    paramLayoutInflater = a();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = (ILebaHelperService)paramLayoutInflater.getRuntimeService(ILebaHelperService.class, "multi");
      if (paramLayoutInflater != null) {
        paramLayoutInflater.initLebaHelper();
      } else {
        QLog.i("LebaTableMgrFragment", 1, "doOnCreateView lebaHelperService == null");
      }
    }
    paramLayoutInflater = this.b.findViewById(2131369757);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)this.b.findViewById(2131376308));
    if (this.jdField_a_of_type_Boolean) {
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165762));
    } else {
      paramLayoutInflater.setBackgroundColor(getResources().getColor(2131165761));
    }
    c(b());
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrTitleBizProxy.a(getActivity(), a(), this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaConfigLebaConfigApi.a();
  }
  
  public void c()
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.i("LebaTableMgrFragment", 1, "updateDate appRuntime == null");
      return;
    }
    List localList = LebaShowListManager.a().a();
    int i = LebaUtil.d((AppRuntime)localObject);
    localObject = new LebaTableMgrFragment.1(this, localList, LebaUtil.a((AppRuntime)localObject, i), i);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      if (getActivity() != null) {
        getActivity().runOnUiThread((Runnable)localObject);
      }
    }
    else {
      ((Runnable)localObject).run();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic = new LebaMgrDataLogic();
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy);
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic.a(a());
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter = new LebaTableMgrAdpter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter.a(this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy);
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter.a(paramBoolean);
    Object localObject = new GridLayoutManager(getActivity(), 3);
    ((GridLayoutManager)localObject).setSpanSizeLookup(new LebaTableMgrFragment.MyLoopUp(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter));
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter.a((GridLayoutManager)localObject);
    ItemTouchHelper localItemTouchHelper = new ItemTouchHelper(new LebaTableMgrFragment.MyTouchCallback(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView, this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic, this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter));
    localItemTouchHelper.attachToRecyclerView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter.a(localItemTouchHelper);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.addItemDecoration(new LebaTableMgrFragment.MyItemDecoration(getActivity(), this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("LebaTableMgrFragment", 1, "doOnCreate");
    LebaShowListManager.a = 0x1 | LebaShowListManager.a;
    paramBundle = a();
    if (paramBundle != null) {
      ReportController.b(paramBundle, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    }
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("LebaTableMgrFragment", 1, "doOnDestroy");
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = null;
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter = null;
    LebaMgrDataLogic localLebaMgrDataLogic = this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic;
    if (localLebaMgrDataLogic != null)
    {
      localLebaMgrDataLogic.c();
      this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaMgrDataLogic = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.i("LebaTableMgrFragment", 1, "doOnResume");
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrFragment
 * JD-Core Version:    0.7.0.1
 */