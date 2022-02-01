package com.tencent.mobileqq.onlinestatus.auto;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class OnlineStatusSmartDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  private AutoStatusManager a;
  
  public OnlineStatusSmartDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramAppRuntime, paramQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager = ((AutoStatusManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager.a(new OnlineStatusSmartDisplayInfo.1(this));
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698502);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager.a(null);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo$UpdateUIListener == null) {
      localArrayList = null;
    } else {
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo$UpdateUIListener.c();
    }
    OnlineStatusPermissionServlet.a(this.jdField_a_of_type_MqqAppAppRuntime, paramOnlineStatusPermissionItem, localArrayList, paramBoolean ^ true);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusManagerAutoStatusManager.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.OnlineStatusSmartDisplayInfo
 * JD-Core Version:    0.7.0.1
 */