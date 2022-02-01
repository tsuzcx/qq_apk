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
    int j;
    if (paramBundle != null)
    {
      j = paramBundle.getInt("uintype", -1);
      if ((j != 0) && (j != 1004)) {
        break label195;
      }
      localArrayList1.add(paramBundle.getString("uin"));
      localArrayList2.add("");
      localArrayList3.add(paramBundle.getString("uinname"));
    }
    label195:
    Object localObject;
    String str;
    int i;
    do
    {
      do
      {
        for (;;)
        {
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
          if (j != 1006) {
            break;
          }
          localArrayList1.add("");
          localArrayList2.add(paramBundle.getString("uin"));
          localArrayList3.add(paramBundle.getString("uinname"));
        }
      } while ((j != 3000) && (j != 1));
      localObject = paramBundle.getString("uinname");
      str = paramBundle.getString("uin");
      i = 0;
    } while (TextUtils.isEmpty(str));
    if (j == 1)
    {
      localArrayList7.add(Integer.valueOf(4));
      paramBundle = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramBundle == null) {
        break label448;
      }
      paramBundle = paramBundle.c(str);
      if (paramBundle == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = paramBundle.wMemberNum;; paramInt = 0)
    {
      paramBundle = (Bundle)localObject;
      for (;;)
      {
        localArrayList4.add(str);
        localObject = paramBundle;
        if (paramBundle == null) {
          localObject = "";
        }
        localArrayList5.add(localObject);
        localArrayList6.add(Integer.valueOf(paramInt));
        break;
        paramInt = i;
        if (j == 3000)
        {
          localArrayList7.add(Integer.valueOf(8));
          paramBundle = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          paramInt = i;
          if (paramBundle != null)
          {
            i = paramBundle.a(str);
            paramBundle = paramBundle.a(str);
            paramInt = i;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.discussionName;
              paramInt = i;
              continue;
            }
          }
        }
        paramBundle = (Bundle)localObject;
      }
    }
  }
  
  public String a()
  {
    if (d())
    {
      String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("choose_friend_dialog_sub_title");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = HardCodeUtil.a(2131704766);
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
        if ((localRecentUser.getType() == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.c(localRecentUser.uin)) && (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.getType())) && (a(jdField_b_of_type_JavaLangInteger)))
        {
          if ((localFriendsManager != null) && (localFriendsManager.b(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() == 1006) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.jdField_b_of_type_Boolean)))
        {
          if (a(jdField_b_of_type_JavaLangInteger)) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (((localRecentUser.getType() == 1) && (a(c))) || ((localRecentUser.getType() == 3000) && (a(d)))) {
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
    if ((this.e <= 0) || (this.jdField_a_of_type_AndroidOsResultReceiver == null)) {}
    do
    {
      do
      {
        return;
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
      } while (!d());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "editsay.button", 0, 0, "", "", "", "");
    } while ((TextUtils.isEmpty(str)) || (str.equals(this.jdField_h_of_type_JavaLangString)));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.send", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (d())
    {
      super.a(paramInt, paramBundle);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.list", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.show", 0, 0, "", "", "", "");
    }
    label290:
    label317:
    do
    {
      do
      {
        return;
        if ((this.e == 1) && (this.f == 2)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.list", 0, 0, "", "", "", "");
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()));
      boolean bool;
      String str3;
      String str2;
      String str1;
      String str4;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("choose_friend_needConfirm");
        if (!bool) {
          break label317;
        }
        str3 = paramBundle.getString("choose_friend_confirmTitle");
        str2 = paramBundle.getString("choose_friend_confirmContent");
        str1 = str2;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (str2.contains("[nick]"))
          {
            str4 = paramBundle.getString("uin");
            str1 = paramBundle.getString("uinname");
            if (TextUtils.isEmpty(str1)) {
              break label290;
            }
            str1 = str2.replace("[nick]", str1);
          }
        }
      }
      for (;;)
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, str3, str1, HardCodeUtil.a(2131704767), HardCodeUtil.a(2131704765), new ForwardChooseFriendOption.1(this, paramInt, paramBundle), new ForwardChooseFriendOption.2(this)).show();
        return;
        bool = false;
        break;
        str1 = str2;
        if (!TextUtils.isEmpty(str4)) {
          str1 = str2.replace("[nick]", str4);
        }
      }
      if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBundle = a(paramInt, paramBundle);
        this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramBundle);
      }
    } while (this.jdField_a_of_type_AndroidAppActivity == null);
    this.jdField_a_of_type_AndroidAppActivity.setResult(1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
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
      str1 = HardCodeUtil.a(2131704769);
    }
    return str1;
  }
  
  protected void b()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_contacts", false);
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_groupchats", false);
    boolean bool4 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("choose_friend_is_create_group_chat", false);
    if ((bool1) && (r()))
    {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
      if ((!bool2) || (!o())) {
        break label175;
      }
      this.jdField_a_of_type_JavaUtilSet.add(jdField_h_of_type_JavaLangInteger);
      label97:
      if (!bool3) {
        break label191;
      }
      this.jdField_a_of_type_JavaUtilSet.add(c);
      this.jdField_a_of_type_JavaUtilSet.add(d);
      label127:
      if (!bool4) {
        break label220;
      }
      this.jdField_a_of_type_JavaUtilSet.remove(l);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilSet.add(i);
      return;
      this.jdField_a_of_type_JavaUtilSet.remove(jdField_b_of_type_JavaLangInteger);
      break;
      label175:
      this.jdField_a_of_type_JavaUtilSet.remove(jdField_h_of_type_JavaLangInteger);
      break label97;
      label191:
      this.jdField_a_of_type_JavaUtilSet.remove(c);
      this.jdField_a_of_type_JavaUtilSet.remove(d);
      break label127;
      label220:
      this.jdField_a_of_type_JavaUtilSet.add(l);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardChooseFriendOption
 * JD-Core Version:    0.7.0.1
 */