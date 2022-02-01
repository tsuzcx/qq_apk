package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardChooseFriendOption
  extends ForwardBaseOption
{
  protected ResultReceiver a;
  int e = 0;
  int f = 0;
  private String h;
  
  public ForwardChooseFriendOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    this.e = paramIntent.getIntExtra("choose_friend_businessType", 0);
    this.f = paramIntent.getIntExtra("choose_friend_businessSubType", 0);
  }
  
  private boolean d()
  {
    return (this.e == 1) && (this.f == 1);
  }
  
  protected Bundle a(int paramInt, Bundle paramBundle)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ArrayList localArrayList7 = new ArrayList();
    if (paramBundle != null)
    {
      int j = paramBundle.getInt("uintype", -1);
      if ((j != 0) && (j != 1004))
      {
        if (j == 1006)
        {
          localArrayList1.add("");
          localArrayList2.add(paramBundle.getString("uin"));
          localArrayList3.add(paramBundle.getString("uinname"));
        }
        else if ((j == 3000) || (j == 1))
        {
          Object localObject1 = paramBundle.getString("uinname");
          String str = paramBundle.getString("uin");
          int i = 0;
          if (!TextUtils.isEmpty(str))
          {
            Object localObject2;
            if (j == 1)
            {
              localArrayList7.add(Integer.valueOf(4));
              localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
              paramBundle = (Bundle)localObject1;
              paramInt = i;
              if (localObject2 != null)
              {
                localObject2 = ((TroopManager)localObject2).c(str);
                paramBundle = (Bundle)localObject1;
                paramInt = i;
                if (localObject2 != null)
                {
                  paramInt = ((TroopInfo)localObject2).wMemberNum;
                  paramBundle = (Bundle)localObject1;
                }
              }
            }
            else
            {
              paramBundle = (Bundle)localObject1;
              paramInt = i;
              if (j == 3000)
              {
                localArrayList7.add(Integer.valueOf(8));
                localObject2 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                paramBundle = (Bundle)localObject1;
                paramInt = i;
                if (localObject2 != null)
                {
                  i = ((DiscussionManager)localObject2).a(str);
                  localObject2 = ((DiscussionManager)localObject2).a(str);
                  paramBundle = (Bundle)localObject1;
                  paramInt = i;
                  if (localObject2 != null)
                  {
                    paramBundle = ((DiscussionInfo)localObject2).discussionName;
                    paramInt = i;
                  }
                }
              }
            }
            localArrayList4.add(str);
            localObject1 = paramBundle;
            if (paramBundle == null) {
              localObject1 = "";
            }
            localArrayList5.add(localObject1);
            localArrayList6.add(Integer.valueOf(paramInt));
          }
        }
      }
      else
      {
        localArrayList1.add(paramBundle.getString("uin"));
        localArrayList2.add("");
        localArrayList3.add(paramBundle.getString("uinname"));
      }
    }
    paramBundle = new Bundle();
    paramBundle.putStringArrayList("choose_friend_uins", localArrayList1);
    paramBundle.putStringArrayList("choose_friend_phones", localArrayList2);
    paramBundle.putStringArrayList("choose_friend_names", localArrayList3);
    if (localArrayList4.size() > 0)
    {
      paramBundle.putStringArrayList("choose_friend_group_uins", localArrayList4);
      paramBundle.putStringArrayList("choose_friend_group_names", localArrayList5);
      paramBundle.putIntegerArrayList("choose_friend_group_counts", localArrayList6);
      paramBundle.putIntegerArrayList("choose_friend_group_types", localArrayList7);
    }
    return paramBundle;
  }
  
  public String a()
  {
    if (d())
    {
      String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("choose_friend_dialog_sub_title");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = HardCodeUtil.a(2131704842);
      }
      return str1;
    }
    return super.a();
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_h_of_type_JavaLangInteger))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 7000)) {
        if ((localRecentUser.getType() == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.c(localRecentUser.uin)) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType())) && (a(jdField_b_of_type_JavaLangInteger)))
        {
          if ((localFriendsManager != null) && (localFriendsManager.b(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() != 1006) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (!this.jdField_b_of_type_Boolean)))
        {
          if (((localRecentUser.getType() == 1) && (a(c))) || ((localRecentUser.getType() == 3000) && (a(d)))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (a(jdField_b_of_type_JavaLangInteger)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getEditString();
    this.jdField_a_of_type_AndroidOsBundle.putString("emsg", str);
    if (this.e > 0)
    {
      if (this.jdField_a_of_type_AndroidOsResultReceiver == null) {
        return;
      }
      Object localObject = a(ForwardAbility.ForwardAbilityType.a.intValue(), this.jdField_a_of_type_AndroidOsBundle);
      ((Bundle)localObject).putString("emsg", str);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, (Bundle)localObject);
      if ((this.f > 0) && (this.jdField_a_of_type_AndroidAppActivity != null))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      if (d())
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "editsay.button", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        if (!str.equals(this.jdField_h_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.send", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (d())
    {
      super.a(paramInt, paramBundle);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.list", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.show", 0, 0, "", "", "", "");
      return;
    }
    if ((this.e == 1) && (this.f == 2)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.list", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    boolean bool;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("choose_friend_needConfirm");
    } else {
      bool = false;
    }
    if (bool)
    {
      String str3 = paramBundle.getString("choose_friend_confirmTitle");
      String str2 = paramBundle.getString("choose_friend_confirmContent");
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (str2.contains("[nick]"))
        {
          String str4 = paramBundle.getString("uin");
          str1 = paramBundle.getString("uinname");
          if (!TextUtils.isEmpty(str1))
          {
            str1 = str2.replace("[nick]", str1);
          }
          else
          {
            str1 = str2;
            if (!TextUtils.isEmpty(str4)) {
              str1 = str2.replace("[nick]", str4);
            }
          }
        }
      }
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, str3, str1, HardCodeUtil.a(2131704843), HardCodeUtil.a(2131704841), new ForwardChooseFriendOption.1(this, paramInt, paramBundle), new ForwardChooseFriendOption.2(this)).show();
      return;
    }
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      paramBundle = a(paramInt, paramBundle);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramBundle);
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("choose_friend_callback"));
    return true;
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("choose_friend_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131704845);
    }
    return str1;
  }
  
  protected void b()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_contacts", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_groupchats", false);
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_create_group_chat", false);
    if ((bool1) && (r())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    } else {
      this.jdField_a_of_type_JavaUtilSet.remove(jdField_b_of_type_JavaLangInteger);
    }
    if ((bool2) && (o())) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
    } else {
      this.jdField_a_of_type_JavaUtilSet.remove(jdField_h_of_type_JavaLangInteger);
    }
    if (bool3)
    {
      this.jdField_a_of_type_JavaUtilSet.add(c);
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilSet.remove(c);
      this.jdField_a_of_type_JavaUtilSet.remove(d);
    }
    if (bool4) {
      this.jdField_a_of_type_JavaUtilSet.remove(l);
    } else {
      this.jdField_a_of_type_JavaUtilSet.add(l);
    }
    this.jdField_a_of_type_JavaUtilSet.add(i);
  }
  
  protected String d()
  {
    if (d())
    {
      String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("choose_friend_dialog_input");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "给TA留言";
      }
      this.jdField_h_of_type_JavaLangString = str1;
      return str1;
    }
    return super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardChooseFriendOption
 * JD-Core Version:    0.7.0.1
 */