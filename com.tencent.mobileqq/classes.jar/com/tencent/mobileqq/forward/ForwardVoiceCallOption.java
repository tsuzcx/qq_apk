package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  boolean a = false;
  
  public ForwardVoiceCallOption(Intent paramIntent)
  {
    super(paramIntent);
    this.E = true;
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
        if ((localRecentUser.getType() == 0) && (!Utils.b(localRecentUser.uin)) && (!Utils.d(localRecentUser.uin)) && (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType())))
        {
          if ((localFriendsManager != null) && (localFriendsManager.n(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() == 1006) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.E))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.A != null) && (this.A.isShowing())) {
      return;
    }
    ForwardVoiceCallOption.1 local1 = new ForwardVoiceCallOption.1(this);
    paramInt = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("troop_uin");
    String str2 = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("uinname");
    if ((paramInt != 0) && (paramInt != 1004))
    {
      if (paramInt == 1006) {
        ChatActivityUtils.a(this.q, this.s, paramInt, "0", paramBundle, str2, true, str1, true, true, local1, "from_internal");
      }
    }
    else {
      ChatActivityUtils.a(this.q, this.s, paramInt, str2, paramBundle, "", true, str1, true, true, local1, "from_internal");
    }
    ReportController.b(this.q, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
  }
  
  protected void c()
  {
    if (ai()) {
      this.C.add(c);
    }
    this.C.add(j);
    if (af()) {
      this.C.add(i);
    }
  }
  
  public boolean e()
  {
    super.e();
    this.a = this.r.getBooleanExtra("fromWebXman", false);
    return true;
  }
  
  public String u()
  {
    return HardCodeUtil.a(2131902846);
  }
  
  public void v()
  {
    ReportController.b(this.q, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
    if (this.a) {
      ReportController.b(this.q, "CliOper", "", "", "0X8004D9C", "0X8004D9C", 0, 0, "", "", "", "");
    }
  }
  
  public void w()
  {
    ReportController.b(this.q, "CliOper", "", "", "Two_call", "Tc_msg_search", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardVoiceCallOption
 * JD-Core Version:    0.7.0.1
 */