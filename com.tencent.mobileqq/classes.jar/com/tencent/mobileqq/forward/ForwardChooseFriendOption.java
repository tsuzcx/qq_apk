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
  int ad = 0;
  int ae = 0;
  private String af;
  
  public ForwardChooseFriendOption(Intent paramIntent)
  {
    super(paramIntent);
    this.E = true;
    this.ad = paramIntent.getIntExtra("choose_friend_businessType", 0);
    this.ae = paramIntent.getIntExtra("choose_friend_businessSubType", 0);
  }
  
  private boolean o()
  {
    return (this.ad == 1) && (this.ae == 1);
  }
  
  protected String H()
  {
    if (o())
    {
      String str2 = this.r.getStringExtra("choose_friend_dialog_input");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "给TA留言";
      }
      this.af = str1;
      return str1;
    }
    return super.H();
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.q.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 7000)) {
        if ((localRecentUser.getType() == 0) && (!Utils.b(localRecentUser.uin)) && (!Utils.d(localRecentUser.uin)) && (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType())) && (a(c)))
        {
          if ((localFriendsManager != null) && (localFriendsManager.n(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() != 1006) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (!this.E)))
        {
          if (((localRecentUser.getType() == 1) && (a(d))) || ((localRecentUser.getType() == 3000) && (a(e)))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (a(c)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (o())
    {
      super.a(paramInt, paramBundle);
      ReportController.b(this.q, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.list", 0, 0, "", "", "", "");
      ReportController.b(this.q, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.show", 0, 0, "", "", "", "");
      return;
    }
    if ((this.ad == 1) && (this.ae == 2)) {
      ReportController.b(this.q, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.list", 0, 0, "", "", "", "");
    }
    if ((this.A != null) && (this.A.isShowing())) {
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
      DialogUtil.a(this.s, 230, str3, str1, HardCodeUtil.a(2131898212), HardCodeUtil.a(2131899883), new ForwardChooseFriendOption.1(this, paramInt, paramBundle), new ForwardChooseFriendOption.2(this)).show();
      return;
    }
    if (this.a != null)
    {
      paramBundle = b(paramInt, paramBundle);
      this.a.send(0, paramBundle);
    }
    if (this.s != null)
    {
      this.s.setResult(1);
      this.s.finish();
    }
  }
  
  protected Bundle b(int paramInt, Bundle paramBundle)
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
              localObject2 = (TroopManager)this.q.getManager(QQManagerFactory.TROOP_MANAGER);
              paramBundle = (Bundle)localObject1;
              paramInt = i;
              if (localObject2 != null)
              {
                localObject2 = ((TroopManager)localObject2).g(str);
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
                localObject2 = (DiscussionManager)this.q.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                paramBundle = (Bundle)localObject1;
                paramInt = i;
                if (localObject2 != null)
                {
                  i = ((DiscussionManager)localObject2).c(str);
                  localObject2 = ((DiscussionManager)localObject2).d(str);
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
  
  protected void b()
  {
    String str = this.A.getEditString();
    this.t.putString("emsg", str);
    if (this.ad > 0)
    {
      if (this.a == null) {
        return;
      }
      Object localObject = b(ForwardAbility.ForwardAbilityType.b.intValue(), this.t);
      ((Bundle)localObject).putString("emsg", str);
      this.a.send(0, (Bundle)localObject);
      if ((this.ae > 0) && (this.s != null))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtras(this.t);
        this.s.setResult(-1, (Intent)localObject);
        this.s.finish();
      }
      if (o())
      {
        ReportController.b(this.q, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "editsay.button", 0, 0, "", "", "", "");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        if (!str.equals(this.af)) {
          ReportController.b(this.q, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerconfirmpage.send", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  protected void c()
  {
    boolean bool1 = this.r.getBooleanExtra("choose_friend_is_qqfriends", true);
    boolean bool2 = this.r.getBooleanExtra("choose_friend_is_contacts", false);
    boolean bool3 = this.r.getBooleanExtra("choose_friend_is_groupchats", false);
    boolean bool4 = this.r.getBooleanExtra("choose_friend_is_create_group_chat", false);
    if ((bool1) && (ai())) {
      this.C.add(c);
    } else {
      this.C.remove(c);
    }
    if ((bool2) && (af())) {
      this.C.add(i);
    } else {
      this.C.remove(i);
    }
    if (bool3)
    {
      this.C.add(d);
      this.C.add(e);
    }
    else
    {
      this.C.remove(d);
      this.C.remove(e);
    }
    if (bool4) {
      this.C.remove(m);
    } else {
      this.C.add(m);
    }
    this.C.add(j);
  }
  
  public boolean e()
  {
    super.e();
    this.a = ((ResultReceiver)this.r.getParcelableExtra("choose_friend_callback"));
    return true;
  }
  
  public String n()
  {
    if (o())
    {
      String str2 = this.r.getStringExtra("choose_friend_dialog_sub_title");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = HardCodeUtil.a(2131902742);
      }
      return str1;
    }
    return super.n();
  }
  
  public String u()
  {
    String str2 = this.r.getStringExtra("choose_friend_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131902744);
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardChooseFriendOption
 * JD-Core Version:    0.7.0.1
 */