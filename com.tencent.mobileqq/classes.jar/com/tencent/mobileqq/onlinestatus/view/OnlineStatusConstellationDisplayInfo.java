package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.constellation.ConstellationLauncher;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import kotlin.Pair;
import mqq.app.AppRuntime;

public class OnlineStatusConstellationDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  StatusExtInfoObserver a;
  private String e = "";
  private String f = "";
  
  public OnlineStatusConstellationDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramAppInterface, paramQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver = new OnlineStatusConstellationDisplayInfo.1(this);
    paramAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
    this.e = OnlineStatusUtil.b(((IProfileCardUtil)QRoute.api(IProfileCardUtil.class)).initCard(paramAppInterface, paramAppInterface.getCurrentAccountUin()).constellation);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698487);
    this.jdField_a_of_type_Boolean = false;
    this.d = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698474);
    if (!TextUtils.isEmpty(this.f))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this.f);
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.e;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.e = ((String)ConstellationViewKt.a(this.jdField_a_of_type_MqqAppAppRuntime, paramIntent, this.e).getSecond());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      OnlineStatusExtInfoServlet.a(this.jdField_a_of_type_MqqAppAppRuntime, this.e);
    }
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ExtensionBizInfoHelper.a.a(this.jdField_a_of_type_MqqAppAppRuntime, 1040);
  }
  
  public void b()
  {
    Friends localFriends = ((IFriendDataService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), true, true, true);
    ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localFriends.constellationJumpUrl, 4015);
    ReportHelperKt.a("0X800AF4D");
  }
  
  public void c()
  {
    ConstellationLauncher.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "VAL_FROM_STATUS_SETTING");
    ReportHelperKt.a("0X800AF97");
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConstellationStatusExtInfoObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusConstellationDisplayInfo
 * JD-Core Version:    0.7.0.1
 */