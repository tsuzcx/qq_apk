package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import anvk;
import anvx;
import aupp;
import aupt;
import auvi;
import bdla;
import bhbx;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nwu;

public class ForwardVoiceCallOption
  extends aupt
{
  boolean i;
  
  public ForwardVoiceCallOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.getType() != 1006) || (a(aupp.h))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 7000)) {
        if ((localRecentUser.getType() == 0) && (!bhbx.a(localRecentUser.uin)) && (!bhbx.c(localRecentUser.uin)) && (!nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType())))
        {
          if ((localanvk != null) && (localanvk.b(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() == 1006) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.jdField_b_of_type_Boolean))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
    if (n()) {
      this.jdField_a_of_type_JavaUtilSet.add(h);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    auvi localauvi = new auvi(this);
    paramInt = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("troop_uin");
    String str2 = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("uinname");
    if ((paramInt == 0) || (paramInt == 1004)) {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, str2, paramBundle, "", true, str1, true, true, localauvi, "from_internal");
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
      return;
      if (paramInt == 1006) {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, "0", paramBundle, str2, true, str1, true, true, localauvi, "from_internal");
      }
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_i_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromWebXman", false);
    return true;
  }
  
  public String b()
  {
    return anvx.a(2131704331);
  }
  
  public void f()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
    if (this.jdField_i_of_type_Boolean) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D9C", "0X8004D9C", 0, 0, "", "", "", "");
    }
  }
  
  public void g()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardVoiceCallOption
 * JD-Core Version:    0.7.0.1
 */