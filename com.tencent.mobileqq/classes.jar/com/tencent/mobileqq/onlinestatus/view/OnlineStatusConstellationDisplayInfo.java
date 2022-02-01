package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import kotlin.Pair;

public class OnlineStatusConstellationDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  StatusExtInfoObserver a;
  private String e = "";
  private String f = "";
  
  public OnlineStatusConstellationDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver = new OnlineStatusConstellationDisplayInfo.1(this);
    paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
    this.e = NearbyProfileUtil.c(ProfileCardUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin()).constellation);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698421);
    this.jdField_a_of_type_Boolean = false;
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698408);
    if (!TextUtils.isEmpty(this.f))
    {
      this.jdField_b_of_type_JavaLangString = (this.e + " | " + this.f);
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.e;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.e = ((String)ConstellationViewKt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, this.e).getSecond());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      OnlineStatusExtInfoServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
    }
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ExtensionBizInfoHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1040);
  }
  
  public void b()
  {
    Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localFriends.constellationJumpUrl, 4015);
    ReportHelperKt.a("0X800AF4D");
  }
  
  public void c()
  {
    ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "VAL_FROM_STATUS_SETTING");
    ReportHelperKt.a("0X800AF97");
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusConstellationDisplayInfo
 * JD-Core Version:    0.7.0.1
 */