package com.tencent.mobileqq.onlinestatus.auto;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import java.util.ArrayList;

public class OnlineStatusSmartDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  private AutoStatusManager a;
  
  public OnlineStatusSmartDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager = ((OnlineStatusManager)paramQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.a(new OnlineStatusSmartDisplayInfo.1(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698436);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.a(null);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ArrayList localArrayList;
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo$UpdateUIListener == null)
    {
      localArrayList = null;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = true;; paramBoolean = false)
    {
      OnlineStatusPermissionServlet.a(localQQAppInterface, paramOnlineStatusPermissionItem, localArrayList, paramBoolean);
      return;
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo$UpdateUIListener.a();
      break;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoAutoStatusManager.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.OnlineStatusSmartDisplayInfo
 * JD-Core Version:    0.7.0.1
 */