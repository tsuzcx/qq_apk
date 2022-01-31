package com.tencent.mobileqq.forward;

import aduv;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardVoiceCallOption
  extends ForwardBaseOption
{
  boolean g = false;
  
  public ForwardVoiceCallOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.type != 9501) && (localRecentUser.type != 6004) && (localRecentUser.type != 7000)) {
        if ((localRecentUser.type == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.c(localRecentUser.uin)) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type)))
        {
          if ((localFriendsManager != null) && (localFriendsManager.b(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.type == 1006) || (((localRecentUser.type == 1004) || (localRecentUser.type == 1000)) && (this.jdField_b_of_type_Boolean))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(i);
    if (g()) {
      this.jdField_a_of_type_JavaUtilSet.add(h);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    aduv localaduv = new aduv(this);
    paramInt = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("troop_uin");
    String str2 = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("uinname");
    if ((paramInt == 0) || (paramInt == 1004)) {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, str2, paramBundle, "", true, str1, true, true, localaduv, "from_internal");
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
      return;
      if (paramInt == 1006) {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, "0", paramBundle, str2, true, str1, true, true, localaduv, "from_internal");
      }
    }
  }
  
  public boolean a()
  {
    super.a();
    this.g = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromWebXman", false);
    return true;
  }
  
  public String b()
  {
    return "选择联系人";
  }
  
  public void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
    if (this.g) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D9C", "0X8004D9C", 0, 0, "", "", "", "");
    }
  }
  
  public void e()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardVoiceCallOption
 * JD-Core Version:    0.7.0.1
 */