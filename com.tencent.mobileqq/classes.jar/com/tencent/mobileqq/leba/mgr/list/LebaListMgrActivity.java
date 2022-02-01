package com.tencent.mobileqq.leba.mgr.list;

import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaListMgrItemBizProxy;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.observer.LebaSettingObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.app.AppRuntime;

public class LebaListMgrActivity
  extends QIphoneTitleBarActivity
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new LebaListMgrActivity.2(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  LebaListMgrItemBizProxy jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy = new LebaListMgrItemBizProxy();
  private LebaListMgrAdapter jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter;
  protected LebaSettingObserver a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public LebaListMgrActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaObserverLebaSettingObserver = new LebaListMgrActivity.3(this);
  }
  
  private void b()
  {
    Object localObject1 = getAppRuntime();
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131561145, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      localObject2 = View.inflate(this, 2131561143, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378784));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693594);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject2, null, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter = new LebaListMgrAdapter((AppRuntime)localObject1, this, LebaShowListManager.a().a(), this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy);
      this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter);
    this.centerView.setTextSize(1, 17.0F);
    setTitle(2131693593);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initUi, ");
      ((StringBuilder)localObject2).append(LebaShowListManager.a().jdField_a_of_type_Boolean);
      QLog.i("Q.lebatab.mgr", 4, ((StringBuilder)localObject2).toString());
    }
    localObject1 = (ILebaHelperService)((AppRuntime)localObject1).getRuntimeService(ILebaHelperService.class, "multi");
    if (localObject1 != null) {
      ((ILebaHelperService)localObject1).initLebaHelper();
    } else {
      QLog.d("Q.lebatab.mgr", 1, "initLebaHelper lebaHelperService == null");
    }
    if (!LebaShowListManager.a().jdField_a_of_type_Boolean) {
      ThreadManager.post(new LebaListMgrActivity.1(this), 5, null, true);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy.a();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LebaShowListManager.jdField_a_of_type_Int |= 0x1;
    a();
    b();
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof AppInterface)) {
      ((AppInterface)paramBundle).addObserver(this.jdField_a_of_type_ComTencentMobileqqLebaObserverLebaSettingObserver, true);
    }
    ReportController.b(paramBundle, "dc00898", "", "", "0X80098FB", "0X80098FB", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter;
    if (localObject != null)
    {
      ((LebaListMgrAdapter)localObject).unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter = null;
    }
    localObject = getAppRuntime();
    if ((localObject instanceof AppInterface)) {
      ((AppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqLebaObserverLebaSettingObserver);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    QLog.i("IphoneTitleBarActivity", 4, "onPostThemeChanged");
    LebaListMgrAdapter localLebaListMgrAdapter = this.jdField_a_of_type_ComTencentMobileqqLebaMgrListLebaListMgrAdapter;
    if (localLebaListMgrAdapter != null) {
      localLebaListMgrAdapter.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrActivity
 * JD-Core Version:    0.7.0.1
 */