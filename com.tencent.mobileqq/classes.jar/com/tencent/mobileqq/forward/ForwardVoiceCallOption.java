package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import anyw;
import anzj;
import auxr;
import auxu;
import avdj;
import bdll;
import bhjx;
import bhpc;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import nok;

public class ForwardVoiceCallOption
  extends auxu
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
    anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.getType() != 1006) || (a(auxr.h))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 7000)) {
        if ((localRecentUser.getType() == 0) && (!bhjx.a(localRecentUser.uin)) && (!bhjx.c(localRecentUser.uin)) && (!nok.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType())))
        {
          if ((localanyw != null) && (localanyw.b(localRecentUser.uin))) {
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
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(h);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      return;
    }
    avdj localavdj = new avdj(this);
    paramInt = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("troop_uin");
    String str2 = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("uinname");
    if ((paramInt == 0) || (paramInt == 1004)) {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, str2, paramBundle, "", true, str1, true, true, localavdj, "from_internal");
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
      return;
      if (paramInt == 1006) {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, "0", paramBundle, str2, true, str1, true, true, localavdj, "from_internal");
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
    return anzj.a(2131703750);
  }
  
  public void f()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
    if (this.jdField_i_of_type_Boolean) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D9C", "0X8004D9C", 0, 0, "", "", "", "");
    }
  }
  
  public void g()
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardVoiceCallOption
 * JD-Core Version:    0.7.0.1
 */